/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : quanfangwei

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2017-03-23 22:59:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sv_create_qrcode_record`
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
-- Table structure for `sv_device`
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
-- Table structure for `sv_qrcode`
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
-- Table structure for `system_resource`
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
-- Table structure for `system_role`
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
INSERT INTO `system_role` VALUES ('1', '访客', '访客');
INSERT INTO `system_role` VALUES ('2', '业主', '业主');
INSERT INTO `system_role` VALUES ('3', '管理员', '管理员');

-- ----------------------------
-- Table structure for `system_thirdconnector_log`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方链接日志表';

-- ----------------------------
-- Records of system_thirdconnector_log
-- ----------------------------

-- ----------------------------
-- Table structure for `system_third_log`
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
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL COMMENT '手机号',
  `owner_id` int(11) DEFAULT NULL COMMENT '令令数据库中的用户ID',
  `lingling_id` varchar(32) DEFAULT NULL COMMENT 'lingling_id',
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-03-20 11:21:03', '2017-03-20 11:21:17', null, '2017-03-20 11:21:29', null, '-1');
INSERT INTO `system_user` VALUES ('4', '17702495456', '63', '042d000ce0', '4e299bce9c8390ba9655e55e34fee3dd', '刘一兰', '2', null, '1981-05-04', null, null, null, null, '105', '沈阳勃通科技', null, null, null, null, null, '2017-03-23 21:02:17', null, '-1');
INSERT INTO `system_user` VALUES ('8', '13942829144', null, '042d000ccb', 'f3842dd3a9524bd105fe1ec387ed6c6f', '张霆文', '2', null, '1980-12-24', null, null, null, null, '108', '二期23楼1号', null, null, null, null, null, '2017-03-23 22:34:55', null, '-1');
INSERT INTO `system_user` VALUES ('9', '13829483934', '20', null, '0e84c3d11ca56ed17951e6c212bf5cdc', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-03-23 22:46:32', null, '-1');

-- ----------------------------
-- Table structure for `system_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '角色名',
  `role_id` int(11) NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('1', '4', '2');
INSERT INTO `system_user_role` VALUES ('3', '8', '3');
INSERT INTO `system_user_role` VALUES ('4', '9', '3');
