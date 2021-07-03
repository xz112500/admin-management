package com.service.Impl;

import com.dao.StaffDao;
import com.pojo.Staff;
import com.service.StaffService;
import com.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class StaffImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize) {
        return staffDao.queryStaffById(id, pageNum, pageSize);
    }

    @Override
    public List<Staff> queryAll(String userName) {
        return staffDao.queryAll(userName);
    }

    @Override
    public List<Staff> queryApprove(Integer pageNum,Integer pageSize) {
        return staffDao.queryApprove(pageNum, pageSize);
    }

    @Override
    public String changeAvatar(MultipartFile file) throws IOException {
        String Base64=null;
        String sub=null;
        String Filename = file.getOriginalFilename();
        InputStream inputStream = null;
        BufferedOutputStream bw=null;
        try{
            inputStream = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            String path = "/home/fine/桌面/application/app/static/";
            byte[] b=new byte[1024];
            int len;
            File tempFile =new File(path);
            if (!tempFile.exists()){
                tempFile.mkdir();
            }
            UUID uuid=UUID.randomUUID();
            String name="1";
            String substring = null;
            if (Filename != null) {
                substring = Filename.substring(Filename.lastIndexOf("."));
                sub=substring;
            }
            Base64=uuid.toString();
            bw = new BufferedOutputStream(new FileOutputStream(path+name+substring));
            if (inputStream != null) {
                while ((len = inputStream.read(b))!=-1){
                    bw.write(b,0,len);
                }
            }else {
                return null;
            }
         /*   BASE64Encoder encoder=new BASE64Encoder();
            Base64 = encoder.encodeBuffer(b);*/
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bw != null) {
                bw.flush();
                bw.close();
            }
        }
        return "ok";
    }

    public Staff queryUserAndPass(String username, String password) {
        Staff staff = this.staffDao.queryUserAndPass(username, password);
        if (staff != null) {
            String token = JWTUtil.getToken(staff.getStaffId(), staff.getUserName(), staff.getPassword());
            this.staffDao.updateToken(token,staff.getStaffId());
            staff.setToken(token);
            return staff;
        } else {
            return null;
        }
    }

    public int updateToken(String token, int id) {
        return staffDao.updateToken(token, id);
    }

    @Override
    public List<Staff> queryMyLeave(Integer state, String category, Integer duration) {
        return staffDao.queryMyLeave(state, category, duration);
    }

    @Override
    @Transactional
    public int addNewStaff(Staff newStaff) {
        return staffDao.addNewStaff(newStaff);
    }

    @Override
    @Transactional
    public int rePassword(int staffId) {
        return staffDao.rePassword(staffId);
    }

    @Override
    @Transactional
    public int deleteStaffById(int staffId) {
        return staffDao.deleteStaffById(staffId);
    }

    @Override
    @Transactional
    public int updateStaffInfo(Staff staff) {
        return staffDao.updateStaffInfo(staff);
    }

    @Override
    public Staff queryStaffByName(String username) {
        return staffDao.queryStaffByName(username);
    }

}
