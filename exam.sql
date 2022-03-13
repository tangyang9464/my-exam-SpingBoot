/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 13/03/2022 20:38:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for meta_paper
-- ----------------------------
DROP TABLE IF EXISTS `meta_paper`;
CREATE TABLE `meta_paper`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_score` double NULL DEFAULT 0,
  `question_number` int(0) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `questions` json NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meta_paper
-- ----------------------------
INSERT INTO `meta_paper` VALUES ('1501830983391936514', '1501798846911512577', '操作系统考试', 3, 3, '2022-03-10 16:03:04', '2022-03-11 17:25:30', '[{\"id\": \"\", \"stem\": \"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题要求实现一个计算m~n（m&lt;n）之间所有整数的和的简单函数。</span></div>\", \"score\": 1.0, \"options\": [\"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题要求</span></div>\", \"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题要求实现一个计算m~n（m&lt;n）之间所有整数的和的简单函数。</span></div>\", \"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题要求实现一个计算m~n（m&lt;n）之间所有整数的和的简单函数。</span></div>\", \"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题要求实现一个计算m~n（m&lt;n）之间所有整数的和的简单函数。</span></div>\"], \"questionType\": 0, \"correctAnswer\": 3}, {\"id\": \"\", \"stem\": \"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题要求实现一个计算m~n（m&lt;n）之间所有整数的和的简单函数。</span></div>\", \"score\": 1.0, \"options\": [\"<div style=\\\"color: #d4d4d4; background-color: #1e1e1e; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; line-height: 19px; white-space: pre;\\\"><span style=\\\"color: #ce9178;\\\">本题</span></div>\", \"<p><span style=\\\"color: #ce9178; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; white-space: pre; background-color: #1e1e1e;\\\">要求实现一个函数。</span></p>\", \"<p><span style=\\\"color: #ce9178; font-family: Consolas, \'Courier New\', monospace; font-size: 14px; white-space: pre; background-color: #1e1e1e;\\\">要求实现一个计算m~n（m&lt;n）之间所有整数的和的简单函数。</span></p>\"], \"questionType\": 1, \"correctAnswer\": [2, 1]}, {\"id\": \"\", \"stem\": \"<p>本题对吗</p>\", \"score\": 1.0, \"options\": [], \"questionType\": 2, \"correctAnswer\": \"T\"}]');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1501801308460421121', '计算机网络', '计算机183', '1501798846911512577');
INSERT INTO `room` VALUES ('1502562804060778497', '操作系统', '计算机184', '1501798846911512577');

-- ----------------------------
-- Table structure for room_student_merge
-- ----------------------------
DROP TABLE IF EXISTS `room_student_merge`;
CREATE TABLE `room_student_merge`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `room_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `archive_status` int(0) NULL DEFAULT NULL COMMENT '0-未归档，1-已归档为历史课堂',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_student_merge
-- ----------------------------
INSERT INTO `room_student_merge` VALUES ('3', '1501801308460421121', '1502526352744640513', 0);

-- ----------------------------
-- Table structure for student_paper
-- ----------------------------
DROP TABLE IF EXISTS `student_paper`;
CREATE TABLE `student_paper`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_paper_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meta_paper_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `obtain_score` double NULL DEFAULT 0,
  `correct_number` int(0) NULL DEFAULT 0,
  `submit_time` datetime(0) NULL DEFAULT NULL,
  `finish_status` int(0) NULL DEFAULT 0 COMMENT '0-1-2 未开始-已提交/未批改-已批改',
  `answers` json NULL,
  `actual_start_time` datetime(0) NULL DEFAULT NULL COMMENT '学生开始答题的时间',
  `total_time` bigint(0) NULL DEFAULT NULL COMMENT '秒单位',
  `deadline` datetime(0) NULL DEFAULT NULL,
  `publish_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `allowed_start_time` datetime(0) NULL DEFAULT NULL,
  `total_score` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_paper
-- ----------------------------
INSERT INTO `student_paper` VALUES ('1502969900493242369', '1502526352744640513', '1502969900405161985', '1501830983391936514', '1501801308460421121', 1, 1, '2022-03-13 19:35:59', 2, '[]', '2022-03-13 19:31:59', 240, '2022-03-14 11:28:29', '操作系统考试', '2022-03-13 11:28:29', 3);
INSERT INTO `student_paper` VALUES ('1502970046807343107', '1502526352744640513', '1502970046807343106', '1501830983391936514', '1501801308460421121', 0, 0, '2022-03-13 20:29:28', 2, '[{\"correctStatus\": 2}, {\"correctStatus\": 2}, {\"correctStatus\": 2}]', '2022-03-13 20:08:24', 600, '2022-03-14 11:28:29', '期末考试', '2022-03-13 11:28:29', 3);

-- ----------------------------
-- Table structure for teacher_paper
-- ----------------------------
DROP TABLE IF EXISTS `teacher_paper`;
CREATE TABLE `teacher_paper`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meta_paper_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `undone_number` int(0) NULL DEFAULT NULL,
  `done_number` int(0) NULL DEFAULT 0,
  `total_time` bigint(0) NULL DEFAULT NULL,
  `deadline` datetime(0) NULL DEFAULT NULL,
  `publish_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_score` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_paper
-- ----------------------------
INSERT INTO `teacher_paper` VALUES ('1502969900405161985', '1501798846911512577', '1501830983391936514', '1501801308460421121', 2, 1, 240, '2022-03-14 11:28:29', '操作系统考试', 3);
INSERT INTO `teacher_paper` VALUES ('1502970046807343106', '1501798846911512577', '1501830983391936514', '1501801308460421121', 1, 2, 60, '2022-03-14 11:28:29', '期末考试', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `display_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(0) NULL DEFAULT NULL COMMENT '0-学生，1-老师',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1501798846911512577', '', 'teacherT', 'c93575f4665fa5848cf4ef2efe163724', 'teacherT', '', '', 1, 'default_avatar.jpg');
INSERT INTO `user` VALUES ('1502526352744640513', '', 'ty', 'c93575f4665fa5848cf4ef2efe163724', 'ty', '', '', 0, 'default_avatar.jpg');

SET FOREIGN_KEY_CHECKS = 1;
