/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-12-24 21:30:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `function`
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) DEFAULT NULL COMMENT '路径',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='功能';

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('13', 'user:create', '用户模块新增', '1');
INSERT INTO `function` VALUES ('14', 'user:update', '用户模块修改', '1');
INSERT INTO `function` VALUES ('15', 'menu:create', '菜单模块新增', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('9', 'admin', '管理员', '1');
INSERT INTO `role` VALUES ('10', 'user', '用户管理员', '1');

-- ----------------------------
-- Table structure for `role_function`
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色主键',
  `function_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '功能主键',
  PRIMARY KEY (`role_id`,`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色功能关系';

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES ('9', '13');
INSERT INTO `role_function` VALUES ('9', '14');
INSERT INTO `role_function` VALUES ('9', '15');
INSERT INTO `role_function` VALUES ('10', '13');
INSERT INTO `role_function` VALUES ('10', '14');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐',
  `locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('17', 'zhang', '671fc3ccd264797e4ba07109f4c0bc31', 'b5b96ddcbba29359b13386082a45d4fe', '0');
INSERT INTO `user` VALUES ('18', 'li', '66bbdcc735e984c8d4ffe623351ffc62', 'f99c06566eb7f8e5d2731f006ff39e27', '0');
INSERT INTO `user` VALUES ('19', 'wu', '591ab8b999170533acb9e643e099f548', '530baf9eec93acf0e41d5dcc7564a9b9', '0');
INSERT INTO `user` VALUES ('20', 'wang', '341e99db830ed3bc6b3bcd6d84af3c78', '539124255bdfdef904205afdb68c9702', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户主键',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色主键',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('17', '9');
