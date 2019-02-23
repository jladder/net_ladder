package cn.iceroot.net_ladder.task;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iceyyy.workday.WorkUtils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.iceroot.net_ladder.context.LadderContext;
import cn.iceroot.net_ladder.dao.ErrorLogMapper;
import cn.iceroot.net_ladder.dao.RunLogMapper;
import cn.iceroot.net_ladder.pojo.ErrorLog;
import cn.iceroot.net_ladder.pojo.RunLog;
import cn.iceroot.net_ladder.util.LadderUtil;
import cn.iceroot.net_ladder.util.NetLadderCountUtil;
import cn.iceroot.net_ladder.valve.TimeValve;

@Service
public class LadderScheduleTask {
    @Value("${jdbc.driver}")
    private String url;
    @Autowired
    private RunLogMapper runLogMapper;
    @Autowired
    private ErrorLogMapper errorLogMapper;

    public void task() {
        String now = DateUtil.now();
        System.out.println("___________执行定时任务now_________" + now + ">" + url);
        System.out.println();
        NetLadderCountUtil.accumulation();
        boolean flag = TimeValve.valve();
        if (!flag) {
            return;
        }
        List<String> netList = LadderContext.getNetList();
        List<String> nameList = LadderContext.getNameList();
        Map<String, String> netMap = LadderContext.getNetMap();
        Map<String, String> nameMap = LadderContext.getNameMap();
        System.out.println(netList);
        System.out.println(nameList);
        System.out.println(netMap);
        System.out.println(nameMap);
        for (int i = 0; i < netList.size(); i++) {
            String url = netList.get(i);
            if (StrUtil.isNotBlank(url)) {
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                monitor(url, runLogMapper, errorLogMapper, netMap);
            }
        }
    }

    private void monitor(String url, RunLogMapper runLogMapper, ErrorLogMapper errorLogMapper,
            Map<String, String> netMap) {
        RunLog runLog = new RunLog();
        String name = netMap.get(url);
        runLog.setName(name);
        runLog.setUrl(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        Builder config = RequestConfig.custom();
        RequestConfig requestConfig = config.setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).setRedirectsEnabled(true).build();
        get.setConfig(requestConfig);
        get.setHeader("Accept-Encoding", "identity");
        String createTime = DateUtil.now();
        runLog.setCreateTime(createTime);
        try {
            response = httpClient.execute(get);
            // } catch (ClientProtocolException e) {
            // e.printStackTrace();
            // } catch (java.net.UnknownHostException e ) {
            // e.printStackTrace();
            // Map<String, String> lastStateMap =
            // LadderContext.getLastStateMap();
            // String lastState = lastStateMap.get(url);
            // if ("true".equals(lastState)) {
            // errorLog(name, url);
            // }
            // lastStateMap.put(url, "false");
            // int saveRunLog = runLogMapper.saveRunLog(runLog);
            // System.out.println("-----1");
            // return;
        } catch (org.apache.http.conn.HttpHostConnectException e) {
            e.printStackTrace();
            Map<String, String> lastStateMap = LadderContext.getLastStateMap();
            String lastState = lastStateMap.get(url);
            if ("true".equals(lastState)) {
                errorLog(name, url);
            }
            lastStateMap.put(url, "false");
            int saveRunLog = runLogMapper.saveRunLog(runLog);
            return;
            // } catch (java.net.ConnectException e ) {
            // e.printStackTrace();
            // Map<String, String> lastStateMap =
            // LadderContext.getLastStateMap();
            // String lastState = lastStateMap.get(url);
            // if ("true".equals(lastState)) {
            // errorLog(name, url);
            // }
            // lastStateMap.put(url, "false");
            // int saveRunLog = runLogMapper.saveRunLog(runLog);
            // System.out.println("-----3");
            // return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        ProtocolVersion protocolVersion = statusLine.getProtocolVersion();
        String reasonPhrase = statusLine.getReasonPhrase();
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long contentLength = entity.getContentLength();
        Header contentType = entity.getContentType();
        Header contentEncoding = entity.getContentEncoding();
        get.abort();
        System.out.println("statusCode=" + statusCode);
        System.out.println("protocolVersion=" + protocolVersion);
        System.out.println("reasonPhrase=" + reasonPhrase);
        System.out.println("contentLength=" + contentLength);
        System.out.println("contentType=" + contentType);
        System.out.println("contentType=>" + contentType.toString());
        System.out.println("contentEncoding=" + contentEncoding);
        System.out.println("---------------------------------");
        // System.out.println("result=" + result);
        runLog.setStatusCode(statusCode + "");
        runLog.setProtocolVersion(LadderUtil.format(protocolVersion));
        runLog.setReasonPhrase(reasonPhrase);
        runLog.setContentLength(LadderUtil.format(contentLength));
        runLog.setContentType(LadderUtil.formatContentType(contentType));
        runLog.setContentEncoding(LadderUtil.format(contentEncoding));
        String content = StrUtil.subPre(result, 512);
        runLog.setContent(content);
        int saveRunLog = runLogMapper.saveRunLog(runLog);
        Map<String, String> lastStateMap = LadderContext.getLastStateMap();
        lastStateMap.put(url, "true");
    }

    private void errorLog(String name, String url) {
        ErrorLog error = new ErrorLog();
        error.setName(name);
        error.setUrl(url);
        String createTime = DateUtil.now();
        error.setCreateTime(createTime);
        errorLogMapper.saveErrorLog(error);
        // 发邮件 TODO
    }
}
