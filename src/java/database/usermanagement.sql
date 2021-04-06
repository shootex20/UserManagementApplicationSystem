SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `usermanagementdb` ;

CREATE SCHEMA IF NOT EXISTS `usermanagementdb` DEFAULT CHARACTER SET latin1;
USE `usermanagementdb` ;

CREATE TABLE IF NOT EXISTS `usermanagementdb`.`users` (
`user_ID` int AUTO_INCREMENT,
`dateJoined` date,
`email` varchar(55),
`password` varchar(20),
`firstName` varchar(30),
`lastName` varchar(30),
`dob` date,
`isActive` BIT NOT NULL,
`isAdmin` BIT NOT NULL,
PRIMARY KEY(`user_ID`))
ENGINE = InnoDB;


INSERT INTO `users` (`user_ID`, `dateJoined`, `email`, `password`, `firstName`, `lastName`, `dob`, `isActive`, `isAdmin`) VALUES
	(1, '2021-02-09', 'admin@usermanagement.com', 'admin', 'Admin', 'Leeson', '2000-08-21', 1, 1),
	(2, '2021-04-25', 'johndoe@email.com', 'John', 'password', 'Doe', '1994-05-12', 1, 0);