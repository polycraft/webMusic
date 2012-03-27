-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Mar 27 Mars 2012 à 16:43
-- Version du serveur: 5.1.53
-- Version de PHP: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `projetweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `copy`
--

CREATE TABLE IF NOT EXISTS `copy` (
  `id_copy` int(11) NOT NULL AUTO_INCREMENT,
  `id_record` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `condition` varchar(100) NOT NULL,
  PRIMARY KEY (`id_copy`),
  KEY `id_record` (`id_record`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `language`
--

CREATE TABLE IF NOT EXISTS `language` (
  `id_language` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_language`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `link_copy_recordlibrary`
--

CREATE TABLE IF NOT EXISTS `link_copy_recordlibrary` (
  `id_copy` int(11) NOT NULL,
  `id_record_library` int(11) NOT NULL,
  PRIMARY KEY (`id_copy`,`id_record_library`),
  KEY `id_record_library` (`id_record_library`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `link_record_person`
--

CREATE TABLE IF NOT EXISTS `link_record_person` (
  `id_record` int(11) NOT NULL,
  `id_person` int(11) NOT NULL,
  `id_record_role` int(11) NOT NULL,
  PRIMARY KEY (`id_record`,`id_person`,`id_record_role`),
  KEY `id_person` (`id_person`),
  KEY `id_record_role` (`id_record_role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `link_record_track`
--

CREATE TABLE IF NOT EXISTS `link_record_track` (
  `id_record` int(11) NOT NULL,
  `id_track` int(11) NOT NULL,
  PRIMARY KEY (`id_record`,`id_track`),
  KEY `id_track` (`id_track`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `link_track_person`
--

CREATE TABLE IF NOT EXISTS `link_track_person` (
  `id_track` int(11) NOT NULL,
  `id_person` int(11) NOT NULL,
  `id_track_role` int(11) NOT NULL,
  PRIMARY KEY (`id_track`,`id_person`,`id_track_role`),
  KEY `id_person` (`id_person`),
  KEY `id_track_role` (`id_track_role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id_person` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `birthname` date NOT NULL,
  PRIMARY KEY (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `record`
--

CREATE TABLE IF NOT EXISTS `record` (
  `id_record` int(11) NOT NULL AUTO_INCREMENT,
  `id_category` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `width` int(11) NOT NULL,
  `matrix` varchar(200) NOT NULL,
  `press_info` text NOT NULL,
  PRIMARY KEY (`id_record`),
  KEY `id_category` (`id_category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `record_library`
--

CREATE TABLE IF NOT EXISTS `record_library` (
  `id_record_library` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  PRIMARY KEY (`id_record_library`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `record_role`
--

CREATE TABLE IF NOT EXISTS `record_role` (
  `id_record_role` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_record_role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `style`
--

CREATE TABLE IF NOT EXISTS `style` (
  `id_style` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_style`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `track`
--

CREATE TABLE IF NOT EXISTS `track` (
  `id_track` int(11) NOT NULL AUTO_INCREMENT,
  `id_style` int(11) NOT NULL,
  `rythm` varchar(100) NOT NULL,
  `label` int(11) NOT NULL,
  `playing_time` int(11) NOT NULL,
  `release_date` date NOT NULL,
  PRIMARY KEY (`id_track`),
  KEY `id_style` (`id_style`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `track_role`
--

CREATE TABLE IF NOT EXISTS `track_role` (
  `id_track_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_track_role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_language` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email_adress` varchar(200) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `biography` text NOT NULL,
  `picture` varchar(200) NOT NULL,
  `website` varchar(200) NOT NULL,
  `social_network_account` varchar(200) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_language` (`id_language`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `copy_ibfk_1` FOREIGN KEY (`id_record`) REFERENCES `record` (`id_record`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `link_copy_recordlibrary`
--
ALTER TABLE `link_copy_recordlibrary`
  ADD CONSTRAINT `link_copy_recordlibrary_ibfk_2` FOREIGN KEY (`id_record_library`) REFERENCES `record_library` (`id_record_library`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `link_copy_recordlibrary_ibfk_1` FOREIGN KEY (`id_copy`) REFERENCES `copy` (`id_copy`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `link_record_person`
--
ALTER TABLE `link_record_person`
  ADD CONSTRAINT `link_record_person_ibfk_3` FOREIGN KEY (`id_record_role`) REFERENCES `record_role` (`id_record_role`),
  ADD CONSTRAINT `link_record_person_ibfk_1` FOREIGN KEY (`id_record`) REFERENCES `record` (`id_record`),
  ADD CONSTRAINT `link_record_person_ibfk_2` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`);

--
-- Contraintes pour la table `link_record_track`
--
ALTER TABLE `link_record_track`
  ADD CONSTRAINT `link_record_track_ibfk_2` FOREIGN KEY (`id_track`) REFERENCES `track` (`id_track`),
  ADD CONSTRAINT `link_record_track_ibfk_1` FOREIGN KEY (`id_record`) REFERENCES `record` (`id_record`);

--
-- Contraintes pour la table `link_track_person`
--
ALTER TABLE `link_track_person`
  ADD CONSTRAINT `link_track_person_ibfk_3` FOREIGN KEY (`id_track_role`) REFERENCES `track_role` (`id_track_role`),
  ADD CONSTRAINT `link_track_person_ibfk_1` FOREIGN KEY (`id_track`) REFERENCES `track` (`id_track`),
  ADD CONSTRAINT `link_track_person_ibfk_2` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`);

--
-- Contraintes pour la table `record`
--
ALTER TABLE `record`
  ADD CONSTRAINT `record_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`);

--
-- Contraintes pour la table `record_library`
--
ALTER TABLE `record_library`
  ADD CONSTRAINT `record_library_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `track`
--
ALTER TABLE `track`
  ADD CONSTRAINT `track_ibfk_1` FOREIGN KEY (`id_style`) REFERENCES `style` (`id_style`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_language`) REFERENCES `language` (`id_language`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
