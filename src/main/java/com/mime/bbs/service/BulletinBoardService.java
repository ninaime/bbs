package com.mime.bbs.service;

import java.util.List;

import com.mime.bbs.dto.ArticleDto;

public interface BulletinBoardService {
	List<ArticleDto>findArticle();
}
