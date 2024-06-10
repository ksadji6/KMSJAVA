-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 10 juin 2024 à 20:19
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `examenjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id_classe` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `filiere` varchar(50) DEFAULT NULL,
  `niveau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id_classe`, `libelle`, `filiere`, `niveau`) VALUES
(1, NULL, '1.0', '1.0'),
(2, NULL, '6.0', '0.0'),
(3, NULL, '0.0', '2.0'),
(4, NULL, '0.0', '1.0'),
(5, NULL, '1.0', '0.0');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `matricule` int(11) NOT NULL,
  `nomComplet` varchar(50) DEFAULT NULL,
  `tuteur` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`matricule`, `nomComplet`, `tuteur`) VALUES
(1, 'Z', 'Z'),
(2, 'II', 'KK'),
(3, 'J', 'J'),
(4, 'R', 'Z'),
(5, 'YI', 'OI'),
(6, 'R', 'T'),
(7, 'ygf', 'vu'),
(8, '2022', 'gvb'),
(11, 'S', 'S'),
(12, 'kjj kj', 'jhg'),
(30, 'E', 'E'),
(33, 'YU', 't'),
(44, 'R', 'R'),
(50, 'T', 'T'),
(60, 'U', 'U'),
(77, 'Y', 'T'),
(80, 'I', 'I'),
(88, 'B', 'B'),
(90, 'O', 'O'),
(99, 'A', 'A'),
(123, 'E', 'O'),
(343, 'G', 'HGB'),
(665, 'y', 'Y'),
(666, 'UUU', 'JJJ'),
(765, 'k', 'k'),
(787, 'HGJH', 'FCVB');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `anneeScolaire` varchar(50) DEFAULT NULL,
  `matricule` int(11) DEFAULT NULL,
  `id_classe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `anneeScolaire`, `matricule`, `id_classe`) VALUES
(1, '2024', 12, NULL),
(2, '2022', NULL, NULL),
(3, '2020', 787, NULL),
(4, '2021', 2, NULL),
(5, '2021', NULL, NULL),
(6, '2023', 7, NULL),
(7, '2022', 8, NULL),
(8, 'T', 4, NULL),
(9, '2022', NULL, NULL),
(10, '2019', 33, NULL),
(11, '2019', 99, NULL),
(12, '2019', 88, NULL),
(13, '2019', 11, NULL),
(14, '2019', 44, NULL),
(15, '2016', 90, NULL),
(16, '2016', 80, NULL),
(17, '2014', 1, 1),
(18, '2014', 2, 1),
(19, '2014', 3, 3),
(20, '2014', 765, 1),
(21, '2016', NULL, 3),
(22, '2013', NULL, 3),
(23, '2010', 123, 2),
(24, '2018', 665, 2),
(25, '2015', 77, 1),
(26, '2014', 6, 1),
(27, '2015', NULL, 3),
(28, '2015', NULL, 3),
(29, '2015', 5, 1),
(30, '2020', 666, 5);

-- --------------------------------------------------------

--
-- Structure de la table `profclasse`
--

CREATE TABLE `profclasse` (
  `id_profclasse` int(11) NOT NULL,
  `id_prof` int(11) DEFAULT NULL,
  `id_classe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `profclasse`
--

INSERT INTO `profclasse` (`id_profclasse`, `id_prof`, `id_classe`) VALUES
(1, 1, 2),
(2, 1, 4),
(3, 2, 5),
(4, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `id_prof` int(11) NOT NULL,
  `nomcomplet` varchar(50) DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  `nci` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id_prof`, `nomcomplet`, `grade`, `nci`) VALUES
(1, 'R', 'T', 4),
(2, 'U', 'IO', 7),
(3, 'E', 'R', 3);

-- --------------------------------------------------------

--
-- Structure de la table `rp`
--

CREATE TABLE `rp` (
  `id_rp` int(11) NOT NULL,
  `nomcomplet` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id_classe`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`matricule`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `matricule` (`matricule`),
  ADD KEY `id_classe` (`id_classe`);

--
-- Index pour la table `profclasse`
--
ALTER TABLE `profclasse`
  ADD PRIMARY KEY (`id_profclasse`),
  ADD KEY `id_prof` (`id_prof`),
  ADD KEY `id_classe` (`id_classe`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_prof`);

--
-- Index pour la table `rp`
--
ALTER TABLE `rp`
  ADD PRIMARY KEY (`id_rp`),
  ADD UNIQUE KEY `telephone` (`telephone`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id_classe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=788;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT pour la table `profclasse`
--
ALTER TABLE `profclasse`
  MODIFY `id_profclasse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `id_prof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `rp`
--
ALTER TABLE `rp`
  MODIFY `id_rp` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `id_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `etudiant` (`matricule`);

--
-- Contraintes pour la table `profclasse`
--
ALTER TABLE `profclasse`
  ADD CONSTRAINT `profclasse_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `professeur` (`id_prof`),
  ADD CONSTRAINT `profclasse_ibfk_2` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
