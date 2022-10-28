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
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `summary` text,
  `logo_url` text,
  `banner_url` text,
  `thumbnail_url` text,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `content_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `content_type` (`id`),
  CONSTRAINT `content_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `content_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (17,'Still testing',NULL,NULL,'test summary...',NULL,NULL,NULL),(18,'Still testing',NULL,NULL,'test summary...',NULL,NULL,NULL),(19,'Still testing',NULL,NULL,'test summary...','owoeoe/fofogog/kdkd.png','ppp/banner.jpg','/thumbnail.jpg'),(20,'Still testing',NULL,NULL,'test summary...','owoeoe/fofogog/kdkd.png','ppp/banner.jpg','/thumbnail.jpg'),(21,'Again testing',NULL,NULL,'test summary...','owoeoe/fofogog/kdkd.png','ppp/banner.jpg','/thumbnail.jpg'),(22,'Again testing',NULL,NULL,'test summary...','owoeoe/fofogog/kdkd.png','ppp/banner.jpg','/thumbnail.jpg'),(23,'Integer testing',NULL,NULL,'test summary...','owoeoe/fofogog/kdkd.png','ppp/banner.jpg','/thumbnail.jpg'),(74,'The hunters',NULL,1,'Horrible hunters...','http://localhost:8000/files/1666598676192.png','http://localhost:8000/files/1666598676198.png','http://localhost:8000/files/1666598676200.png'),(75,'Series',NULL,1,'Blabla','http://localhost:8000/files/1666598900250.png','http://localhost:8000/files/1666598900255.png','http://localhost:8000/files/1666598900257.png'),(76,'Test',NULL,1,'bala','http://localhost:8000/files/1666599118669.png','http://localhost:8000/files/1666599118675.png','http://localhost:8000/files/1666599118678.png'),(77,'Funny bug',NULL,1,'blaa','http://localhost:8000/files/1666599204210.png','http://localhost:8000/files/1666599204216.png','http://localhost:8000/files/1666599204218.png'),(79,'La la laaa',NULL,1,'Bla bla','http://localhost:8000/files/1666599476351.png','http://localhost:8000/files/1666599476356.png','http://localhost:8000/files/1666599476358.png'),(80,'Hello from series create',NULL,1,'Hahaha','http://localhost:8000/files/1666599786029.png','http://localhost:8000/files/1666599786034.png','http://localhost:8000/files/1666599786036.png'),(82,'Funny series',NULL,3,'Bla...','http://localhost:8000/files/1666601131284.png','http://localhost:8000/files/1666601131289.png','http://localhost:8000/files/1666601131291.png'),(83,'Hello',NULL,1,'Test...','http://localhost:8000/files/1666601213566.png','http://localhost:8000/files/1666601213583.png','http://localhost:8000/files/1666601213585.png'),(84,'Test series',NULL,1,'Summary...','http://localhost:8000/files/1666601905296.png','http://localhost:8000/files/1666601905306.png','http://localhost:8000/files/1666601905309.png'),(85,'Testing',NULL,NULL,'test test','http://localhost:8000/files/1666612932712.png','http://localhost:8000/files/1666612932719.png','http://localhost:8000/files/1666612932723.png'),(96,'Tom Hanks is Forrest Gump',2,4,'Tom Hanks plays Forrest Gump...','http://localhost:8000/files/1666861555764.png','http://localhost:8000/files/1666861555784.png','http://localhost:8000/files/1666861555788.png'),(97,'Enola Holmes',2,2,'Young amatour detective goes to village...','http://localhost:8000/files/1666861819661.png','http://localhost:8000/files/1666861819682.png','http://localhost:8000/files/1666861819685.png'),(98,'Forever Rich',2,4,'Hip hop, drugs and cash...','http://localhost:8000/files/1666861929159.png','http://localhost:8000/files/1666861929180.png','http://localhost:8000/files/1666861929184.png'),(99,'Love Death Robots',2,2,'Robots take over and fall in love...but then comes death...','http://localhost:8000/files/1666862069002.png','http://localhost:8000/files/1666862069017.png','http://localhost:8000/files/1666862069019.png'),(100,'Anikulapo',2,4,'Anikulapo village gets a new leader from a foreign galaxy...','http://localhost:8000/files/1666862297119.png','http://localhost:8000/files/1666862297134.png','http://localhost:8000/files/1666862297138.png'),(101,'Christmas Wedding Planner',2,3,'Rose plans a fantastic wedding at Christmas.','http://localhost:8000/files/1666862438809.png','http://localhost:8000/files/1666862438822.png','http://localhost:8000/files/1666862438825.png'),(102,'Monster Harmon',2,4,'Harmon is accused of being a monster.','http://localhost:8000/files/1666862543162.png','http://localhost:8000/files/1666862543174.png','http://localhost:8000/files/1666862543177.png'),(103,'1922',2,4,'A dark story about running away from...','http://localhost:8000/files/1666862778336.png','http://localhost:8000/files/1666862778352.png','http://localhost:8000/files/1666862778355.png'),(104,'Boys in the Hood',3,5,'The story of the boys in the hood and their mother.','http://localhost:8000/files/1666863131322.png','http://localhost:8000/files/1666863131338.png','http://localhost:8000/files/1666863131341.png'),(105,'Alive',3,5,'A documentary about a hastag and some influencers....','http://localhost:8000/files/1666863229522.png','http://localhost:8000/files/1666863229538.png','http://localhost:8000/files/1666863229543.png'),(106,'Centauro',3,5,'The story about the motor racer who won the Spanish cup...','http://localhost:8000/files/1666863363980.png','http://localhost:8000/files/1666863363991.png','http://localhost:8000/files/1666863363993.png'),(107,'DC Titans',1,2,'Cool titans fighting and racing...','http://localhost:8000/files/1666863482388.png','http://localhost:8000/files/1666863482404.png','http://localhost:8000/files/1666863482407.png'),(108,'The A List',1,4,'Teenagers in high school keep their own a list over class mates.','http://localhost:8000/files/1666863861466.png','http://localhost:8000/files/1666863861482.png','http://localhost:8000/files/1666863861493.png'),(109,'Snabba Cash',1,2,'Criminals want to get rich so they rob a bank...','http://localhost:8000/files/1666864293487.png','http://localhost:8000/files/1666864293501.png','http://localhost:8000/files/1666864293510.png'),(110,'All of us are dead',1,1,'All zombies come back from their graves.','http://localhost:8000/files/1666865377653.png','http://localhost:8000/files/1666865377680.png','http://localhost:8000/files/1666865377683.png'),(111,'Dinotrux',1,2,'Dinosaur lego animation where beasts meat and...','http://localhost:8000/files/1666865454128.png','http://localhost:8000/files/1666865454141.png','http://localhost:8000/files/1666865454145.png'),(112,'Fauda',1,2,'Fauda decides to join the war.','http://localhost:8000/files/1666865545767.png','http://localhost:8000/files/1666865545788.png','http://localhost:8000/files/1666865545791.png'),(113,'Drishyam',1,3,'Drishyam is a family father with many ideas...','http://localhost:8000/files/1666865589841.png','http://localhost:8000/files/1666865589852.png','http://localhost:8000/files/1666865589855.png'),(114,'Holiday in the wild',1,4,'Max goes on a holiday in the wild and gets lost.','http://localhost:8000/files/1666865639758.png','http://localhost:8000/files/1666865639769.png','http://localhost:8000/files/1666865639771.png');
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-27 12:22:46
