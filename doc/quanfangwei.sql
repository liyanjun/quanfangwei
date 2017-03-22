/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : quanfangwei

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-22 17:43:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sv_create_qrcode_record
-- ----------------------------
DROP TABLE IF EXISTS `sv_create_qrcode_record`;
CREATE TABLE `sv_create_qrcode_record` (
  `id` int(11) NOT NULL,
  `device_ids` varchar(512) NOT NULL COMMENT '设备ID',
  `user_id` int(11) NOT NULL COMMENT '哪个用户创建的',
  `qrcode` varchar(255) DEFAULT NULL COMMENT '创建出来的二维码',
  `effect_time` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_avalible` tinyint(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='创建开门二维码记录';

-- ----------------------------
-- Records of sv_create_qrcode_record
-- ----------------------------

-- ----------------------------
-- Table structure for sv_device
-- ----------------------------
DROP TABLE IF EXISTS `sv_device`;
CREATE TABLE `sv_device` (
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
-- Records of sv_device
-- ----------------------------

-- ----------------------------
-- Table structure for sv_qrcode
-- ----------------------------
DROP TABLE IF EXISTS `sv_qrcode`;
CREATE TABLE `sv_qrcode` (
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
-- Records of sv_qrcode
-- ----------------------------

-- ----------------------------
-- Table structure for system_resource
-- ----------------------------
DROP TABLE IF EXISTS `system_resource`;
CREATE TABLE `system_resource` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL COMMENT '资源名',
  `url` varchar(255) NOT NULL COMMENT '资源地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_resource
-- ----------------------------

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(32) NOT NULL COMMENT '角色名',
  `describ` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role
-- ----------------------------

-- ----------------------------
-- Table structure for system_thirdconnector_log
-- ----------------------------
DROP TABLE IF EXISTS `system_thirdconnector_log`;
CREATE TABLE `system_thirdconnector_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `connectorName` varchar(50) NOT NULL DEFAULT '0' COMMENT '链接名',
  `requestUrl` varchar(250) NOT NULL DEFAULT '0' COMMENT '请求地址',
  `request` varchar(800) NOT NULL DEFAULT '0' COMMENT '请求',
  `return_back` varchar(800) NOT NULL DEFAULT '0' COMMENT '返回',
  `other1` varchar(500) DEFAULT '0' COMMENT '保留参数',
  `other2` varchar(500) DEFAULT '0' COMMENT '保留参数2',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COMMENT='第三方链接日志表';

-- ----------------------------
-- Records of system_thirdconnector_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_third_log
-- ----------------------------
DROP TABLE IF EXISTS `system_third_log`;
CREATE TABLE `system_third_log` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录和第三方通讯时候的情况';

-- ----------------------------
-- Records of system_third_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_pk` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-03-20 11:21:03', '2017-03-20 11:21:17', null, '2017-03-20 11:21:29', null, '-1');
