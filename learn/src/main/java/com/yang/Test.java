package com.yang;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: yang
 * @Date: 2020-03-03 21:52
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws ParseException {


        String s1 = UUID.randomUUID().toString();
        System.out.println(s1);
        System.out.println(s1.length());

        System.out.println("-----------------------------------------------------------");


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = df.parse("2021-01-01");
        SimpleDateFormat y = new SimpleDateFormat("yyyy");
        String format = y.format(parse);


        System.out.println("data==================================="+format);

        BigDecimal bigDecimal = new BigDecimal("-99");

        if (("-99").equals(String.valueOf(bigDecimal))) {
            System.out.println("================");
        } else {
            System.out.println("----------------------------------");
        }
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样 String aa = "ab"; // 放在常量池中
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }

        String s = new String("aaaaaa");
        System.out.println("------------------------------");
        System.out.println(s);
        Class<? extends String> aClass = s.getClass();

        System.out.println(aClass);

        StringBuffer stringBuffer = new StringBuffer();
        Class<? extends StringBuffer> aClass1 = stringBuffer.getClass();
        System.out.println(aClass1);

    }

}
