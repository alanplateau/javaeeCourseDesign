-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ars
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `airplaneID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `airplaneType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `economyClassSeats` int(11) DEFAULT NULL,
  `firstClassSeats` int(11) DEFAULT NULL,
  `businessClassSeats` int(11) DEFAULT NULL,
  PRIMARY KEY (`airplaneID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES ('BY0001','大型机',10,100,200),('BY0002','大型机',10,100,200),('BY0003','中型机',5,50,100),('BY0004','中型机',5,50,100);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `airportID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `airportName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cityName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`airportID`) USING BTREE,
  KEY `cityName` (`cityName`) USING BTREE,
  CONSTRAINT `foreignkey1` FOREIGN KEY (`cityName`) REFERENCES `city` (`cityName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('AR0001','首都国际机场','北京'),('AR0002','广州白云机场','广州'),('AR0003','北京大兴国际机场','北京'),('AR0004','广州国际机场','广州'),('AR0005','上海浦东机场','上海'),('AR0006','上海虹桥机场','上海');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `cityName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`cityName`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('上海'),('东营'),('丹东'),('义乌'),('乌兰浩特'),('乌海'),('九江'),('二连浩特'),('井冈山市'),('伊春'),('佳木斯'),('包头'),('北京'),('南京'),('南昌'),('南通'),('南阳'),('厦门'),('台州'),('合肥'),('呼和浩特'),('哈尔滨'),('唐山'),('大同'),('大庆'),('大连'),('天津'),('太原'),('威海'),('安庆'),('宜昌'),('宜春'),('巴彦淖尔'),('常德'),('广州'),('延吉'),('张家口'),('张家界'),('徐州'),('怀化'),('恩施'),('扬州'),('抚远'),('无锡'),('景德镇'),('朝阳'),('杭州'),('武夷山市'),('武汉'),('池州'),('沈阳'),('泉州'),('洛阳'),('济南'),('济宁'),('海拉尔'),('温州'),('满洲里'),('漠河'),('潍坊'),('烟台'),('牡丹江'),('白山'),('盐城'),('石家庄'),('神农架'),('福州'),('秦皇岛'),('舟山'),('衡阳'),('襄阳'),('赣州'),('赤峰'),('运城'),('连云港'),('连城'),('通化'),('通辽'),('邯郸'),('郑州'),('鄂尔多斯'),('锡林浩特'),('锦州'),('长春'),('长沙'),('长治'),('长海'),('阜阳'),('阿尔山'),('阿拉善右旗'),('阿拉善左旗'),('青岛'),('鞍山'),('额济纳旗'),('鸡西'),('黄山'),('齐齐哈尔');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flightID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `departureTime` datetime DEFAULT NULL,
  `arrivalTime` datetime DEFAULT NULL,
  `airplaneID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `departureAirportID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `arrivalAirportID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`flightID`) USING BTREE,
  KEY `airplaneID` (`airplaneID`) USING BTREE,
  KEY `departureAirportID` (`departureAirportID`) USING BTREE,
  KEY `ArrivalAirportID` (`arrivalAirportID`) USING BTREE,
  KEY `arrivalAirportID_2` (`arrivalAirportID`) USING BTREE,
  CONSTRAINT `foreignKey2` FOREIGN KEY (`airplaneID`) REFERENCES `airplane` (`airplaneID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `foreignKey3` FOREIGN KEY (`departureAirportID`) REFERENCES `airport` (`airportID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `foreignKey4` FOREIGN KEY (`arrivalAirportID`) REFERENCES `airport` (`airportID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('GD0001','2020-01-08 04:28:00','2020-01-08 07:22:00','BY0001','AR0002','AR0003'),('GD0002','2020-01-09 10:06:56','2020-01-09 11:07:01','BY0001','AR0001','AR0002'),('GD0003','2020-01-08 04:28:00','2020-01-08 07:22:00','BY0001','AR0002','AR0003'),('GD0005','2020-01-15 05:00:00','2020-01-15 12:00:00','BY0004','AR0006','AR0004'),('GD0006','2020-01-15 10:00:00','2020-01-16 00:00:00','BY0002','AR0002','AR0005'),('GD0007','2020-01-22 09:00:00','2020-01-23 00:00:00','BY0004','AR0002','AR0004'),('GD0008','2020-01-07 00:00:00','2020-01-08 00:00:00','BY0002','AR0003','AR0004'),('GD0009','2020-01-14 00:00:00','2020-01-15 00:00:00','BY0002','AR0001','AR0005'),('GD0010','2020-01-14 06:00:00','2020-01-15 00:00:00','BY0002','AR0006','AR0002'),('GD0011','2020-01-21 00:00:00','2020-01-22 00:00:00','BY0003','AR0001','AR0004');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `ticketType` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `orderStatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `passengerID` int(11) DEFAULT NULL,
  `flightID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IDCard` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`orderID`) USING BTREE,
  KEY `FK_PID` (`passengerID`) USING BTREE,
  KEY `FK_FID` (`flightID`) USING BTREE,
  CONSTRAINT `FK_FID` FOREIGN KEY (`flightID`) REFERENCES `flight` (`flightID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (34,1,'2020-01-08 11:42:40','已退票',NULL,'GD0002',3,'17857696352','金矫波','201706061913'),(35,1,'2020-01-08 11:45:38','已退票',NULL,'GD0002',3,'17857342234','金矫波','1231654654'),(36,1,'2020-01-08 11:49:14','已退票',NULL,'GD0002',3,'123','mzc','201706061919'),(37,1,'2020-01-08 13:14:15','已退票',NULL,'GD0002',3,'17857342234','金矫波','4213894798314'),(38,1,'2020-01-08 13:20:25','已退票',NULL,'GD0002',3,'123','kl','201706061930');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `passengerID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `IDCard` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `identifyType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`passengerID`) USING BTREE,
  KEY `passengerID` (`passengerID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (7,'金矫波','17857698672','1231654654','成年'),(9,'金矫波','17857696352','201706061913','成年'),(10,'的书法国画','17857696352','3247293047','成年'),(11,'额日哦好疼','17857696352','2907320974','成年'),(12,'及那是哦','17857696352','493072498432','成年'),(13,'金矫','17857696352','201706061914','成年'),(15,'金矫波','17857342234','4213894798314','成年');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketinfo`
--

DROP TABLE IF EXISTS `ticketinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketinfo` (
  `TicketInfoID` int(11) NOT NULL,
  `firstClassTicket` int(11) DEFAULT NULL,
  `businessClassTicket` int(11) DEFAULT NULL,
  `economyClassTicket` int(11) DEFAULT NULL,
  `firstClassTicketPrice` float DEFAULT NULL,
  `businessClassTicketPrice` float DEFAULT NULL,
  `economyClassTicketPrice` float DEFAULT NULL,
  `FlightID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`TicketInfoID`) USING BTREE,
  KEY `foreignKey` (`FlightID`) USING BTREE,
  CONSTRAINT `foreignKey` FOREIGN KEY (`FlightID`) REFERENCES `flight` (`flightID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketinfo`
--

LOCK TABLES `ticketinfo` WRITE;
/*!40000 ALTER TABLE `ticketinfo` DISABLE KEYS */;
INSERT INTO `ticketinfo` VALUES (1,11,20,100,5000,3000,1000,'GD0001'),(2,39,19,100,5500,3000,1000,'GD0002'),(3,11,20,100,5000,3000,1000,'GD0003'),(5,10,20,100,5000,3000,1000,'GD0005'),(6,10,20,100,5000,3000,1000,'GD0006'),(7,10,20,100,5000,3000,1000,'GD0007'),(8,10,20,100,5000,3000,1000,'GD0008'),(10,10,20,100,5000,3000,1000,'GD0009'),(11,10,20,100,5000,3000,1000,'GD0010'),(12,10,20,100,5000,3000,1000,'GD0011');
/*!40000 ALTER TABLE `ticketinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('123','123456',2),('17857342234','123456',3),('17857696352','123456',3),('456','123456',2),('789','123456',2),('admin','123456',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-10  0:28:46
