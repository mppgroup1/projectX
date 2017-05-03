CREATE DATABASE  IF NOT EXISTS `Caanes` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Caanes`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: Caanes
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `t_animal`
--

DROP TABLE IF EXISTS `t_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_animal` (
  `an_id` int(11) NOT NULL AUTO_INCREMENT,
  `an_name` varchar(50) DEFAULT NULL,
  `an_gender` varchar(6) DEFAULT NULL,
  `an_neuter` varchar(1) DEFAULT NULL,
  `an_birth` datetime DEFAULT NULL,
  `an_color` varchar(20) DEFAULT NULL,
  `sp_id` int(11) DEFAULT NULL,
  `br_id` int(11) DEFAULT NULL,
  `mr_id` int(11) DEFAULT NULL,
  `an_deceased` datetime DEFAULT NULL,
  `an_status` varchar(1) DEFAULT NULL,
  `an_createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`an_id`),
  KEY `specie_animal_idx` (`sp_id`),
  KEY `breed_animal_idx` (`br_id`),
  KEY `microship_animal_idx` (`mr_id`),
  CONSTRAINT `breed_animal` FOREIGN KEY (`br_id`) REFERENCES `t_breed` (`br_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `microship_animal` FOREIGN KEY (`mr_id`) REFERENCES `t_microchip` (`mr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `specie_animal` FOREIGN KEY (`sp_id`) REFERENCES `t_specie` (`sp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_animal`
--

LOCK TABLES `t_animal` WRITE;
/*!40000 ALTER TABLE `t_animal` DISABLE KEYS */;
INSERT INTO `t_animal` VALUES (1,'yaak','MALE','1','2017-04-12 00:00:00','asfdas',NULL,NULL,NULL,'2017-04-13 00:00:00','1','2017-04-12 10:47:16'),(3,'asdg','FEMALE','0','2017-04-04 00:00:00','sadg',NULL,NULL,NULL,'2017-04-12 00:00:00','0','2017-04-12 21:33:21');
/*!40000 ALTER TABLE `t_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_breed`
--

DROP TABLE IF EXISTS `t_breed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_breed` (
  `br_id` int(11) NOT NULL AUTO_INCREMENT,
  `br_description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`br_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_breed`
--

LOCK TABLES `t_breed` WRITE;
/*!40000 ALTER TABLE `t_breed` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_breed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_deworm`
--

DROP TABLE IF EXISTS `t_deworm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_deworm` (
  `de_id` int(11) NOT NULL AUTO_INCREMENT,
  `an_id` int(11) DEFAULT NULL,
  `pr_id` int(11) DEFAULT NULL,
  `de_date` datetime DEFAULT NULL,
  `de_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`de_id`),
  KEY `animal_deworm_idx` (`an_id`),
  KEY `person_deworm_idx` (`pr_id`),
  CONSTRAINT `animal_deworm` FOREIGN KEY (`an_id`) REFERENCES `t_animal` (`an_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `person_deworm` FOREIGN KEY (`pr_id`) REFERENCES `t_person` (`pr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_deworm`
--

LOCK TABLES `t_deworm` WRITE;
/*!40000 ALTER TABLE `t_deworm` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_deworm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_email`
--

DROP TABLE IF EXISTS `t_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_email` (
  `em_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_id` int(11) DEFAULT NULL,
  `em_email` varchar(50) DEFAULT NULL,
  `ph_primary` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`em_id`),
  KEY `person_email_idx` (`pr_id`),
  CONSTRAINT `person_email` FOREIGN KEY (`pr_id`) REFERENCES `t_person` (`pr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_email`
--

LOCK TABLES `t_email` WRITE;
/*!40000 ALTER TABLE `t_email` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_location`
--

DROP TABLE IF EXISTS `t_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_location` (
  `lc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_id` int(11) DEFAULT NULL,
  `lc_address` varchar(50) DEFAULT NULL,
  `lc_city` varchar(50) DEFAULT NULL,
  `lc_state` varchar(2) DEFAULT NULL,
  `lc_zipcode` int(5) DEFAULT NULL,
  `lc_country` varchar(50) DEFAULT NULL,
  `ph_primary` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`lc_id`),
  KEY `person_location_idx` (`pr_id`),
  CONSTRAINT `person_location` FOREIGN KEY (`pr_id`) REFERENCES `t_person` (`pr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_location`
--

LOCK TABLES `t_location` WRITE;
/*!40000 ALTER TABLE `t_location` DISABLE KEYS */;
INSERT INTO `t_location` VALUES (6,2,'asf','asd','sa',23,'2','0'),(7,4,'sdf','sf','sd',21,'234','1'),(8,4,'awer','dag','ee',22,'wef','0'),(9,2,'wertyuio','sdfg','df',43,'geg','1'),(10,2,'asdfsdg','sdgsdr','ee',52,'sdgsg','0');
/*!40000 ALTER TABLE `t_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_microchip`
--

DROP TABLE IF EXISTS `t_microchip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_microchip` (
  `mr_id` int(11) NOT NULL AUTO_INCREMENT,
  `mr_description` varchar(50) DEFAULT NULL,
  `mr_implantsite` varchar(50) DEFAULT NULL,
  `mr_brand` varchar(50) DEFAULT NULL,
  `mr_date` datetime DEFAULT NULL,
  PRIMARY KEY (`mr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_microchip`
--

LOCK TABLES `t_microchip` WRITE;
/*!40000 ALTER TABLE `t_microchip` DISABLE KEYS */;
INSERT INTO `t_microchip` VALUES (13,'ads','VENTRAL_AREA','asdasd','2017-04-06 00:00:00');
/*!40000 ALTER TABLE `t_microchip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_person`
--

DROP TABLE IF EXISTS `t_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_person` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_type` int(2) NOT NULL,
  `pr_title` varchar(4) DEFAULT NULL,
  `pr_lastname` varchar(45) DEFAULT NULL,
  `pr_firstname` varchar(45) DEFAULT NULL,
  `pr_gender` varchar(6) DEFAULT NULL,
  `pr_status` varchar(1) DEFAULT NULL,
  `pr_createdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_person`
--

LOCK TABLES `t_person` WRITE;
/*!40000 ALTER TABLE `t_person` DISABLE KEYS */;
INSERT INTO `t_person` VALUES (2,1,'DR','Gallego','Andres','MALE','Y','2017-04-16 15:44:23'),(4,1,'DR','adf','sxc','FEMALE','Y','2017-04-17 18:23:56');
/*!40000 ALTER TABLE `t_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_phone`
--

DROP TABLE IF EXISTS `t_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_phone` (
  `ph_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_id` int(11) DEFAULT NULL,
  `ph_areacode` int(2) DEFAULT NULL,
  `ph_telephone` int(10) DEFAULT NULL,
  `ph_primary` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ph_id`),
  KEY `person_phone_idx` (`pr_id`),
  CONSTRAINT `person_phone` FOREIGN KEY (`pr_id`) REFERENCES `t_person` (`pr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_phone`
--

LOCK TABLES `t_phone` WRITE;
/*!40000 ALTER TABLE `t_phone` DISABLE KEYS */;
INSERT INTO `t_phone` VALUES (1,2,2342,2346,'Y');
/*!40000 ALTER TABLE `t_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_specie`
--

DROP TABLE IF EXISTS `t_specie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_specie` (
  `sp_id` int(11) NOT NULL AUTO_INCREMENT,
  `sp_description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_specie`
--

LOCK TABLES `t_specie` WRITE;
/*!40000 ALTER TABLE `t_specie` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_specie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_vaccine`
--

DROP TABLE IF EXISTS `t_vaccine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_vaccine` (
  `va_id` int(11) NOT NULL AUTO_INCREMENT,
  `an_id` int(11) DEFAULT NULL,
  `pr_id` int(11) DEFAULT NULL,
  `va_date` datetime DEFAULT NULL,
  `va_name` varchar(60) DEFAULT NULL,
  `va_batch` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`va_id`),
  KEY `animal_vaccine_idx` (`an_id`),
  KEY `person_vaccine_idx` (`pr_id`),
  CONSTRAINT `animal_vaccine` FOREIGN KEY (`an_id`) REFERENCES `t_animal` (`an_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `person_vaccine` FOREIGN KEY (`pr_id`) REFERENCES `t_person` (`pr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_vaccine`
--

LOCK TABLES `t_vaccine` WRITE;
/*!40000 ALTER TABLE `t_vaccine` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_vaccine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'admin','ROLE_ADMIN'),(2,'admin','ROLE_USER'),(3,'user','ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','$2a$10$oAEZCQPxcmOlbId0pj3.aO5wqdwN4ZPXm3s0OP6/XbCp93NXA0gsG',1),('user','$2a$10$Vkteot/V8nx6CKRUSOhk7uhC4Q/543cIM/51SnZJ1e0T4jAAf4R4C',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-18 23:14:31
