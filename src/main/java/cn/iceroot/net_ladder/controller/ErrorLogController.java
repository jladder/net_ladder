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

import cn.iceroot.net_ladder.pojo.ErrorLog;
import cn.iceroot.net_ladder.service.ErrorLogService;

@Controller
@RequestMapping("/errorLog")
public class ErrorLogController {

    private static Logger log = Logger.getLogger(ErrorLogController.class);
    @Autowired
    private ErrorLogService errorLogService;

    // http://127.0.0.1:8080/net_ladder/errorLog/find.do
    @RequestMapping("/find")
    public String find(HttpServletRequest request, HttpServletResponse response) {
        log.info("/errorLog/find.do");
        List<ErrorLog> errorLog = errorLogService.getAll();
        request.setAttribute("errorLogList", errorLog);
        return "errorLog";
    }

    // http://127.0.0.1:8080/net_ladder/errorLog/list.do
    @ResponseBody
    @RequestMapping("/list")
    public List<ErrorLog> list(HttpServletRequest request, HttpServletResponse response) {
        log.info("/errorLog/list.do");
        List<ErrorLog> errorLog = errorLogService.getAll();
        return errorLog;
    }

    // http://127.0.0.1:8080/net_ladder/errorLog/batchDelete.html?ids=1001,1002
    @RequestMapping("/batchDelete")
    public String batchDelete(String[] ids, HttpServletRequest request, HttpServletResponse response) {
        log.info("ids=" + Arrays.toString(ids));
        int count = errorLogService.deleteBatch(ids);
        System.out.println("删除" + count + "条记录");
        return "redirect:/errorLog/find.html";
    }

    // http://127.0.0.1:8080/net_ladder/errorLog/update.do
    @ResponseBody
    @RequestMapping("/update")
    public List<ErrorLog> update(HttpServletRequest request, HttpServletResponse response) {
        log.info("/errorLog/update.do");
        // List<ErrorLog> errorLog = errorLogService.update();
        return null;
    }
}
