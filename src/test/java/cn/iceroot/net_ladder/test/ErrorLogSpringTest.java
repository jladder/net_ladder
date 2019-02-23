package cn.iceroot.net_ladder.test;

import cn.hutool.core.util.RandomUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.iceroot.net_ladder.pojo.ErrorLog;
import cn.iceroot.net_ladder.service.ErrorLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })
public class ErrorLogSpringTest {
    @Autowired
    private ErrorLogService errorLogService;

    // @Test
    public void saveErrorLog() {
        ErrorLog errorLog = new ErrorLog();
        // errorLog.setId(RandomUtil.randomInt(10000));
        errorLog.setName(RandomUtil.randomString(8));
        errorLog.setUrl(RandomUtil.randomString(8));
        errorLog.setStatusCode(RandomUtil.randomString(8));
        errorLog.setContentType(RandomUtil.randomString(8));
        errorLog.setContentLength(RandomUtil.randomString(8));
        errorLog.setContentEncoding(RandomUtil.randomString(8));
        errorLog.setProtocolVersion(RandomUtil.randomString(8));
        errorLog.setReasonPhrase(RandomUtil.randomString(8));
        errorLog.setCreateTime(RandomUtil.randomString(8));
        errorLog.setContent(RandomUtil.randomString(8));
        errorLogService.saveErrorLog(errorLog);
    }

    @Test
    public void test() {

    }
}
