package com.yang.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum SexEnum implements IEnum<Integer> {
    MAN(1, "男"),
    WOMAN(2, "女");
    private int code;

    private String value;

    SexEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

    // 重写toString() 不然mybatis-plus返回的是MAN而不是男
    @Override
    public String toString() {
        return this.value;
    }

}
