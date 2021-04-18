/* script de la base de donnée Compte_bancaire */

CREATE DATABASE compte_bancaire;
use compte_bancaire;


/* creation de table titulaire */


DROP TABLE IF EXISTS `titulaire`;
CREATE TABLE IF NOT EXISTS `titulaire` (
  `CODETITULAIRE` int(4) NOT NULL AUTO_INCREMENT,
  `PRENOMTITULAIRE` varchar(32) NOT NULL,
  `NOMTITULAIRE` varchar(32) NOT NULL,
  `ADRESSETITULAIRE` varchar(32) NOT NULL,
  `CODEPOSTALTITULAIRE` char(5) NOT NULL,
  PRIMARY KEY `CODETITULAIRE` (`CODETITULAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* les insert into titulaire */

/* requête REGEX :      ^([0-9]+)\t([A-z]+)\t([\w]+)\t([\d \w]+)\t([0-9]+)$     */
/* requête replace :    ($1, "$2", "$3", "$4", $5)         */


INSERT INTO `titulaire` (`PRENOMTITULAIRE`, `NOMTITULAIRE`, `ADRESSETITULAIRE`, `CODEPOSTALTITULAIRE`) VALUES
("Noni", "Chadd", "630 Vermont Pass", 93110),
("Ivor", "Barribal", "770 Bayside Park", 93390),
("Dentelle", "Planque", "455 rue Menomonie", 93270),
("Daisi", "Verissimo", "8292 promenade Mccormick", 75016),
("Katrinka", "Pedler", "577 Ruelle Del Sol", 31308),
("Dyanna", "Denidge", "6 rue Bluejay", 95090),
("Gennie", "Arlett", "50371 Golf View Hill", 13003),
("Liv", "Grissett", "0772 Point du sommet", 12908),
("Zlattan", "Danilovic", "2010 Chemin Loftsgordon", 78400),
("Anastasie", "Bleakley", "4742  Traversee de Fulton ", 93370);

/* creation de table typecompte */

DROP TABLE IF EXISTS `typecompte`;
CREATE TABLE IF NOT EXISTS `typecompte` (
  `CODETYPECOMPTE` char(1) NOT NULL,
  `INTITULECOMPTE` varchar(25) NOT NULL,
  PRIMARY KEY `CODETYPECOMPTE` (`CODETYPECOMPTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* les insert into typecompte */

INSERT INTO `typecompte` (`CODETYPECOMPTE`, `INTITULECOMPTE`) VALUES
("C", "Compte Courant"),
("P", "PEL"),
("B", "CEL"),
("L", "LEP"),
("A", "Livret A"),
("J", "Livret Jeune"),
("D", "LDDS"),
("E", "PEA");


/* creation de table compte */

/* le "on delete cascade" permet la suppression de données d'une table alors qu'elle est liée à une autre table par une clè étrangère ==>  ça engendre la suupressio des données de l'autre table aussi pas cascade 
 exemple: si une table building et table room; si je supprime un building ça supprime par cascade toutes les rooms liées à ce building*/

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `NUMEROCOMPTE` int(5) NOT NULL AUTO_INCREMENT,
  `CODETYPECOMPTE` char(1) NOT NULL,
  `CODETITULAIRE` int(4) NOT NULL,
  `SOLDECOMPTE` float(10,2) NOT NULL,
  PRIMARY KEY `NUMEROCOMPTE` (`NUMEROCOMPTE`),
  CONSTRAINT FOREIGN KEY (`CODETYPECOMPTE`) REFERENCES `typecompte` (`CODETYPECOMPTE`) ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`CODETITULAIRE`) REFERENCES `titulaire` (`CODETITULAIRE`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* les insert into compte */

INSERT INTO `compte` (`NUMEROCOMPTE`, `CODETYPECOMPTE`, `CODETITULAIRE`, `SOLDECOMPTE`) VALUES
(10001, "C", 1, 500.43),
(10002, "C", 2, 120.04),
(10003, "B", 3, 2000.65),
(10004, "L", 4, 355),
(10005, "A", 5, 503),
(10006, "J", 6, 790.78),
(10007, "D", 7, 250.07),
(10008, "E", 8, 3000),
(10009, "P", 9, 50000),
(10010, "A", 10, 2930);


/* creation de table operations */

DROP TABLE IF EXISTS `operations`;
CREATE TABLE IF NOT EXISTS `operations` (
  `NUMEROOPERATION` int(11) NOT NULL AUTO_INCREMENT,
  `NUMEROCOMPTE` int(5) NOT NULL,
  `DATEOPERATION` date NOT NULL,
  `LIBELLEOPERATION` varchar(32) NOT NULL,
  `MONTANT` float(10,2) NOT NULL,
  `TYPEOPERATION` char(15) NOT NULL,
  PRIMARY KEY `NUMEROOPERATION` (`NUMEROOPERATION`),
  CONSTRAINT FOREIGN KEY (`NUMEROCOMPTE`) REFERENCES `compte` (`NUMEROCOMPTE`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* les insert into operations */

INSERT INTO `operations` (`NUMEROCOMPTE`, `DATEOPERATION`, `LIBELLEOPERATION`, `MONTANT`, `TYPEOPERATION`) VALUES
(10001, "2020-02-11", "Virement", 50.43, "V"),
(10002, "2020-01-01", "Prélèvement", 10.04, "P"),
(10003, "2020-12-02", "Prélèvement", 20.65, "P"),
(10004, "2020-06-03", "Virement", 55, "V"),
(10005, "2020-02-10", "Prélèvement", 53, "P"),
(10006, "2020-10-02", "Retrait", 800, "R"),
(10007, "2020-04-12", "Retrait", 20, "R"),
(10008, "2020-02-07", "Dépôt", 40, "D"),
(10009, "2020-01-12", "Virement", 500, "V"),
(10010, "2020-02-01", "Virement", 2930, "V");








