package com.dao;

import com.pojo.Trip;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao {
    List<Trip> queryAllTrip();

    List<Trip> queryApproveTrip(@Param("staffId")int staffId);

    int AddTrip(Trip trip);

    List<Trip> querySubordinateTrip(@Param("state")Integer state,
                                    @Param("category") String category,
                                    @Param("duration") Integer duration);

    int updateStaffById(@Param("state") int state,
                        @Param("id") int id);

    List<Trip> queryEmpTrip(@Param("staffId") int staffId,
                            @Param("pageNum")Integer pageNum,
                            @Param("pageSize") Integer pageSize);
}
