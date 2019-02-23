package cn.iceroot.net_ladder.test;

import cn.hutool.core.util.RandomUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.iceroot.net_ladder.pojo.ErrorLog;
import cn.iceroot.net_ladder.service.ErrorLogService;

public class ErrorLogTest {
    private ErrorLogService errorLogService;

    @Before
    public void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml", "spring-mybatis.xml" });
        errorLogService = (ErrorLogService) ac.getBean("errorLogService");
    }

    @After
    public void after() {

    }

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
