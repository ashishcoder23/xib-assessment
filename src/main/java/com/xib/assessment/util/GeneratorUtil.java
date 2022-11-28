package com.xib.assessment.util;

public class GeneratorUtil {

    public static String randomIdNumber() {
        Long number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
        return number.toString();
    }
}
