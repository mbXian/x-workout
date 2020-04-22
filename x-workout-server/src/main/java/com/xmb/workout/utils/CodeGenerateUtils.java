package com.xmb.workout.utils;

import java.util.Random;

/**
 * @author Ben
 * @date 2020-03-06
 */
public class CodeGenerateUtils {

    public static String generate(String prefix) {
        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < 6; j++)
        {
            stringBuilder.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return prefix + stringBuilder.toString();
    }
}
