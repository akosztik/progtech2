CREATE SCHEMA `harry_potter`;

CREATE TABLE `harry_potter`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `character_name` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `age` INT NULL,
  `house_id` INT NULL,
  PRIMARY KEY (`id`));

  ALTER TABLE `harry_potter`.`student`
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

ALTER TABLE `harry_potter`.`student` 
CHANGE COLUMN `name` `name` VARCHAR(255) NOT NULL ,
ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC);

CREATE TABLE `harry_potter`.`house` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `crest` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));


ALTER TABLE `harry_potter`.`house` 
CHANGE COLUMN `name` `name` VARCHAR(255) NOT NULL ,
ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC);


