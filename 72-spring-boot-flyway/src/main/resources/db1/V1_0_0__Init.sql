DROP TABLE IF EXISTS `base_audio`;
CREATE TABLE `base_audio` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '描述',
  `branch_id` bigint(20) DEFAULT NULL COMMENT '门店',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `file_name` varchar(200) DEFAULT NULL COMMENT '文件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 COMMENT='系统提示音';