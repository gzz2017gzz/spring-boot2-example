/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2020-02-25 23:51:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_customer`
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer`;
CREATE TABLE `sys_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `tradeType` tinyint(4) DEFAULT NULL COMMENT '行业类型 化工0配电1变电 2',
  `title` varchar(100) DEFAULT NULL COMMENT '系统标题',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `url` varchar(100) DEFAULT NULL COMMENT '公司网址',
  `contacts` varchar(15) DEFAULT NULL COMMENT '联系人',
  `contactsJob` varchar(15) DEFAULT NULL COMMENT '联系人职位',
  `contactsTel` varchar(15) DEFAULT NULL COMMENT '联系人电话',
  `contactsMail` varchar(20) DEFAULT NULL COMMENT '联系人邮件',
  `contactsOther` varchar(20) DEFAULT NULL COMMENT '联系人邮件',
  `phoneNo` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=474 DEFAULT CHARSET=utf8 COMMENT='客户';

-- ----------------------------
-- Records of sys_customer
-- ----------------------------
INSERT INTO `sys_customer` VALUES ('462', 'aaa', '0', 'ggg', null, null, 'ccc', null, null, null, null, '3333', 'cccs');
INSERT INTO `sys_customer` VALUES ('465', 'string', '1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('466', null, '1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('467', null, '1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('468', null, '1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('469', null, '1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('470', null, '1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('471', null, null, null, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('472', null, null, null, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `sys_customer` VALUES ('473', null, null, null, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string');

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typeName` varchar(20) DEFAULT NULL COMMENT '类型名称',
  `typeCode` int(11) DEFAULT NULL COMMENT '类型编码',
  `dataKey` int(11) DEFAULT NULL COMMENT '数据键',
  `dataValue` varchar(50) DEFAULT NULL COMMENT '数据值',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态1 启动 0 禁用',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='枚举字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parentId` int(11) DEFAULT NULL COMMENT '上级主键',
  `level` int(11) DEFAULT NULL COMMENT '层级',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `path` varchar(100) DEFAULT NULL COMMENT '路径',
  `orderNum` int(11) DEFAULT NULL COMMENT '排序编号',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customerId` int(11) DEFAULT NULL COMMENT '客户主键',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('2', 'gzz2', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('3', 'gzz3', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('4', 'gzz4', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('5', 'gzz5', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('6', 'gzz6', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('7', 'gzz7', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('8', 'gzz8', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('9', 'gzz9', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('10', 'gzz10', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('11', 'gzz11', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('12', 'gzz12', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('13', 'gzz13', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('14', 'gzz14', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('15', 'gzz15', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('16', 'gzz16', '2018-07-13', '1');
INSERT INTO `sys_user` VALUES ('17', 'gzz', null, '1');
INSERT INTO `sys_user` VALUES ('18', 'gzz', null, '1');
