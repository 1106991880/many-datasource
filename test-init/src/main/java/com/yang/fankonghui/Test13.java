package com.yang.fankonghui;

import java.math.BigDecimal;

public class Test13 {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal(0.9F);
        BigDecimal b3 = new BigDecimal(0.8D);
        BigDecimal m = b1.subtract(b2);
        BigDecimal n = b2.subtract(b3);
        if(m.compareTo(n)==0){
            System.out.println("compareTo");
        }
        if(m.equals(n)){
            System.out.println("equals");
        }
    }
}
