package com.controller;

import com.annotation.Admin;
import com.pojo.Job;
import com.service.JobService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "Job")
@CrossOrigin
@RestController
public class JobController {
    @Autowired
    private R r;
    @Autowired
    private JobService jobService;
    @RequestMapping(value ="/AddJob",method = RequestMethod.POST)
    public R addNewStaff(@RequestBody Job job){
        int result = jobService.addNewJob(job);
        return result > 0 ? r.success():r.error();
    }
    //TODO 删除现有岗位功能
    @RequestMapping(value = "/DeleteJob/{jobId}",method = RequestMethod.DELETE)
    @Admin
    public R deleteStaff(@PathVariable("jobId") int jobId) {
        return r.success(jobService.deleteJobById(jobId));
    }
    @RequestMapping(value ="/UpdateJob",method = RequestMethod.POST)
    public R updateJob(@RequestBody Job job) {
        int result = jobService.updateJob(job);
       return result > 0 ? r.success():r.error();
    }
    //TODO 分页展示员工信息功能
    @RequestMapping(value = "/ShowJobInfoLimit",method = RequestMethod.GET)
    public R showJobInfo(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "100") Integer pageSize) {
        List<Job> jobs = jobService.queryJobLimit();
        List<Job> collect = jobs.stream().skip((long) (pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    //TODO 根据ID查询岗位功能
    @RequestMapping(value ="/ShowJobById",method = RequestMethod.GET)
    public R showJobById(@RequestBody int jobId) {
        return r.success(jobService.queryJobById(jobId));
    }

}
