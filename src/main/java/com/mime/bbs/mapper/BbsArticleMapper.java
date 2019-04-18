package com.mime.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mime.bbs.model.BbsArticle;

@Mapper
public interface BbsArticleMapper {
	//查询所有文章
	List<BbsArticle>findArticle();
}
