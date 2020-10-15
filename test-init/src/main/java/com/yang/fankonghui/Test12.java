package com.yang.fankonghui;

public class Test12 {
    public static void main(String[] args) {
        float f1=1.0F-0.9F;
        float f2=0.9F-0.8F;
        if (f1==f2){
            System.out.println("f1==f2");
        }
        Float aFloat = Float.valueOf(f1);
        Float bFloat = Float.valueOf(f2);
        if(aFloat.equals(bFloat)){
            System.out.println("aFloat.equals(bFloat);");
        }
    }
}
