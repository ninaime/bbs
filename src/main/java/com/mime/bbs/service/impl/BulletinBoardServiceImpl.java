package com.mime.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mime.bbs.dto.ArticleDto;
import com.mime.bbs.mapper.ArticleMapper;
import com.mime.bbs.service.BulletinBoardService;

@Service("bulletinBoardService")
public class BulletinBoardServiceImpl implements BulletinBoardService{

	@Autowired
	private ArticleMapper bbsArticleMapper;
	
	@Override
	public List<ArticleDto> findArticle() {
		return bbsArticleMapper.findArticle();
	}
	
}
