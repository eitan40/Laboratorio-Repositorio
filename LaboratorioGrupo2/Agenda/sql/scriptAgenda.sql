drop database `agenda`;

CREATE DATABASE `agenda`;
USE agenda;

drop table `Personas`;
CREATE TABLE `Personas` 
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `mail` varchar(40) ,
  `cumpleanios` date ,
  
  `calle` varchar(40) ,
  `altura` int(10),
  `piso` int(2),
  `depto` varchar(2) ,
  `localidad` int(11) ,
  `tipoContacto` int(11) ,
  PRIMARY KEY (`idPersona`)
);

ALTER TABLE `Personas` ADD FOREIGN KEY(`localidad`) REFERENCES `Localidad`(`idLocalidad`) on update cascade;
ALTER TABLE `Personas` ADD FOREIGN KEY(`tipoContacto`) REFERENCES `TipoContacto`(`idTipoContacto`) on update cascade;


drop table `Localidad`;
CREATE TABLE `Localidad`
(  
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreLocalidad` varchar (30),
  PRIMARY KEY (`idLocalidad`)
 ); 

drop table `TipoContacto`;
CREATE TABLE `TipoContacto`
(  
  `idTipoContacto` int(11) NOT NULL AUTO_INCREMENT,
  `tipoContacto` varchar (20) ,
   PRIMARY KEY (`idTipoContacto`)
 ); 


