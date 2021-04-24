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
    `MovieID` INT NOT NULL AUTO_INCREMENT,
    `Title` VARCHAR(45) NOT NULL,
    `Genre` VARCHAR(45) NOT NULL,
    `Description` VARCHAR(800) NOT NULL,
    `Duration` INT NOT NULL,
    `Is3D` ENUM('Yes', 'No') NOT NULL,
    PRIMARY KEY (`MovieID`))
    ENGINE = InnoDB;

LOCK TABLES `CinemaDB`.`Movie` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Movie` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Movie` (`Title`, `Genre`, `Description`, `Duration`, `Is3D`) VALUES
('Fast and Furious 8', 'action', 'Dom encounters a mysterious woman, Cipher, who gets him involved in the world of terrorism. The crew has to reunite to stop Cipher and save the man who brought them together as a family.', 100, 'Yes'),
('Godzilla vs. Kong', 'action', 'Kong and his protectors undertake a perilous journey to find his true home. Along for the ride is Jia, an orphaned girl who has a unique and powerful bond with the mighty beast. However, they soon find themselves in the path of an enraged Godzilla as he cuts a swath of destruction across the globe. The initial confrontation between the two titans -- instigated by unseen forces -- is only the beginning of the mystery that lies deep within the core of the planet', 113, 'Yes'),
("We're the Millers", 'comedy', 'David, a drug dealer, is forced by his boss to smuggle drugs from Mexico. He hires a stripper, a petty thief and a teenage neighbour and forms a fake family to help him smuggle the drugs.', 118, 'No'),
("The Equalizer", 'action', 'A man who believes he has put his mysterious past behind him cannot stand idly by when he meets a young girl under the control of ultra-violent Russian gangsters.', 172, 'No'),
("Casino", 'crime', 'A tale of greed, deception, money, power, and murder occur between two best friends: a mafia enforcer and a casino executive compete against each other over a gambling empire, and over a fast-living and fast-loving socialite.', 241, 'No'),
("The Godfather", 'crime', 'An organized crime dynastys aging patriarch transfers control of his clandestine empire to his reluctant son.', 305, 'No'),
("Grown Ups 2", 'comedy', 'After moving his family back to his hometown to be with his friends and their kids, Lenny finds out that between old bullies, new bullies, schizo bus drivers, drunk cops on skis, and four hundred costumed party crashers sometimes crazy follows you.', 101, 'No'),
("Taxi 5", 'comedy', 'A police officer who transferred in the police of Marseilles gets assigned to take down a group of Italian robbers who drive the powerful Ferraris with the older nephew of Daniel, a terrible driver who gets the legendary white taxi.', 102, 'No'),
("The Italian Job", 'action', 'After being betrayed and left for dead in Italy, Charlie Croker and his team plan an elaborate gold heist against their former ally.', 111, 'No'),
("American Made", 'comedy', 'The story of Barry Seal, an American pilot who became a drug-runner for the CIA in the 1980s in a clandestine operation that would be exposed as the Iran-Contra Affair.', 115, 'No'),
("Accepted", 'comedy', 'A high school slacker who rejected by every school he applies to opts to create his own institution of higher learning, the South Harmon Institute of Technology, on a rundown piece of property near his hometown.', 93, 'No'),
("The Wolf of Wall Street", 'crime', 'Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.', 180, 'No'),
("Ford v Ferrari", 'action', 'American car designer Carroll Shelby and driver Ken Miles battle corporate interference and the laws of physics to build a revolutionary race car for Ford in order to defeat Ferrari at the 24 Hours of Le Mans in 1966.', 152, 'No'),
("Toy Story 2", 'comedy', 'When Woody is stolen by a toy collector, Buzz and his friends set out on a rescue mission to save Woody before he becomes a museum toy property with his roundup gang Jessie, Prospector, and Bullseye.', 92, 'Yes');
/*!40000 ALTER TABLE `CinemaDB`.`Movie` ENABLE KEYS */;
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Projection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Projection` (
    `ProjectionID` INT NOT NULL AUTO_INCREMENT,
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
INSERT INTO `CinemaDB`.`Projection` (`StartTime`, `EndTime`, `Date`, `RoomID`, `MovieID`) VALUES
('18:30:00', '20:45:00', '2021-04-27', 4, 1),
('18:50:00', '21:05:00', '2021-04-27', 5, 1),
('18:30:00', '20:45:00', '2021-04-27', 2, 3),
('20:30:00', '22:45:00', '2021-04-27', 3, 10),
('18:30:00', '19:45:00', '2021-04-27', 3, 8),
('21:25:00', '22:55:00', '2021-04-27', 5, 11),

('17:40:00', '19:55:00', '2021-04-28', 2, 3),
('18:30:00', '20:45:00', '2021-04-28', 4, 1),
('17:40:00', '19:55:00', '2021-04-28', 1, 3),
('18:40:00', '20:45:00', '2021-04-28', 3, 6),
('20:30:00', '22:45:00', '2021-04-28', 5, 10),
('19:40:00', '21:55:00', '2021-04-28', 2, 5),

('18:50:00', '21:05:00', '2021-04-29', 1, 3),
('21:00:00', '23:10:00', '2021-04-29', 4, 11),
('20:10:00', '22:20:00', '2021-04-29', 5, 2),
('19:50:00', '22:05:00', '2021-04-29', 3, 4),
('21:10:00', '23:20:00', '2021-04-29', 2, 10),
('18:10:00', '20:20:00', '2021-04-29', 5, 12),

('18:50:00', '21:05:00', '2021-04-30', 1, 3),
('21:00:00', '23:10:00', '2021-04-30', 4, 6),
('20:10:00', '22:20:00', '2021-04-30', 5, 2),
('19:50:00', '22:05:00', '2021-04-30', 3, 5),

('21:10:00', '23:20:00', '2021-05-01', 2, 9),
('18:10:00', '20:20:00', '2021-05-01', 5, 10),
('18:05:00', '20:20:00', '2021-05-01', 3, 7),
('20:10:00', '22:05:00', '2021-05-01', 1, 8),
('21:10:00', '22:50:00', '2021-05-01', 2, 12),

('17:40:00', '19:20:00', '2021-05-02', 3, 13),
('20:30:00', '22:50:00', '2021-05-02', 4, 7),
('20:30:00', '22:50:00', '2021-05-02', 1, 10),
('20:30:00', '22:50:00', '2021-05-02', 5, 8),
('18:30:00', '20:50:00', '2021-05-02', 4, 7),

('18:50:00', '21:05:00', '2021-05-03', 5, 9),
('20:50:00', '22:05:00', '2021-05-03', 1, 11),
('21:05:00', '23:05:00', '2021-05-03', 3, 10),
('19:50:00', '21:45:00', '2021-05-03', 4, 12),
('19:30:00', '21:40:00', '2021-05-03', 2, 13),
('21:45:00', '23:30:00', '2021-05-03', 5, 14),

('20:00:00', '22:30:00', '2021-05-04', 2, 10),
('18:00:00', '20:30:00', '2021-05-04', 3, 7),
('20:30:00', '22:30:00', '2021-05-04', 5, 6),
('19:00:00', '20:05:00', '2021-05-04', 1, 5),
('20:00:00', '22:15:00', '2021-05-04', 4, 8),
('21:45:00', '23:30:00', '2021-05-04', 1, 14),

('19:50:00', '21:40:00', '2021-05-05', 1, 3),
('19:10:00', '21:20:00', '2021-05-05', 3, 11),
('19:50:00', '21:40:00', '2021-05-05', 2, 5),
('19:30:00', '21:25:00', '2021-05-05', 4, 9),
('21:45:00', '23:30:00', '2021-05-05', 4, 14),

('18:50:00', '21:05:00', '2021-05-06', 5, 2),
('20:00:00', '22:30:00', '2021-05-06', 2, 13),
('18:00:00', '20:30:00', '2021-05-06', 2, 13),
('19:00:00', '20:55:00', '2021-05-06', 4, 12),
('20:30:00', '22:25:00', '2021-05-06', 1, 12),
('21:45:00', '23:30:00', '2021-05-06', 4, 14),

('19:50:00', '21:40:00', '2021-05-07', 1, 13),
('19:10:00', '21:20:00', '2021-05-07', 3, 7),
('19:50:00', '21:40:00', '2021-05-07', 2, 8),
('19:30:00', '21:25:00', '2021-05-07', 4, 10),
('21:45:00', '23:30:00', '2021-05-07', 4, 14),
('20:30:00', '21:55:00', '2021-05-07', 5, 11),

('19:50:00', '21:40:00', '2021-05-08', 1, 8),
('19:10:00', '21:20:00', '2021-05-08', 3, 7),
('19:50:00', '21:40:00', '2021-05-08', 2, 10),
('19:30:00', '21:25:00', '2021-05-08', 4, 13),
('21:45:00', '23:30:00', '2021-05-08', 4, 14),
('18:45:00', '19:35:00', '2021-05-08', 5, 14),
('20:30:00', '21:55:00', '2021-05-08', 5, 11);

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
('bgoverin@emailru.com', MD5('boris123')),
('galjagalja@emailru.com', MD5('galja222')),
('aparker@cinema.com', MD5('apark123')),
('tmason@cinema.com', MD5('masonmason321')),
('kmihalova@cinema.com', MD5('mihalova999')),
('lmusorova@cinema.com', MD5('larisalarisa5'));
/*!40000 ALTER TABLE `CinemaDB`.`AccountInfo` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `CinemaDB`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Customer` (
    `CustomerID` INT NOT NULL AUTO_INCREMENT,
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
INSERT INTO `CinemaDB`.`Customer` (`FirstName`, `LastName`, `Phone`, `Email`) VALUES
('John','Doe','93-223-2323','johndoe@mail.com'),
('Jane','Green','93-721-2559','jane.green@gmail.com'),
('Boris','Goverin','93-223-2323','bgoverin@emailru.com'),
('Galina','Batkovna','93-223-2323','galjagalja@emailru.com');
/*!40000 ALTER TABLE `CinemaDB`.`Customer` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `CinemaDB`.`Cashier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Cashier` (
    `CashierID` INT NOT NULL AUTO_INCREMENT,
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
INSERT INTO `CinemaDB`.`Cashier` (`Name`, `Salary`, `Email`) VALUES
('Alex Parker',900,'aparker@cinema.com'),
('Tony Mason',800,'tmason@cinema.com'),
('Karina Mihalova',700,'kmihalova@cinema.com'),
('Larisa Musorova',900,'lmusorova@cinema.com');
/*!40000 ALTER TABLE `CinemaDB`.`Cashier` ENABLE KEYS */;
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
INSERT INTO `CinemaDB`.`Reservation` (`CustomerID`, `ProjectionID`, `SeatCode`) VALUES
(1,1,18),
(1,1,19),
(2,1,12),
(2,1,13),
(2,1,14),
(1,2,20),
(1,2,21),
(1,2,22),
(3,3,10),
(3,3,11),
(3,3,12),
(4,4,5),
(4,4,6);
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
-- Table `CinemaDB`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Ticket` (
    `TicketID` INT NOT NULL AUTO_INCREMENT,
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

LOCK TABLES `CinemaDB`.`Ticket` WRITE;
/*!40000 ALTER TABLE `CinemaDB`.`Ticket` DISABLE KEYS */;
INSERT INTO `CinemaDB`.`Ticket` (`ReservationID`, `Price`, `CashierID`) VALUES
(6,5.4,1);
/*!40000 ALTER TABLE `CinemaDB`.`Ticket` ENABLE KEYS */;
UNLOCK TABLES;

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
