package cn.iceroot.net_ladder.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderContext {
    private static List<String> netList = new ArrayList<String>();
    private static List<String> nameList = new ArrayList<String>();
    private static Map<String, String> netMap = new HashMap<String, String>();
    private static Map<String, String> nameMap = new HashMap<String, String>();
    private static Map<String, String> lastStateMap = new HashMap<String, String>();
    private static int start;
    private static int end;
    private static int busyMulriple;
    private static int idleMulriple;
    private static String basePath;
    private static String logPath;

    public static List<String> getNetList() {
        return netList;
    }

    public static void setNetList(List<String> netList) {
        LadderContext.netList = netList;
    }

    public static List<String> getNameList() {
        return nameList;
    }

    public static void setNameList(List<String> nameList) {
        LadderContext.nameList = nameList;
    }

    public static Map<String, String> getNetMap() {
        return netMap;
    }

    public static void setNetMap(Map<String, String> netMap) {
        LadderContext.netMap = netMap;
    }

    public static Map<String, String> getNameMap() {
        return nameMap;
    }

    public static void setNameMap(Map<String, String> nameMap) {
        LadderContext.nameMap = nameMap;
    }

    public static Map<String, String> getLastStateMap() {
        return lastStateMap;
    }

    public static void setLastStateMap(Map<String, String> lastStateMap) {
        LadderContext.lastStateMap = lastStateMap;
    }

    public static int getStart() {
        return start;
    }

    public static void setStart(int start) {
        LadderContext.start = start;
    }

    public static int getEnd() {
        return end;
    }

    public static void setEnd(int end) {
        LadderContext.end = end;
    }

    public static int getBusyMulriple() {
        return busyMulriple;
    }

    public static void setBusyMulriple(int busyMulriple) {
        LadderContext.busyMulriple = busyMulriple;
    }

    public static int getIdleMulriple() {
        return idleMulriple;
    }

    public static void setIdleMulriple(int idleMulriple) {
        LadderContext.idleMulriple = idleMulriple;
    }

    public static String getBasePath() {
        return basePath;
    }

    public static void setBasePath(String basePath) {
        LadderContext.basePath = basePath;
    }

    public static String getLogPath() {
        return logPath;
    }

    public static void setLogPath(String logPath) {
        LadderContext.logPath = logPath;
    }

}
