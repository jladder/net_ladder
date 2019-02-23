package cn.iceroot.net_ladder.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.iceroot.net_ladder.pojo.ErrorLog;

public interface ErrorLogMapper {
    int deleteErrorLog(Integer id);

    int saveErrorLog(ErrorLog record);

    int insertSelective(ErrorLog record);

    ErrorLog getErrorLogById(Integer id);

    int updateErrorLog(ErrorLog record);

    int updateByPrimaryKey(ErrorLog record);

    List<ErrorLog> findAll();

    int deleteBatch(@Param("ids")Integer[] ids);
}
