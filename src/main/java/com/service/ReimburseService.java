//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service;

import com.pojo.Reimbursement;
import com.pojo.Reimbursementsubjects;
import com.pojo.Vo.ReimbursementSubVo;
import com.pojo.Vo.ReimbursementVo;
import java.util.List;

public interface ReimburseService {
    /**
     * 添加报销申请
     * @param reimbursementVo
     * @return
     */
    int AddReimburse(ReimbursementVo reimbursementVo);

    /**
     * 查询所有报销信息详情
     * @return
     */
    List<Reimbursement> queryAllReim();

    /**
     *添加报销科目
     * @param reimbursementSubVo
     * @return
     */
    int AddReimbursementSub(ReimbursementSubVo reimbursementSubVo);

    /**
     * 查询所有报销科目
     * @return
     */
    List<Reimbursementsubjects> queryAllSub();

    /**
     * 查询所有未审批报销
     * @return
     */
    List<Reimbursement> queryApprove();

    /**
     * 通过id查询报销信息
     * @param id
     * @return
     */
    List<Reimbursement> queryReimById(int id);
}
