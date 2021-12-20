package com.harris.harris.dao.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * article_articles
 * @author 
 */
@Data
public class ArticleArticles implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private Integer clickNum;

    private String tag;

    private Integer pvNum;

    private Integer status;

    private Date createdAt;

    private Date publistedAt;

    private String backgroundImg;

    private String mainImg;

    private Integer type;

    private static final long serialVersionUID = 1L;
}