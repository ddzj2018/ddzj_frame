CREATE DATABASE IF NOT EXISTS mgr_frame DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE mgr_frame;

CREATE TABLE IF NOT EXISTS `user`(
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';