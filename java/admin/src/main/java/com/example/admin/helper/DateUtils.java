/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.helper;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author Guotao.Liu
 * @version : DateUtils.java, v 0.1 2020-08-13 12:55 lgt Exp $
 */
public class DateUtils {

    public static String formatDate(Date date) {
        return DateFormatUtils.format(date,
            DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.getPattern());
    }

    public static void main(String[] args) {
        System.out.printf("%s", DateUtils.formatDate(new Date()));
    }
}
