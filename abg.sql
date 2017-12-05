-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: abg
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BOOKING_HISTORY`
--

DROP TABLE IF EXISTS `BOOKING_HISTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOKING_HISTORY` (
  `idbooking_history` int(11) NOT NULL AUTO_INCREMENT,
  `guide_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbooking_history`),
  UNIQUE KEY `idbooking_history_UNIQUE` (`idbooking_history`),
  KEY `guide_id_idx` (`guide_id`),
  KEY `user_id_idx` (`client_id`),
  CONSTRAINT `guide_id` FOREIGN KEY (`guide_id`) REFERENCES `GUIDE` (`idguide`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`client_id`) REFERENCES `USER` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOKING_HISTORY`
--

LOCK TABLES `BOOKING_HISTORY` WRITE;
/*!40000 ALTER TABLE `BOOKING_HISTORY` DISABLE KEYS */;
INSERT INTO `BOOKING_HISTORY` VALUES (1,1,3),(2,2,4);
/*!40000 ALTER TABLE `BOOKING_HISTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CITY`
--

DROP TABLE IF EXISTS `CITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CITY` (
  `idcity` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcity`),
  UNIQUE KEY `idcity_UNIQUE` (`idcity`),
  UNIQUE KEY `city_name_UNIQUE` (`city_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CITY`
--

LOCK TABLES `CITY` WRITE;
/*!40000 ALTER TABLE `CITY` DISABLE KEYS */;
INSERT INTO `CITY` VALUES (1,'Berat'),(9,'Durres'),(5,'Elbasan'),(2,'Gjirokaster'),(10,'Korce'),(12,'Kruje'),(11,'Lezhe'),(4,'Sarande'),(7,'Shkoder'),(8,'Tirane'),(6,'Tropoje'),(3,'Vlore');
/*!40000 ALTER TABLE `CITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DEPARTURE_STATION`
--

DROP TABLE IF EXISTS `DEPARTURE_STATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DEPARTURE_STATION` (
  `iddeparture_station` int(11) NOT NULL AUTO_INCREMENT,
  `departurecity_id` int(11) NOT NULL,
  `station_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddeparture_station`),
  UNIQUE KEY `iddeparture_station_UNIQUE` (`iddeparture_station`),
  KEY `departurecity_id_idx` (`departurecity_id`),
  CONSTRAINT `departurecity_id` FOREIGN KEY (`departurecity_id`) REFERENCES `CITY` (`idcity`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEPARTURE_STATION`
--

LOCK TABLES `DEPARTURE_STATION` WRITE;
/*!40000 ALTER TABLE `DEPARTURE_STATION` DISABLE KEYS */;
INSERT INTO `DEPARTURE_STATION` VALUES (1,8,'Prane Shkolles se Baletit'),(2,9,'Porti i Durresit');
/*!40000 ALTER TABLE `DEPARTURE_STATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DESTINATION`
--

DROP TABLE IF EXISTS `DESTINATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DESTINATION` (
  `iddestination` int(11) NOT NULL AUTO_INCREMENT,
  `destinationcity_id` int(11) DEFAULT NULL,
  `destination_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddestination`),
  UNIQUE KEY `iddestination_UNIQUE` (`iddestination`),
  KEY `destinationcity_id_idx` (`destinationcity_id`),
  CONSTRAINT `destinationcity_id` FOREIGN KEY (`destinationcity_id`) REFERENCES `CITY` (`idcity`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DESTINATION`
--

LOCK TABLES `DESTINATION` WRITE;
/*!40000 ALTER TABLE `DESTINATION` DISABLE KEYS */;
INSERT INTO `DESTINATION` VALUES (1,1,'Kalaja e Beratit'),(2,2,'Kalaja e GJirokastres'),(27,NULL,NULL),(28,NULL,NULL),(29,NULL,NULL),(30,NULL,NULL),(31,NULL,NULL),(32,NULL,NULL),(33,NULL,NULL),(34,NULL,NULL),(35,NULL,NULL);
/*!40000 ALTER TABLE `DESTINATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GUIDE`
--

DROP TABLE IF EXISTS `GUIDE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GUIDE` (
  `idguide` int(11) NOT NULL AUTO_INCREMENT,
  `departure_station_id` int(11) DEFAULT NULL,
  `departure_time` datetime DEFAULT NULL,
  `destination_id` int(11) DEFAULT NULL,
  `destination_arrival_time` datetime DEFAULT NULL,
  `destination_leave_time` datetime DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `max_reservation_nr` int(11) DEFAULT '20',
  `guide_description` varchar(200) DEFAULT NULL,
  `guidecategory_id` int(11) DEFAULT NULL,
  `reservation_number` int(11) DEFAULT '0',
  PRIMARY KEY (`idguide`),
  UNIQUE KEY `idguide_UNIQUE` (`idguide`),
  KEY `departurestation_id_idx` (`departure_station_id`),
  KEY `destination_id_idx` (`destination_id`),
  KEY `guidecategory_id_idx` (`guidecategory_id`),
  CONSTRAINT `departurestation_id` FOREIGN KEY (`departure_station_id`) REFERENCES `DEPARTURE_STATION` (`iddeparture_station`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `destination_id` FOREIGN KEY (`destination_id`) REFERENCES `DESTINATION` (`iddestination`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `guidecategory_id` FOREIGN KEY (`guidecategory_id`) REFERENCES `GUIDE_CATEGORY` (`idguide_category`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GUIDE`
--

LOCK TABLES `GUIDE` WRITE;
/*!40000 ALTER TABLE `GUIDE` DISABLE KEYS */;
INSERT INTO `GUIDE` VALUES (1,1,'2017-11-01 12:00:00',1,'2017-11-01 14:00:00','2017-11-02 14:00:00','2017-11-01 16:00:00',20,'Eksplorimi i Kalase se Beratit',2,0),(2,1,'2017-11-01 10:00:00',2,'2017-11-01 14:00:00','2017-11-03 13:00:00','2017-11-03 18:00:00',20,'Eksplorimi i Kalase se Gjirokastres',2,0),(3,1,'2018-03-03 10:00:00',1,'2018-03-03 12:00:00','2018-03-04 10:00:00','2018-03-04 12:00:00',20,'Eksplorimi i Kalase se Beratit',2,0);
/*!40000 ALTER TABLE `GUIDE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GUIDE_CATEGORY`
--

DROP TABLE IF EXISTS `GUIDE_CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GUIDE_CATEGORY` (
  `idguide_category` int(11) NOT NULL AUTO_INCREMENT,
  `guide_name` varchar(45) DEFAULT NULL,
  `guide_category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idguide_category`),
  UNIQUE KEY `idguide_category_UNIQUE` (`idguide_category`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GUIDE_CATEGORY`
--

LOCK TABLES `GUIDE_CATEGORY` WRITE;
/*!40000 ALTER TABLE `GUIDE_CATEGORY` DISABLE KEYS */;
INSERT INTO `GUIDE_CATEGORY` VALUES (1,'Guida Malore','Udhetime Malore'),(2,'Guida Historike','Eksplorimi i vendeve historike');
/*!40000 ALTER TABLE `GUIDE_CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `user_lastname` varchar(45) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_password` varchar(45) DEFAULT '123456',
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`),
  KEY `user_type_idx` (`user_type`),
  CONSTRAINT `user_type` FOREIGN KEY (`user_type`) REFERENCES `USER_TYPE` (`iduser_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'Evion','Cane','evioncane@gmail.com','evioncane',3),(2,'Redi','Cane','redicane@gmail.com','redicane',2),(3,'Xhino','Lita','xhinolita@gmail.com','xhinolita',1),(4,'Ikub','Info','ikubinfo@gmail.com','ikubinfo',1);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_TYPE`
--

DROP TABLE IF EXISTS `USER_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_TYPE` (
  `iduser_type` int(11) NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser_type`),
  UNIQUE KEY `iduser_type_UNIQUE` (`iduser_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_TYPE`
--

LOCK TABLES `USER_TYPE` WRITE;
/*!40000 ALTER TABLE `USER_TYPE` DISABLE KEYS */;
INSERT INTO `USER_TYPE` VALUES (1,'client'),(2,'admin'),(3,'superadmin');
/*!40000 ALTER TABLE `USER_TYPE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-04 13:17:49
