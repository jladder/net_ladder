package cn.iceroot.net_ladder.init;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import cn.hutool.core.date.DateUtil;
import cn.iceroot.net_ladder.util.LadderUtil;

@Component
public class InitService {
    @PostConstruct
    public static void init() {
        String now = DateUtil.now();
        System.out.println("spring启动" + now);
        LadderUtil.loadProp();
        LadderUtil.loadTimeProp();
    }
}
