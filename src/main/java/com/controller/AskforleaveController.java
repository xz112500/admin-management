package com.controller;

import com.annotation.Admin;
import com.pojo.Askforleave;
import com.service.AskforleaveService;
import com.service.LeaveService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping(value = "Askforleave")
@CrossOrigin
@Controller
@ResponseBody
public class AskforleaveController {
    @Autowired
    private R r;
    @Autowired
    private AskforleaveService askforleaveService;
    @Autowired
    private LeaveService leaveService;
    /**
     * 请假情况
     */
    //所有请假记录
    @GetMapping("/queryAttendanceDay")
    public R queryAttendanceDay(@RequestParam(value = "staffId") int staffId,
                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(askforleaveService.queryAskforleaveAll(staffId,pageNum,pageSize));
    }
    //查看该月的请假记录
    @GetMapping("/queryAskforleaveAllByTime")
    public R queryAskforleaveAllByTime(@RequestParam(value = "staffId") int staffId,
                                       @RequestParam(value = "date") Date date,
                                       @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                       @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(askforleaveService.queryAskforleaveAllByTime(staffId,date,pageNum,pageSize));
    }
    //修改批准状态
    @PutMapping(value = "/updateStateById/{state}/{id}")
    @Admin
    public R updateStateById(@PathVariable(value = "state") int state,
                             @PathVariable(value = "id") int id){
        int i = leaveService.updateById(state, id);
        return i > 0 ? r.success():r.error();
    }
    @PostMapping(value = "/AddLeave")
    public R AddLeave(@RequestBody(required = false) Askforleave askforleave){
        askforleave.setApplyTime(new Date());
        return r.success(leaveService.InsertLeave(askforleave));
    }
}
