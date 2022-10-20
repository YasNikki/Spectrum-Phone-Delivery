-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.25-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para spectrum_hb
CREATE DATABASE IF NOT EXISTS `spectrum_hb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `spectrum_hb`;

-- Copiando estrutura para tabela spectrum_hb.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(38) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `endereco` varchar(51) NOT NULL,
  PRIMARY KEY (`id_cliente`,`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela spectrum_hb.clientes: ~0 rows (aproximadamente)

-- Copiando estrutura para tabela spectrum_hb.estoque
CREATE TABLE IF NOT EXISTS `estoque` (
  `id_ingrediente` int(11) NOT NULL AUTO_INCREMENT,
  `ingrediente` varchar(15) DEFAULT NULL,
  `quantidade` int(6) DEFAULT NULL,
  PRIMARY KEY (`id_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela spectrum_hb.estoque: ~13 rows (aproximadamente)
INSERT INTO `estoque` (`id_ingrediente`, `ingrediente`, `quantidade`) VALUES
	(1, 'Carne', 150),
	(2, 'Alface', 130),
	(3, 'Tomate', 150),
	(4, 'Cheddar', 120),
	(5, 'Pao', 220),
	(7, 'agua', 70),
	(8, 'coca-cola', 60),
	(9, 'fanta', 40),
	(10, 'suco', 30),
	(11, 'molho', 80),
	(12, 'bacon', 90),
	(13, 'cebola', 110),
	(14, 'calabresa', 85);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
