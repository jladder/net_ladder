package cn.iceroot.net_ladder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iceroot.net_ladder.dao.ErrorLogMapper;
import cn.iceroot.net_ladder.pojo.ErrorLog;
import cn.iceroot.net_ladder.service.ErrorLogService;

@Service("errorLogService")
public class ErrorLogServiceImpl implements ErrorLogService {
    @Autowired
    private ErrorLogMapper errorLogMapper;

    public void saveErrorLog(ErrorLog errorLog) {
        errorLogMapper.saveErrorLog(errorLog);
    }

    public ErrorLog getErrorLogById(Integer errorLogId) {
        return errorLogMapper.getErrorLogById(errorLogId);
    }

    public List<ErrorLog> getAll() {
        return errorLogMapper.findAll();
    }

    public int deleteBatch(String[] ids) {
        Integer[] idsInt = idsInt(ids);
        return errorLogMapper.deleteBatch(idsInt);
    }

    private Integer[] idsInt(String[] ids) {
        Integer[] nums = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            nums[i] = Integer.parseInt(ids[i]);
        }
        return nums;
    }
}
