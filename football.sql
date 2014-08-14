/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : football

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-08-14 17:00:41
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
  `Date` varchar(15) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of premiership
-- ----------------------------
