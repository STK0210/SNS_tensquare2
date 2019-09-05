package com.tensquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @auther likeyu
 * @create 2019-09-05-14:31
 **/
@Document(indexName = "tensquare_article", type = "article")
public class Article implements Serializable {

    @Id
    private String id;

    //是否索引，就是看该域是否能被搜索
    //是否分词，就表示搜索的时候是整体匹配还是单词匹配
    //是否存储，就是是否在页面上显示，整篇文章的内容是不需要存储的
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")//这个注解的意思代表该列值进行索引,分词和搜索分词都用ik分词器
    private String title;

    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;//最好使用描述

    private String state;//审核状态，实际开发中删除不一定真删，一般是改变有效状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
