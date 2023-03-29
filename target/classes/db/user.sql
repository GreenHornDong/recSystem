/*
Navicat MySQL Data Transfer

Source Server         : RecSystem_schema
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : recsystem

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2023-03-27 16:43:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `author_verified` tinyint(1) DEFAULT '0' COMMENT '是否认证为作者',
  `last_login` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上次登录时间',
  `remember_me` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs', 'f4d303b1854ae65764e80394373685e96b43479371b3df5d', null, '0', null, '0');
INSERT INTO `user` VALUES ('2', 'zse', '69153922758813fa25f2dd3499062050750795bd24b0be66', null, '0', null, '0');
INSERT INTO `user` VALUES ('3', 'admin', 'f19e79e6096494172ec11170519715c07f55c40814229b77', '13678890@163.com', '0', '566009862', '0');
