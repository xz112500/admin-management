package com.controller;

import com.pojo.TripInfo;
import com.pojo.Vo.TripVo;
import com.service.TripService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Trip")
@CrossOrigin
public class TripController {
    @Autowired
    private R r;
    @Autowired
    private TripService tripService;
    //所有出差记录
    @GetMapping("/queryAllTrip")
    public R queryAllTrip(){
        return r.success(tripService.queryAllTrip());
    }
    @GetMapping("/queryTripInfoById")
    public R queryTripInfoById(@RequestParam(value = "id") int id,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        List<TripInfo> tripInfos = tripService.queryTripInfoById(id);
        List<TripInfo> collect = tripInfos.stream().skip((long) (pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    @PostMapping("/AddTrip")
    public R AddTrip(@RequestBody TripVo tripVo){
        return r.success(tripService.AddTrip(tripVo));
    }
    //查询未批准出差
    @GetMapping("/queryApprove")
    public R queryApprove(){
        return r.success(tripService.queryApproveTrip());
    }
    //查看该月的出差记录
    @GetMapping("/querySubordinateTrip")
    public R querySubordinateTrip(@RequestParam(value = "state",required = false) Integer state,
                                  @RequestParam(value = "category",required = false) String category,
                                  @RequestParam(value = "duration",required = false) Integer duration){
        return r.success(tripService.querySubordinateTrip(state, category, duration));
    }
    @PutMapping("/updateStaffById/{state}/{id}")
    public R updateStaffById(@PathVariable(value = "state") int state,
                             @PathVariable(value = "id") int id){
        int i = tripService.updateStaffById(state, id);
        return i > 0 ? r.success():r.error();
    }
}
