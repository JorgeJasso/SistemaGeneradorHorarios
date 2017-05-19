-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: horarios
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `Num_Control` int(11) NOT NULL,
  `Nombre_Alumno` varchar(50) NOT NULL,
  `Apellido_Paterno` varchar(50) NOT NULL,
  `Apellido_Materno` varchar(50) NOT NULL,
  `Carrera` varchar(70) NOT NULL,
  `Semestre` int(11) NOT NULL,
  `Contraseña` char(50) NOT NULL,
  PRIMARY KEY (`Num_Control`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (15240604,'Araceli','Guzmán','Cáceres','Ingeniería en Sistemas Computacionales',4,'Araceli1997'),(15240719,'Jorge','Jasso','Torres','Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Jorge1997'),(15240832,'Miguel','Reyes','Solís','Ingeniería Electromecánica',5,'Miguel1996'),(15240954,'Marlen','García','Galván','Ingeniería Electrónica',5,'Marlen1996'),(15241043,'Juda','Vallejo','Herrera','Ingeniería en Gestión Empresarial',6,'Juda1995'),(15242132,'Adrián','Solís','Salas','Ingeniería en Logística',6,'Adrian1995'),(15248654,'Armando','Díaz','Anguiano','Ingeniería en Mecatrónica',7,'Armando1994'),(15249856,'Isaac','Flores','Gaytán','Ingeniería Industrial',7,'Isaac1994');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `Id_Grupo` int(11) NOT NULL,
  `Carrera` varchar(60) NOT NULL,
  `Semestre` int(11) NOT NULL,
  `Materia` varchar(50) NOT NULL,
  `Maestro` varchar(100) NOT NULL,
  `HLunes` varchar(45) DEFAULT NULL,
  `HMartes` varchar(45) DEFAULT NULL,
  `HMiercoles` varchar(45) DEFAULT NULL,
  `HJuves` varchar(45) DEFAULT NULL,
  `HViernes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_Grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (4000,'Ingeniería en Sistemas Computacionales',4,'Ecuaciones Diferenciales','Joel Rico','7:00-8:40','  ','7:00-8:40',' ','7:00-7:50'),(4001,'Ingeniería en Sistemas Computacionales',4,'Métodos Numéricos','Juan Pantoja','','8:45-10:25','','8:45-10:25',''),(4002,'Ingeniería en Sistemas Computacionales',4,'Tópicos Avanzados de Programación','Jose Carpio','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4003,'Ingeniería en Sistemas Computacionales',4,'Fundamentos de Base de Datos','Laura León',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4004,'Ingeniería en Sistemas Computacionales',4,'Simulación','Eugenio Conrrado','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4005,'Ingeniería en Sistemas Computacionales',4,'Principios Eléctricos y Aplicaciones Digitales','Asael Ramírez',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4006,'Ingeniería en Sistemas Computacionales',5,'Graficación','Claudia Pantoja','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4007,'Ingeniería en Sistemas Computacionales',5,'Fundamentos de Ingeniería de Software','Jose Perez',' ','8:45-10:25',' ','8:45-10:25',' '),(4008,'Ingeniería en Sistemas Computacionales',5,'Fundamentos de Telecomunicaciones','Irma Lerma','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4009,'Ingeniería en Sistemas Computacionales',5,'Sistemas Operativos','Marco Paniagua',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4010,'Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Matemáticas Aplicadas a Comunicaciones','David González','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4011,'Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Programación II','Pablo Levi',' ','8:45-10:25',' ','8:45-10:25',' '),(4012,'Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Fundamentos de Redes','Julio Pintor','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4013,'Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Taller de Base de Datos','Marcos Cortes',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4014,'Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Circuitos Eléctricos y Electrónicos','Blanca Llanos','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4015,'Ingeniería en Tecnologías de la Información y Comunicaciones',4,'Ingeniería de Software','Pamela Urupia',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4016,'Ingeniería en Tecnologías de la Información y Comunicaciones',5,'Administración de Proyectos','Paloma zúñiga','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4017,'Ingeniería en Tecnologías de la Información y Comunicaciones',5,'Taller de Ingeniería de Software','Hernan Colunga',' ','8:45-10:25',' ','8:45-10:25',''),(4018,'Ingeniería en Tecnologías de la Información y Comunicaciones',5,'Arquitectura de Computadoras','Marta Perez','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4019,'Ingeniería en Tecnologías de la Información y Comunicaciones',5,'Redes de Computadoras','Joel Pintor',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4020,'Ingeniería Electromecánica',5,'Diseño de Elementos de Máquinas','Martin Manrique','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4021,'Ingeniería Electromecánica',5,'Diseño e Ingeniería Asistidos por Computadora','Julio Jalado',' ','8:45-10:25',' ','8:45-10:25',' '),(4022,'Ingeniería Electromecánica',5,'Transferencia de Calor','Pablo González','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4023,'Ingeniería Electromecánica',5,'Análisis de Circuitos Eléctricos de CA','Armando Lozada',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4024,'Ingeniería Electromecánica',5,'Sistemas y Máquinas de Fluidos','Adrian Gaona','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4025,'Ingeniería Electromecánica',5,'Electrónica Digital','Brayan Guzmán',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4026,'Ingeniería Electromecánica',6,'Ahorro de Energía','Nahilea Cáceres','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4027,'Ingeniería Electromecánica',6,'Instalaciones Eléctricas','Hugo Torres',' ','8:45-10:25',' ','8:45-10:25',' '),(4028,'Ingeniería Electromecánica',6,'Máquinas Eléctricas','Marcos Toledo','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4029,'Ingeniería Electromecánica',6,'Taller de Investigación I','Aranza Jafet',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4030,'Ingeniería Electrónica',5,'Circuitos Eléctricos II','Magali Moreno','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4031,'Ingeniería Electrónica',5,'Diodos y Transistores','Sarahi Belgar',' ','8:45-10:25',' ','8:45-10:25',' '),(4032,'Ingeniería Electrónica',5,'Teoría Electromagnética','Alberto Jasso','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4033,'Ingeniería Electrónica',5,'Máquinas Eléctricas','Paolo Hernandez',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4034,'Ingeniería Electrónica',5,'Diseño Digital con VHDL','Yola Nicasio','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4035,'Ingeniería Electrónica',5,'Desarrollo Profesional','Marta Sanchez',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4036,'Ingeniería Electrónica',6,'Control I','Valeria Rangel','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4037,'Ingeniería Electrónica',6,'Fundamentos Financieros','Ivan Miranda',' ','8:45-10:25',' ','8:45-10:25',' '),(4038,'Ingeniería Electrónica',6,'Taller de Investigación I','Isaura Rodriguez','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4039,'Ingeniería Electrónica',6,'Microcontroladores','Isadora Pachuca',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4040,'Ingeniería en Gestión Empresarial',6,'Administración de la Salud y Seguridad Ocupacional','Raúl Lora','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4041,'Ingeniería en Gestión Empresarial',6,'El Emprendedor y la Innovación','Josy Cano',' ','8:45-10:25',' ','8:45-10:25',' '),(4042,'Ingeniería en Gestión Empresarial',6,'Gestión de la Producción I','Ariel Cano','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4043,'Ingeniería en Gestión Empresarial',6,'Diseño Organizacional','Lizeth Arevalo',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4044,'Ingeniería en Gestión Empresarial',6,'Taller de Investigación II','Patricia Gonzalez','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4045,'Ingeniería en Gestión Empresarial',6,'Sistemas de Información de la Mercadotecnia','Joel Rico',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4046,'Ingeniería en Gestión Empresarial',7,'Plan de Negocios','Emmanuel Pintor','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4047,'Ingeniería en Gestión Empresarial',7,'Gestión Estratégica','Telia González',' ','8:45-10:25',' ','8:45-10:25',' '),(4048,'Ingeniería en Gestión Empresarial',7,'Desarrollo Sustentable','Vicky Silva','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4049,'Ingeniería en Gestión Empresarial',7,'Mercadotecnia Electrónica','Mariela Sanchez',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4050,'Ingeniería en Logística',6,'Tráfico y Transporte','Paola Silva','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4051,'Ingeniería en Logística',6,'Investigación de Operaciones II','Maria Perez',' ','8:45-10:25',' ','8:45-10:25',' '),(4052,'Ingeniería en Logística',6,'Empaque y Embalaje','Juan Luna','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4053,'Ingeniería en Logística',6,'Ingeniería Económica','Cinthia Luna',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4054,'Ingeniería en Logística',6,'Taller de Investigación I','Cinthya Nava','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4055,'Ingeniería en Logística',6,'Finanzas','Sayra Lovato',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4056,'Ingeniería en Logística',7,'Comercio Internacional','Alexis Porras','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4057,'Ingeniería en Logística',7,'Geografía para el Transporte','Maro Prado',' ','8:45-10:25',' ','8:45-10:25',' '),(4058,'Ingeniería en Logística',7,'Modelos de Simulación','Joel Rico','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4059,'Ingeniería en Logística',7,'Procesos de Fabricación','Juan Salas',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4060,'Ingeniería en Mecatrónica',7,'Dinámica de Sistemas','Irma Manzanares','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4061,'Ingeniería en Mecatrónica',7,'Manufactura Avanzada','Claudia Chia',' ','8:45-10:25',' ','8:45-10:25',' '),(4062,'Ingeniería en Mecatrónica',7,'Circuitos Hidráulicos','Brayan Guzmán','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4063,'Ingeniería en Mecatrónica',7,'Mantenimiento','Paolo González',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10'),(4064,'Ingeniería en Mecatrónica',7,'Microcontroladores','Julio Perez','10:30-12:10',' ','10:30-12:10',' ','10:30-11:20'),(4065,'Ingeniería en Mecatrónica',7,'Programación Avanzada','Carlos Levi',' ','12:15-13:55',' ','12:15-13:55','13:05-13:55'),(4066,'Ingeniería en Mecatrónica',8,'Control','Andoni Lopez','7:00-8:40',' ','7:00-8:40',' ','7:00-7:50'),(4067,'Ingeniería en Mecatrónica',8,'Formulación de Proyectos','Sayra Rodriguez',' ','8:45-10:25',' ','8:45-10:25',' '),(4068,'Ingeniería en Mecatrónica',8,'Controladores Lógicos','Hugo Cisneros','8:45-10:25',' ','8:45-10:25',' ','8:45-9:35'),(4069,'Ingeniería en Mecatrónica',8,'Programación avanzada II','Marlen Collaso','','10:30-12:10','','10:30-12:10','11:20-12:10'),(4070,'Ingeniería Industrial',7,'Taller de Investigación II','Daniel Zarate','7:00-8:40','','7:00-8:40','','7:00-7:50'),(4071,'Ingeniería Industrial',7,'Planeación Financiera','Daniel Villanueva','','8:45-10:25','','8:45-10:25',''),(4072,'Ingeniería Industrial',7,'\rPlaneación y Diseño','Sebastian Villalobos','8:45-10:25','','8:45-10:25','','8:45-9:35'),(4073,'Ingeniería Industrial',7,'Sistemas de Manufactura','Fernanda Guzmán','','10:30-12:10','','10:30-12:10','11:20-12:10'),(4074,'Ingeniería Industrial',7,'Logistica y Cadenas','Pablo Gallardo','10:30-12:10','','10:30-12:10','','10:30-11:20'),(4075,'Ingeniería Industrial',7,'Gestión de Calidad','Gabriela González','','12:15-13:55','','12:15-13:55','13:05-13:55'),(4076,'Ingeniería Industrial',8,'Ingeniería de Sistemas','Ana Suarez','7:00-8:40','','7:00-8:40','','7:00-7:50'),(4077,'Ingeniería Industrial',8,'Formulación y Evaluación','Cecilia Mora','','8:45-10:25','','8:45-10:25',''),(4078,'Ingeniería Industrial',8,'Relaciones Industriales','Cristian Arellano','8:45-10:25','','8:45-10:25','','8:45-9:35'),(4079,'Ingeniería Industrial',8,'Simulación','Juana Mendez',' ','10:30-12:10',' ','10:30-12:10','11:20-12:10');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'horarios'
--

--
-- Dumping routines for database 'horarios'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-18 19:33:30
