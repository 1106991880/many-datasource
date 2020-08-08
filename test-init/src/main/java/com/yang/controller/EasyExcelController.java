package com.yang.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.yang.entity.EasyExcelInfo;
import com.yang.utils.fileData.FileDataUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yang
 * @Date: 2020-08-01 22:25
 * @Description: 阿里的easy excel对表格操作
 */
@Controller
public class EasyExcelController {


    // 获得文件输入流
    @RequestMapping("/fileInputStream")
    public String fileInputStream(@RequestBody String json) throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/templates/test.xlsx");
        // 将输入流转为对象
        // 对对象进行处理实现业务逻辑功能
        return "获得文件输入流";
    }


    // 往excel里面写入数据
    public static void main(String[] args) {

        // 写法1
        String fileName = FileDataUtils.getPath() + "simpleWrite1" + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, EasyExcelInfo.class).sheet("模板").doWrite(data());

        // 写法2
        fileName = FileDataUtils.getPath() + "simpleWrite2" + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, EasyExcelInfo.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

        // 分sheet页面写入
        repeatedWrite();

    }


    // 测试数据
    private static List<EasyExcelInfo> data() {
        List<EasyExcelInfo> list = new ArrayList<EasyExcelInfo>();
        for (int i = 0; i < 10; i++) {
            EasyExcelInfo easyExcelInfo = new EasyExcelInfo();
            easyExcelInfo.setString("字符串" + i);
            easyExcelInfo.setDate(new Date());
            easyExcelInfo.setDoubleData(0.56);

            // 复杂表头
            easyExcelInfo.setOtherString("字符串" + i);
            easyExcelInfo.setOtherDate(new Date());
            easyExcelInfo.setOtherDoubleData(0.56);

            // 复杂表头
            easyExcelInfo.setOtherStringExt("字符串Ext" + i);


            // 自定义数据的显示格式
            easyExcelInfo.setExtDate(new Date());
            easyExcelInfo.setExtDoubleData(5.67);

            list.add(easyExcelInfo);
        }
        return list;
    }

    // 分sheet页面
    public static void repeatedWrite() {
        // 方法1 如果写到同一个sheet
        String fileName = FileDataUtils.getPath() + "repeatedWrite1" + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            // 这里 需要指定写用哪个class去写
            excelWriter = EasyExcel.write(fileName, EasyExcelInfo.class).build();
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<EasyExcelInfo> data = data();
                excelWriter.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

        // 方法2 如果写到不同的sheet 同一个对象
        fileName = FileDataUtils.getPath() + "repeatedWrite2" + ".xlsx";
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName, EasyExcelInfo.class).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<EasyExcelInfo> data = data();
                excelWriter.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

        // 方法3 如果写到不同的sheet 不同的对象
        fileName = FileDataUtils.getPath() + "repeatedWrite3" + ".xlsx";
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(EasyExcelInfo.class).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<EasyExcelInfo> data = data();
                excelWriter.write(data, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }


}
