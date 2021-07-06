
package com.service.Impl;

import com.dao.OtherConsumeDao;
import com.dao.ScheduleDao;
import com.dao.TripDao;
import com.dao.TripInfoDao;
import com.pojo.Otherconsume;
import com.pojo.Schedule;
import com.pojo.Trip;
import com.pojo.TripInfo;
import com.pojo.Vo.TripVo;
import com.service.TripService;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripImpl implements TripService {
    @Autowired
    private TripDao tripDao;
    @Autowired
    private TripInfoDao tripInfoDao;
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private OtherConsumeDao otherConsumeDao;

    public List<Trip> queryAllTrip() {
        return tripDao.queryAllTrip();
    }

    public List<TripInfo> queryTripInfoById(int id) {
        return tripInfoDao.queryTripInfoById(id);
    }

    public List<Trip> queryApproveTrip(int staffId) {
        return tripDao.queryApproveTrip(staffId);
    }

    public int AddTrip(TripVo tripVo) {
        Trip trip=new Trip();
        trip.setApplyTime(new Date());
        trip.setApprovalId(tripVo.getApprovalId());
        trip.setCategory(tripVo.getCategory());
        trip.setReason(tripVo.getReason());
        trip.setDuration(tripVo.getDuration());
        trip.setEndTime(tripVo.getEndTime());
        trip.setStartTime(tripVo.getStartTime());
        trip.setAmount(tripVo.getAmount());
        trip.setStaffId(tripVo.getStaffId());
        trip.setState(0);
        int i = tripDao.AddTrip(trip);
        System.out.println(trip.getTripId());
        if (i>0){
            List<Schedule> r = tripVo.getSchedules();
            r.forEach(item->{ item.setTripId(trip.getTripId());});
            scheduleDao.AddSchedule(r);
        }else {
            return -1;
        }
        List<Otherconsume> otherconsumes = tripVo.getOtherconsumes();
        otherconsumes.forEach(item->{item.setTripId(trip.getTripId());});
        return otherConsumeDao.AddOtherConsume(otherconsumes);
    }

    @Override
    public List<Trip> querySubordinateTrip(Integer state, String category, Integer duration) {
        return tripDao.querySubordinateTrip(state, category, duration);
    }

    @Override
    public int updateStaffById(int state, int id) {
        return tripDao.updateStaffById(state,id);
    }

    @Override
    public List<Trip> queryEmpTrip(int staffId,Integer pageNum,Integer pageSize) {
        return tripDao.queryEmpTrip(staffId,pageNum,pageSize);
    }
}
