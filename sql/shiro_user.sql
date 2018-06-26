/*
Navicat MySQL Data Transfer

Source Server         : 192.168.26.128_3306
Source Server Version : 50173
Source Host           : 192.168.26.128:3306
Source Database       : saastest

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-06-15 17:44:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shiro_user`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_user
-- ----------------------------
INSERT INTO `shiro_user` VALUES ('1', 'root@shiro.com', 'b846ddbdcbebeadbc9745f19d9f19445');
INSERT INTO `shiro_user` VALUES ('2', 'admin@shiro.com', 'b846ddbdcbebeadbc9745f19d9f19445');
INSERT INTO `shiro_user` VALUES ('3', 'user@shiro.com', 'b846ddbdcbebeadbc9745f19d9f19445');
INSERT INTO `shiro_user` VALUES ('4', 'guest@shiro.com', 'b846ddbdcbebeadbc9745f19d9f19445');
