package com.harris.harris;

import com.harris.harris.dao.po.ArticleArticles;
import com.harris.harris.util.JsonUtil;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @ClassName EsTest
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-10-28 11:03
 **/
public class EsTest extends HarrisApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 判断ID是否存在索引中，存在则获取
     */
    @Test
    public void getById() throws IOException {
        GetRequest getRequest = new GetRequest("blog").id("1");
        boolean exist = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println("当前索引是否存在：" + exist);
        if (exist) {
            GetResponse res = restHighLevelClient.get(getRequest,RequestOptions.DEFAULT);
            String str = res.getSourceAsString();
            System.out.println(JsonUtil.silentString2Object(str, ArticleArticles.class));
        }
    }

}
