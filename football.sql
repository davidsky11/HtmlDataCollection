/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : football

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-08-15 09:56:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `premiership`
-- ----------------------------
DROP TABLE IF EXISTS `premiership`;
CREATE TABLE `premiership` (
  `HomeTeam` varchar(20) default NULL,
  `AwayTeam` varchar(20) default NULL,
  `Result` varchar(20) default NULL,
  `Date` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of premiership
-- ----------------------------
INSERT INTO `premiership` VALUES ('赫尔城', '埃弗顿', '0:2', '2014-05-11');
INSERT INTO `premiership` VALUES ('桑德兰', '斯旺西城', '1:3', '2014-05-11');
INSERT INTO `premiership` VALUES ('加迪夫', '切尔西', '1:2', '2014-05-11');
INSERT INTO `premiership` VALUES ('利物浦', '纽卡斯尔', '2:1', '2014-05-11');
INSERT INTO `premiership` VALUES ('曼城', '西汉姆', '2:0', '2014-05-11');
INSERT INTO `premiership` VALUES ('热刺', '维拉', '3:0', '2014-05-11');
INSERT INTO `premiership` VALUES ('南安普联', '曼联', '1:1', '2014-05-11');
INSERT INTO `premiership` VALUES ('诺维奇城', '阿森纳', '0:2', '2014-05-11');
