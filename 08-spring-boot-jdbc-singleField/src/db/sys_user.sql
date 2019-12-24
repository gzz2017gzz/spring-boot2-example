/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2019-01-05 00:18:05
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'gzz1', '2018-07-13', '1');
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
