package cn.iceroot.net_ladder.service;

import java.util.List;

import cn.iceroot.net_ladder.pojo.RunLog;

public interface RunLogService {
    void saveRunLog(RunLog runLog);

    RunLog getRunLogById(Integer id);

    List<RunLog> getAll();

    int deleteBatch(String[] ids);
}
