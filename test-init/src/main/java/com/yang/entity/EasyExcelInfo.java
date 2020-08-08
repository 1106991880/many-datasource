package com.yang.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: yang
 * @Date: 2020-08-01 22:27
 * @Description:
 */
@Data
@NoArgsConstructor // 无参构造函数
@AllArgsConstructor // 有参构造函数
public class EasyExcelInfo {

    // value表头名称 index 指定写入的列
    @ExcelProperty(value = "字符串标题", index = 0)
    private String string;
    @ExcelProperty(value = "日期标题", index = 1)
    private Date date;
    @ExcelProperty(value = "数字标题", index = 2)
    private Double doubleData;
    // 忽略这个字段
    @ExcelIgnore
    private String ignore;

    // 复杂表头
    @ExcelProperty({"主标题", "字符串标题"})
    private String otherString;
    @ExcelProperty({"主标题", "日期标题"})
    private Date otherDate;
    @ExcelProperty({"主标题", "数字标题"})
    private Double otherDoubleData;

    // 复杂表头
    @ExcelProperty({"字符串标题Ext", "主标题Ext"})
    private String otherStringExt;


    // 我想写到excel 用年月日的格式
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty("自定义日期格式日期标题")
    private Date extDate;

    // 我想写到excel 用百分比表示
    @NumberFormat("#.##%")
    @ExcelProperty(value = "百分比数字标题")
    private Double extDoubleData;

}
