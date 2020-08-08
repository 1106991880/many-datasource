package com.yang.utils.jsonString;

import lombok.Data;

/**
 * @Author: yang
 * @Date: 2020-07-26 01:00
 * @Description: 返回的数据
 */
@Data
public class ResponseBean<T> {
    private boolean result;// 返回结果
    private T data;// 返回的数据
    private String message;// 返回的信息描述

    public ResponseBean() {
    }

    public ResponseBean(boolean result, T data, String message) {

    }


}