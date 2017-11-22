CREATE SCHEMA `harry_potter`;

CREATE TABLE `harry_potter`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `character` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`));

  ALTER TABLE `harry_potter`.`student`
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

