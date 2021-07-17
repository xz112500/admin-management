package com.controller;

import com.annotation.Admin;
import com.pojo.Holidays;
import com.pojo.Vo.HolidayVo;
import com.service.HolidayService;
import com.utils.BeanUtil;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping(value = "Holidays")
@CrossOrigin
@Controller
@ResponseBody
public class HolidaysController {
    @Autowired
    private R r;
    @Autowired
    private HolidayService holidaysService;
    /**
     * 节假日修改
     */
    //查看全部假期
    @GetMapping("/queryHolidayTime")
    public R queryHolidayTime(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value="pageSize",defaultValue = "4") Integer pageSize){
        return r.success(holidaysService.queryHolidayAllTime((pageNum-1)*pageSize,pageSize));
    }

    //查看该年假期
    @GetMapping("/queryHolidayTimeByYear")
    public R queryHolidayTimeByYear(@RequestParam("year") @DateTimeFormat(pattern="yyyy-MM-dd") Date year){
        return r.success(holidaysService.queryHolidayTimeByYear(year));
    }

    //添加假期
    @PostMapping("/addHolidayTimeByTime")
    @Admin
    public R addHolidayTimeByTime(@RequestBody Holidays holidays){
        return r.success(holidaysService.addHolidayTimeByTime(holidays));
    }

    //删除假期
    @DeleteMapping("/delectHolidayTimeById/{holidayId}")
    @Admin
    public R delectHolidayTimeById(@PathVariable(value = "holidayId") int holidayId){
        return r.success(holidaysService.delectHolidayTimeById(holidayId));
    }
}
