package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yang
 * @Date: 2020-07-26 01:20
 * @Description: 网页爬虫的数据对象
 */
@Data
@NoArgsConstructor // 无参构造函数
@AllArgsConstructor // 有参构造函数
public class HtmlDataInfo {

    private String title;
    private String imgUrl;
    private String price;

}
