package com.harris.harris;

import com.harris.harris.dao.po.ArticleArticles;
import com.harris.harris.service.IArticleArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName IArticleArticleServiceTest
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-10-26 16:21
 **/
public class IArticleArticleServiceTest extends HarrisApplicationTests{

    @Autowired
    IArticleArticleService articleArticleService;

    @Test
    public void getById() {
        ArticleArticles articleArticles = articleArticleService.getById(1);
        System.out.println(articleArticles);
    }
}
