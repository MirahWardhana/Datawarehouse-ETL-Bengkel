/*
SQLyog Professional v12.5.1 (64 bit)
MySQL - 10.4.24-MariaDB-log : Database - db_bengkel_asikgen_otomotif
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_bengkel_asikgen_otomotif` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `db_bengkel_asikgen_otomotif`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `ID_BARANG` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_BARANG` varchar(100) DEFAULT NULL,
  `STOK` int(11) DEFAULT NULL,
  `HARGA_BELI` int(11) DEFAULT NULL,
  `HARGA_JUAL` int(11) DEFAULT NULL,
  `satuan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_BARANG`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `barang` */

insert  into `barang`(`ID_BARANG`,`NAMA_BARANG`,`STOK`,`HARGA_BELI`,`HARGA_JUAL`,`satuan`) values 
(1,'oli',98,30000,38000,'liter'),
(2,'ban dalam',99,20000,25000,'pcs'),
(3,'ban luar',48,150000,170000,'pcs'),
(4,'accu',30,1000000,1050000,'pcs'),
(5,'knalpot',70,200000,250000,'pcs');

/*Table structure for table `cabang` */

DROP TABLE IF EXISTS `cabang`;

CREATE TABLE `cabang` (
  `ID_CABANG` int(11) NOT NULL AUTO_INCREMENT,
  `ALAMAT_CABANG` varchar(100) DEFAULT NULL,
  `TELP_CABANG` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_CABANG`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cabang` */

insert  into `cabang`(`ID_CABANG`,`ALAMAT_CABANG`,`TELP_CABANG`) values 
(1,'Jl.XIII/2A, Nusa Kambangan, Kec. Mertoyudan, Kab Magelang, Jawa Tengah','081239695402');

/*Table structure for table `detail_jual_barang` */

DROP TABLE IF EXISTS `detail_jual_barang`;

CREATE TABLE `detail_jual_barang` (
  `ID_DETAIL_JUAL_BARANG` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PENJUALAN` int(11) DEFAULT NULL,
  `ID_BARANG` int(11) DEFAULT NULL,
  `JUMLAH_BARANG` int(11) DEFAULT NULL,
  `TOTAL_BAYAR_BARANG` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETAIL_JUAL_BARANG`),
  KEY `FK_DETAIL_J_REFERENCE_BARANG` (`ID_BARANG`),
  KEY `FK_DETAIL_J_REFERENCE_PENJUALA` (`ID_PENJUALAN`),
  CONSTRAINT `FK_DETAIL_J_REFERENCE_BARANG` FOREIGN KEY (`ID_BARANG`) REFERENCES `barang` (`ID_BARANG`),
  CONSTRAINT `FK_DETAIL_J_REFERENCE_PENJUALA` FOREIGN KEY (`ID_PENJUALAN`) REFERENCES `penjualan` (`ID_PENJUALAN`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `detail_jual_barang` */

insert  into `detail_jual_barang`(`ID_DETAIL_JUAL_BARANG`,`ID_PENJUALAN`,`ID_BARANG`,`JUMLAH_BARANG`,`TOTAL_BAYAR_BARANG`) values 
(1,14,1,1,100000),
(2,15,1,1,50000);

/*Table structure for table `detail_jual_service` */

DROP TABLE IF EXISTS `detail_jual_service`;

CREATE TABLE `detail_jual_service` (
  `ID_DETAIL_JUAL_SERVICE` int(100) NOT NULL AUTO_INCREMENT,
  `ID_PENJUALAN` int(100) DEFAULT NULL,
  `ID_SERVICE` int(100) DEFAULT NULL,
  `TOTAL_BAYAR_SERVICE` int(100) DEFAULT NULL,
  PRIMARY KEY (`ID_DETAIL_JUAL_SERVICE`),
  KEY `FK_DETAIL_J_REFERENCE_SERVICE` (`ID_SERVICE`),
  KEY `FK_DETAIL_SERVICE+PENJUALAN` (`ID_PENJUALAN`),
  CONSTRAINT `FK_DETAIL+SERVICE` FOREIGN KEY (`ID_SERVICE`) REFERENCES `service` (`ID_SERVICE`),
  CONSTRAINT `FK_DETAIL_SERVICE+PENJUALAN` FOREIGN KEY (`ID_PENJUALAN`) REFERENCES `penjualan` (`ID_PENJUALAN`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `detail_jual_service` */

insert  into `detail_jual_service`(`ID_DETAIL_JUAL_SERVICE`,`ID_PENJUALAN`,`ID_SERVICE`,`TOTAL_BAYAR_SERVICE`) values 
(1,1,1,100000),
(2,2,1,70000),
(3,3,3,80000),
(4,4,1,50000),
(5,5,2,50000),
(6,6,1,75000),
(7,7,3,100000),
(8,8,3,150000),
(9,9,1,70000),
(10,10,2,80000),
(11,11,2,50000),
(12,12,1,50000),
(13,13,3,75000);

/*Table structure for table `detail_supply_barang` */

DROP TABLE IF EXISTS `detail_supply_barang`;

CREATE TABLE `detail_supply_barang` (
  `ID_DETAIL_SUPPLY_BARANG` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SUPPLY_BARANG` int(11) DEFAULT NULL,
  `ID_BARANG` int(11) DEFAULT NULL,
  `JUMLAH_SUPPLY` int(11) DEFAULT NULL,
  `TOTAL_BAYAR_SUPPLY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETAIL_SUPPLY_BARANG`),
  KEY `FK_DETAIL_S_REFERENCE_BARANG` (`ID_BARANG`),
  KEY `FK_DETAIL_S_REFERENCE_SUPPLY_B` (`ID_SUPPLY_BARANG`),
  CONSTRAINT `FK_DETAIL_S_REFERENCE_BARANG` FOREIGN KEY (`ID_BARANG`) REFERENCES `barang` (`ID_BARANG`),
  CONSTRAINT `FK_DETAIL_S_REFERENCE_SUPPLY_B` FOREIGN KEY (`ID_SUPPLY_BARANG`) REFERENCES `supply_barang` (`ID_SUPPLY_BARANG`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `detail_supply_barang` */

insert  into `detail_supply_barang`(`ID_DETAIL_SUPPLY_BARANG`,`ID_SUPPLY_BARANG`,`ID_BARANG`,`JUMLAH_SUPPLY`,`TOTAL_BAYAR_SUPPLY`) values 
(1,1,1,50,1500000),
(2,2,1,50,1500000),
(3,3,2,50,7500000),
(4,4,3,50,1000000);

/*Table structure for table `jenis_service` */

DROP TABLE IF EXISTS `jenis_service`;

CREATE TABLE `jenis_service` (
  `ID_JENIS_SERVICE` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_SERVICE` varchar(100) DEFAULT NULL,
  `HARGA_SERVICE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_JENIS_SERVICE`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `jenis_service` */

insert  into `jenis_service`(`ID_JENIS_SERVICE`,`NAMA_SERVICE`,`HARGA_SERVICE`) values 
(1,'ganti oli',100000),
(2,'ganti ban dalam',70000),
(3,'ganti ban luar',100000),
(4,'ganti knalpot',100000),
(5,'full service',150000);

/*Table structure for table `kasir` */

DROP TABLE IF EXISTS `kasir`;

CREATE TABLE `kasir` (
  `ID_KASIR` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_KASIR` varchar(100) DEFAULT NULL,
  `USERNAME_KASIR` varchar(100) DEFAULT NULL,
  `PASSWORD_KASIR` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_KASIR`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kasir` */

insert  into `kasir`(`ID_KASIR`,`NAMA_KASIR`,`USERNAME_KASIR`,`PASSWORD_KASIR`) values 
(1,'Mirah Wardhana','Mirah','123'),
(2,'Mawar Ningsih','Mawar','123'),
(3,'Tria Nanda','poorteriyaki','123'),
(4,'Dhiandika','Dhiandika','123');

/*Table structure for table `kendaraan` */

DROP TABLE IF EXISTS `kendaraan`;

CREATE TABLE `kendaraan` (
  `ID_KENDARAAN` int(11) NOT NULL AUTO_INCREMENT,
  `NO_POLISI` varchar(10) DEFAULT NULL,
  `MERK_KENDARAAN` varchar(100) DEFAULT NULL,
  `KELUHAN` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_KENDARAAN`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kendaraan` */

insert  into `kendaraan`(`ID_KENDARAAN`,`NO_POLISI`,`MERK_KENDARAAN`,`KELUHAN`) values 
(1,'D536KW','Honda Supra GTR150','mesin rusak'),
(2,'B1110EFY','Honda Scoopy','mogok'),
(3,'AA7268GH','Honda Beat','ban dalam lepas'),
(4,'D3874AA','Honda Vario','ban bocor'),
(5,'H73472KK','Honda Scoopy','ban meledak'),
(6,'P338KK','Honda Beat','ganti saringan'),
(7,'D2776G','PCX','ganti busi'),
(8,'GG28786H','NMax','ganti oli'),
(9,'D87KJ','Vespa ','full service'),
(10,'AA2665J','Honda Scoopy','pasang spion'),
(11,'B728JUG','Supra','ganti accu'),
(12,'B72872HA','Mio','ganti rantai'),
(13,'G82656J','Honda Vario','ganti knalpot'),
(14,'DK235FBF','Ninja','pasang spion'),
(15,'DK765FBF','Scoopy','full service'),
(16,'DK888FBF','PCX','ban bocor'),
(17,'B767K','Scoopy','ganti oli'),
(18,'BP8888F','NMAX','ganti busi');

/*Table structure for table `mekanik` */

DROP TABLE IF EXISTS `mekanik`;

CREATE TABLE `mekanik` (
  `ID_MEKANIK` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_MEKANIK` varchar(100) DEFAULT NULL,
  `ALAMAT_MEKANIK` varchar(100) DEFAULT NULL,
  `TELP_MEKANIK` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`ID_MEKANIK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `mekanik` */

insert  into `mekanik`(`ID_MEKANIK`,`NAMA_MEKANIK`,`ALAMAT_MEKANIK`,`TELP_MEKANIK`) values 
(1,'dadang','blora','083674235457'),
(2,'anton','gunung kidul','085541218659'),
(3,'joni','bojonegoro','089976584537');

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `ID_PELANGGAN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_KENDARAAN` int(11) DEFAULT NULL,
  `NAMA_PELANGGAN` varchar(100) DEFAULT NULL,
  `ALAMAT_PELANGGAN` varchar(100) DEFAULT NULL,
  `NO_TELP_PELANGGAN` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_PELANGGAN`),
  KEY `FK_PELANGGA_REFERENCE_KENDARAA` (`ID_KENDARAAN`),
  CONSTRAINT `FK_PELANGGA_REFERENCE_KENDARAA` FOREIGN KEY (`ID_KENDARAAN`) REFERENCES `kendaraan` (`ID_KENDARAAN`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`ID_PELANGGAN`,`ID_KENDARAAN`,`NAMA_PELANGGAN`,`ALAMAT_PELANGGAN`,`NO_TELP_PELANGGAN`) values 
(1,1,'yanto','bojonggede','084534275436'),
(2,2,'endang','kediri','083565554263'),
(3,3,'juminten','nganjuk','083672537457'),
(4,4,'komariati','blitar','082563532683'),
(5,5,'asep','nusa kambangan','082553562787'),
(6,6,'juki','blitar','082665258738'),
(7,7,'denisa','bantul','089787636524'),
(8,8,'puan','cianjur','082636123515'),
(9,9,'joko','gunung kidul','086256535245'),
(10,10,'marwan','kediri','0827536565235'),
(11,11,'sarminah','blitar','082867363562'),
(12,12,'ekawati','bojongsari','082756534536'),
(13,13,'kumala','cimahi','087256353453'),
(14,14,'Putu','Denpasar','087654565432'),
(15,15,'Kadek','Badung','081243542786'),
(16,16,'Nyoman','Buleleng','083426547876'),
(17,17,'Mirah','Tabanan','083463786287'),
(18,18,'Dikha','Karangasem','087652635187');

/*Table structure for table `penjualan` */

DROP TABLE IF EXISTS `penjualan`;

CREATE TABLE `penjualan` (
  `ID_PENJUALAN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_KASIR` int(11) DEFAULT NULL,
  `ID_PELANGGAN` int(11) DEFAULT NULL,
  `ID_CABANG` int(11) DEFAULT NULL,
  `TANGGAL_PENJUALAN` timestamp NULL DEFAULT NULL,
  `TOTAL_BARANG` int(11) DEFAULT NULL,
  `TOTAL_SERVICE` int(11) DEFAULT NULL,
  `TOTAL_BAYAR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_PENJUALAN`),
  KEY `FK_PENJUALA_REFERENCE_KASIR` (`ID_KASIR`),
  KEY `FK_PENJUALA_REFERENCE_PELANGGA` (`ID_PELANGGAN`),
  KEY `FK_PENJUALA_REFERENCE_CABANG` (`ID_CABANG`),
  CONSTRAINT `FK_PENJUALA_REFERENCE_CABANG` FOREIGN KEY (`ID_CABANG`) REFERENCES `cabang` (`ID_CABANG`),
  CONSTRAINT `FK_PENJUALA_REFERENCE_KASIR` FOREIGN KEY (`ID_KASIR`) REFERENCES `kasir` (`ID_KASIR`),
  CONSTRAINT `FK_PENJUALA_REFERENCE_PELANGGA` FOREIGN KEY (`ID_PELANGGAN`) REFERENCES `pelanggan` (`ID_PELANGGAN`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `penjualan` */

insert  into `penjualan`(`ID_PENJUALAN`,`ID_KASIR`,`ID_PELANGGAN`,`ID_CABANG`,`TANGGAL_PENJUALAN`,`TOTAL_BARANG`,`TOTAL_SERVICE`,`TOTAL_BAYAR`) values 
(4,2,17,1,'2022-12-16 09:24:05',1,1,250000),
(5,1,18,1,'2022-12-17 09:24:42',1,1,300000),
(6,3,19,1,'2022-12-18 09:25:10',1,1,50000);

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `ID_SERVICE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_JENIS_SERVICE` int(11) DEFAULT NULL,
  `ID_MEKANIK` int(11) DEFAULT NULL,
  `ID_KENDARAAN` int(11) DEFAULT NULL,
  `TANGGAL` timestamp NULL DEFAULT NULL,
  `JUMLAH_TOTAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICE`),
  KEY `FK_SERVICE_REFERENCE_JENIS_SE` (`ID_JENIS_SERVICE`),
  KEY `FK_SERVICE_REFERENCE_MEKANIK` (`ID_MEKANIK`),
  KEY `FK_SERVICE_REFERENCE_KENDARAA` (`ID_KENDARAAN`),
  CONSTRAINT `FK_SERVICE_REFERENCE_JENIS_SE` FOREIGN KEY (`ID_JENIS_SERVICE`) REFERENCES `jenis_service` (`ID_JENIS_SERVICE`),
  CONSTRAINT `FK_SERVICE_REFERENCE_KENDARAA` FOREIGN KEY (`ID_KENDARAAN`) REFERENCES `kendaraan` (`ID_KENDARAAN`),
  CONSTRAINT `FK_SERVICE_REFERENCE_MEKANIK` FOREIGN KEY (`ID_MEKANIK`) REFERENCES `mekanik` (`ID_MEKANIK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `service` */

insert  into `service`(`ID_SERVICE`,`ID_JENIS_SERVICE`,`ID_MEKANIK`,`ID_KENDARAAN`,`TANGGAL`,`JUMLAH_TOTAL`) values 
(1,1,1,1,'2022-12-05 05:26:54',1),
(2,2,2,2,'2022-12-06 05:27:23',1),
(3,3,3,3,'2022-12-06 05:27:43',1);

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `ID_SUPPLIER` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_SUPPLIER` varchar(100) DEFAULT NULL,
  `ALAMAT_SUPPLIER` varchar(100) DEFAULT NULL,
  `NO_TELP_SUPPLIER` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_SUPPLIER`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `supplier` */

insert  into `supplier`(`ID_SUPPLIER`,`NAMA_SUPPLIER`,`ALAMAT_SUPPLIER`,`NO_TELP_SUPPLIER`) values 
(1,'jojo siwa','nganjuk, jateng','083564743650'),
(2,'sumarinah','bojonegoro','084365473540'),
(3,'sulastri ningsih','jombang','082643562358'),
(4,'jared leto','blitar','083456324616');

/*Table structure for table `supply_barang` */

DROP TABLE IF EXISTS `supply_barang`;

CREATE TABLE `supply_barang` (
  `ID_SUPPLY_BARANG` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SUPPLIER` int(11) DEFAULT NULL,
  `TANGGAL_SUPPLY` timestamp NULL DEFAULT NULL,
  `TOTAL_RESTOK` int(11) DEFAULT NULL,
  `TOTAL_BAYAR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_SUPPLY_BARANG`),
  KEY `FK_SUPPLY_B_REFERENCE_SUPPLIER` (`ID_SUPPLIER`),
  CONSTRAINT `FK_SUPPLY_B_REFERENCE_SUPPLIER` FOREIGN KEY (`ID_SUPPLIER`) REFERENCES `supplier` (`ID_SUPPLIER`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `supply_barang` */

insert  into `supply_barang`(`ID_SUPPLY_BARANG`,`ID_SUPPLIER`,`TANGGAL_SUPPLY`,`TOTAL_RESTOK`,`TOTAL_BAYAR`) values 
(1,1,'2022-09-01 17:27:42',50,1500000),
(2,2,'2022-09-02 17:29:56',50,1500000),
(3,3,'2022-09-04 17:30:48',50,7500000),
(4,4,'2022-10-02 17:30:57',50,1000000);

/* Trigger structure for table `detail_supply_barang` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_detail_supply_barang` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_detail_supply_barang` AFTER INSERT ON `detail_supply_barang` FOR EACH ROW BEGIN
	update detail_supply_barang
	set TOTAL_BAYAR_SUPPLY=new.jumlah_supply*barang.`HARGA_BELI`
	where id_barang=barang.`ID_BARANG`;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
