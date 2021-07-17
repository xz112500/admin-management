package com.service.Impl;

import com.dao.HolidayDao;
import com.pojo.Holidays;
import com.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class HolidayImpl implements HolidayService {
    @Autowired
    private HolidayDao holidayDao;
    @Override
    public List<Holidays> queryHolidayTime() {
        List<Holidays> holidays = holidayDao.queryHolidayTime();
        List<Holidays> collect = holidays.stream().sorted(Comparator.comparing(Holidays::getHolidayEndTime).reversed())
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Holidays> queryHolidayAllTime(Integer pageNum, Integer pageSize) {
        List<Holidays> holidays = holidayDao.queryHolidayAllTime(pageNum, pageSize);
        List<Holidays> collect = holidays.stream().sorted(Comparator.comparing(Holidays::getHolidayEndTime).reversed())
                .collect(Collectors.toList());
        return collect;
    }
    //查看该年假期
    @Override
    public List<Holidays> queryHolidayTimeByYear(Date year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(year);
        cal.add(Calendar.MONTH,12);
        cal.add(Calendar.DAY_OF_MONTH,31);
        List<Holidays> holidays = holidayDao.queryHolidayTime();
        System.out.println(holidays);
        List<Holidays> collect = holidays.stream().filter(n -> n.getHolidayStartTime().after(year)
                && n.getHolidayEndTime().before(cal.getTime())).collect(Collectors.toList());
        System.out.println(collect);
      /* if (CollectionUtils.isEmpty(collect)){
            return Collections.emptyList();
        }*/
        return CollectionUtils.isEmpty(collect)?Collections.emptyList():collect;
    }
    //添加假期
    @Override
    @Transactional
    public int addHolidayTimeByTime(Holidays holidays) {
        return holidayDao.addHolidayTimeByTime(holidays);
    }
    //删除假期
    @Override
    @Transactional
    public int delectHolidayTimeById(int id) {
        return holidayDao.delectHolidayTimeById(id);
    }

}
