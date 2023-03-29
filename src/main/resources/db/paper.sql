/*
Navicat MySQL Data Transfer

Source Server         : RecSystem_schema
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : recsystem

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2023-03-27 15:23:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `authors` varchar(400) DEFAULT NULL COMMENT '作者',
  `title` varchar(230) DEFAULT NULL COMMENT '标题',
  `url` varchar(500) DEFAULT NULL COMMENT '链接',
  `comments` varchar(500) DEFAULT NULL COMMENT '信息',
  `subjects` varchar(500) DEFAULT NULL COMMENT '类别',
  `update_date` varchar(50) DEFAULT NULL COMMENT '时间',
  `paper_abstract` varchar(1000) DEFAULT NULL,
  `categories` varchar(255) DEFAULT NULL,
  `paper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `favorite` tinyint(1) DEFAULT '0' COMMENT '收藏状态',
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('ab1, xnsj, yyy, xxx,zzz', 'thea', 'http.link', '9page', 'ccd', '1999.93,03', null, null, '1', null);
INSERT INTO `paper` VALUES ('ab2', 'shaqo', 'http.link', '9page', 'ccd', '1999.93,04', null, null, '2', null);
INSERT INTO `paper` VALUES ('ab3', 'thec', 'http.link', '9page', 'ccd', '1999.93,05', null, null, '3', null);
INSERT INTO `paper` VALUES ('ab4, xnsj, yyy, xxx,zzz', 'thed', 'http.link', '9page', 'ccd', '1999.93,06', null, null, '4', null);
INSERT INTO `paper` VALUES ('ab5, xnsj, yyy, xxx,zzz', 'thee', 'http.link', '9page', 'ccd', '1999.93,07', null, null, '5', null);
INSERT INTO `paper` VALUES ('ab6, xnsj, yyy, xxx,zzz', 'thef', 'http.link', '9page', 'ccd', '1999.93,08', null, null, '6', null);
