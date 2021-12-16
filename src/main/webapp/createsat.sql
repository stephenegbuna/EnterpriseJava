set sql_notes=0;

CREATE DATABASE IF NOT EXISTS sat;
use sat; 
-- --------------------------------------------------------

DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `supplier`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `department`;
DROP TABLE IF EXISTS `prospect`;
DROP TABLE IF EXISTS `salgrade`;
-- 
-- Table structure for table `customer`
-- 
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_nr` smallint(6) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `initials` char(6) NOT NULL,
  `street` varchar(25) default NULL,
  `town` varchar(25) default NULL,
  `county` varchar(15) default NULL,
  `post_code` char(8) default NULL,
  `telephone` varchar(15) default NULL,
  `credit_limit` decimal(6,2) default NULL,
  PRIMARY KEY  (`customer_nr`)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `customer`
-- 

INSERT INTO `customer` (`customer_nr`, `surname`, `initials`, `street`, `town`, `county`, `post_code`, `telephone`, `credit_limit`) VALUES (1317, 'Williams', 'R.', '15, London Road', 'Manchester', NULL, 'M13 6TR', '0161 254 1094', 1000.00),
(1087, 'Knight', 'M.B.', '23, Highbury Street', 'London', NULL, 'NW12 7FC', '020 8905 6127', 500.00),
(1019, 'Jameson', 'N.H.B.', '12-14, Turner Road', 'Dudley', 'W.Midlands', 'B13 4DE', '0161 912 3305', 1250.00),
(1543, 'McDonald', 'S.W.', '102, Feltham Court', 'Croydon', 'Surrey', 'CR8 7GH', '01314 267209', 1500.00),
(1822, 'Jones', 'W.J.', '16, Alloa Crescent', 'Birmingham', NULL, 'B5 6HH', '0121 234 8123', 1000.00),
(1036, 'Blake', 'S.T.', '67, Victoria Place', 'London', NULL, 'SW4 9TR', '020 7210 3156', 750.00),
(1443, 'Smith', 'T.', '22, Gresham Court', 'Wivenhoe', 'Essex', 'CO15 7VD', '01206 872090', 750.00),
(1980, 'Green', 'L.M.', '45, Leeds Road', 'London', NULL, 'W6 9HG', '020 7710 1027', 1250.00),
(1674, 'Jones', 'W.J.', '90, Carter Street', 'Manchester', NULL, 'M15 8FD', '0161 205 2206', 1500.00),
(1223, 'Brown', 'K.', '5, Windmill Place', 'Truro', 'Cornwall', 'TR4 2VX', '01857 511089', 500.00);

-- --------------------------------------------------------

-- 
-- Table structure for table `department`
-- 

CREATE TABLE IF NOT EXISTS `department` (
  `department_nr` smallint(2) NOT NULL,
  `name` varchar(10) NOT NULL,
  `location` varchar(15) NOT NULL,
  PRIMARY KEY  (`department_nr`)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `department`
-- 

INSERT INTO `department` (`department_nr`, `name`, `location`) VALUES (10, 'Accounts', 'Birmingham'),
(20, 'Research', 'Glasgow'),
(30, 'Sales', 'Manchester'),
(40, 'Operations', 'Birmingham');

-- --------------------------------------------------------

-- 
-- Table structure for table `employee`
-- 

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_nr` smallint(6) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `initials` char(6) default NULL,
  `sex` char(1) NOT NULL,
  `start_date` date NOT NULL,
  `job` varchar(15) NOT NULL,
  `manager` smallint(6) default NULL,
  `salary` decimal(6,2) NOT NULL,
  `department_nr` smallint(2),
  PRIMARY KEY  (`employee_nr`),
  FOREIGN KEY `emp_fkey` (`department_nr`) REFERENCES department(department_nr)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `employee`
-- 

