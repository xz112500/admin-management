package com.dao;

import com.pojo.Reimbursementcontent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementContentDao {
    int AddReimbursementContent(Reimbursementcontent reimbursementcontent );

    List<Reimbursementcontent> queryAllContent();
}
