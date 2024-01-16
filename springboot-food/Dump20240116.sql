CREATE DATABASE  IF NOT EXISTS `food` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `food`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: food
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `PRODUCT_ID` int NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(45) DEFAULT NULL,
  `PRICE` int DEFAULT NULL,
  `PIC` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'美式漢堡',300,'beef_ham.jpg'),(2,'炸雞',200,'chicken.jpg'),(3,'墨西哥捲餅',350,'burrito.jpg'),(4,'炒飯',350,'fries.jpg'),(5,'麵食',400,'fried_rice.jpg'),(6,'生魚片',1000,'sashimi.jpg'),(7,'牛排',2000,'steak.jpg'),(12,'沙拉',5,'4.jpg'),(13,'導回測試',999,'test1 (1).jpg'),(19,'哈哈',99999,'t2.jpg'),(20,'測試',22,'t2.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trx_detail`
--

DROP TABLE IF EXISTS `trx_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trx_detail` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TRX_ID` int NOT NULL,
  `PRODUCT_ID` int NOT NULL,
  `QTY` int NOT NULL,
  `PRICE` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_td_trx_id_idx` (`TRX_ID`),
  KEY `fk_td_product_id_idx` (`PRODUCT_ID`),
  CONSTRAINT `fk_td_product_id` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `fk_td_trx_id` FOREIGN KEY (`TRX_ID`) REFERENCES `trx_main` (`TRX_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trx_detail`
--

LOCK TABLES `trx_detail` WRITE;
/*!40000 ALTER TABLE `trx_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `trx_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trx_main`
--

DROP TABLE IF EXISTS `trx_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trx_main` (
  `TRX_ID` int NOT NULL AUTO_INCREMENT,
  `CHECKOUT_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TOTAL` int NOT NULL,
  PRIMARY KEY (`TRX_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trx_main`
--

LOCK TABLES `trx_main` WRITE;
/*!40000 ALTER TABLE `trx_main` DISABLE KEYS */;
/*!40000 ALTER TABLE `trx_main` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-16 10:42:32
