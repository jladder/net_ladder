package cn.iceroot.net_ladder.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.Setting;
import cn.iceroot.net_ladder.context.LadderContext;

public class LadderUtil {
    public static void loadProp() {
        List<String> netList = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();
        Map<String, String> netMap = new HashMap<String, String>();
        Map<String, String> nameMap = new HashMap<String, String>();
        Setting setting = new Setting("net.properties");
        int propLength = 10;
        for (int i = 0; i < propLength; i++) {
            String netKey = "url" + i;
            String nameKey = "name" + i;
            String netValue = setting.getStr(netKey);
            String nameValue = setting.getStr(nameKey);
            if (netValue == null) {
                continue;
            }
            if (!netValue.startsWith("http://") && !netValue.startsWith("https://")) {
                netValue = "http://" + netValue;
            }
            nameValue = UnicodeUtil.toString(nameValue);
            if (netValue != null) {
                netMap.put(netValue, nameValue);
            }
            if (nameValue != null) {
                nameMap.put(nameValue, netValue);
            }
            netList.add(netValue);
            nameList.add(nameValue);
        }
        LadderContext.setNetList(netList);
        LadderContext.setNameList(nameList);
        LadderContext.setNetMap(netMap);
        LadderContext.setNameMap(nameMap);
    }

    public static String format(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return obj.toString();
        }
    }

    public static String formatContentType(Header contentType) {
        if (contentType == null) {
            return null;
        }
        String contentTypeStr = contentType.toString();
        String name = contentType.getName();
        String value = contentType.getValue();
        System.out.println("name====**==" + name);
        System.out.println("value====**==" + value);
        contentTypeStr = StrUtil.removePrefix(contentTypeStr, "Content-Type:");
        return StrUtil.trim(contentTypeStr);
    }

    public static void loadTimeProp() {
        SettingUtil.init("conf.properties");
        String basePath = SettingUtil.getStr("basePath");
        String logPath = SettingUtil.getStr("logPath");
        String rangeTime = SettingUtil.getStr("rangeTime");
        String busyMulriple = SettingUtil.getStr("busyMulriple");
        String idleMulriple = SettingUtil.getStr("idleMulriple");
        initTimeContext(rangeTime);
        LadderContext.setLogPath(logPath);
        LadderContext.setBasePath(basePath);
        int busyMulripleInt = Convert.toInt(busyMulriple, 5);
        int idleMulripleInt = Convert.toInt(idleMulriple, 60);
        LadderContext.setBusyMulriple(busyMulripleInt);
        LadderContext.setIdleMulriple(idleMulripleInt);
        NetLadderCountUtil.init();
    }

    public static void initTimeContext(String rangeTime) {
        String startTime = StrUtil.subBefore(rangeTime, "-", false);
        String endTime = StrUtil.subAfter(rangeTime, "-", true);
        int start = DateUtil.timeToSecond(startTime);
        int end = DateUtil.timeToSecond(endTime);
        LadderContext.setStart(start);
        LadderContext.setEnd(end);
    }

    public static int currentMinute() {
        String time = DateUtil.format(new Date(), "HH:mm");
        int minute = DateUtil.timeToSecond(time);
        return minute;
    }

    public static String currentYmd() {
        String ymd = DateUtil.format(new Date(), "yyyyMMdd");
        return ymd;
    }

    public static boolean inRange(int currentMinute, int start, int end) {
        if (currentMinute > start && currentMinute < end) {
            return true;
        }
        return false;
    }
}
