/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : quanfangwei

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2017-03-19 23:13:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL,
  `device_id` int(11) NOT NULL COMMENT '设备ID',
  `sdk_key` varchar(255) DEFAULT NULL COMMENT '开门秘钥',
  `user_id` int(11) NOT NULL COMMENT '当前数据库用户ID',
  `key_effec_day` int(11) DEFAULT NULL COMMENT '秘钥有效天数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前时间',
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------

-- ----------------------------
-- Table structure for `qrcode`
-- ----------------------------
DROP TABLE IF EXISTS `qrcode`;
CREATE TABLE `qrcode` (
  `id` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL COMMENT '业主二维码：1，访客二维码：2',
  `code_id` int(11) NOT NULL COMMENT '二维码的code_id',
  `qrcode_key` varchar(255) NOT NULL COMMENT '二维码字符串',
  `user_id` int(11) NOT NULL COMMENT '对应全方位服务器用户ID',
  `visit_phone` varchar(32) NOT NULL COMMENT '访客手机号',
  `name` varchar(64) NOT NULL COMMENT '访客姓名',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '来访时间，访客二维码特有,用于控制访客可以开始打开设备的时间',
  `end_time` int(11) NOT NULL COMMENT '二维码有效时间，单位分钟，最大4095分钟',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '二维码创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrcode
-- ----------------------------

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL COMMENT '资源名',
  `url` varchar(255) NOT NULL COMMENT '资源地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) NOT NULL COMMENT '角色名',
  `describ` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL COMMENT '手机号',
  `owner_id` int(11) DEFAULT NULL COMMENT '令令数据库中的用户ID',
  `lingling_id` int(11) DEFAULT NULL COMMENT 'lingling_id',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `username` varchar(16) DEFAULT NULL COMMENT '用户姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `nation` varchar(64) DEFAULT NULL COMMENT '民族',
  `birthday` varchar(16) DEFAULT NULL COMMENT '生日',
  `creditAddress` varchar(255) DEFAULT NULL COMMENT '身份证地址',
  `creditNo` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `creditImgUrl` varchar(512) DEFAULT NULL COMMENT '身份证图片地址',
  `headImgUrl` varchar(512) DEFAULT NULL COMMENT '大头照片图片地址',
  `addressId` int(11) DEFAULT NULL COMMENT '小区内住址ID',
  `address` varchar(255) DEFAULT NULL COMMENT '小区内住址',
  `qrcode_key` varchar(255) DEFAULT NULL COMMENT '二维码字符串',
  `end_time` int(11) DEFAULT NULL COMMENT '二维码有效时间，单位分钟，最大4095分钟',
  `qrcode_create_time` timestamp NULL DEFAULT NULL,
  `begin_date` timestamp NULL DEFAULT NULL COMMENT '开始有效时间',
  `end_date` timestamp NULL DEFAULT NULL COMMENT '结束有效时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(11) NOT NULL COMMENT '-1：已删除，1：未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
