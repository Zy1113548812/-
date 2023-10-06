/*
Navicat MySQL Data Transfer

Source Server         : whx
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : film_db

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2023-08-25 10:56:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for arrangement
-- ----------------------------
DROP TABLE IF EXISTS `arrangement`;
CREATE TABLE `arrangement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `movie_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arrangement
-- ----------------------------
INSERT INTO `arrangement` VALUES ('1', 'A', '123', '1', '孤注一掷');

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(50) DEFAULT NULL,
  `director_name` varchar(50) DEFAULT NULL,
  `act_role` varchar(50) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '孤注一掷', '某某', '王传君', '啊实打实的', '90分钟');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(1) DEFAULT NULL,
  `user_level` varchar(10) DEFAULT NULL,
  `price_total` varchar(10) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '1', null, null, '2023-08-22 11:37:55', null, null);
INSERT INTO `user` VALUES ('3', 'lisi', '123456', '3', '铜牌', '50', '2023-08-22 11:38:38', '134146912', '81234845791@qq.com');
INSERT INTO `user` VALUES ('4', 'wangwu', '123456', '3', '银牌', '60', '2023-08-22 11:38:38', '134146912', '81234845791@qq.com');
INSERT INTO `user` VALUES ('5', 'jinli', '123456', '2', null, null, '2023-08-22 11:41:03', null, null);
