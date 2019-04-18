package com.mime.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mime.bbs.mapper.BbsArticleMapper;
import com.mime.bbs.model.BbsArticle;
import com.mime.bbs.service.BulletinBoardService;

@Service("bulletinBoardService")
public class BulletinBoardServiceImpl implements BulletinBoardService{

	@Autowired
	private BbsArticleMapper bbsArticleMapper;
	
	@Override
	public List<BbsArticle> findArticle() {
		return bbsArticleMapper.findArticle();
	}
	
}
