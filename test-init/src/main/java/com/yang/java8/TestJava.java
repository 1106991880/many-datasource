package com.yang.java8;

import cn.hutool.core.util.IdUtil;
import com.yang.constants.TestContanst;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: yang
 * @Date: 11/18/20 5:29 PM
 * @Description:
 */
public class TestJava {

    public static void main(String[] args) {
        String testString = "111001,222002,333003,444004";
        String[] split = testString.split(",");
        List<TestObject> collect = Arrays.stream(split).map(s -> new TestObject(Integer.parseInt(StringUtils.substring(s, 0, 7)), new BigDecimal("0")
        )).collect(Collectors.toList());

        System.out.println(collect);


        String substring = StringUtils.substring("111001", 7);
        System.out.println(substring);


        List<Student> list = new ArrayList<>();
        list.add(new Student(22, "yang"));
        list.add(new Student(33, "yang1"));
        list.add(new Student(23, "yang2"));

        boolean yang4 = list.stream().filter(e -> e.getName().equals("yang")).findFirst().isPresent();
        System.out.println("yang==============================" + yang4);


        Map<String, String> map = TestContanst.getMap();
        String ea = map.get(null);
        System.out.println(ea);

        DecimalFormat df = new DecimalFormat("0.00%");
        BigDecimal d = new BigDecimal(0.666);
        String percent = df.format(d);

        System.out.println("----------------------" + percent);

        LocalDate now = LocalDate.now();


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dateTimeFormatter.format(now);

        System.out.println("dsadasda===============" + format);


        LocalDateTime date4 = LocalDateTime.of(2021, 1, 6, 19, 26, 16);
        Duration duration = Duration.between(date4, LocalDateTime.now());

        System.out.println(LocalDateTime.now() + " 与 " + date4 + " 间隔  " + "\n"
                + " 天 :" + duration.toDays() + "\n"
                + " 时 :" + duration.toHours() + "\n"
                + " 分 :" + duration.toMinutes() + "\n"
                + " 毫秒 :" + duration.toMillis() + "\n"
                + " 纳秒 :" + duration.toNanos() + "\n"
        );
        long l = duration.toMinutes();

        long dateTime = 5 * 24 * 60 - l;
        String text = "";
        if (dateTime < 0) {
            System.out.println("超期" + (duration.toDays() - 5 + 1) + "天");
            text = "超期" + (l - 5 * 24 * 60) + "分钟";
        } else {
            text = dateTime + "分钟";

            System.out.println("还有多少天" + (5 - duration.toDays()) + "天");

            if (dateTime == 0) {
                System.out.println("datatime==========================" + dateTime);
            }
        }

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(text);

    }
}
