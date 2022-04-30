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

 Date: 30/04/2022 18:07:57
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
INSERT INTO `meta_paper` VALUES ('1509050450389520386', '1501798846911512577', '期末考试-修改版', 8, 3, '2022-03-30 14:10:39', '2022-03-30 14:45:30', '[{\"stem\": \"<p>这是一个单选题</p>\", \"score\": 2.0, \"options\": [\"<p>false</p>\", \"<p>正确答案</p>\", \"<p>false</p>\", \"<p>false</p>\"], \"questionType\": 0, \"correctAnswer\": 1}, {\"stem\": \"<p>多选题目</p>\", \"score\": 4.0, \"options\": [\"<p>正确C</p>\", \"<p>正确D</p>\", \"<p>答案A</p>\", \"<p>答案B</p>\"], \"questionType\": 1, \"correctAnswer\": [2, 3]}, {\"stem\": \"<p>判断题</p>\", \"score\": 2.0, \"options\": [\"<p>正确C</p>\", \"<p>正确D</p>\", \"<p>答案A</p>\", \"<p>答案B</p>\"], \"questionType\": 2, \"correctAnswer\": \"F\"}]');

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
INSERT INTO `room` VALUES ('1509046305767051265', '计算机网络', '计科183', '1501798846911512577');
INSERT INTO `room` VALUES ('1512719294815596546', '课堂1', '143', '1501798846911512577');
INSERT INTO `room` VALUES ('1512719321109688321', '课堂2', '143', '1501798846911512577');
INSERT INTO `room` VALUES ('1512719342437724161', '课堂3', '143', '1501798846911512577');
INSERT INTO `room` VALUES ('1512719400809852930', '课堂5', '143', '1501798846911512577');

-- ----------------------------
-- Table structure for room_student_merge
-- ----------------------------
DROP TABLE IF EXISTS `room_student_merge`;
CREATE TABLE `room_student_merge`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `room_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `archive_status` int(0) NULL DEFAULT 0 COMMENT '0-未归档，1-已归档为历史课堂',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_student_merge
-- ----------------------------
INSERT INTO `room_student_merge` VALUES ('1509049919868784642', '1509046305767051265', '1502526352744640513', 0);

-- ----------------------------
-- Table structure for student_paper
-- ----------------------------
DROP TABLE IF EXISTS `student_paper`;
CREATE TABLE `student_paper`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_paper_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meta_paper_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `room_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `obtain_score` double NULL DEFAULT 0,
  `correct_number` int(0) NULL DEFAULT 0,
  `submit_time` datetime(0) NULL DEFAULT NULL,
  `finish_status` int(0) NULL DEFAULT 0 COMMENT '0-1-2 未开始-已开始-已提交',
  `student_answers` json NULL,
  `actual_start_time` datetime(0) NULL DEFAULT NULL COMMENT '学生开始答题的时间',
  `total_time` bigint(0) NULL DEFAULT NULL COMMENT '秒单位',
  `deadline` datetime(0) NULL DEFAULT NULL,
  `publish_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `allowed_start_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_paper
-- ----------------------------
INSERT INTO `student_paper` VALUES ('1509093618405466114', '1502526352744640513', '1509093618405466113', '1501798846911512577', '1509050450389520386', '1509046305767051265', 2, 1, '2022-03-30 17:13:52', 2, '[{\"correctStatus\": 0, \"studentAnswer\": 1}, {\"correctStatus\": 0, \"studentAnswer\": [1, 2]}, {\"correctStatus\": 0, \"studentAnswer\": \"T\"}]', '2022-03-30 17:13:44', 1800, '2022-03-31 09:02:08', '期末考试-修改版', '2022-03-30 09:02:07');
INSERT INTO `student_paper` VALUES ('1512732116828090370', '1502526352744640513', '1512732116760981506', '1501798846911512577', '1509050450389520386', '1509046305767051265', 0, 0, '2022-04-09 23:26:52', 2, '[{\"correctStatus\": 0, \"studentAnswer\": 2}, {\"correctStatus\": 0, \"studentAnswer\": [0, 1]}, {\"correctStatus\": 0, \"studentAnswer\": \"T\"}]', '2022-04-09 23:26:31', 1800, '2022-04-09 10:00:13', '期末考试-修改版', '2022-04-09 10:00:12');
INSERT INTO `student_paper` VALUES ('1512995113811111939', '1502526352744640513', '1512995113811111938', '1501798846911512577', '1509050450389520386', '1509046305767051265', 0, 0, '2022-04-10 15:47:32', 2, '[{\"correctStatus\": 0}, {\"correctStatus\": 0}, {\"correctStatus\": 0}]', '2022-04-10 15:47:11', 1800, '2022-04-10 03:25:19', '期末考试-修改版', '2022-04-10 03:25:17');
INSERT INTO `student_paper` VALUES ('1513035205858619394', '1502526352744640513', '1513035205791510529', '1501798846911512577', '1509050450389520386', '1509046305767051265', 0, 0, NULL, 1, '[{\"correctStatus\": 0, \"studentAnswer\": 0}, {\"correctStatus\": 0, \"studentAnswer\": [0]}, {\"correctStatus\": 0, \"studentAnswer\": \"T\"}]', '2022-04-22 12:57:34', 1800, '2022-04-10 06:04:37', '测试考试', '2022-04-10 06:04:36');

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
  `all_score` double NULL DEFAULT 0 COMMENT '所有学生得分',
  `correct_question_number` int(0) NULL DEFAULT 0 COMMENT '所有学生正确题目数汇总',
  `student_option_distribution` json NULL COMMENT '学生每题的选项分布',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_paper
-- ----------------------------
INSERT INTO `teacher_paper` VALUES ('1509093618405466113', '1501798846911512577', '1509050450389520386', '1509046305767051265', 0, 1, 1800, '2022-03-31 09:02:08', '期末考试-修改版', 2, 1, '[[0, 1, 0, 0], [0, 1, 1, 0], [1, 0]]');
INSERT INTO `teacher_paper` VALUES ('1512732116760981506', '1501798846911512577', '1509050450389520386', '1509046305767051265', 0, 1, 1800, '2022-04-09 10:00:13', '期末考试-修改版', 0, 0, '[[0, 0, 1, 0], [1, 1, 0, 0], [1, 0]]');
INSERT INTO `teacher_paper` VALUES ('1512995113811111938', '1501798846911512577', '1509050450389520386', '1509046305767051265', 0, 1, 1800, '2022-04-10 03:25:19', '期末考试-修改版', 0, 0, '[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0]]');
INSERT INTO `teacher_paper` VALUES ('1513035205791510529', '1501798846911512577', '1509050450389520386', '1509046305767051265', 1, 0, 1800, '2022-04-10 06:04:37', '测试考试', 0, 0, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
INSERT INTO `user` VALUES ('1501798846911512577', '', 'teacher', 'ofSbX', '50388e346be6a88fdd5f406c505e2647', 'teacherT', '', '', 1, 'default_avatar.jpg');
INSERT INTO `user` VALUES ('1502526352744640513', '', 'student', 'ofSbX', '50388e346be6a88fdd5f406c505e2647', 'teacherT', '', '', 1, 'default_avatar.jpg');

SET FOREIGN_KEY_CHECKS = 1;
