package com.yang.testinit;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@SpringBootTest
class TestInitApplicationTests {


    @Autowired
    private RestHighLevelClient restHighLevelClient;


    @Test
    void contextLoads() {
    }


    @Test
    public String createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("yang_index");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
        return "创建索引";
    }

}
