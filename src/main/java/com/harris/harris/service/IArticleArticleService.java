package com.harris.harris.service;

import com.harris.harris.dao.po.ArticleArticles;

/**
 * @author admin
 */
public interface IArticleArticleService {

    /**
     * 查询文章
     * @param id
     * @return
     */
    ArticleArticles getById(Integer id);
}
