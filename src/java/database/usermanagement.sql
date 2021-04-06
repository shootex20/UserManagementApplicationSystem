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
`firstName` varchar(30),
`lastName` varchar(30),
`dob` date,
`isActive` CHAR,
`isAdmin` CHAR,
PRIMARY KEY(`user_ID`))
ENGINE = InnoDB;


INSERT INTO `users` (`user_ID`, `dateJoined`, `email`, `firstName`, `lastName`, `dob`, `isActive`, `isAdmin`) VALUES
	(1, '2021-02-09', 'admin@usermanagement.com' ,'Admin', 'Leeson', '2000-08-21', 'T', 'T'),
	(2, '2021-04-25', 'johndoe@email.com', 'John', 'Doe', '1994-05-12', 'T', 'F');