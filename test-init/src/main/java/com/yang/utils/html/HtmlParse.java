package com.yang.utils.html;

import com.yang.entity.HtmlDataInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yang
 * @Date: 2020-07-26 01:00
 * @Description: 处理网页 爬取网络上的数据
 * 爬虫网络实例
 */

public class HtmlParse {
    // 获取请求
    // 需要联网
    public static void main(String[] args) throws IOException {
        HtmlParse.parseHtml("java");
    }
    // 解析网页 爬虫
    // 也可以传递一些分页参数
    public static List<HtmlDataInfo> parseHtml(String keyWord) throws IOException {
        // 请求链接
        String url = "https://search.jd.com/Search?keyword=" + keyWord;
        // 解析网页
        // Document 浏览器的对象 设置超时时间
        Document document = Jsoup.parse(new URL(url), 30000);
        // 获取节点属性 js里面使用的方法这里都是可以使用的
        Element element = document.getElementById("J_goodsList");
        // 下面的这行代码就是获取的网页
        // System.out.println("获取数据===" + j_goodsList);
        // 获取所有的li标签
        Elements lis = element.getElementsByTag("li");
        // 返回的对象
        List<HtmlDataInfo> dataInfoList = new ArrayList<>();
        // 获取元素中的内容
        for (Element el : lis) {
            // el 每个商品里面的数据项
            // 获取到图片的地址
            String imgUrl = el.getElementsByTag("img").eq(0).attr("src");
            // 图片的 有时候会懒加载 一定要找到对于的图片位置
            // String imgUrl = el.getElementsByTag("img").eq(0).attr("source-data-lazy");
            // 获取价格
            String price = el.getElementsByClass("p-price").eq(0).text();
            // 获取标题
            String title = el.getElementsByClass("p-name").eq(0).text();
            // System.out.println("图片：" + imgUrl);
            // System.out.println("价格：" + price);
            // System.out.println("标题：" + title);
            HtmlDataInfo htmlDataInfo = new HtmlDataInfo();
            htmlDataInfo.setImgUrl(imgUrl);
            htmlDataInfo.setTitle(title);
            htmlDataInfo.setPrice(price);
            dataInfoList.add(htmlDataInfo);
        }
        return dataInfoList;
    }
}
