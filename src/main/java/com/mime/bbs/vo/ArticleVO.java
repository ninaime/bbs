package com.mime.bbs.vo;

import lombok.Data;

@Data
public class ArticleVO {
	
	private int id;
	/** 标题 */
	private String title;
	/** 内容 */
	private String context;
	/** 浏览数 */
	private Integer viewCount;
	/** 评论数 */
	private Integer comments;
	/** 喜欢数 */
	private Integer likeCount;
	/** 置顶 */
	private Integer weight;
	/** 是否收藏 */
	private Boolean collect;
	private Integer authorId;
	private String nickname;
	
	
	
	
}