INSERT INTO `employee` (`employee_nr`, `surname`, `initials`, `sex`, `start_date`, `job`, `manager`, `salary`, `department_nr`) 
VALUES 
(1000, 'King', 'J.R.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 2257 DAY), 'Chairman', NULL, 5000.00, 10),
(1036, 'Blake', 'S.T.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 1257 DAY), 'Manager', 1000, 2850.00, 30),
(1023, 'Clark', 'M.', 'F', SUBDATE(CURRENT_DATE(), INTERVAL 1057 DAY), 'Manager', 1000, 2450.00, 10),
(1024, 'Jones', 'D.S.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 1117 DAY), 'Manager', 1000, 2975.00, 20),
(1035, 'Martin', 'R.J.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 257 DAY), 'Salesman', 1036, 1250.00, 30),
(1033, 'Allen', 'P.G.', 'F', SUBDATE(CURRENT_DATE(), INTERVAL 1207 DAY), 'Salesman', 1023, 2000.00, 10),
(1007, 'Turner', 'J.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 125 DAY), 'Salesman', 1036, 1500.00, 30),
(1019, 'Jameson', 'N.H.B.', 'F', SUBDATE(CURRENT_DATE(), INTERVAL 57 DAY), 'Clerk', 1036, 950.00, 30),
(1013, 'Ward', 'K.T.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 25 DAY), 'Salesman', 1024, 1250.00, 20),
(1026, 'Ford', NULL, 'M', SUBDATE(CURRENT_DATE(), INTERVAL 1221 DAY), 'Analyst', 1023, 3000.00, 10),
(1029, 'Smith', 'J.', 'M', SUBDATE(CURRENT_DATE(), INTERVAL 15  DAY), 'Clerk', 1036, 800.00, 30),
(1022, 'Scott', 'B.L.', 'F', SUBDATE(CURRENT_DATE(), INTERVAL 125  DAY), 'Analyst', 1024, 3000.00, 20),
(1017, 'Adams', 'G.D.C', 'F', SUBDATE(CURRENT_DATE(), INTERVAL 457 DAY), 'Clerk', 1023, 1100.00, 10),
(1030, 'Miller', NULL, 'F', SUBDATE(CURRENT_DATE(), INTERVAL 657 DAY), 'Clerk', 1024, 1300.00, NULL);

-- --------------------------------------------------------

-- 
-- Table structure for table `prospect`
-- 

CREATE TABLE IF NOT EXISTS `prospect` (
  `prospect_nr` smallint(6) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `initials` char(6) NOT NULL,
  `street` varchar(25) default NULL,
  `town` varchar(25) default NULL,
  `county` varchar(15) default NULL,
  `post_code` char(8) default NULL,
  `telephone` varchar(15) default NULL,
  `credit_rating` smallint(2) NOT NULL,
  PRIMARY KEY  (`prospect_nr`)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `prospect`
-- 

INSERT INTO `prospect` (`prospect_nr`, `surname`, `initials`, `street`, `town`, `county`, `post_code`, `telephone`, `credit_rating`) VALUES (1, 'Lamb', 'R.J.', '15, London Road', 'Manchester', NULL, 'M13 6TR', '0161 254 1094', 10),
(2, 'Knight', 'M.B.', '23, Highbury Street', 'London', NULL, 'NW12 7FC', '020 8905 6127', 5),
(3, 'Jameson', 'N.H.B.', '12-14, Turner Road', 'Dudley', 'W.Midlands', 'B13 4DE', '0161 912 3305', 10),
(4, 'Hendrix', 'J.', '102, Feltham Court', 'Croydon', 'Surrey', 'CR8 7GH', '01314 267209', 15),
(5, 'Jones', 'L.R.', '16, Alloa Crescent', 'Birmingham', NULL, 'B5 6HH', '0121 234 8123', 10),
(6, 'Smith', 'M.', '67, Victoria Place', 'London', NULL, 'SW4 9TR', '020 7210 3156', 7),
(7, 'Smith', 'T.', '22, Gresham Court', 'Wivenhoe', 'Essex', 'CO15 7VD', '01206 872090', 7),
(8, 'White', 'K.R.', '45, Leeds Road', 'London', NULL, 'W6 9HG', '020 7710 1027', 10),
(9, 'Jones', 'W.J.', '90, Carter Street', 'Manchester', NULL, 'M15 8FD', '0161 205 2206', 15),
(10, 'Botham', 'S.P.', '5, Windmill Place', 'Truro', 'Cornwall', 'TR4 2VX', '01857 511089', 5),
(11, 'Williams', 'R.', '15, London Road', 'Manchester', NULL, 'M13 6TR', '0161 254 1094', 10),
(12, 'Watkins', 'D.R.L.', '23, Highbury Street', 'London', NULL, 'NW12 7FC', '020 8905 6127', 5),
(13, 'Fford', 'H.C.C.', '12-14, Turner Road', 'Dudley', 'W.Midlands', 'B13 4DE', '0161 912 3305', 10),
(14, 'McDonald', 'S.W.', '102, Feltham Court', 'Croydon', 'Surrey', 'CR8 7GH', '01314 267209', 15),
(15, 'Jones', 'P.', '16, Alloa Crescent', 'Birmingham', NULL, 'B5 6HH', '0121 234 8123', 10),
(16, 'Blake', 'S.T.', '67, Victoria Place', 'London', NULL, 'SW4 9TR', '020 7210 3156', 7),
(17, 'Allen', 'B.C.', '22, Gresham Court', 'Wivenhoe', 'Essex', 'CO15 7VD', '01206 872090', 7),
(18, 'Green', 'L.M.', '45, Leeds Road', 'London', NULL, 'W6 9HG', '020 7710 1027', 12),
(19, 'Middleton', 'S.', '90, Carter Street', 'Manchester', NULL, 'M15 8FD', '0161 205 2206', 15),
(20, 'Brown', 'K.', '5, Windmill Place', 'Truro', 'Cornwall', 'TR4 2VX', '01857 511089', 5),
(21, 'Channon', 'M.', '124, Causton Road', 'Ipswich', 'Suffolk', 'IP3 6FD', '01420 340912', 7);

-- --------------------------------------------------------

-- 
-- Table structure for table `salgrade`
-- 

CREATE TABLE IF NOT EXISTS `salgrade` (
  `grade` smallint(2) NOT NULL,
  `low_salary` decimal(6,2) NOT NULL,
  `high_salary` decimal(6,2) NOT NULL
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `salgrade`
-- 

INSERT INTO `salgrade` (`grade`, `low_salary`, `high_salary`) VALUES (1, 700.00, 1200.00),
(2, 1201.00, 1400.00),
(3, 1401.00, 2000.00),
(4, 2001.00, 3000.00),
(5, 3001.00, 9999.00);

-- --------------------------------------------------------

-- 
-- Table structure for table `supplier`
-- 

CREATE TABLE IF NOT EXISTS `supplier` (
  `supplier_nr` smallint(6) NOT NULL,
  `name` varchar(30) NOT NULL,
  `street` varchar(25) default NULL,
  `town` varchar(25) default NULL,
  `county` varchar(15) default NULL,
  `post_code` char(8) default NULL,
  `telephone` varchar(15) default NULL,
  PRIMARY KEY  (`supplier_nr`)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `supplier`
-- 

INSERT INTO `supplier` (`supplier_nr`, `name`, `street`, `town`, `county`, `post_code`, `telephone`) VALUES (1034, 'Ace Software Ltd.', '24, Dudley Road', 'Birmingham', NULL, 'B10 4JK', '0121 356 7885'),
(1060, 'Computer City Ltd.', '9, Highfield Court', 'London', NULL, 'N19 2RD', '020 8556 2045'),
(1005, 'The Hardware Shop', '23-25, High Street', 'Colchester', 'Essex', 'CO7 5LM', '01206 308985'),
(1196, 'London Computers Ltd.', '143, Merchants Road', 'London', NULL, 'W4 7GH', NULL),
(1078, 'PC Universe Ltd.', '27, Coventry Road', 'Bristol', 'Avon', 'BR2 6HS', '01222 108873'),
(1045, 'K. Brown', 'CompuHouse, High Street', 'Brighton', 'Sussex', 'BT5 9UK', '01239 235666');

-- 
-- Table structure for table `product`
-- 

CREATE TABLE IF NOT EXISTS `product` (
  `product_code` char(10) NOT NULL,
  `description` varchar(30) NOT NULL,
  `supplier_nr` smallint(6) NOT NULL,
  `cost_price` decimal(6,2) default NULL,
  `sales_price` decimal(6,2) default NULL,
  `instock` smallint(5) default NULL,
  PRIMARY KEY  (`product_code`),
  FOREIGN KEY `prod_fkey` (`supplier_nr`) references supplier(supplier_nr)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `product`
-- 

INSERT INTO `product` (`product_code`, `description`, `supplier_nr`, `cost_price`, `sales_price`, `instock`) VALUES ('MW97', 'MicroWare Office 97', 1034, 230.00, 305.00, 450),
('FD35', 'PCK 1.44Mb Floppy Drive', 1060, 25.00, 35.00, 206),
('TX10', 'TrailBLaser Printer X10', 1196, 440.00, 510.00, 124),
('AM17', 'Activan 17" Monitor', 1196, 450.00, 605.00, 20),
('HD12', '1.2GB Hard Disk Drive', 1005, 198.00, 204.00, 230),
('DS96', 'DataStore DBMS 96', 1060, 420.00, 525.00, 100),
('GD2', 'Graphix Draw 2.0', 1034, 120.00, 165.00, 203),
('XM21', 'XVision 21" Monitor', 1196, 512.00, 712.00, 26),
('ASM2', 'Activan SuperMouse 2', 1005, 24.00, 35.00, 105);

-- --------------------------------------------------------

-- 
-- Table structure for table `orders`
-- 

CREATE TABLE IF NOT EXISTS `orders` (
  `order_nr` smallint(6) NOT NULL,
  `product_code` char(10) NOT NULL,
  `customer_nr` smallint(6) NOT NULL,
  `order_date` datetime default NULL,
  `quantity` smallint(4) NOT NULL,
  PRIMARY KEY  (`order_nr`),
  FOREIGN KEY `ord_fkey_cust` (`customer_nr`) REFERENCES customer(customer_nr),
  FOREIGN KEY `ord_fkey_prod` (`product_code`) REFERENCES product(product_code)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `orders`
-- 
INSERT INTO orders VALUES 
(1000,'MW97',1317,SUBDATE(NOW(), INTERVAL 570 DAY),100),
(1001,'HD12',1674,SUBDATE(NOW(), INTERVAL 529 DAY),5),
(1002,'DS96',1443,SUBDATE(NOW(), INTERVAL 524 DAY),150),
(1003,'MW97',1674,SUBDATE(NOW(), INTERVAL 466 DAY),75),
(1004,'HD12',1317,SUBDATE(NOW(), INTERVAL 442 DAY),5),
(1005,'MW97',1543,SUBDATE(NOW(), INTERVAL 440 DAY),100),
(1006,'TX10',1087,SUBDATE(NOW(), INTERVAL 394 DAY),25),
(1007,'AM17',1019,SUBDATE(NOW(), INTERVAL 366 DAY),5),
(1008,'XM21',1674,SUBDATE(NOW(), INTERVAL 334 DAY),10),
(1009,'HD12',1223,SUBDATE(NOW(), INTERVAL 291 DAY),125),
(1010,'GD2', 1036,SUBDATE(NOW(), INTERVAL 257 DAY),100),
(1011,'DS96',1674,SUBDATE(NOW(), INTERVAL 257 DAY),50),
(1012,'TX10',1036,SUBDATE(NOW(), INTERVAL 224 DAY),5),
(1013,'MW97',1223,SUBDATE(NOW(), INTERVAL 207 DAY),10),
(1014,'HD12',1036,SUBDATE(NOW(), INTERVAL 197 DAY),100),
(1015,'AM17',1443,SUBDATE(NOW(), INTERVAL 169 DAY),50),
(1016,'DS96',1317,SUBDATE(NOW(), INTERVAL 162 DAY),25),
(1017,'HD12',1543,SUBDATE(NOW(), INTERVAL 128 DAY),10),
(1018,'GD2', 1443,SUBDATE(NOW(), INTERVAL 110 DAY),5),
(1019,'MW97',1019,SUBDATE(NOW(), INTERVAL 83 DAY),25),
(1020,'XM21',1223,SUBDATE(NOW(), INTERVAL 63 DAY),5),
(1021,'GD2', 1087,SUBDATE(NOW(), INTERVAL 49 DAY),125),
(1022,'DS96',1674,NOW(),  100),
(1023,'HD12',1443,NOW(),  10);

CREATE TABLE IF NOT EXISTS `bank`(
 `account_nr` smallint(4) NOT NULL,
 `name` varchar(30) NOT NULL,
 `balance` decimal(8,2) NOT NULL,
 `od_limit` decimal(6,2),
 `account_type` char(1) NOT NULL,
 PRIMARY KEY  (`account_nr`)
) ENGINE=innodb DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
-- In case autocommit is set to 0:
commit;
set sql_notes=1;



