/*
 Navicat Premium Data Transfer

 Source Server         : trial_run1
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : goods

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 16/01/2022 19:16:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods_
-- ----------------------------
DROP TABLE IF EXISTS `goods_`;
CREATE TABLE `goods_`  (
  `id` int UNSIGNED NOT NULL COMMENT '商品编号',
  `name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `price` int NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_
-- ----------------------------
INSERT INTO `goods_` VALUES (1001, 'cellphone', 10086);
INSERT INTO `goods_` VALUES (1002, 'laptop', 10001);
INSERT INTO `goods_` VALUES (1003, 'keyboard', 10000);
INSERT INTO `goods_` VALUES (1004, 'earplug', 4399);

-- ----------------------------
-- Table structure for order_
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_`  (
  `order_id` int UNSIGNED NOT NULL COMMENT '订单编号',
  `id` int UNSIGNED NOT NULL COMMENT '商品编号',
  `name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `price` int UNSIGNED NOT NULL COMMENT '商品价格',
  `time` datetime NOT NULL COMMENT '下单时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES (10003, 1003, 'keyboard', 10000, '2021-12-25 15:30:54');
INSERT INTO `order_` VALUES (10002, 1002, 'laptop', 10001, '2021-12-25 15:30:29');
INSERT INTO `order_` VALUES (10001, 1001, 'cellphone', 10086, '2021-12-25 15:29:52');
INSERT INTO `order_` VALUES (10004, 1004, 'earplug', 4399, '2021-12-25 15:15:15');

SET FOREIGN_KEY_CHECKS = 1;
