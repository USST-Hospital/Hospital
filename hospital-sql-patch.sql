-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.55 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 hospital 的数据库结构
CREATE DATABASE IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hospital`;


-- 导出  表 hospital.account 结构
CREATE TABLE IF NOT EXISTS `account` (
  `account` int(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `power` varchar(30) NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.account 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`account`, `password`, `power`) VALUES
	(1, 'admin', 'admin'),
	(1001, '123', 'doctor'),
	(1002, '123', 'doctor'),
	(1010, '123456', 'doctor'),
	(2001, '123', 'analgesist'),
	(2002, '123', 'analgesist'),
	(3001, '123', 'nurse'),
	(3002, '123', 'nurse'),
	(3003, '123', 'nurse');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- 导出  表 hospital.analgesist 结构
CREATE TABLE IF NOT EXISTS `analgesist` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `analgesist_account_account_fk` FOREIGN KEY (`id`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.analgesist 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `analgesist` DISABLE KEYS */;
INSERT INTO `analgesist` (`id`, `name`, `gender`, `age`, `number`) VALUES
	(2001, '李麻醉师', '女', 25, '135'),
	(2002, '王麻醉师', '女', 29, '135');
/*!40000 ALTER TABLE `analgesist` ENABLE KEYS */;


-- 导出  表 hospital.doctor 结构
CREATE TABLE IF NOT EXISTS `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `doctor_account_account_fk` FOREIGN KEY (`id`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.doctor 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`id`, `name`, `gender`, `age`, `number`) VALUES
	(1001, '张医生', '男', 30, '135'),
	(1002, '李医生', '男', 20, '135'),
	(1010, 'doctor-20180318', '男', 35, '135');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


-- 导出  表 hospital.nurse 结构
CREATE TABLE IF NOT EXISTS `nurse` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `nurse_account_account_fk` FOREIGN KEY (`id`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.nurse 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` (`id`, `name`, `gender`, `age`, `number`) VALUES
	(3001, '王护士', '女', 21, '135'),
	(3002, '赵护士', '女', 23, '135 '),
	(3003, '李护士', '女', 23, '135');
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;


-- 导出  表 hospital.nurse_schedule 结构
CREATE TABLE IF NOT EXISTS `nurse_schedule` (
  `operation_id` int(11) DEFAULT NULL,
  `nurse_id` int(11) DEFAULT NULL,
  `nurse_status` int(11) DEFAULT NULL,
  KEY `nurse_schedule_operation_id_fk` (`operation_id`),
  KEY `nurse_schedule_nurse_id_fk` (`nurse_id`),
  CONSTRAINT `nurse_schedule_nurse_id_fk` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nurse_schedule_operation_id_fk` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.nurse_schedule 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `nurse_schedule` DISABLE KEYS */;
INSERT INTO `nurse_schedule` (`operation_id`, `nurse_id`, `nurse_status`) VALUES
	(0, 3001, 1),
	(0, 3003, 0),
	(0, 3002, 0),
	(2, 3001, 0),
	(2, 3003, 0),
	(1, 3001, 0),
	(1, 3003, 0);
/*!40000 ALTER TABLE `nurse_schedule` ENABLE KEYS */;


-- 导出  表 hospital.operation 结构
CREATE TABLE IF NOT EXISTS `operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) DEFAULT NULL,
  `operation_room_id` int(11) DEFAULT NULL,
  `analgesist_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `doctor_status` int(11) DEFAULT NULL,
  `analgesist_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `operation_date_start_time_end_time_operation_room_id_uindex` (`date`,`start_time`,`end_time`,`operation_room_id`),
  KEY `operation_analgesist_id_fk` (`analgesist_id`),
  KEY `operation_doctor_id_fk` (`doctor_id`),
  KEY `operation_operation_room_id_fk` (`operation_room_id`),
  KEY `operation_patient_id_fk` (`patient_id`),
  CONSTRAINT `operation_analgesist_id_fk` FOREIGN KEY (`analgesist_id`) REFERENCES `analgesist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `operation_doctor_id_fk` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `operation_operation_room_id_fk` FOREIGN KEY (`operation_room_id`) REFERENCES `operation_room` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `operation_patient_id_fk` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.operation 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` (`id`, `doctor_id`, `operation_room_id`, `analgesist_id`, `patient_id`, `name`, `date`, `start_time`, `end_time`, `status`, `doctor_status`, `analgesist_status`) VALUES
	(1, 1010, 1, 2001, 1, 'FirstOperation', '2017年2月15日', 14, 17, 1, 0, 0),
	(2, 1001, 2, 2001, 1, 'operatinoSecond', '2018年4月5日', 0, 4, 0, 0, 0);
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;


-- 导出  表 hospital.operation_room 结构
CREATE TABLE IF NOT EXISTS `operation_room` (
  `id` int(11) NOT NULL,
  `location` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.operation_room 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `operation_room` DISABLE KEYS */;
INSERT INTO `operation_room` (`id`, `location`) VALUES
	(1, '101'),
	(2, '305');
/*!40000 ALTER TABLE `operation_room` ENABLE KEYS */;


-- 导出  表 hospital.patient 结构
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hospital.patient 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`id`, `name`, `gender`, `age`, `number`) VALUES
	(1, '王五', '男', 28, '135');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
