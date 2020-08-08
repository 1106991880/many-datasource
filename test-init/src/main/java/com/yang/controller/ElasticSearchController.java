package com.yang.controller;

import com.alibaba.fastjson.JSON;
import com.yang.entity.EsUserInfo;
import com.yang.entity.HtmlDataInfo;
import com.yang.utils.html.HtmlParse;
import com.yang.utils.jsonString.JsonStringUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.elasticsearch.client.RequestOptions.DEFAULT;

/**
 * @Author: yang
 * @Date: 2020-07-25 23:10
 * @Description: es高级客户端操作API
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    private static final Logger log = LoggerFactory.getLogger(ElasticSearchController.class);


    @Autowired
    public RestHighLevelClient restHighLevelClient;

    // 创建索引
    @RequestMapping("/createIndex")
    public String createIndex(@RequestBody String json) throws IOException {
        log.info("创建索引====", json);
        CreateIndexRequest request = new CreateIndexRequest("yang_index1");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, DEFAULT);
        System.out.println(createIndexResponse);
        return "创建索引";
    }

    // 获取索引
    @RequestMapping("/getIndex")
    public String getIndex(@RequestBody String json) throws IOException {
        log.info("获取索引====", json);
        GetIndexRequest request = new GetIndexRequest("yang_index1");
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(request, DEFAULT);
        System.out.println(getIndexResponse);
        return "获取索引";
    }

    // 删除索引
    @RequestMapping("/deleteIndex")
    public String deleteIndex(@RequestBody String json) throws IOException {
        log.info("删除索引====", json);
        DeleteIndexRequest request = new DeleteIndexRequest("yang_index1");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, DEFAULT);
        System.out.println(delete);
        return "删除索引";
    }

    // 添加文档
    @RequestMapping("/createDocument")
    public String createDocument(@RequestBody String json) throws IOException {
        log.info("添加文档====", json);
        EsUserInfo esUserInfo = new EsUserInfo("yang", "23", new Date());
        // 创建请求
        IndexRequest indexRequest = new IndexRequest("yang_index");
        // kibana的操作 put/yang_index/_doc/1
        indexRequest.id("1");
        // 将数据放入请求
        IndexRequest source = indexRequest.source(JSON.toJSONString(esUserInfo), XContentType.JSON);
        // 客户端发送请求
        IndexResponse index = restHighLevelClient.index(indexRequest, DEFAULT);
        RestStatus status = index.status();
        String string = index.toString();
        System.out.println("status:" + status);
        System.out.println("string:" + string);
        return "添加文档";
    }

    // 获取文档
    @RequestMapping("/getDocument")
    public String getDocument(@RequestBody String json) throws IOException {
        log.info("获取文档====", json);
        GetRequest request = new GetRequest("yang_index", "1");
        request.fetchSourceContext(new FetchSourceContext(false));
        boolean exists = restHighLevelClient.exists(request, DEFAULT);
        System.out.println("是否存在===" + exists);
        if (exists) {
            System.out.println("存在");
            GetResponse documentFields = restHighLevelClient.get(request, DEFAULT);
            System.out.println("文档的内容===" + documentFields.getSourceAsString());
        }
        return "获取文档";
    }

    // 更新文档
    @RequestMapping("/updateDocument")
    public String updateDocument(@RequestBody String json) throws IOException {
        log.info("更新文档====", json);
        UpdateRequest request = new UpdateRequest("yang_index", "1");
        // 设置更新时间
        request.timeout("1s");
        EsUserInfo esUserInfo = new EsUserInfo("yang1", "25", new Date());
        UpdateRequest doc = request.doc(JSON.toJSONString(esUserInfo), XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(request, DEFAULT);
        System.out.println("更新数据：" + update);
        return "更新文档";
    }

    // 删除文档
    @RequestMapping("/deleteDocument")
    public String deleteDocument(@RequestBody String json) throws IOException {
        log.info("删除文档====", json);
        DeleteRequest request = new DeleteRequest("yang_index", "1");
        // 设置更新时间
        request.timeout("1s");
        DeleteResponse delete = restHighLevelClient.delete(request, DEFAULT);
        System.out.println("删除文档：" + delete);
        return "删除文档";
    }

    // 大批量数据导入es
    @RequestMapping("/importDocument")
    public String importDocument(@RequestBody String json) throws IOException {
        log.info("大批量数据导入es====", json);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("100s");
        List<EsUserInfo> esUserInfoList = new ArrayList<>();
        esUserInfoList.add(new EsUserInfo("yang1", "25", new Date()));
        esUserInfoList.add(new EsUserInfo("yang2", "26", new Date()));
        esUserInfoList.add(new EsUserInfo("yang3", "27", new Date()));

        // 批量刷入数据
        for (int i = 0; i < esUserInfoList.size(); i++) {
            bulkRequest.add(new IndexRequest("yang_index")
                    .id("" + (i + 1))
                    .source(JSON.toJSONString(esUserInfoList.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, DEFAULT);
        boolean b = bulk.hasFailures();
        System.out.println("是否失败===" + b);

        return "大批量数据导入es";
    }

    // 搜索文档
    // 搜索请求 SearchRequest
    // 条件构造 SearchSourceBuilder
    // 高亮显示 HighlightBuilder
    // 构建精确查询 TermQueryBuilder
    // 匹配所有 MatchAllQueryBuilder
    @RequestMapping("/searchDocument")
    public String searchDocument(@RequestBody String json) throws IOException {
        log.info("搜索文档====", json);
        SearchRequest searchRequest = new SearchRequest("yang_index");
        // 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 高亮
        // HighlightBuilder highlighter = sourceBuilder.highlighter();
        // 精确查询 和 匹配所有
        // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        // 精确匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "yang");
        sourceBuilder.query(termQueryBuilder);
        // 60秒查询时间
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        // 执行查询
        SearchResponse search = restHighLevelClient.search(searchRequest, DEFAULT);
        // 获取查询结果
        SearchHits hits = search.getHits();
        System.out.println("打印查询结果===" + JSON.toJSONString(hits));
        // 便利查询结果
        for (SearchHit searchHit : search.getHits().getHits()) {
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
        }
        return JsonStringUtils.JsonData(true, "搜索文档", null);
    }


    // 网页的数据批量放入es数据库中
    @RequestMapping("/htmlToEsByBulk")
    public String htmlToEsByBulk(@RequestBody String json) throws IOException {
        log.info("网页的数据批量放入es数据库中====", json);
        List<HtmlDataInfo> list = HtmlParse.parseHtml("java");
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(new TimeValue(60, TimeUnit.SECONDS));
        for (int i = 0; i < list.size(); i++) {
            // 创建的索引名称为jd_goods
            bulkRequest.add(new IndexRequest("jd_goods")
                    .id(UUID.randomUUID().toString())
                    .source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, DEFAULT);
        System.out.println("批量放入结束==" + bulk);
        return JsonStringUtils.JsonData(true, "网页的数据批量放入es数据库中", bulk);
    }

    // 搜索放入到es里面的数据(从京东上面爬取的)
    @RequestMapping("/searchDataByPage/{keyWords}/{pageNo}/{pageSize}")
    public String searchDataByPage(@PathVariable("keyWords") String keyWords, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        // 条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");

        // 条件构造器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 分页
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);

        // 精确匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyWords);
        sourceBuilder.query(termQueryBuilder);


        // 超时时间
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 高亮 解析结果的时候也需要处理高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);// 关闭多个高亮
        highlightBuilder.preTags("<span style='color:red'>");// 前缀
        highlightBuilder.postTags("</span>");// 后缀
        // 将高亮设置到条件构造器里面
        sourceBuilder.highlighter(highlightBuilder);

        // 执行搜索
        searchRequest.source(sourceBuilder);

        SearchResponse search = restHighLevelClient.search(searchRequest, DEFAULT);

        // 解析结果
        List<Map<String, Object>> listMap = new ArrayList<>();

        // 遍历查询结果集
        for (SearchHit searchHit : search.getHits().getHits()) {

            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            // 获得高亮
            HighlightField title = highlightFields.get("title");
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            if (title != null) {
                // 高亮的字段进行替换
                Text[] fragments = title.fragments();
                String newTitle = "";
                for (Text text : fragments) {
                    newTitle += text;
                }
                sourceAsMap.put("title", newTitle);
            }

            listMap.add(sourceAsMap);
        }
        return JsonStringUtils.JsonData(true, "查询成功", listMap);
    }


}


