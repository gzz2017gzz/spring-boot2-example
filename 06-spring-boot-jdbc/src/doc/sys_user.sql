DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
)COMMENT='用户';

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
) COMMENT='客户';
INSERT INTO `sys_customer` VALUES ('461', '新松融通', '1', '新松机器人管理平台', null, null, '刘峰', null, null, null, null, '18514587077', '111');
INSERT INTO `sys_customer` VALUES ('462', '阿斯蒂芬', '1', '23', 'asdf', 'string', 'ccc', null, null, null, null, 'string', 'string');
INSERT INTO `sys_customer` VALUES ('489', 'aaa', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('490', 'Kayla_Lesch}', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('491', 'Anika_Heaney', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('492', 'Emerald.Lowe', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('493', 'Esta.DAmore', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('494', 'Virgie91', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('495', 'Eldon_Witting', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('496', 'Cora_Kessler', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');
INSERT INTO `sys_customer` VALUES ('497', 'Adrian_Miller', '0', 'ggg', null, null, null, null, null, null, null, '1233425', 'cccs');


