/*
Navicat MySQL Data Transfer

Source Server         : bbs
Source Server Version : 50718
Source Host           : cdb-iu7ogbez.gz.tencentcdb.com:10014
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-03-05 17:47:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbs_annal
-- ----------------------------
DROP TABLE IF EXISTS `bbs_annal`;
CREATE TABLE `bbs_annal` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_annal
-- ----------------------------

-- ----------------------------
-- Table structure for bbs_article
-- ----------------------------
DROP TABLE IF EXISTS `bbs_article`;
CREATE TABLE `bbs_article` (
  `id` bigint(20) NOT NULL,
  `plate_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `english_title` varchar(255) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `context` text,
  `view_count` bigint(20) DEFAULT NULL,
  `comment_count` bigint(20) DEFAULT NULL,
  `weight` tinyint(4) DEFAULT NULL,
  `is_disable` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_article
-- ----------------------------

-- ----------------------------
-- Table structure for bbs_like
-- ----------------------------
DROP TABLE IF EXISTS `bbs_like`;
CREATE TABLE `bbs_like` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_like
-- ----------------------------

-- ----------------------------
-- Table structure for bbs_notice
-- ----------------------------
DROP TABLE IF EXISTS `bbs_notice`;
CREATE TABLE `bbs_notice` (
  `id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_notice
-- ----------------------------

-- ----------------------------
-- Table structure for bbs_plate
-- ----------------------------
DROP TABLE IF EXISTS `bbs_plate`;
CREATE TABLE `bbs_plate` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `plate_name` varchar(128) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `plate_describe` varchar(255) DEFAULT NULL,
  `is_disable` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_plate
-- ----------------------------
INSERT INTO `bbs_plate` VALUES ('1', '分区1', '0', '1', '第一分区', '0', '2019-02-24 18:01:33', '2019-02-24 18:01:37');
INSERT INTO `bbs_plate` VALUES ('2', '分区2', '0', '2', '第二分区', '0', '2019-02-24 18:03:30', '2019-02-24 18:03:33');
INSERT INTO `bbs_plate` VALUES ('3', '分区1的板块1', '1', '1', '分区1的板块1', '0', '2019-02-24 18:04:01', '2019-02-24 18:04:04');
INSERT INTO `bbs_plate` VALUES ('4', '分区1的板块2', '1', '2', '分区1的板块2', '0', '2019-02-24 18:04:22', '2019-02-24 18:04:26');
INSERT INTO `bbs_plate` VALUES ('5', '分区2的板块1', '2', '1', '分区2的板块1', '0', '2019-02-24 18:04:41', '2019-02-24 18:04:43');
INSERT INTO `bbs_plate` VALUES ('6', '分区2的板块2', '2', '2', '分区2的板块2', '0', '2019-02-24 18:04:59', '2019-02-24 18:05:01');

-- ----------------------------
-- Table structure for bbs_review
-- ----------------------------
DROP TABLE IF EXISTS `bbs_review`;
CREATE TABLE `bbs_review` (
  `id` bigint(20) NOT NULL,
  `artucke_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `like_count` bigint(20) DEFAULT NULL,
  `is_disable` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_review
-- ----------------------------

-- ----------------------------
-- Table structure for sys_meun
-- ----------------------------
DROP TABLE IF EXISTS `sys_meun`;
CREATE TABLE `sys_meun` (
  `id` bigint(20) NOT NULL,
  `meun_name` varchar(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `meun_name_en` varchar(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `is_disable` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_meun
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(24) NOT NULL COMMENT '权限名',
  `permission` varchar(24) NOT NULL COMMENT '授权名',
  `role_describe` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `is_disable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 正常、1禁用',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role_rn` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户权限表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'admin', '管理员', '0', '2019-02-18 14:14:27', '2019-02-18 14:14:27');
INSERT INTO `sys_role` VALUES ('2', 'user', 'user', '普通用户', '0', '2019-02-18 14:28:44', '2019-02-18 14:28:44');

-- ----------------------------
-- Table structure for sys_role_meun
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_meun`;
CREATE TABLE `sys_role_meun` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) DEFAULT NULL,
  `meun_id` bigint(11) DEFAULT NULL,
  `is_disable` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_meun
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(24) DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(16) NOT NULL COMMENT '登录名',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(36) DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `role_id` bigint(11) NOT NULL DEFAULT '2' COMMENT '权限外键',
  `is_disable` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 正常、1 禁用',
  `is_online` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0 在线、1 不在线',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_user_un` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', null, null, null, '1', '0', '1', '2019-02-24 12:25:02', '2019-02-24 12:25:02');
INSERT INTO `sys_user` VALUES ('2', null, 'test', '4292bb58be34c59d28a0dcbd11932d49', null, null, null, '2', '0', '1', '2019-02-19 13:27:58', '2019-02-19 13:27:58');
INSERT INTO `sys_user` VALUES ('5', null, 'xietao', 'E10ADC3949BA59ABBE56E057F20F883E', '', '', null, '1', '0', '1', '2019-02-19 14:59:19', '2019-02-19 14:59:19');
INSERT INTO `sys_user` VALUES ('6', null, 'aaaaa', 'e8997e43e9fee8106f7aa56c62ae99db', '', '', null, '1', '0', '1', '2019-02-20 15:39:40', '2019-02-20 15:39:40');
INSERT INTO `sys_user` VALUES ('7', null, 'aaaa', '26a0700f28eb13656ecaf0d3cb931d1d', '', '', null, '2', '0', '1', '2019-02-20 15:54:02', '2019-02-20 15:54:02');
INSERT INTO `sys_user` VALUES ('9', null, 'asdf', '61fc906a7d5f7042df4489949e7bc376', '', '', null, '1', '0', '1', '2019-02-20 17:55:06', '2019-02-20 17:55:06');
INSERT INTO `sys_user` VALUES ('10', null, 'aaa', 'a349cd2f2555ff99e9c39969db86abe2', '', '', null, '1', '0', '1', '2019-02-21 13:16:05', '2019-02-21 13:16:05');
INSERT INTO `sys_user` VALUES ('11', null, 'aaaaaa', 'e8997e43e9fee8106f7aa56c62ae99db', '', '', null, '2', '0', '1', '2019-02-21 22:50:40', '2019-02-21 22:50:40');
INSERT INTO `sys_user` VALUES ('12', null, 'dsadasd', 'b6c1fed399ffec7e84880afaceed1e3a', '', '', null, '2', '0', '1', '2019-02-24 16:56:39', '2019-02-24 16:56:39');
INSERT INTO `sys_user` VALUES ('13', null, 'aaaaaaaa', '4dad3cbcdfa7e35c89c2210dce0be8f0', '', '', null, '2', '0', '1', '2019-02-24 17:00:35', '2019-02-24 17:00:35');
INSERT INTO `sys_user` VALUES ('14', null, 'dasdsadas', '4467ff3ad016903d1790b38c9cb41190', '', '', null, '2', '0', '1', '2019-02-24 17:00:45', '2019-02-24 17:00:45');
INSERT INTO `sys_user` VALUES ('15', null, 'dasdsadasdas', '0aa4a72015035ec9df85eabdbc2419e1', '', '', null, '2', '0', '1', '2019-02-24 17:00:50', '2019-02-24 17:00:50');
INSERT INTO `sys_user` VALUES ('16', null, 'qwwqewq', '15976ba9884c7c64f4ae830ae9df7bde', '', '', null, '2', '0', '1', '2019-02-24 17:00:56', '2019-02-24 17:00:56');
INSERT INTO `sys_user` VALUES ('17', null, 'ewqeqw', 'e89197fb7e836ca42d52427c4b2b8419', '', '', null, '2', '0', '1', '2019-02-24 17:01:02', '2019-02-24 17:01:02');
INSERT INTO `sys_user` VALUES ('18', null, 'asdadas', '302d40e40ce328be429d7c6d6462ff22', '', '', null, '2', '0', '1', '2019-02-24 17:01:10', '2019-02-24 17:01:10');
INSERT INTO `sys_user` VALUES ('19', null, 'ewqewqe', '74f5afe4c38060a32266ce46e99dc712', '', '', null, '2', '0', '1', '2019-02-24 17:01:16', '2019-02-24 17:01:16');
INSERT INTO `sys_user` VALUES ('21', null, '111', '111', null, null, null, '2', '0', '1', '2019-02-27 16:08:33', '2019-02-27 16:08:33');
INSERT INTO `sys_user` VALUES ('22', null, '333', '333', null, null, null, '2', '0', '1', '2019-02-27 16:09:46', '2019-02-27 16:09:46');

-- ----------------------------
-- Table structure for sys_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_userinfo`;
CREATE TABLE `sys_userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT '2',
  `birthday` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `exp` bigint(20) DEFAULT '0',
  `sign` varchar(20) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_userinfo
-- ----------------------------
INSERT INTO `sys_userinfo` VALUES ('1', '10', '1', '2019-02-21 15:02:36', '11', null, '111', '1', null, '');
INSERT INTO `sys_userinfo` VALUES ('11', '1222', null, null, null, null, null, null, null, null);
INSERT INTO `sys_userinfo` VALUES ('12', '21', null, null, null, null, null, null, null, null);
INSERT INTO `sys_userinfo` VALUES ('13', '22', null, null, null, null, null, null, null, null);
DROP TRIGGER IF EXISTS `user_on_userinfo`;
DELIMITER ;;
CREATE TRIGGER `user_on_userinfo` AFTER INSERT ON `sys_user` FOR EACH ROW BEGIN
	insert into sys_userinfo(user_id) values(new.id);
END
;;
DELIMITER ;
