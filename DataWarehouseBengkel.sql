/*
SQLyog Professional v12.5.1 (64 bit)
MySQL - 10.4.24-MariaDB-log : Database - datawarehouse_bengkel_asikgen_otomotif
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`datawarehouse_bengkel_asikgen_otomotif` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `datawarehouse_bengkel_asikgen_otomotif`;

/*Table structure for table `dimensi_barang` */

DROP TABLE IF EXISTS `dimensi_barang`;

CREATE TABLE `dimensi_barang` (
  `ID_BARANG` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_BARANG` varchar(100) DEFAULT NULL,
  `HARGA_JUAL` int(11) DEFAULT NULL,
  `HARGA_BELI` int(11) DEFAULT NULL,
  `STOK_BARANG` int(11) DEFAULT NULL,
  `satuan` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_BARANG`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `dimensi_barang` */

insert  into `dimensi_barang`(`ID_BARANG`,`NAMA_BARANG`,`HARGA_JUAL`,`HARGA_BELI`,`STOK_BARANG`,`satuan`) values 
(1,'oli',30000,38000,98,'liter'),
(2,'oli',30000,38000,98,'liter'),
(3,'ban dalam',20000,25000,99,'pcs'),
(4,'ban dalam',20000,25000,99,'pcs'),
(5,'ban dalam',20000,25000,99,'pcs'),
(6,'ban dalam',20000,25000,99,'pcs'),
(7,'ban dalam',20000,25000,99,'pcs'),
(8,'ban luar',150000,170000,48,'pcs'),
(9,'ban luar',150000,170000,48,'pcs'),
(10,'accu',1000000,1050000,30,'pcs'),
(11,'accu',1000000,1050000,30,'pcs'),
(12,'knalpot',200000,250000,70,'pcs'),
(13,'knalpot',200000,250000,70,'pcs');

/*Table structure for table `dimensi_cabang` */

DROP TABLE IF EXISTS `dimensi_cabang`;

CREATE TABLE `dimensi_cabang` (
  `ID_CABANG` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_CABANG` varchar(100) DEFAULT NULL,
  `ALAMAT_CABANG` varchar(100) DEFAULT NULL,
  `TELP_CABANG` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_CABANG`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

/*Data for the table `dimensi_cabang` */

insert  into `dimensi_cabang`(`ID_CABANG`,`NAMA_CABANG`,`ALAMAT_CABANG`,`TELP_CABANG`) values 
(1,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(2,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(3,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(4,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(5,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(6,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(7,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(8,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(9,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(10,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(11,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(12,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(13,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(14,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(15,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(16,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(17,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(18,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(19,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(20,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(21,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402'),
(22,'1','Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402');

/*Table structure for table `dimensi_mekanik` */

DROP TABLE IF EXISTS `dimensi_mekanik`;

CREATE TABLE `dimensi_mekanik` (
  `ID_MEKANIK` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_MEKANIK` varchar(100) DEFAULT NULL,
  `TELP_MEKANIK` varchar(15) DEFAULT NULL,
  `ALAMAT_MEKANIK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_MEKANIK`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

/*Data for the table `dimensi_mekanik` */

insert  into `dimensi_mekanik`(`ID_MEKANIK`,`NAMA_MEKANIK`,`TELP_MEKANIK`,`ALAMAT_MEKANIK`) values 
(1,'dadang','083674235457','blora'),
(2,'dadang','083674235457','blora'),
(3,'joni','089976584537','bojonegoro'),
(4,'dadang','083674235457','blora'),
(5,'anton','085541218659','gunung kidul'),
(6,'dadang','083674235457','blora'),
(7,'joni','089976584537','bojonegoro'),
(8,'joni','089976584537','bojonegoro'),
(9,'dadang','083674235457','blora'),
(10,'anton','085541218659','gunung kidul'),
(11,'anton','085541218659','gunung kidul'),
(12,'dadang','083674235457','blora'),
(13,'joni','089976584537','bojonegoro'),
(14,'dadang','083674235457','blora'),
(15,'dadang','083674235457','blora'),
(16,'joni','089976584537','bojonegoro'),
(17,'dadang','083674235457','blora'),
(18,'dadang','083674235457','blora'),
(19,'anton','085541218659','gunung kidul'),
(20,'dadang','083674235457','blora'),
(21,'dadang','083674235457','blora'),
(22,'anton','085541218659','gunung kidul');

/*Table structure for table `dimensi_pelanggan` */

DROP TABLE IF EXISTS `dimensi_pelanggan`;

CREATE TABLE `dimensi_pelanggan` (
  `ID_PELANGGAN` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_PELANGGAN` varchar(100) DEFAULT NULL,
  `TELP_PELANGGAN` varchar(100) DEFAULT NULL,
  `ALAMAT_PELANGGAN` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_PELANGGAN`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `dimensi_pelanggan` */

insert  into `dimensi_pelanggan`(`ID_PELANGGAN`,`NAMA_PELANGGAN`,`TELP_PELANGGAN`,`ALAMAT_PELANGGAN`) values 
(1,'yanto','084534275436','bojonggede'),
(2,'endang','083565554263','kediri'),
(3,'juminten','083672537457','nganjuk'),
(4,'komariati','082563532683','blitar'),
(5,'asep','082553562787','nusa kambangan'),
(6,'juki','082665258738','blitar'),
(7,'denisa','089787636524','bantul'),
(8,'puan','082636123515','cianjur'),
(9,'joko','086256535245','gunung kidul'),
(10,'marwan','0827536565235','kediri'),
(11,'sarminah','082867363562','blitar'),
(12,'ekawati','082756534536','bojongsari'),
(13,'kumala','087256353453','cimahi'),
(14,'Putu','087654565432','Denpasar'),
(15,'Kadek','081243542786','Badung'),
(16,'Nyoman','083426547876','Buleleng'),
(17,'Mirah','083463786287','Tabanan'),
(18,'Dikha','087652635187','Karangasem'),
(19,'Mirah','083463786287','Tabanan'),
(20,'Dikha','087652635187','Karangasem');

/*Table structure for table `dimensi_service` */

DROP TABLE IF EXISTS `dimensi_service`;

CREATE TABLE `dimensi_service` (
  `ID_SERVICE` int(11) NOT NULL AUTO_INCREMENT,
  `JENIS_SERVICE` varchar(100) DEFAULT NULL,
  `HARGA_SERVICE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICE`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

/*Data for the table `dimensi_service` */

insert  into `dimensi_service`(`ID_SERVICE`,`JENIS_SERVICE`,`HARGA_SERVICE`) values 
(1,'ganti oli',100000),
(2,'ganti oli',100000),
(3,'ganti ban luar',100000),
(4,'ganti oli',100000),
(5,'ganti ban dalam',70000),
(6,'ganti oli',100000),
(7,'ganti ban luar',100000),
(8,'ganti ban luar',100000),
(9,'ganti oli',100000),
(10,'ganti ban dalam',70000),
(11,'ganti ban dalam',70000),
(12,'ganti oli',100000),
(13,'ganti ban luar',100000),
(14,'ganti oli',100000),
(15,'ganti oli',100000),
(16,'ganti ban luar',100000),
(17,'ganti ban dalam',70000),
(18,'ganti oli',100000),
(19,'ganti oli',100000),
(20,'ganti ban dalam',70000),
(21,'ganti oli',100000),
(22,'ganti oli',100000);

/*Table structure for table `dimensi_waktu` */

DROP TABLE IF EXISTS `dimensi_waktu`;

CREATE TABLE `dimensi_waktu` (
  `ID_WAKTU` int(11) NOT NULL AUTO_INCREMENT,
  `TAHUN` int(11) DEFAULT NULL,
  `BULAN` int(11) DEFAULT NULL,
  `TANGGAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_WAKTU`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `dimensi_waktu` */

insert  into `dimensi_waktu`(`ID_WAKTU`,`TAHUN`,`BULAN`,`TANGGAL`) values 
(1,2022,12,21),
(2,2022,12,21),
(3,2022,12,21),
(4,2022,12,21),
(5,2022,12,21);

/*Table structure for table `fakta_penjualan` */

DROP TABLE IF EXISTS `fakta_penjualan`;

CREATE TABLE `fakta_penjualan` (
  `ID_FAKTA_PENJUALAN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PELANGGAN` int(11) DEFAULT NULL,
  `ID_MEKANIK` int(11) DEFAULT NULL,
  `ID_WAKTU` int(11) DEFAULT NULL,
  `ID_BARANG` int(11) DEFAULT NULL,
  `ID_SERVICE` int(11) DEFAULT NULL,
  `ID_CABANG` int(11) DEFAULT NULL,
  `JUMLAH_SERVICE` int(11) DEFAULT NULL,
  `JUMLAH_BARANG` int(11) DEFAULT NULL,
  `TOTAL_PENJUALAN` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_FAKTA_PENJUALAN`),
  KEY `FK_FAKTA_PE_REFERENCE_DIMENSI_` (`ID_PELANGGAN`),
  KEY `ID_MEKANIK` (`ID_MEKANIK`),
  KEY `ID_SERVICE` (`ID_SERVICE`),
  KEY `ID_WAKTU` (`ID_WAKTU`),
  KEY `ID_CABANG` (`ID_CABANG`),
  CONSTRAINT `FK_FAKTA_PE_REFERENCE_DIMENSI_` FOREIGN KEY (`ID_PELANGGAN`) REFERENCES `dimensi_pelanggan` (`ID_PELANGGAN`),
  CONSTRAINT `fakta_penjualan_ibfk_1` FOREIGN KEY (`ID_MEKANIK`) REFERENCES `dimensi_mekanik` (`ID_MEKANIK`),
  CONSTRAINT `fakta_penjualan_ibfk_2` FOREIGN KEY (`ID_SERVICE`) REFERENCES `dimensi_service` (`ID_SERVICE`),
  CONSTRAINT `fakta_penjualan_ibfk_3` FOREIGN KEY (`ID_WAKTU`) REFERENCES `dimensi_waktu` (`ID_WAKTU`),
  CONSTRAINT `fakta_penjualan_ibfk_4` FOREIGN KEY (`ID_CABANG`) REFERENCES `dimensi_cabang` (`ID_CABANG`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Data for the table `fakta_penjualan` */

insert  into `fakta_penjualan`(`ID_FAKTA_PENJUALAN`,`ID_PELANGGAN`,`ID_MEKANIK`,`ID_WAKTU`,`ID_BARANG`,`ID_SERVICE`,`ID_CABANG`,`JUMLAH_SERVICE`,`JUMLAH_BARANG`,`TOTAL_PENJUALAN`) values 
(1,1,1,1,1,1,1,13,15,NULL),
(2,2,2,1,1,1,1,13,15,NULL),
(3,3,3,1,3,3,1,13,15,NULL),
(4,3,3,1,3,3,1,13,15,NULL),
(5,4,4,1,1,1,1,13,15,NULL),
(6,5,5,1,2,2,1,13,15,NULL),
(7,6,6,1,1,1,1,13,15,NULL),
(8,7,7,1,3,3,1,13,15,NULL),
(9,8,8,1,3,3,1,13,15,NULL),
(10,9,9,1,1,1,1,13,15,NULL),
(11,10,10,1,2,2,1,13,15,NULL),
(12,11,11,1,2,2,1,13,15,NULL),
(13,12,12,1,1,1,1,13,15,NULL),
(14,13,13,1,3,3,1,13,15,NULL),
(15,1,14,3,1,1,1,13,3,NULL),
(16,2,15,3,1,1,1,13,3,NULL),
(17,3,16,3,3,3,1,13,3,NULL),
(18,4,17,4,1,1,1,13,3,NULL),
(19,5,18,4,2,2,1,13,3,NULL),
(20,4,17,5,1,1,1,13,3,NULL),
(21,5,18,5,2,2,1,13,3,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
