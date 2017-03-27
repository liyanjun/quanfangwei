/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : quanfangwei

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2017-03-28 00:17:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sv_create_qrcode_record`
-- ----------------------------
DROP TABLE IF EXISTS `sv_create_qrcode_record`;
CREATE TABLE `sv_create_qrcode_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sv_qrcode
-- ----------------------------
INSERT INTO `sv_qrcode` VALUES ('1', '2', '56714', 'F2EB940855150DD1DEE75408EF12DC6E001196F3DB47D20EB9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', 'æè¡å', '2017-04-06 00:00:00', '4095', '2017-03-27 22:16:16');
INSERT INTO `sv_qrcode` VALUES ('2', '2', '56715', 'F2EB940855150DD1DEE7540851507016001196F3EABB691DB9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', 'æè¡å', '2017-04-06 00:00:00', '4095', '2017-03-27 22:37:13');
INSERT INTO `sv_qrcode` VALUES ('3', '2', '56716', 'F2EB940855150DD1DEE7540851507016001196F32ACA4AB8B9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', 'æè¡å', '2017-04-06 00:00:00', '4095', '2017-03-27 22:37:26');
INSERT INTO `sv_qrcode` VALUES ('4', '2', '56717', 'F2EB940855150DD1DEE75408E2E9F202001196F381ED40C2B9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', 'æè¡å', '2018-12-04 00:00:00', '4095', '2017-03-27 22:49:29');
INSERT INTO `sv_qrcode` VALUES ('5', '2', '56718', 'F2EB940855150DD1DEE75408FB0725A5001196F30ECBC60AB9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', 'æè¡å', '2018-12-04 00:00:00', '4095', '2017-03-27 22:50:24');
INSERT INTO `sv_qrcode` VALUES ('6', '2', '56719', 'F2EB940855150DD1DEE75408481B2B03001196F38031A5D7B9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', 'æè¡å', '2018-12-04 00:00:00', '4095', '2017-03-27 22:53:26');
INSERT INTO `sv_qrcode` VALUES ('7', '2', '56720', 'F2EB940855150DD1DEE75408F4BDE9C7001196F334496EA1B9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720', '20', '15677188594', '李衍君', '2018-12-04 00:00:00', '4095', '2017-03-27 22:56:27');

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '角色名',
  `describ` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(11) NOT NULL COMMENT '-1：已删除，1：未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2017-03-20 11:21:29', null, '-1');
INSERT INTO `system_user` VALUES ('20', '15607716976', '76', '042d000cfd', '', '廖海成', '2', null, '1993-10-03', null, null, null, null, '10', '高新苑01栋01单元', '2017-03-26 11:58:53', null, '-1');
INSERT INTO `system_user` VALUES ('21', '15577873817', null, null, '3e756f04d22303eee4c5d5d5e2827f37', null, null, null, null, null, null, null, null, null, null, '2017-03-26 11:59:34', null, '-1');
INSERT INTO `system_user` VALUES ('22', '15677188594', null, null, '', null, null, null, null, null, null, null, null, null, null, '2017-03-26 23:23:52', null, '-1');
INSERT INTO `system_user` VALUES ('24', '1567718859', null, null, '4e299bce9c8390ba9655e55e34fee3dd', null, null, null, null, null, null, null, null, null, null, '2017-03-26 23:39:21', null, '1');
INSERT INTO `system_user` VALUES ('25', '18376621242', null, null, 'f3842dd3a9524bd105fe1ec387ed6c6f', null, null, null, null, null, null, null, null, null, null, '2017-03-27 10:49:24', null, '-1');
INSERT INTO `system_user` VALUES ('26', '18977141907', '10', '042d000cfa', 'f3842dd3a9524bd105fe1ec387ed6c6f', '庞贤丰', '2', null, '1995-09-06', null, null, null, null, '134', '1DANYUAN', '2017-03-27 21:57:01', null, '-1');

-- ----------------------------
-- Table structure for `system_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '角色名',
  `role_id` int(11) NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('1', '4', '2');
INSERT INTO `system_user_role` VALUES ('3', '8', '3');
INSERT INTO `system_user_role` VALUES ('4', '9', '3');
INSERT INTO `system_user_role` VALUES ('5', '10', '1');
INSERT INTO `system_user_role` VALUES ('6', '11', '1');
INSERT INTO `system_user_role` VALUES ('7', '12', '1');
INSERT INTO `system_user_role` VALUES ('8', '13', '1');
INSERT INTO `system_user_role` VALUES ('9', '14', '1');
INSERT INTO `system_user_role` VALUES ('10', '15', '1');
INSERT INTO `system_user_role` VALUES ('11', '17', '1');
INSERT INTO `system_user_role` VALUES ('12', '20', '2');
INSERT INTO `system_user_role` VALUES ('13', '21', '1');
INSERT INTO `system_user_role` VALUES ('14', '22', '1');
INSERT INTO `system_user_role` VALUES ('15', '24', '1');
INSERT INTO `system_user_role` VALUES ('16', '25', '1');
INSERT INTO `system_user_role` VALUES ('17', '26', '3');
