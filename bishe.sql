/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 127.0.0.1:3306
 Source Schema         : bishe

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 24/05/2023 15:03:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alarm_information
-- ----------------------------
DROP TABLE IF EXISTS `alarm_information`;
CREATE TABLE `alarm_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alarm_time` datetime(0) NOT NULL,
  `alarm_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alarm_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for distribution_equipment
-- ----------------------------
DROP TABLE IF EXISTS `distribution_equipment`;
CREATE TABLE `distribution_equipment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `model` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for distribution_network_parameters
-- ----------------------------
DROP TABLE IF EXISTS `distribution_network_parameters`;
CREATE TABLE `distribution_network_parameters`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `voltage` float NOT NULL,
  `current` float NOT NULL,
  `power` float NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fault_report
-- ----------------------------
DROP TABLE IF EXISTS `fault_report`;
CREATE TABLE `fault_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fault_time` datetime(0) NOT NULL,
  `equipment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node`  (
  `node_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '节点编号',
  `node_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '节点名称',
  `fault_info` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '故障信息',
  `latitude` decimal(10, 3) DEFAULT NULL COMMENT '纬度',
  `longitude` decimal(10, 3) DEFAULT NULL COMMENT '经度',
  `current` float(10, 2) DEFAULT NULL COMMENT '电流',
  `electric_field` float(10, 2) DEFAULT NULL COMMENT '电场',
  `temperature` float(10, 2) DEFAULT NULL COMMENT '温度',
  `humidity` float(10, 2) DEFAULT NULL COMMENT '湿度',
  `battery_voltage` float(10, 2) DEFAULT NULL COMMENT '电池电压',
  `solar_voltage` float(10, 2) DEFAULT NULL COMMENT '太阳能电压',
  `create_time` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建时间\r\n',
  PRIMARY KEY (`node_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 658 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '节点信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES (1, '上海一号', '正常', 121.474, 31.231, 1.20, 4.20, 22.00, 88.00, 363.00, 220.00, NULL);
INSERT INTO `node` VALUES (654, '北京一号', '接地', 116.405, 39.905, 1.40, 3.00, 22.00, 88.00, 53.00, 360.00, '2023-05-18');
INSERT INTO `node` VALUES (655, '太原一号', '正常', 112.549, 37.857, 4.60, 5.30, 22.00, 88.00, 53.00, 220.00, '2023-05-18');
INSERT INTO `node` VALUES (656, '石家庄一号', '宕机重启', 114.502, 38.045, 4.30, 5.60, 22.00, 88.00, 22.00, 360.00, '2023-05-18');
INSERT INTO `node` VALUES (657, '西安一号', '接地', 108.948, 34.263, 5.30, 4.80, 22.00, 55.00, 22.00, 220.00, '2023-05-18');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'admin', '666666');
INSERT INTO `user` VALUES (3, 'root', '123456');

SET FOREIGN_KEY_CHECKS = 1;
