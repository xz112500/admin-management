package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dao.AttendanceDao;
import com.dao.HolidayDao;
import com.dao.ReimbursementSubjectsDao;
import com.pojo.Holidays;
import com.pojo.Otherconsume;
import com.pojo.Staff;
import com.service.OtherConsumeService;
import com.service.StaffService;
import com.utils.SimpleFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class AdminManagementApplicationTests {
   @Autowired
   private OtherConsumeService otherConsumeService;
   @Autowired
   private ReimbursementSubjectsDao reimbursementSubjectsDao;
   @Autowired
   private StaffService staffService;
    @Autowired
    private HolidayDao holidayDao;
    @Autowired
    private AttendanceDao attendanceDao;
    @Test
    void contextLoads() throws MalformedURLException {
   /*     String Filename="1232.com";
        String substring = Filename.substring(Filename.lastIndexOf("."));
        System.out.println(substring);*/
      /*  adminDao.queryAll();*/
        List<Otherconsume> otherconsumes=new ArrayList<>();
        Otherconsume otherconsume=new Otherconsume();
        Otherconsume otherconsume1=new Otherconsume();
        otherconsume.setCost(1000);
        otherconsume.setConsumeType("吃饭");
        otherconsume.setTripId(1);
        otherconsume1.setCost(2000);
        otherconsume1.setConsumeType("睡觉");
        otherconsume1.setTripId(1);
        otherconsumes.add(otherconsume);
        otherconsumes.add(otherconsume1);
        otherConsumeService.AddOtherConsume(otherconsumes);

    }
    @Test
    public void Test6(){
        System.out.println(reimbursementSubjectsDao.queryAllSub());
    }
    @Test
    public void  Test4(){
        System.out.println(staffService.queryStaffByName("xz"));
    }
    @Test
    public void Test5(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


/*        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH,12-(new Date().getMonth()+1));
        System.out.println(cal.getTime());
        System.out.println(new Date().getMonth());
        List<Holidays> holidays = holidayDao.queryHolidayTime();
        List<Holidays> collect = holidays.stream().filter(n -> n.getHolidayStartTime().after(cal.getTime())
        && n.getHolidayEndTime().before(time)).collect(Collectors.toList());*/
       /* if (time.after(time) && time.before(cal.getTime())){
        }*/
/*      List<Integer> names=new ArrayList<>();
      names.add(1);
      names.add(2);
      names.add(3);
        List<Staff> staff = staffService.queryListById(names);
        staff.forEach(item->{
            System.out.println(JSONObject.parseObject(JSON.toJSONString(item)));
        });
        List<Integer> id=new ArrayList<>();
        id.add(6);
        id.add(7);
        staffService.deleteListById(id);*/
        System.out.println(attendanceDao.queryAttendanceMonthByTime(1,1,5));
        System.out.println(format.format("Thu Jul 01 2021 00:00:00 GMT+0800"));
    }
}
