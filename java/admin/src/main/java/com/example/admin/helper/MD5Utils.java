/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Guotao.Liu
 * @version : MD5Utils.java, v 0.1 2020-08-20 17:06 lgt Exp $
 */
public class MD5Utils {

    public static String md5(String input) {
        byte[] bytes;
        try {
            bytes = MessageDigest.getInstance("md5").digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.printf("%s\n", md5("1234"));
    }
}
