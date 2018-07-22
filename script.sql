
--CREATE DATABASE SCRIPT

DROP DATABASE IF EXISTS `bookmanagement`;

CREATE DATABASE bookmanagement;

USE bookmanagement;

--CREATE TABLE SCRIPT


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `library_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  PRIMARY KEY (`library_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `library_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `library_book`;

CREATE TABLE `library_book` (
  `library_book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `library_id` bigint(20) DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `is_active` char(1) DEFAULT NULL,
  PRIMARY KEY (`library_book_id`),
  KEY `user_id` (`user_id`),
  KEY `library_id` (`library_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `library_book_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `library_book_ibfk_2` FOREIGN KEY (`library_id`) REFERENCES `library` (`library_id`),
  CONSTRAINT `library_book_ibfk_3` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


-- INSERT DATA SCRIPT 

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'Ayush','2017-05-23','2018-07-20 20:48:26','Y'),(2,'Chiki','2017-01-29','2018-07-20 20:49:08','Y'),(3,'Karan','2005-08-16','2018-07-20 21:26:45','Y'),(4,'Sahil Kanojiya','2009-08-01','2018-07-20 23:24:55','Y'),(5,'Test User','2009-08-01','2018-07-22 21:08:55','Y');
UNLOCK TABLES;


LOCK TABLES `book` WRITE;
INSERT INTO `book` VALUES (1,'Immortals of Meluha','Amish Tripathi','Mythological Fiction',1,'2018-07-21 11:23:23','Y'),(2,'Sceret of Nagas','Amish Tripathi','Mythological Fiction',1,'2018-07-21 11:24:11','Y'),(3,'Oath of Vayuputras','Amish Tripathi','Mythological Fiction',1,'2018-07-21 11:24:57','Y'),(4,'Wings of Fire','APJ Abdul Kalam','Biography',2,'2018-07-21 11:25:54','Y'),(5,'Train to Pakistan','Ravinder Singh','Fiction',1,'2018-07-21 15:54:06','Y'),(6,'Godan','Premchand','Story',2,'2018-07-21 16:21:25','Y'),(7,'Test User 5','Author 5','New Genere Updated',5,'2018-07-22 21:12:56','Y');
UNLOCK TABLES;



LOCK TABLES `library` WRITE;
INSERT INTO `library` VALUES (1,'Mythology',1,'2018-07-21 18:34:39','Y'),(2,'Fiction',1,'2018-07-21 18:34:48','Y'),(3,'Fiction',2,'2018-07-21 18:34:54','Y'),(4,'Biography',2,'2018-07-21 18:35:02','Y'),(5,'Testing user 5 library',5,'2018-07-22 21:15:28','Y');
UNLOCK TABLES;



LOCK TABLES `library_book` WRITE;
INSERT INTO `library_book` VALUES (1,1,1,1,'2018-07-22 18:54:18','Y'),(2,NULL,1,2,'2018-07-22 19:10:20','Y'),(3,1,1,3,'2018-07-22 20:29:29','Y'),(5,5,5,7,'2018-07-22 21:26:52','Y'),(6,1,2,5,'2018-07-22 21:46:32','Y');
UNLOCK TABLES;

