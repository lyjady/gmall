package org.augustus.utils;

import java.util.Random;

/**
 * @author LinYongJin
 * @date 2020/3/15 15:31
 */
public class CommonUtils {

    private CommonUtils() {}

    /**
     * 随机生成0 ~ 60的随机数
     * @return
     */
    public static int generalRandomMinute(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
