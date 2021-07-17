package com.service;

import com.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {

    List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize);

    List<Staff> queryAll(String userName);

    /**
     * 查询未批准请假
     */
    List<Staff>  queryApprove(Integer pageNum,Integer pageSize);

    /**
     * 上传头像
     */
    String changeAvatar(MultipartFile file) throws IOException;


    Staff queryUserAndPass(String username ,String password);


    int updateToken(String token, int id);

    List<Staff> queryMyLeave(Integer state,
                             String category,
                             Integer duration);

    int addNewStaff(Staff newStaff);

    int rePassword(int staffId);

    int deleteStaffById(int staffId);

    int updateStaffInfo(Staff staff);

    Staff queryStaffByName(String username);

    List<Staff> queryBoss();

    List<Staff> queryListById(List<Integer> names);

    int deleteListById( List<Integer> ids);
}
