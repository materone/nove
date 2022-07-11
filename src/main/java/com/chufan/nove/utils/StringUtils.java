package com.chufan.nove.utils;

import org.slf4j.LoggerFactory;

public class StringUtils {
    public static final String VER = "1.2.3";

    public static String GetVersion() {
        org.slf4j.Logger l = LoggerFactory.getLogger("SU");
        l.info("Get Version in GET");
        return VER;
    }
}
