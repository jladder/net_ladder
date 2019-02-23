package cn.iceroot.net_ladder.test;

import cn.hutool.core.util.RandomUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.iceroot.net_ladder.pojo.RunLog;
import cn.iceroot.net_ladder.service.RunLogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })
public class RunLogSpringTest {
    @Autowired
    private RunLogService runLogService;

    // @Test
    public void saveRunLog() {
        RunLog runLog = new RunLog();
        // runLog.setId(RandomUtil.randomInt(10000));
        runLog.setName(RandomUtil.randomString(8));
        runLog.setUrl(RandomUtil.randomString(8));
        runLog.setStatusCode(RandomUtil.randomString(8));
        runLog.setContentType(RandomUtil.randomString(8));
        runLog.setContentLength(RandomUtil.randomString(8));
        runLog.setContentEncoding(RandomUtil.randomString(8));
        runLog.setProtocolVersion(RandomUtil.randomString(8));
        runLog.setReasonPhrase(RandomUtil.randomString(8));
        runLog.setCreateTime(RandomUtil.randomString(8));
        runLog.setContent(RandomUtil.randomString(8));
        runLogService.saveRunLog(runLog);
    }

    @Test
    public void test() {

    }
}
