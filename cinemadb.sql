UNLOCK TABLES;
DROP DATABASE IF EXISTS `CinemaDB`;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

UNLOCK TABLES;
-- -----------------------------------------------------
-- Schema Cinema Booking System
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `CinemaDB` DEFAULT CHARACTER SET utf8 ;
USE `CinemaDB` ;

-- -----------------------------------------------------
-- Table `CinemaDB`.`Room`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `CinemaDB`.`Room` (
  `RoomID` INT NOT NULL AUTO_INCREMENT,
  `For3D` TINYINT(1) NOT NULL,
  PRIMARY KEY (`RoomID`))
ENGINE = InnoDB;

LOCK TABLES `CinemaDB`.`Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Room` (`For3D`) VALUES (0), (0), (0), (1), (1);
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Seat` (
  `SeatCode` INT NOT NULL AUTO_INCREMENT,
  `Row` CHAR NOT NULL,
  `Column` INT NOT NULL,
  PRIMARY KEY (`SeatCode`))
ENGINE = InnoDB;

LOCK TABLES `CinemaDB`.`Seat` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Seat` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Seat` (`Row`, `Column`) VALUES
('A', 1),
('A', 2),
('A', 3),
('A', 4),
('A', 5),
('B', 1),
('B', 2),
('B', 3),
('B', 4),
('B', 5),
('C', 1),
('C', 2),
('C', 3),
('C', 4),
('C', 5),
('D', 1),
('D', 2),
('D', 3),
('D', 4),
('D', 5),
('E', 1),
('E', 2),
('E', 3),
('E', 4),
('E', 5);
/*!40000 ALTER TABLE `CinemaDB`.`Seat` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Movie` (
  `MovieID` INT NOT NULL,
  `Title` VARCHAR(45) NOT NULL,
  `Genre` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(800) NOT NULL,
  `Duration` INT NOT NULL,
  `Is3D` ENUM('Yes', 'No') NOT NULL,
  PRIMARY KEY (`MovieID`))
ENGINE = InnoDB;

LOCK TABLES `CinemaDB`.`Movie` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Movie` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Movie` VALUES
(123, 'Fast and Furious 8', 'action', 'Dom encounters a mysterious woman, Cipher, who gets him involved in the world of terrorism. The crew has to reunite to stop Cipher and save the man who brought them together as a family.', 100, 'Yes'),
(428, 'Godzilla vs. Kong', 'action', 'Kong and his protectors undertake a perilous journey to find his true home. Along for the ride is Jia, an orphaned girl who has a unique and powerful bond with the mighty beast. However, they soon find themselves in the path of an enraged Godzilla as he cuts a swath of destruction across the globe. The initial confrontation between the two titans -- instigated by unseen forces -- is only the beginning of the mystery that lies deep within the core of the planet', 113, 'Yes'),
(295, "We're the Millers", 'comedy', 'David, a drug dealer, is forced by his boss to smuggle drugs from Mexico. He hires a stripper, a petty thief and a teenage neighbour and forms a fake family to help him smuggle the drugs.', 118, 'No');
/*!40000 ALTER TABLE `CinemaDB`.`Movie` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Projection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Projection` (
  `ProjectionID` INT NOT NULL,
  `StartTime` TIME NOT NULL,
  `EndTime` TIME NOT NULL,
  `Date` DATE NOT NULL,
  `RoomID` INT NOT NULL,
  `MovieID` INT NOT NULL,
  PRIMARY KEY (`ProjectionID`),
  INDEX `fk_Projection_Room1_idx` (`RoomID` ASC),
  INDEX `fk_Projection_Movie1_idx` (`MovieID` ASC),
  CONSTRAINT `fk_Projection_Room1`
    FOREIGN KEY (`RoomID`)
    REFERENCES `CinemaDB`.`Room` (`RoomID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projection_Movie1`
    FOREIGN KEY (`MovieID`)
    REFERENCES `CinemaDB`.`Movie` (`MovieID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


LOCK TABLES `CinemaDB`.`Projection` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Projection` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Projection` VALUES
(983, '18:30:00', '20:45:00', '2021-04-27', 4, 123),
(927, '18:50:00', '21:05:00', '2021-04-27', 5, 123),
(183, '18:30:00', '20:45:00', '2021-04-27', 2, 295),
(551, '17:40:00', '19:55:00', '2021-04-28', 2, 295),
(102, '18:30:00', '20:45:00', '2021-04-28', 4, 123),
(193, '17:40:00', '19:55:00', '2021-04-28', 1, 295),
(229, '18:50:00', '21:05:00', '2021-04-29', 1, 295),
(305, '21:00:00', '23:10:00', '2021-04-29', 4, 428),
(448, '20:10:00', '22:20:00', '2021-04-29', 5, 428);
/*!40000 ALTER TABLE `CinemaDB`.`Projection` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`AccountInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`AccountInfo` (
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Email`))
ENGINE = InnoDB;

LOCK TABLES `CinemaDB`.`AccountInfo` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`AccountInfo` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`AccountInfo` VALUES
('johndoe@mail.com', MD5('john123')),
('jane.green@gmail.com', MD5('janelovebird1')),
('aparker@cinema.com', MD5('apark123')),
('tmason@cinema.com', MD5('masonmason321'));
/*!40000 ALTER TABLE `CinemaDB`.`AccountInfo` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `CinemaDB`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Customer` (
  `CustomerID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  INDEX `fk_Customer_AccountInfo1_idx` (`Email` ASC),
  CONSTRAINT `fk_Customer_AccountInfo1`
    FOREIGN KEY (`Email`)
    REFERENCES `CinemaDB`.`AccountInfo` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


LOCK TABLES `CinemaDB`.`Customer` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Customer` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Customer` VALUES
('123','John','Doe','93-223-2323','johndoe@mail.com'),
('234','Jane','Green','93-721-2559','jane.green@gmail.com');
/*!40000 ALTER TABLE `CinemaDB`.`Customer` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Reservation` (
  `ReservationID` INT NOT NULL AUTO_INCREMENT,
  `CustomerID` INT NOT NULL,
  `ProjectionID` INT NOT NULL,
  `SeatCode` INT NOT NULL,
  PRIMARY KEY (`ReservationID`),
  INDEX `fk_Reservation_Customer1_idx` (`CustomerID` ASC),
  INDEX `fk_Reservation_Projection1_idx` (`ProjectionID` ASC),
  INDEX `fk_Reservation_Seat1_idx` (`SeatCode` ASC),
  CONSTRAINT `fk_Reservation_Customer1`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `CinemaDB`.`Customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Projection1`
    FOREIGN KEY (`ProjectionID`)
    REFERENCES `CinemaDB`.`Projection` (`ProjectionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Seat1`
    FOREIGN KEY (`SeatCode`)
    REFERENCES `CinemaDB`.`Seat` (`SeatCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


LOCK TABLES `CinemaDB`.`Reservation` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Reservation` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Reservation` VALUES
(1,123,983,18),
(2,123,983,19),
(4,234,983,12),
(5,234,983,13),
(6,234,983,14),
(7,123,229,20),
(8,123,229,21),
(9,123,229,22);
/*!40000 ALTER TABLE `CinemaDB`.`Reservation` ENABLE KEYS */;
UNLOCK TABLES;

