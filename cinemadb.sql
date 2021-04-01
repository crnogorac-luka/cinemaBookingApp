SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Cinema Booking System
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `CinemaDB` DEFAULT CHARACTER SET utf8 ;
USE `CinemaDB` ;

-- -----------------------------------------------------
-- Table `CinemaDB`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Room` (
  `RoomID` INT NOT NULL,
  `Capacity` INT NOT NULL,
  PRIMARY KEY (`RoomID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Seat` (
  `SeatCode` INT NOT NULL,
  `Row` INT NOT NULL,
  `Column` INT NOT NULL,
  `RoomID` INT NOT NULL,
  PRIMARY KEY (`SeatCode`),
  INDEX `fk_Seat_Room_idx` (`RoomID` ASC),
  CONSTRAINT `fk_Seat_Room`
    FOREIGN KEY (`RoomID`)
    REFERENCES `CinemaDB`.`Room` (`RoomID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Movie` (
  `MovieID` INT NOT NULL,
  `Title` VARCHAR(45) NOT NULL,
  `Genre` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Duration` VARCHAR(45) NOT NULL,
  `Is3D` ENUM('Yes', 'No') NOT NULL,
  PRIMARY KEY (`MovieID`))
ENGINE = InnoDB;


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


-- -----------------------------------------------------
-- Table `CinemaDB`.`AccountInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`AccountInfo` (
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Person` (
  `PersonID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PersonID`),
  INDEX `fk_Person_AccountInfo1_idx` (`Email` ASC),
  CONSTRAINT `fk_Person_AccountInfo1`
    FOREIGN KEY (`Email`)
    REFERENCES `CinemaDB`.`AccountInfo` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Reservation` (
  `ReservationID` INT NOT NULL,
  `PersonID` INT NOT NULL,
  `ProjectionID` INT NOT NULL,
  `SeatCode` INT NOT NULL,
  PRIMARY KEY (`ReservationID`),
  INDEX `fk_Reservation_Person1_idx` (`PersonID` ASC),
  INDEX `fk_Reservation_Projection1_idx` (`ProjectionID` ASC),
  INDEX `fk_Reservation_Seat1_idx` (`SeatCode` ASC),
  CONSTRAINT `fk_Reservation_Person1`
    FOREIGN KEY (`PersonID`)
    REFERENCES `CinemaDB`.`Person` (`PersonID`)
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


-- -----------------------------------------------------
-- Table `CinemaDB`.`Cashier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Cashier` (
  `CashierID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Salary` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CashierID`),
  INDEX `fk_Cashier_AccountInfo1_idx` (`Email` ASC),
  CONSTRAINT `fk_Cashier_AccountInfo1`
    FOREIGN KEY (`Email`)
    REFERENCES `CinemaDB`.`AccountInfo` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CinemaDB`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CinemaDB`.`Ticket` (
  `TicketID` INT NOT NULL,
  `Price` VARCHAR(45) NOT NULL,
  `CashierID` INT NOT NULL,
  PRIMARY KEY (`TicketID`),
  INDEX `fk_Ticket_Cashier1_idx` (`CashierID` ASC),
  CONSTRAINT `fk_Ticket_Cashier1`
    FOREIGN KEY (`CashierID`)
    REFERENCES `CinemaDB`.`Cashier` (`CashierID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
