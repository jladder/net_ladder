package cn.iceroot.net_ladder.valve;

import com.iceyyy.workday.WorkUtils;

import cn.iceroot.net_ladder.context.LadderContext;
import cn.iceroot.net_ladder.util.LadderUtil;
import cn.iceroot.net_ladder.util.NetLadderCountUtil;

public class TimeValve {
    public static boolean valve() {
        String ymd = LadderUtil.currentYmd();
        boolean isWorkDay = WorkUtils.isWorkendDay(ymd);
        int start = LadderContext.getStart();
        int end = LadderContext.getEnd();
        int busyMulriple = LadderContext.getBusyMulriple();
        int idleMulriple = LadderContext.getIdleMulriple();
        int count = NetLadderCountUtil.getCount();
        int currentMinute = LadderUtil.currentMinute();
        if (/* isWorkDay && */LadderUtil.inRange(currentMinute, start, end)) {
            if (count % busyMulriple == 0) {
                return true;
            }
        } else {
            if (count % idleMulriple == 0) {
                return true;
            }
        }
        return false;
    }
}
