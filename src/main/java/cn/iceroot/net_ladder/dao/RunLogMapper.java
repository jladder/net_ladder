package cn.iceroot.net_ladder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.iceroot.net_ladder.pojo.RunLog;

public interface RunLogMapper {
    int deleteRunLog(Integer id);

    int saveRunLog(RunLog record);

    int insertSelective(RunLog record);

    RunLog getRunLogById(Integer id);

    int updateRunLog(RunLog record);

    int updateByPrimaryKey(RunLog record);

    List<RunLog> findAll();

    int deleteBatch(@Param("ids")Integer[] ids);
}
