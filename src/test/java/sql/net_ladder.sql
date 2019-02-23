# Host: localhost  (Version: 5.5.53)
# Date: 2019-02-23 21:29:17
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "t_error_log"
#

DROP TABLE IF EXISTS `t_error_log`;
CREATE TABLE `t_error_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `url` varchar(512) DEFAULT NULL COMMENT '访问地址',
  `statusCode` varchar(8) DEFAULT NULL COMMENT '状态码',
  `contentType` varchar(64) DEFAULT NULL COMMENT '内容类型',
  `contentLength` varchar(8) DEFAULT NULL COMMENT '内容长度',
  `contentEncoding` varchar(32) DEFAULT NULL COMMENT '内容编码',
  `protocolVersion` varchar(32) DEFAULT NULL COMMENT '协议版本',
  `reasonPhrase` varchar(64) DEFAULT NULL COMMENT 'reasonPhrase',
  `createTime` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `content` varchar(512) DEFAULT NULL COMMENT '返回内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='错误日志表';

#
# Structure for table "t_run_log"
#

DROP TABLE IF EXISTS `t_run_log`;
CREATE TABLE `t_run_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `url` varchar(512) DEFAULT NULL COMMENT '访问地址',
  `statusCode` varchar(8) DEFAULT NULL COMMENT '状态码',
  `contentType` varchar(64) DEFAULT NULL COMMENT '内容类型',
  `contentLength` varchar(8) DEFAULT NULL COMMENT '内容长度',
  `contentEncoding` varchar(32) DEFAULT NULL COMMENT '内容编码',
  `protocolVersion` varchar(32) DEFAULT NULL COMMENT '协议版本',
  `reasonPhrase` varchar(64) DEFAULT NULL COMMENT 'reasonPhrase',
  `createTime` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `content` varchar(512) DEFAULT NULL COMMENT '返回内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=239 DEFAULT CHARSET=utf8 COMMENT='运行日志表';
