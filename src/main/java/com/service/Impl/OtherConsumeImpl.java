//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service.Impl;

import com.dao.OtherConsumeDao;
import com.pojo.Otherconsume;
import com.service.OtherConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherConsumeImpl implements OtherConsumeService {
    @Autowired
    private OtherConsumeDao otherConsumeDao;

    public OtherConsumeImpl() {
    }

    public int AddOtherConsume(Otherconsume otherconsume) {
        return this.otherConsumeDao.AddOtherConsume(otherconsume);
    }
}
