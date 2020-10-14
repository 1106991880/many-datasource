package com.yang.suanfa;

/**
 * @Author: yang
 * @Date: 2020-08-25 21:42
 * @Description:
 */
public class Test01 {

    public static void main(String[] args) {

        String str = "hello world";

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        int len = len(str);
        System.out.println(len);
    }


    public static int len(String str) {
        int length = 0;
        int i = str.length() - 1;
        while (i >= 0) {

            char c = str.charAt(i);
            System.out.println("cccc====" + c);

            if (str.charAt(i) == ' ') {
                return length;
            }
            length++;
            i--;
        }
        return length;
    }


}
