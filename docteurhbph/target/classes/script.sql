-- MySQL dump 10.13  Distrib 5.6.43, for Linux (x86_64)
--
-- Host: localhost    Database: docteurhb
CREATE TABLE `Parametre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateDeNaissance` date NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Releve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateEnvoi` datetime NOT NULL,
  `valeur` float NOT NULL,
  `parametre_id` bigint(20) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9jw2p2qtn8sh2afxpkr7clr7` (`parametre_id`),
  KEY `FKgqs9ct92nfu3kt9ggf6gcifle` (`patient_id`),
  CONSTRAINT `FK9jw2p2qtn8sh2afxpkr7clr7` FOREIGN KEY (`parametre_id`) REFERENCES `Parametre` (`id`),
  CONSTRAINT `FKgqs9ct92nfu3kt9ggf6gcifle` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

