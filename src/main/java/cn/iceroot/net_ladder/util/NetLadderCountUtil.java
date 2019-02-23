package cn.iceroot.net_ladder.util;

public class NetLadderCountUtil {
    public static int count = 0;

    public static int getCount() {
        return count;
    }

    public static int init() {
        count = 0;
        return count;
    }

    public static int accumulation() {
        count++;
        return count;
    }
}
