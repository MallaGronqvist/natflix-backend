-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: natflix
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `details_series`
--

DROP TABLE IF EXISTS `details_series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `details_series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_id` int(11) NOT NULL,
  `season_number` int(11) DEFAULT NULL,
  `episode_number` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `thumbnail_url` text,
  `video_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `content_id` (`content_id`),
  CONSTRAINT `details_series_ibfk_1` FOREIGN KEY (`content_id`) REFERENCES `content` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `details_series`
--

LOCK TABLES `details_series` WRITE;
/*!40000 ALTER TABLE `details_series` DISABLE KEYS */;
INSERT INTO `details_series` VALUES (27,107,1,1,'Pilot','Titans meeet each other for the first time.','http://localhost:8000/files/1666863632628.png','_cKIiQviCao'),(28,107,1,2,'Back to the streets','Titans return to the streets of Ohio and look for the enemy.','http://localhost:8000/files/1666863703696.png','peeO4bwuPys'),(29,107,1,3,'Major revenge','Titans are attacked by some strange creatures.','http://localhost:8000/files/1666863788870.png','6ttU1iKSpdA'),(30,108,1,1,'Max meets Lisa','Tensions arise when Max starts seeing Lisa.','http://localhost:8000/files/1666864009413.png','7kIKGd6w6Y8'),(31,108,1,2,'Linda goes wild','Linda turns out to have super powers...','http://localhost:8000/files/1666864065253.png','NUxwlnc5owM'),(32,108,2,1,'New winds','The girls plan a party at a country house but who is invited...','http://localhost:8000/files/1666864135095.png','L71GcMnPnFA'),(33,108,2,2,'What happened to Linda?','Linda is missing and nobody knows where she is...','http://localhost:8000/files/1666864203757.png','p7b4MkSAr9o'),(34,109,1,1,'Where\'s the cash?','After a succesful robbing gig the cash is suddenly gone.','http://localhost:8000/files/1666864465440.png','bog5J_xsVmk'),(35,109,1,2,'Cash smells','Jonny regrets robbing his relatives and wants to...','http://localhost:8000/files/1666864540100.png','yHFBsGdIBzs'),(36,109,2,1,'The gang is back','The gang tries to solve their confilcts.','http://localhost:8000/files/1666864624686.png','6UBogcztd2A'),(37,109,2,2,'Hard game','The fights escalate and Jonny needs to take a decision.','http://localhost:8000/files/1666864719792.png','o141_2Mj844'),(38,109,2,3,'Promise','Jonny promises to never lie but the reality shows...','http://localhost:8000/files/1666864795911.png','vyTwo-TB7Ao');
/*!40000 ALTER TABLE `details_series` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-27 12:22:48
