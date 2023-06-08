/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : daodemodb

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 08/06/2023 23:07:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for p_selectUserByAge
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_selectUserByAge`;
delimiter ;;
CREATE PROCEDURE `p_selectUserByAge`(age int, out count int)
BEGIN
	SET count=(SELECT count(1) FROM t_user t WHERE t.age=age);
	SELECT * FROM t_user t WHERE t.age=age;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
