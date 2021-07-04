
package com.dao;

import com.pojo.TripInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripInfoDao {
    List<TripInfo> queryTripInfoById(@Param("id") int id);
}
