-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: sophos
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `sophos`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sophos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sophos`;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `names` varchar(255) DEFAULT NULL,
  `lastnames` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthdate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'jsmith','John','Smith','john.smith@example.com','(555) 123-4567','123 Main St, Anytown, USA','1990-01-01 00:01:00.000000'),(2,'lrodriguez','Laura','Rodriguez','laura.rodriguez@example.com','(555) 234-5678','456 Elm St, Anytown, USA','1985-01-15 00:05:00.000000'),(3,'mlee','Michael','Lee','michael.lee@example.com','(555) 345-6789','789 Oak St, Anytown, USA','2000-01-28 00:11:00.000000'),(4,'knguyen','Kim','Nguyen','kim.nguyen@example.com','(555) 456-7890','987 Maple St, Anytown, USA','1995-01-12 00:08:00.000000'),(5,'abrown','Ashley','Brown','ashley.brown@example.com','(555) 567-8901','654 Pine St, Anytown, USA','1988-01-04 00:03:00.000000'),(6,'jrivera','Juan','Rivera','juan.rivera@example.com','(555) 678-9012','321 Cedar St, Anytown, USA','1992-01-22 00:09:00.000000'),(7,'Mmarta','Marta','Miranda','mmarta@example.com','(555) 123-444','322 Cedar ST, Anytwon, USA','2000-04-29 00:00:00.000000');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Shigeru Miyamoto'),(2,'Takashi Tezuka'),(3,'Yoshio Sakamoto'),(4,'Will Wright'),(5,'David Cage'),(6,'Amy Hennig'),(7,'Jeff Kaplan'),(8,'Ion Hazzikostas'),(9,'Tom Chilton'),(10,'Patrice D├®silets'),(11,'Michel Ancel'),(12,'Ashraf Ismail'),(13,'Cory Barlog'),(14,'Fumito Ueda'),(15,'David Jaffe');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loan_date` datetime(6) DEFAULT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `videogame_unit_id` int DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `videogame_unit_id` (`videogame_unit_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`videogame_unit_id`) REFERENCES `videogame_unit` (`id`),
  CONSTRAINT `loan_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (9,'2023-01-27 00:05:00.000000','2023-01-03 00:06:00.000000',1,1,1),(10,'2023-01-27 00:05:00.000000','2023-01-03 00:06:00.000000',1,4,1),(11,'2023-01-27 00:05:00.000000','2023-01-03 00:06:00.000000',1,7,1),(12,'2023-01-27 00:05:00.000000','2023-01-03 00:06:00.000000',1,10,1),(13,'2023-01-28 00:05:00.000000','2023-01-04 00:06:00.000000',1,2,2),(14,'2023-01-28 00:05:00.000000','2023-01-04 00:06:00.000000',1,3,3),(15,'2023-01-28 00:05:00.000000','2023-01-04 00:06:00.000000',1,8,6),(16,'2023-05-27 00:00:00.000000','2023-06-03 00:00:00.000000',1,5,2),(17,'2023-05-27 00:00:00.000000','2023-05-30 00:00:00.000000',1,1,1),(18,'2023-05-27 00:00:00.000000','2023-06-03 00:00:00.000000',0,2,2),(19,'2023-05-27 00:00:00.000000','2023-05-31 00:00:00.000000',0,7,1);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform`
--

DROP TABLE IF EXISTS `platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platform` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform`
--

LOCK TABLES `platform` WRITE;
/*!40000 ALTER TABLE `platform` DISABLE KEYS */;
INSERT INTO `platform` VALUES (1,'Xbox'),(2,'Nintendo'),(3,'PC'),(4,'PlayStation');
/*!40000 ALTER TABLE `platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producer`
--

DROP TABLE IF EXISTS `producer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producer`
--

LOCK TABLES `producer` WRITE;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
INSERT INTO `producer` VALUES (1,'Nintendo'),(2,'Electronic Arts (EA)'),(3,'Activision Blizzard'),(4,'Ubisoft'),(5,'Sony Interactive Entertainment ');
/*!40000 ALTER TABLE `producer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videogame_title`
--

DROP TABLE IF EXISTS `videogame_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videogame_title` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `realise_date` datetime(6) DEFAULT NULL,
  `loan_price` double DEFAULT NULL,
  `protagonists` varchar(255) DEFAULT NULL,
  `director_id` int DEFAULT NULL,
  `producer_id` int DEFAULT NULL,
  `platform_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `director_id` (`director_id`),
  KEY `producer_id` (`producer_id`),
  KEY `platform_id` (`platform_id`),
  CONSTRAINT `videogame_title_ibfk_1` FOREIGN KEY (`director_id`) REFERENCES `director` (`id`),
  CONSTRAINT `videogame_title_ibfk_2` FOREIGN KEY (`producer_id`) REFERENCES `producer` (`id`),
  CONSTRAINT `videogame_title_ibfk_3` FOREIGN KEY (`platform_id`) REFERENCES `platform` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videogame_title`
--

LOCK TABLES `videogame_title` WRITE;
/*!40000 ALTER TABLE `videogame_title` DISABLE KEYS */;
INSERT INTO `videogame_title` VALUES (1,'Super Mario Bros','1985-09-13 00:00:00.000000',5.99,'Mario and Luigi',1,1,2),(2,'Assassin\'s Creed Origins','2017-10-27 00:00:00.000000',9.99,'Bayek of Siwa',12,4,4),(3,'Overwatch','2016-05-24 00:00:00.000000',7.99,'Various heroes, including Tracer, Winston, and Mercy',7,3,3),(4,'World of Warcraft','2004-10-23 00:00:00.000000',4.99,'Various player characters',8,3,3);
/*!40000 ALTER TABLE `videogame_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videogame_unit`
--

DROP TABLE IF EXISTS `videogame_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videogame_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avaliable_status` tinyint(1) DEFAULT NULL,
  `videogame_title_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `videogame_title_id` (`videogame_title_id`),
  CONSTRAINT `videogame_unit_ibfk_1` FOREIGN KEY (`videogame_title_id`) REFERENCES `videogame_title` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videogame_unit`
--

LOCK TABLES `videogame_unit` WRITE;
/*!40000 ALTER TABLE `videogame_unit` DISABLE KEYS */;
INSERT INTO `videogame_unit` VALUES (1,1,1),(2,0,1),(3,1,1),(4,1,2),(5,1,2),(6,1,2),(7,0,3),(8,1,3),(9,1,3),(10,1,4),(11,1,4),(12,1,4);
/*!40000 ALTER TABLE `videogame_unit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-27 20:52:29
