package com.mime.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mime.bbs.dto.ArticleDto;

@Mapper
public interface ArticleMapper {
	//查询所有文章
	List<ArticleDto>findArticle();
}
