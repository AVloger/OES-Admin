package com.other;

import com.dut.util.MD5Util;

import java.util.UUID;

public class test {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(UUID.randomUUID());
//        }

//        System.out.println(String.valueOf(UUID.randomUUID()).length());
        System.out.println(MD5Util.MD5("super-admin"));
    }
}
