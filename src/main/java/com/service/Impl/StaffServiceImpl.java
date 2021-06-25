package com.service.Impl;

import com.dao.StaffDao;
import com.pojo.Askforleave;
import com.pojo.Staff;
import com.service.StaffService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize) {
        return staffDao.queryStaffById(id, pageNum, pageSize);
    }

    @Override
    public List<Staff> queryAll() {
        return staffDao.queryAll();
    }

    @Override
    public List<Staff> queryApprove() {
        return staffDao.queryApprove();
    }

    @Override
    public String changeAvatar(MultipartFile file) throws IOException {
        String Base64=null;
        String Filename = file.getOriginalFilename();
        InputStream inputStream = null;
        BufferedOutputStream bw=null;
        try{
            inputStream = file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            String path = "/home/fine/Avatar/";
            byte[] b=new byte[1024];
            int len;
            File tempFile =new File(path);
            if (!tempFile.exists()){
                tempFile.mkdir();
            }
            UUID uuid=UUID.randomUUID();
            String substring = null;
            if (Filename != null) {
                substring = Filename.substring(Filename.lastIndexOf("."));
            }
            bw = new BufferedOutputStream(new FileOutputStream(path+uuid+substring));
            if (inputStream != null) {
                while ((len = inputStream.read(b))!=-1){
                    bw.write(b,0,len);
                }
            }else {
                return null;
            }
            BASE64Encoder encoder=new BASE64Encoder();
            Base64 = encoder.encodeBuffer(b);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bw != null) {
                bw.flush();
                bw.close();
            }
        }
        return Base64;
    }

/*    @Override
    public List<Staff> Approve() {
        List<Staff> staff = staffDao.queryAll();
        staff.forEach(item->{
            Set<Askforleave> askforleave = item.getAskforleave();
            Set<Askforleave> collect = askforleave.stream().
            filter(n -> n.getState() == 1).collect(Collectors.toSet());
            item.setAskforleave(collect);
        });
        return null;
    }*/



}
