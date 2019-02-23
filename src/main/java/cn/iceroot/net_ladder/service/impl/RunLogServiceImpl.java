package cn.iceroot.net_ladder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iceroot.net_ladder.dao.RunLogMapper;
import cn.iceroot.net_ladder.pojo.RunLog;
import cn.iceroot.net_ladder.service.RunLogService;

@Service("runLogService")
public class RunLogServiceImpl implements RunLogService {
    @Autowired
    private RunLogMapper runLogMapper;

    public void saveRunLog(RunLog runLog) {
        runLogMapper.saveRunLog(runLog);
    }

    public RunLog getRunLogById(Integer runLogId) {
        return runLogMapper.getRunLogById(runLogId);
    }

    public List<RunLog> getAll() {
        return runLogMapper.findAll();
    }

    public int deleteBatch(String[] ids) {
        Integer[] idsInt = idsInt(ids);
        return runLogMapper.deleteBatch(idsInt);
    }

    private Integer[] idsInt(String[] ids) {
        Integer[] nums = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            nums[i] = Integer.parseInt(ids[i]);
        }
        return nums;
    }
}
