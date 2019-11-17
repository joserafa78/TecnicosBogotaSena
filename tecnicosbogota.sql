-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-09-2019 a las 00:42:38
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tecnicosbogota`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

CREATE TABLE IF NOT EXISTS `tecnico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(16) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `celular` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `anos_servicio` int(11) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `zona` varchar(45) DEFAULT NULL,
  `direccion` varchar(80) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=44 ;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`id`, `identificacion`, `nombres`, `apellidos`, `celular`, `correo`, `anos_servicio`, `pais`, `ciudad`, `zona`, `direccion`, `fecha_registro`) VALUES
(2, '1124072717', 'Jose Rafael', 'Jimenez  Serna', '3136946736', 'jose.rafael.jimenez.6@gmail.com', 5, 'Colombia', 'Bogota', 'Chapinero', 'Calle Suba', '2019-09-21 16:36:53'),
(3, '1013631907', 'Miguel Alexander', 'Aarrado Lesmes', '3195875512', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:33:41'),
(4, '79985596', 'Carlos Andres', 'Muñoz Bohorquez', '3115738841', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:35:44'),
(5, '80242417', 'Jonatan', 'Diaz Vargas', '3142545192', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:38:37'),
(6, '1053772131', 'Ernesto de Jesus', 'Blandon Trejos', '', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:39:43'),
(7, '79324069', 'Jaime', 'Martinez  Lopez', '3158742120', 'jotamarloz@gmail.com', 20, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:42:00'),
(8, '80147841', 'Iader Andres', 'Prado Cortazar', '3045570443', 'andres_masterfix@hotmail.com', 19, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:43:47'),
(9, '19790477', 'Irving Thomas', 'Rojas Charaima', '319-796-5133', 'irvingthomas1505@gmail.com', 6, 'Colombia', 'Bogota', 'Chapinero', 'Chapinero', '2019-09-21 20:45:51'),
(10, '1070330542', 'Dayvid Mauricio', 'Landino Velasquez', '3057439262', 'dayvidladino@gmail.com', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:47:28'),
(11, '1022365802', 'Cristian Vladimir', 'Diaz Ardilla', '3005514081', 'bit.laboratorio@gmail.com', 5, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:49:13'),
(12, '79661713', 'Jhon Humberto', 'Montaño Bolivar', '3142933784', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:51:02'),
(13, '1094858764', 'Alcibiades', 'Guerrero romero', '3045711319', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:52:44'),
(14, '1030641313', 'Luis Felipe', 'Torres Pedroza', '3138835968', '', 3, 'Colombia', 'Bogota', 'Centro', 'Cento', '2019-09-21 20:54:36'),
(15, '80227428', 'Gerardo', 'Becerra Rojas', '3013192822', '', 5, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:55:48'),
(16, '80203651', 'Omar David', 'Pinilla Gomez', '3202519569', '', 5, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:57:10'),
(17, '1000063491', 'Wesley Andrey', 'Parra Ospina', '3193783412', '', 3, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:58:32'),
(18, '79919899', 'Jorge Eduardo', 'Morales Abello', '3024218415', 'J.moralesabello0712@gmail.com', 5, 'Colombia', 'Bogota', 'Centro', 'Centro', '2019-09-21 20:59:31'),
(19, '80833139', 'Gonzalo', 'moreno', '3114833378', 'gplgonzo85@hotmail.com', 10, 'Colombia', 'Bogota', '', '', '2019-09-21 21:04:54'),
(20, '80747230 ', 'Carlos', 'Rodriguez', '3123598468', 'Telematicavitel@msn.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:07:00'),
(21, '80060687', 'Reynel mauricio', 'merchan vergara', '3112217271', 'merchanplast@hotmail.com', 5, 'Colombia', 'Bogota', '', '', '2019-09-21 21:08:20'),
(22, '80880746', 'Giovanny Alejandro', 'Ladino Jiménez ', '3506140764', 'Giacomano@hotmail.com', 1, 'Colombia', 'Bogota', '', '', '2019-09-21 21:09:20'),
(23, '80793722', 'Jhon Jairo', 'rivera Cuéllar', '3144658164', 'jnriverarojo22@gmail.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:10:17'),
(24, '1024464180', 'Andrés Felipe', 'López melo', '3194235246 ', 'andreslopez1024@hotmail.com ', 2, 'Colombia', 'Bogota', '', '', '2019-09-21 21:11:10'),
(25, '80825991', 'guillermo', 'andres muñoz', '3004663738', 'elmundopirata2004@gmail.com', 10, 'Colombia', 'Bogota', '', '', '2019-09-21 21:12:35'),
(26, '1040524162', 'Paola andrea', 'suarez rojas', '3004663797', 'Paolajp18@hotmail.com', 7, 'Colombia', 'Bogota', '', '', '2019-09-21 21:13:39'),
(27, '94420468', 'uan Carlos', 'Solano Gaviria', '3166989741', 'Juancasolano77@gmail.com', 5, 'Colombia', 'Bogota', '', '', '2019-09-21 21:14:49'),
(28, '94274470', 'Hector Fabio ', 'Gutierrez Velez', '3163423207', 'hefaguve@hotmail.com', 5, 'Colombia', 'Bogota', '', '', '2019-09-21 21:15:39'),
(29, '1031158730', 'Angelo', 'Sanchez ', '3115103282', 'angelosanchezc95@gmail.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:16:49'),
(30, '1052970706', 'Jose gregorio', '', '3023624947', 'Jhosepjose2@gmail.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:17:31'),
(31, '1098408154', 'edwin ferney', 'martinez ramirez', '3194458447', 'edmarr357@gmail.com', 5, 'Colombia', 'Bogota', '', '', '2019-09-21 21:18:27'),
(32, '1010232010', 'Kevin Daniel', 'Gonzalez Angulo', '3023462304', 'kevin.1202@hotmail.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:19:21'),
(33, '1010197153', 'Juan sevastian', 'sanchez soache', '3016678298', 'Vastianss@hotmail.com', 5, 'Colombia', 'Bogota', '', '', '2019-09-21 21:21:30'),
(34, '1019044604', 'Jonathan alexander', 'hoyos garcia', '3112181790', 'Jonalex02060805@gmail.com', 10, 'Colombia', 'Bogota', '', '', '2019-09-21 21:22:16'),
(35, '85168315', 'Eduardo Enrique', 'Borja Yépez', '3014305063', 'eduarborja@hotmail.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:23:02'),
(36, '1023922419', 'Jeisson Steven', 'Mendoza cadavid', '3217468787', 'jeykevin50@gmail.com', 10, 'Colombia', 'Bogota', '', '', '2019-09-21 21:24:44'),
(37, '1013631906', 'Miguel', 'parrado', '3195875512', 'Parley724@gmail.com', 1, 'Colombia', 'Bogota', '', '', '2019-09-21 21:25:31'),
(38, '8371371', 'Jose gabriel', 'rodroguez caballero', '3213375186', 'Sga-49@hotmail.com', 1, 'Colombia', 'Bogota', '', '', '2019-09-21 21:26:47'),
(39, '73147268', 'Carlos Alonso', 'Garcia Periñan', '3022921310', 'shalomcomputer2013@gmail.com', 10, 'Colombia', 'Bogota', '', '', '2019-09-21 21:27:31'),
(40, '915345217061996', 'Palmerino junio ', 'ferreri diaz', '3202766808', 'solucionestecnologiasferreri@gmail.com', 3, 'Colombia', 'Bogota', '', '', '2019-09-21 21:28:26'),
(41, '79526080', 'Hector', 'Leguizamon Alarcon', '3192442798', 'hectorhla.0615@gmail.com', 10, 'Colombia', 'Bogota', 'localidad barrios unidos', 'cra 64 no 75 b 25', '2019-09-24 15:47:39'),
(42, '1235239064', 'Luis Jose', 'Otero Jimenez', '3058807289', 'oteroluis87@gmail.com', 10, 'Colombia', 'Bogota', 'chapinero', 'cra 13 n59 - 38 local  201', '2019-09-24 15:50:06'),
(43, '11204214', 'Wilson Javier', 'Diaz Lopez', '3133823255', 'willydiaz1010@gmail.com', 2, 'Colombia', 'Bogota', 'Chia', 'Centro Calle 11 12 57', '2019-09-24 17:01:38');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
