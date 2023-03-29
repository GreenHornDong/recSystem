/*
Navicat MySQL Data Transfer

Source Server         : RecSystem_schema
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : recsystem

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2023-03-29 15:57:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_to_paper
-- ----------------------------
DROP TABLE IF EXISTS `user_to_paper`;
CREATE TABLE `user_to_paper` (
  `user_id` int NOT NULL,
  `paper_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_to_paper
-- ----------------------------
INSERT INTO `user_to_paper` VALUES ('1', '4');
INSERT INTO `user_to_paper` VALUES ('1', '1');
INSERT INTO `user_to_paper` VALUES ('1', '2');
INSERT INTO `user_to_paper` VALUES ('1', '3');
INSERT INTO `user_to_paper` VALUES ('2', '1');
INSERT INTO `user_to_paper` VALUES ('2', '2');
