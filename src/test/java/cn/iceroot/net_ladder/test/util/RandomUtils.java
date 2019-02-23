package cn.iceroot.net_ladder.test.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;

public class RandomUtils {
    public static double roundDouble() {
        return RandomUtil.randomDouble(0d, 10000d, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal roundBigDecimal() {
        BigDecimal num = NumberUtil.round(RandomUtil.randomDouble(10000d), 2);
        return num;
    }

    public static Date roundDate() {
        Date date = RandomUtil.randomDay(-365, 365);
        return date;
    }
}
