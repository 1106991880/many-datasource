package com.yang.java8;

public enum TestEum {

    a(1,"aaa"),
    b(2,"bbbb");

    private Integer code;
    private String desc;

    TestEum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

    public static String getDesc(Integer code){
        for (TestEum eum : values()){
            if(eum.getCode().equals(code)){
                return eum.getDesc();
            }
        }
        return null;
    }

}