/*
-- -----------------------------------------------------
-- Table `CinemaDB`.`PROJECTION_RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`PROJECTION_RESERVATION` (
  `ProjectionID` INT NOT NULL,
  `ReservationID` INT NOT NULL,
  INDEX `fk_PROJECTION_RESERVATION_Projection1_idx` (`ProjectionID` ASC),
  INDEX `fk_PROJECTION_RESERVATION_Reservation1_idx` (`ReservationID` ASC),
  CONSTRAINT `fk_PROJECTION_RESERVATION_Projection1`
    FOREIGN KEY (`ProjectionID`)
    REFERENCES `CinemaDB`.`Projection` (`ProjectionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROJECTION_RESERVATION_Reservation1`
    FOREIGN KEY (`ReservationID`)
    REFERENCES `CinemaDB`.`Reservation` (`ReservationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
*/

-- -----------------------------------------------------
-- Table `CinemaDB`.`Cashier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Cashier` (
  `CashierID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Salary` DOUBLE NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CashierID`),
  INDEX `fk_Cashier_AccountInfo1_idx` (`Email` ASC),
  CONSTRAINT `fk_Cashier_AccountInfo1`
    FOREIGN KEY (`Email`)
    REFERENCES `CinemaDB`.`AccountInfo` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


LOCK TABLES `CinemaDB`.`Cashier` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Cashier` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Cashier` VALUES
('111','Alex Parker',900,'aparker@cinema.com'),
('222','Tony Mason',800,'tmason@cinema.com');
/*!40000 ALTER TABLE `CinemaDB`.`Cashier` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Ticket` (
  `TicketID` INT NOT NULL,
  `ReservationID` INT NOT NULL,
  `Price` DOUBLE NOT NULL,
  `CashierID` INT ,
  PRIMARY KEY (`TicketID`),
  INDEX `fk_Ticket_Cashier1_idx` (`CashierID` ASC),
  CONSTRAINT `fk_Ticket_Cashier1`
    FOREIGN KEY (`CashierID`)
    REFERENCES `CinemaDB`.`Cashier` (`CashierID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/*
-- -----------------------------------------------------
-- Table `CinemaDB`.`TICKET_RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`TICKET_RESERVATION` (
  `TicketID` INT NOT NULL,
  `ReservationID` INT NOT NULL,
  INDEX `fk_TICKET_RESERVATION_Ticket1_idx` (`TicketID` ASC),
  INDEX `fk_TICKET_RESERVATION_Reservation1_idx` (`ReservationID` ASC),
  CONSTRAINT `fk_TICKET_RESERVATION_Ticket1`
    FOREIGN KEY (`TicketID`)
    REFERENCES `CinemaDB`.`Ticket` (`TicketID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TICKET_RESERVATION_Reservation1`
    FOREIGN KEY (`ReservationID`)
    REFERENCES `CinemaDB`.`Reservation` (`ReservationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
*/


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
