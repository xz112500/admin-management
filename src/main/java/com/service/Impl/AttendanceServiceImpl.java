package com.service.Impl;

import ch.qos.logback.core.util.TimeUtil;
import com.dao.AttendanceDao;
import com.dao.HolidayDao;
import com.pojo.Attendance;
import com.pojo.Holidays;
import com.pojo.Vo.AttendanceVo;
import com.pojo.Vo.AttendanceVo1;
import com.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private HolidayDao holidayDao;
    /**
     * 个人考勤查看
     * 日查询
     */
    //查看个人的日考勤情况
    @Override
    public List<Attendance> queryAttendanceDay(int staffId, Integer pageNum, Integer pageSize) {
        return attendanceDao.queryAttendanceDay(staffId,(pageNum-1)*pageSize,pageSize);
    }
    //查看个人的日考勤情况按选择的时间来查
    @Override
    public List<Attendance> queryAttendanceDayByTime(int staffId, Date date, Integer pageNum, Integer pageSize) {
        Date time=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        try {
            time=format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return attendanceDao.queryAttendanceDayByTime(staffId,time,(pageNum-1)*pageSize,pageSize);
    }

    /**
     * 月查询
     */
    //查看个人的月考勤情况按选择的时间来查
    @Override
    public List<Attendance> queryAttendanceMonthByTime(int staffId, Date date, Integer pageNum, Integer pageSize) {
        List<Attendance> attendances = attendanceDao.queryAttendanceMonthByTime(staffId, pageNum, pageSize);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DAY_OF_MONTH,-30);
        Integer[] arr ={1,3,5,7,8,10,12};
        List<Integer> arrs=Arrays.asList(arr);
        int month=date.getMonth()+2;
        boolean contains = arrs.contains(month);
        if (contains){
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        if (month == 2){
            calendar.add(Calendar.DAY_OF_MONTH,28);
        } else {calendar.add(Calendar.DAY_OF_MONTH,30);}
        List<Attendance> collect = attendances.stream().filter(n -> n.getDateId().after(date)
        && n.getDateId().before(calendar.getTime())||n.getDateId().equals(calendar.getTime()))
        .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)){
            return Collections.emptyList();
        }else {
            return collect;
        }

    /*    ArrayList<AttendanceVo> attendanceVos = new ArrayList<>();
        Date date1 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        date1=cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date date2 = new Date();
        date2=cal.getTime();
        List<Attendance> attendances =attendanceDao.queryAttendanceMonthByTime(staffId, date1, date2, (pageNum - 1) * pageSize, pageSize);
        Map<Date,Integer> map = new HashMap<>();
        for (int i = 0; i < attendances.size(); i++) {
            Attendance attendance = attendances.get(i);
            Date dateId = attendance.getDateId();
            map.put(dateId,attendance.getClockintimeList().size());
        }
        List<Attendance> attendances1 = attendanceDao.queryAttendanceAll(staffId, date1, date2, (pageNum - 1) * pageSize, pageSize);
        for (int i = 0; i < attendances1.size(); i++) {
            if(map.get(attendances1.get(i).getDateId())!=null){
                attendanceVos.add(new AttendanceVo(attendances1.get(i).getDateId(),map.get(attendances1.get(i).getDateId()),attendances1.get(i).getCheckInTime(),attendances1.get(i).getSignOutTime(),attendances1.get(i).getRemark()));
            }else {
                attendanceVos.add(new AttendanceVo(attendances1.get(i).getDateId(),0,attendances1.get(i).getCheckInTime(),attendances1.get(i).getSignOutTime(),attendances1.get(i).getRemark()));
            }
        }
        int outSum=0,askForLeaveSum=0,trip=0,holidaysSum=0,atTimeSum=0;
        for (AttendanceVo attendanceVo : attendanceVos) {
            Date dateId = attendanceVo.getDateId();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String s = simpleDateFormat.format(dateId);
            String s1=s+" 09:00:00",s2=s+" 17:00:00";
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start=new Date();
            Date end=new Date();
            try {
                start = simpleDateFormat1.parse(s1);
                end = simpleDateFormat1.parse(s2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (attendanceVo.getClockSum()==0){
                if(attendanceVo.getRemark().equals("请假")){
                    askForLeaveSum++;
                }else if(attendanceVo.getRemark().equals("出差")){
                    trip++;
                }else if(attendanceVo.getRemark().equals("假期")){
                    holidaysSum++;
                }
            }else{
                if(attendanceVo.getCheckInTime().compareTo(start)>=0 || attendanceVo.getSignOutTime().compareTo(end)<=0){
                    outSum++;
                }else{
                    atTimeSum++;
                }
            }

        }
        AttendanceVo1 attendanceVo1 = new AttendanceVo1();
        attendanceVo1.setAttendanceVos(attendanceVos);
        attendanceVo1.setAskForLeaveSum(askForLeaveSum);
        attendanceVo1.setAtTimeSum(atTimeSum);
        attendanceVo1.setHolidaysSum(holidaysSum);
        attendanceVo1.setOutSum(outSum);
        attendanceVo1.setTrip(trip);

        return attendanceVo1;*/
    }

}
