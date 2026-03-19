-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-12-2025 a las 17:02:16
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peluqueria_canina`
--
CREATE DATABASE IF NOT EXISTS peluqueria_canina;
USE peluqueria_canina;
--
-- Estructura de tabla para la tabla `cita`
--

DROP TABLE IF EXISTS `cita`;
CREATE TABLE IF NOT EXISTS `cita` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_hora` datetime NOT NULL,
  `id_mascotas` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cita_mascota` (`id_mascotas`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;


--
-- Estructura de tabla para la tabla `cita_servicios`
--

DROP TABLE IF EXISTS `cita_servicios`;
CREATE TABLE IF NOT EXISTS `cita_servicios` (
  `id_cita` int NOT NULL,
  `id_servicio` int NOT NULL,
  PRIMARY KEY (`id_cita`,`id_servicio`),
  KEY `id_servicio` (`id_servicio`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
 

--
-- Estructura de tabla para la tabla `duenio`
--

DROP TABLE IF EXISTS `duenio`;
CREATE TABLE IF NOT EXISTS `duenio` (
  `ID_DUENIO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TELEFONO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_DUENIO`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

 
--
-- Estructura de tabla para la tabla `mascotas`
--

DROP TABLE IF EXISTS `mascotas`;
CREATE TABLE IF NOT EXISTS `mascotas` (
  `NUM_CLIENTE` int NOT NULL AUTO_INCREMENT,
  `ALERGICO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ATENCION_ESPECIAL` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `COLOR` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBREMAS` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `OBSERVACIONES` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `RAZA` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `UNDUENIO_ID_DUENIO` int DEFAULT NULL,
  PRIMARY KEY (`NUM_CLIENTE`),
  KEY `FK_MASCOTAS_UNDUENIO_ID_DUENIO` (`UNDUENIO_ID_DUENIO`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
 

--
-- Estructura de tabla para la tabla `mascota_servicios`
--

DROP TABLE IF EXISTS `mascota_servicios`;
CREATE TABLE IF NOT EXISTS `mascota_servicios` (
  `id_mascota` int NOT NULL,
  `id_servicio` int NOT NULL,
  PRIMARY KEY (`id_mascota`,`id_servicio`),
  KEY `FK_mascota_servicios_id_servicio` (`id_servicio`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
 
--
-- Estructura de tabla para la tabla `servicios`
--

DROP TABLE IF EXISTS `servicios`;
CREATE TABLE IF NOT EXISTS `servicios` (
  `ID_SERVICIO` int NOT NULL AUTO_INCREMENT,
  `PRECIO` double DEFAULT NULL,
  `TIPOSERVICIOS` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICIO`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

 

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_usuario_rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
 
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
