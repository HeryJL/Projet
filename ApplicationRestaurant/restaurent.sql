-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 28 août 2024 à 11:51
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP :  7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `restaurent`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `id_tables` int(11) NOT NULL,
  `date_commande` datetime NOT NULL,
  `etat_commande` enum('en attente','servie','paye','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `id_tables`, `date_commande`, `etat_commande`) VALUES
(8, 1, '2024-08-27 13:36:40', 'paye'),
(9, 1, '2024-08-27 18:30:51', 'paye'),
(10, 1, '2024-08-27 18:53:29', 'paye'),
(11, 1, '2024-08-27 18:55:04', 'paye'),
(12, 1, '2024-08-27 18:57:07', 'paye'),
(13, 1, '2024-08-27 19:00:24', 'paye'),
(14, 1, '2024-08-27 19:01:08', 'paye'),
(15, 4, '2024-08-27 19:04:14', 'paye'),
(16, 1, '2024-08-27 20:06:10', 'paye'),
(17, 1, '2024-08-27 20:08:27', 'paye'),
(18, 1, '2024-08-27 20:17:52', 'paye'),
(19, 2, '2024-08-28 10:43:24', 'en attente'),
(20, 1, '2024-08-28 10:43:31', 'en attente');

-- --------------------------------------------------------

--
-- Structure de la table `detailcomande`
--

CREATE TABLE `detailcomande` (
  `id` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `detailcomande`
--

INSERT INTO `detailcomande` (`id`, `id_commande`, `id_menu`, `quantite`, `prix_total`) VALUES
(35, 8, 1, 2, 6000),
(36, 9, 3, 1, 15000),
(37, 11, 1, 1, 3000),
(38, 12, 1, 1, 3000),
(39, 13, 1, 1, 3000),
(40, 14, 2, 48, 144000),
(41, 16, 3, 48, 720000),
(42, 17, 4, 44, 66000),
(43, 18, 1, 4, 12000),
(44, 18, 2, 2, 6000),
(45, 18, 1, 2, 6000),
(46, 20, 1, 34, 12000),
(47, 20, 2, 5, 15000),
(48, 20, 2, 4, 12000);

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE `menu` (
  `id` int(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix` int(20) NOT NULL,
  `disponibilite` int(10) NOT NULL,
  `photo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `menu`
--

INSERT INTO `menu` (`id`, `nom`, `prix`, `disponibilite`, `photo`) VALUES
(1, 'soupe garnie', 3000, 0, 'p.png'),
(2, 'soupe chinoise', 3000, 29, 'andrana2.jpg'),
(3, 'jungoli de boji', 15000, 40, 'andrana3.jpg'),
(4, 'cafard au choco', 1500, 40, 'andrana4.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `payement`
--

CREATE TABLE `payement` (
  `id` int(10) NOT NULL,
  `id_commande` int(10) NOT NULL,
  `montant` int(50) NOT NULL,
  `date_payement` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `payement`
--

INSERT INTO `payement` (`id`, `id_commande`, `montant`, `date_payement`) VALUES
(1, 14, 144000, '2024-08-27 19:01:21'),
(3, 16, 720000, '2024-08-27 20:08:24'),
(4, 17, 66000, '2024-08-27 20:10:07'),
(5, 18, 24000, '2024-08-28 10:42:25');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE `stock` (
  `id` int(10) NOT NULL,
  `ingredient` varchar(100) NOT NULL,
  `quantite` int(10) NOT NULL,
  `quantite_min` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `tables`
--

CREATE TABLE `tables` (
  `id` int(20) NOT NULL,
  `numero` int(20) NOT NULL,
  `etat` enum('libre','occuper') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tables`
--

INSERT INTO `tables` (`id`, `numero`, `etat`) VALUES
(1, 1, 'occuper'),
(2, 2, 'occuper'),
(3, 3, 'libre'),
(4, 4, 'libre');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `detailcomande`
--
ALTER TABLE `detailcomande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `payement`
--
ALTER TABLE `payement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `detailcomande`
--
ALTER TABLE `detailcomande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT pour la table `payement`
--
ALTER TABLE `payement`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `tables`
--
ALTER TABLE `tables`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
