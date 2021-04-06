package com.aliyun.rtc.whiteboard.util;

import java.util.Random;

/**
 * 随机字符串 工具类
 */
public class RandomStringUtil {

    /**
     * 生成随机英文名
     * @return 随机英文名
     */
    public static String getRandomName(Random random) {

        String[] surname = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph",
                "Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven",
                "Edward", "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy"};

        int index = random.nextInt(surname.length - 1);

        return surname[index];
    }
}

