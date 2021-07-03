package com.dao;

import com.pojo.Askforleave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AskforLeaveDao {
    /**
     * @param askforleave
     * @return 影响行数
     * 注解插入
     */
/*    @Insert(value = "   insert into askforleave (ApplyTime,StartTime,EndTime,Duration,Applicant,Category,Reason,State,ApprovalId)\n" +
            "        value (#{applyTime},#{startTime},#{endTime},#{duration},#{applicant},#{category},#{reason},#{state},#{approvalId})")*/
    int InsertLeave(Askforleave askforleave);

    /**
     *
     * @param state
     * @param id
     * @return 影响行数
     * 修改状态
     */
    int updateStateById(@Param("state") int state,@Param("id") int id);

    /**
     * 查询所有请假
     * @return
     */
    List<Askforleave> queryAllLeave();

    /**
     * 查询请假未批准
     * @return
     */
    List<Askforleave> queryApprove();

    List<Askforleave> queryMyAcc(int staffId);

    List<Askforleave> queryMyAsk(int staffId);

    List<Askforleave> queryOrgAsk();

    List<Askforleave> queryMyEmpAsk(int staffId);

    //查看该月的请假记录
    List<Askforleave> queryAskforleaveAllByTime(int id, Date stratTime, Date endTime, Integer pageNum, Integer pageSize);

    //所有请假记录
    List<Askforleave> queryAskforleaveAll(int id,Integer pageNum, Integer pageSize);

}
