package cn.iceroot.net_ladder.service;

import java.util.List;

import cn.iceroot.net_ladder.pojo.ErrorLog;

public interface ErrorLogService {
    void saveErrorLog(ErrorLog errorLog);

    ErrorLog getErrorLogById(Integer id);

    List<ErrorLog> getAll();

    int deleteBatch(String[] ids);
}
