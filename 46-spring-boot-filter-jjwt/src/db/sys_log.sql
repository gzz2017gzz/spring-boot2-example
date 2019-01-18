/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2019-01-13 10:59:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_ip` varchar(30) CHARACTER SET latin1 DEFAULT NULL COMMENT '客户端IP',
  `uri` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '请求地址',
  `type` varchar(50) CHARACTER SET latin1 DEFAULT NULL COMMENT '请求方式,普通,ajax',
  `method` varchar(10) CHARACTER SET latin1 DEFAULT NULL COMMENT 'method post get等',
  `param_data` longtext CHARACTER SET latin1 COMMENT '参数json',
  `session_id` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT 'sessionID',
  `request_time` bigint(20) DEFAULT NULL,
  `return_time` bigint(20) DEFAULT NULL,
  `return_data` longtext CHARACTER SET latin1 COMMENT '返回json',
  `status_code` int(10) DEFAULT NULL COMMENT 'httpStatusCode',
  `cost_time` int(8) DEFAULT '0' COMMENT '耗时-毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='请求日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('41', '127.0.0.1', '/sysUser/queryList', 'application/json;charset=UTF-8', 'POST', '{}', '1', '1547347244032', '1547347244311', 'null', '200', '279');
INSERT INTO `sys_log` VALUES ('42', '127.0.0.1', '/sysUser/queryPage', 'application/json;charset=UTF-8', 'POST', '{}', '2', '1547347244382', '1547347244392', 'null', '200', '10');
INSERT INTO `sys_log` VALUES ('43', '127.0.0.1', '/sysUser/queryList', 'application/json;charset=UTF-8', 'POST', '{}', '1', '1547347301347', '1547347301556', 'null', '200', '209');
INSERT INTO `sys_log` VALUES ('44', '127.0.0.1', '/sysUser/queryPage', 'application/json;charset=UTF-8', 'POST', '{}', '2', '1547347301621', '1547347301633', 'null', '200', '12');

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
