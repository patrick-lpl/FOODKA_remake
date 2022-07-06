/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : foodka

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 06/07/2022 17:07:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID\r\n',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `admin_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式',
  `admin_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `photo` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户';

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`admin_id`, `username`, `password`, `admin_name`, `admin_phone`, `admin_email`, `photo`, `create_time`, `update_time`) VALUES (1, 'admin', 'MTIz', 'gst', '2222', '123@qq.com', '', '2021-11-26 07:10:24', '2021-11-26 07:10:27');
INSERT INTO `admin` (`admin_id`, `username`, `password`, `admin_name`, `admin_phone`, `admin_email`, `photo`, `create_time`, `update_time`) VALUES (2, 'admin1', '123', 'lpl', '123', '123@qq.com', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `dish_id` int NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dish_price` int DEFAULT NULL,
  PRIMARY KEY (`dish_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dish
-- ----------------------------
BEGIN;
INSERT INTO `dish` (`dish_id`, `dish_name`, `dish_price`) VALUES (1, '牛逼汉堡', 18);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(255) NOT NULL,
  `us_id` int DEFAULT NULL,
  `total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` (`order_id`, `us_id`, `total`, `create_time`) VALUES ('1649396504550', 1, '1000', '2022-06-30 13:41:44');
INSERT INTO `order` (`order_id`, `us_id`, `total`, `create_time`) VALUES ('1649420880859', 1, '100', '2022-06-30 20:28:00');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `us_id` int NOT NULL AUTO_INCREMENT,
  `us_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员名称',
  `us_age` int DEFAULT NULL COMMENT '年龄',
  `us_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `us_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`us_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`us_id`, `us_name`, `us_age`, `us_phone`, `create_time`, `us_password`) VALUES (1, 'gst', 18, '18969144960', '2022-06-29 21:43:26', 'MTIz');
INSERT INTO `user` (`us_id`, `us_name`, `us_age`, `us_phone`, `create_time`, `us_password`) VALUES (2, 'lpl', 1, '13036351198', '2022-07-04 14:48:16', 'lpl');
INSERT INTO `user` (`us_id`, `us_name`, `us_age`, `us_phone`, `create_time`, `us_password`) VALUES (18, 'ljj', 3, '123456', '2022-07-04 15:49:45', 'MTIz');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
