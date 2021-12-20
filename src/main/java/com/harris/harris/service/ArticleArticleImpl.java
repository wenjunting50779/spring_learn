package com.harris.harris.service;

import com.harris.harris.dao.mapper.ArticleArticlesDao;
import com.harris.harris.dao.po.ArticleArticles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName DemoImpl
 * @description:
 * @author: wenjunting@zhuanzhuan.com
 * @create: 2021-10-26 15:52
 **/
@Service
public class ArticleArticleImpl implements IArticleArticleService {
    @Resource
    private ArticleArticlesDao articleArticlesDao;

    @Override
    public ArticleArticles getById(Integer id) {
        return articleArticlesDao.selectById(id);
    }
}
