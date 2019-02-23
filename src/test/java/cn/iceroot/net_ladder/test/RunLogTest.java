package cn.iceroot.net_ladder.test;

import cn.hutool.core.util.RandomUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.iceroot.net_ladder.pojo.RunLog;
import cn.iceroot.net_ladder.service.RunLogService;

public class RunLogTest {
    private RunLogService runLogService;

    @Before
    public void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml", "spring-mybatis.xml" });
        runLogService = (RunLogService) ac.getBean("runLogService");
    }

    @After
    public void after() {

    }

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
