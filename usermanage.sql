/*
Navicat MySQL Data Transfer

Source Server         : mysql5.6
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : usermanage

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2020-06-27 23:17:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` varchar(60) NOT NULL,
  `adminuser` varchar(30) DEFAULT NULL,
  `adminpass` varchar(30) DEFAULT NULL,
  `adminame` varchar(11) DEFAULT NULL,
  `adminemail` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `power` int(1) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  `loginip` varchar(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', 'root', null, null, null, '2', '2020-06-28 18:18:16', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('06C070515D364BB8AB53EF4A1F0BB4E0', '12311', '12311', '12311', '1040492966@qq.com', '1211', '2020-06-28', '0', '1', '30FB82FB116B4B1CBCC6D8C035E6A3B6');
INSERT INTO `user` VALUES ('51539B28C08A439FA43E42FA3F482B25', 'aaa', 'aaa', '12日日日', 'aaa@qq.com', '15259592449', '2020-06-21', '0', '1', '46697FB0A02F49079D2881E410E69C8C');
INSERT INTO `user` VALUES ('D4712EC6F9A447238BC05DEF50B88604', 'hhh', 'hhh', '张三', '1040492966@qq.com', '15259592449', '2020-06-21', '男', '1', '599DC38C37DE44C79E044F384F75F800');
