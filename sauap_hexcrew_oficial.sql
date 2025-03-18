CREATE DATABASE  IF NOT EXISTS `sauap_hexcrew` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sauap_hexcrew`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: sauap_hexcrew
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `idusuario` int NOT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `idusuario_admin` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (15),(16),(17);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignacion`
--

DROP TABLE IF EXISTS `asignacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignacion` (
  `idunidad` int NOT NULL,
  `idprofe` int NOT NULL,
  PRIMARY KEY (`idprofe`,`idunidad`),
  KEY `idunidad_asignacion_idx` (`idunidad`),
  CONSTRAINT `idprofesor_asignacion` FOREIGN KEY (`idprofe`) REFERENCES `profesor` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idunidad_asignacion` FOREIGN KEY (`idunidad`) REFERENCES `unidadaprendizaje` (`claveunidadaprendizaje`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion`
--

LOCK TABLES `asignacion` WRITE;
/*!40000 ALTER TABLE `asignacion` DISABLE KEYS */;
INSERT INTO `asignacion` VALUES (11990,0),(11990,1),(11990,2),(11990,3),(11990,4),(11991,0),(11991,1),(11991,2),(11991,3),(11991,4),(11992,0),(11992,1),(11992,2),(11992,3),(11992,4),(11993,0),(11993,1),(11993,2),(11994,3),(11994,4),(12015,5),(12015,6),(12015,7),(12015,8);
/*!40000 ALTER TABLE `asignacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `numprofesor` int NOT NULL,
  `idusuario` int NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `numprofesor_UNIQUE` (`numprofesor`),
  CONSTRAINT `idusuario_profe` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1191123,9),(1191345,6),(1191432,12),(1191456,3),(1191543,14),(1191567,1),(1191675,10),(1191739,4),(1191764,11),(1191789,8),(1191872,2),(1191928,7),(1191979,0),(1191980,5),(1191987,13);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadaprendizaje`
--

DROP TABLE IF EXISTS `unidadaprendizaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadaprendizaje` (
  `claveunidadaprendizaje` int NOT NULL,
  `nombreunidad` varchar(255) DEFAULT NULL,
  `horasclase` int DEFAULT NULL,
  `horastaller` int DEFAULT NULL,
  `horaslab` int DEFAULT NULL,
  PRIMARY KEY (`claveunidadaprendizaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadaprendizaje`
--

LOCK TABLES `unidadaprendizaje` WRITE;
/*!40000 ALTER TABLE `unidadaprendizaje` DISABLE KEYS */;
INSERT INTO `unidadaprendizaje` VALUES (11990,'Desarrollo de Software',3,3,0),(11991,'Aplicaciones Web con Base de Datos',3,0,2),(11992,'Redes II',2,1,0),(11993,'Estructura Socioeconomica de Mexico',2,2,0),(11994,'Optimizacion de Recursos Computacionales',2,2,0),(12015,'Inteligencia Artificial',2,0,3);
/*!40000 ALTER TABLE `unidadaprendizaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `rfc` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `idusuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (0,'AODL040816972','aponte@gmail.com','0000','Luis','Aponte Dzul'),(1,'GUGE010529P41','enrique@gmail.com','1111','Enrique','Gudino Gomez'),(2,'MOAE040727J66','erandi@gmail.com','2222','Erandi','Moreno Avendano'),(3,'OIXC951212892','xavier@gmail.com','3333','Xavier','Ortiz'),(4,'VIMA041012954','angel@gmail.com','4444','Angel','Villagomez Martinez'),(5,'AORJ040909LY5','jorge@gmail.com','5555','Jorge','Apodaca Ramos'),(6,'VIGM030710DT1','marcos@gmail.com','6666','Marcos','Vizcaino Guzman'),(7,'BARY0304075V2','yuliriam@gmail.com','7777','Yuliriam','Bravo Rubio'),(8,'CAAJ040225KB5','jesus@gmail.com','8888','Jesus','Cardona Araujo'),(9,'NUMM001108KN3','maximiliano@gmail.com','9999','Maximiliano','Nunez Morales'),(10,'BERJ040309SS5','jacquelyne@gmail.com','10000','Jacquelyne','Bedoya Ramos'),(11,'GABA040625BV4','alberto@gmail.com','11000','Alberto','Garcia Becerra'),(12,'SAMG0407059J9','gabriel@gmail.com','12000','Gabriel','Santillan Marquez'),(13,'CARD041228LMA','diego@gmail.com','13000','Diego','Carballo Ramirez'),(14,'PIMR020501EE3','ramiro@gmail.com','14000','Ramiro','Pimentel Munoz'),(15,'GUOJ010809IS5','jorge@gmail.com','15000','Santiago','Guerrero Ozuna'),(16,'EIRG000712CU4','guillermo@gmail.com','16000','Guillermo','Encinas Rolon'),(17,'LOJE040406HT9','enrique@gmail.com','17000','Enrique','Lopez Jimenez');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-18 15:22:17
