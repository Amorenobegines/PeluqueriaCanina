-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 19-03-2026 a las 12:21:50
-- Versión del servidor: 8.0.44
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `peluqueriacanina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

DROP TABLE IF EXISTS `cita`;
CREATE TABLE IF NOT EXISTS `cita` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `fecha_hora` datetime(3) NOT NULL,
  `id_mascotas` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_cita_id_mascotas` (`id_mascotas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`ID`, `fecha_hora`, `id_mascotas`) VALUES
(1, '2026-03-19 10:17:22.234', 1),
(3, '2026-03-20 11:57:00.000', 3),
(4, '2026-03-21 12:00:00.000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_servicios`
--

DROP TABLE IF EXISTS `cita_servicios`;
CREATE TABLE IF NOT EXISTS `cita_servicios` (
  `id_servicio` int NOT NULL,
  `id_cita` int NOT NULL,
  PRIMARY KEY (`id_servicio`,`id_cita`),
  KEY `FK_cita_servicios_id_cita` (`id_cita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cita_servicios`
--

INSERT INTO `cita_servicios` (`id_servicio`, `id_cita`) VALUES
(5, 1),
(6, 1),
(12, 3),
(13, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DUENIO`
--

DROP TABLE IF EXISTS `DUENIO`;
CREATE TABLE IF NOT EXISTS `DUENIO` (
  `ID_DUENIO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_DUENIO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `DUENIO`
--

INSERT INTO `DUENIO` (`ID_DUENIO`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Alicia', '123456789'),
(3, 'Alicia', '123456789'),
(4, 'Jesus', '123456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

DROP TABLE IF EXISTS `mascotas`;
CREATE TABLE IF NOT EXISTS `mascotas` (
  `NUM_CLIENTE` int NOT NULL AUTO_INCREMENT,
  `ALERGICO` varchar(255) DEFAULT NULL,
  `ATENCION_ESPECIAL` varchar(255) DEFAULT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `NOMBREMAS` varchar(255) DEFAULT NULL,
  `OBSERVACIONES` varchar(255) DEFAULT NULL,
  `RAZA` varchar(255) DEFAULT NULL,
  `UNDUENIO_ID_DUENIO` int DEFAULT NULL,
  PRIMARY KEY (`NUM_CLIENTE`),
  KEY `FK_mascotas_UNDUENIO_ID_DUENIO` (`UNDUENIO_ID_DUENIO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`NUM_CLIENTE`, `ALERGICO`, `ATENCION_ESPECIAL`, `COLOR`, `NOMBREMAS`, `OBSERVACIONES`, `RAZA`, `UNDUENIO_ID_DUENIO`) VALUES
(1, 'No', 'Si', 'Marrón', 'Chica', 'Es asustadiza, Edad 13', 'Malinois', 1),
(3, 'No', 'Si', 'MArron', 'Michin', 'Cuidado mal genio', 'Gato', 3),
(4, 'Si', 'Si', 'Negro', 'Chico', 'Edad: 6', 'Nose', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota_servicios`
--

DROP TABLE IF EXISTS `mascota_servicios`;
CREATE TABLE IF NOT EXISTS `mascota_servicios` (
  `id_mascota` int NOT NULL,
  `id_servicio` int NOT NULL,
  PRIMARY KEY (`id_mascota`,`id_servicio`),
  KEY `FK_mascota_servicios_id_servicio` (`id_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `mascota_servicios`
--

INSERT INTO `mascota_servicios` (`id_mascota`, `id_servicio`) VALUES
(1, 3),
(1, 4),
(3, 8),
(3, 9),
(4, 14),
(4, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ROL`
--

DROP TABLE IF EXISTS `ROL`;
CREATE TABLE IF NOT EXISTS `ROL` (
  `ID_ROL` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_ROL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `ROL`
--

INSERT INTO `ROL` (`ID_ROL`, `NOMBRE`) VALUES
(1, 'Administrador'),
(2, 'Recepcionista'),
(3, 'Trabajador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

DROP TABLE IF EXISTS `servicios`;
CREATE TABLE IF NOT EXISTS `servicios` (
  `ID_SERVICIO` int NOT NULL AUTO_INCREMENT,
  `PRECIO` double DEFAULT NULL,
  `TIPOSERVICIOS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICIO`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`ID_SERVICIO`, `PRECIO`, `TIPOSERVICIOS`) VALUES
(1, 15, 'Baño'),
(2, 10, 'Corte de uñas'),
(3, 10, 'Corte de uñas'),
(4, 15, 'Baño'),
(5, 10, 'Corte de uñas'),
(6, 15, 'Baño'),
(7, 15, 'Baño'),
(8, 15, 'Baño'),
(9, 10, 'Corte de uñas'),
(10, 15, 'Baño'),
(11, 15, 'Baño'),
(12, 15, 'Baño'),
(13, 15, 'Baño'),
(14, 15, 'Baño'),
(15, 20, 'Corte de pelo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `PASS` varchar(255) DEFAULT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_usuarios_id_rol` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID`, `APELLIDOS`, `EMAIL`, `NOMBRE`, `PASS`, `id_rol`) VALUES
(1, 'Begines', 'alicia@gmail.com', 'Alicia', '123456', 1),
(2, 'Diaz', 'jesus@gmail.com', 'Jesus', '123456', 2),
(4, 'Moran', 'lucia@hotmail.com', 'Lucia', '123456', 3);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `FK_cita_id_mascotas` FOREIGN KEY (`id_mascotas`) REFERENCES `mascotas` (`NUM_CLIENTE`);

--
-- Filtros para la tabla `cita_servicios`
--
ALTER TABLE `cita_servicios`
  ADD CONSTRAINT `FK_cita_servicios_id_cita` FOREIGN KEY (`id_cita`) REFERENCES `cita` (`ID`),
  ADD CONSTRAINT `FK_cita_servicios_id_servicio` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`ID_SERVICIO`);

--
-- Filtros para la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD CONSTRAINT `FK_mascotas_UNDUENIO_ID_DUENIO` FOREIGN KEY (`UNDUENIO_ID_DUENIO`) REFERENCES `DUENIO` (`ID_DUENIO`);

--
-- Filtros para la tabla `mascota_servicios`
--
ALTER TABLE `mascota_servicios`
  ADD CONSTRAINT `FK_mascota_servicios_id_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mascotas` (`NUM_CLIENTE`),
  ADD CONSTRAINT `FK_mascota_servicios_id_servicio` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`ID_SERVICIO`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_usuarios_id_rol` FOREIGN KEY (`id_rol`) REFERENCES `ROL` (`ID_ROL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
