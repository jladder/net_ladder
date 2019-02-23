package cn.iceroot.net_ladder.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iceroot.net_ladder.pojo.RunLog;
import cn.iceroot.net_ladder.service.RunLogService;

@Controller
@RequestMapping("/runLog")
public class RunLogController {

    private static Logger log = Logger.getLogger(RunLogController.class);
    @Autowired
    private RunLogService runLogService;

    // http://127.0.0.1:8080/net_ladder/runLog/find.do
    @RequestMapping("/find")
    public String find(HttpServletRequest request, HttpServletResponse response) {
        log.info("/runLog/find.do");
        List<RunLog> runLog = runLogService.getAll();
        request.setAttribute("runLogList", runLog);
        return "runLog";
    }

    // http://127.0.0.1:8080/net_ladder/runLog/list.do
    @ResponseBody
    @RequestMapping("/list")
    public List<RunLog> list(HttpServletRequest request, HttpServletResponse response) {
        log.info("/runLog/list.do");
        List<RunLog> runLog = runLogService.getAll();
        return runLog;
    }

    // http://127.0.0.1:8080/net_ladder/runLog/batchDelete.html?ids=1001,1002
    @RequestMapping("/batchDelete")
    public String batchDelete(String[] ids, HttpServletRequest request, HttpServletResponse response) {
        log.info("ids=" + Arrays.toString(ids));
        int count = runLogService.deleteBatch(ids);
        System.out.println("删除" + count + "条记录");
        return "redirect:/runLog/find.html";
    }

    // http://127.0.0.1:8080/net_ladder/runLog/update.do
    @ResponseBody
    @RequestMapping("/update")
    public List<RunLog> update(HttpServletRequest request, HttpServletResponse response) {
        log.info("/runLog/update.do");
        //List<RunLog> runLog = runLogService.update();
        return null;
    }
}
