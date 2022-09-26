
---LENGUAJE DDL

CREATE USER 'unmsm' IDENTIFIED BY 'unmsm';
GRANT ALL PRIVILEGES ON *.* TO 'unmsm';
FLUSH PRIVILEGES;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_unmsm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_unmsm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_unmsm` DEFAULT CHARACTER SET utf8 ;
USE `db_unmsm` ;

-- -----------------------------------------------------
-- Table `db_unmsm`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`persona` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido_paterno` VARCHAR(45) NOT NULL,
  `apellido_materno` VARCHAR(45) NOT NULL,
  `dni` CHAR(8) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `correo` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`usuario` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(240) NOT NULL,
  `perfil` CHAR(1) NOT NULL,
  `foto` BLOB NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_persona_idx` (`persona_id` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `db_unmsm`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`escuela_profesional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`escuela_profesional` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`tutorado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`tutorado` (
  `persona_id` INT NOT NULL,
  `codigo` VARCHAR(30) NOT NULL,
  `escuela_profesional_id` INT NOT NULL,
  INDEX `fk_tutorado_persona1_idx` (`persona_id` ASC) VISIBLE,
  PRIMARY KEY (`persona_id`),
  CONSTRAINT `fk_tutorado_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `db_unmsm`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tutorado_escuela_profesional1`
    FOREIGN KEY (`escuela_profesional_id`)
    REFERENCES `db_unmsm`.`escuela_profesional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`tutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`tutor` (
  `persona_id` INT NOT NULL,
  `estado` CHAR(1) NOT NULL,
  `codigo` VARCHAR(30) NOT NULL,
  INDEX `fk_tutor_persona1_idx` (`persona_id` ASC) VISIBLE,
  PRIMARY KEY (`persona_id`),
  CONSTRAINT `fk_tutor_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `db_unmsm`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`trabajador` (
  `persona_id` INT NOT NULL,
  `foto` VARCHAR(30) NULL,
  INDEX `fk_trabajador_persona1_idx` (`persona_id` ASC) VISIBLE,
  PRIMARY KEY (`persona_id`),
  CONSTRAINT `fk_trabajador_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `db_unmsm`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`asignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`asignatura` (
  `codigo` VARCHAR(30) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `escuela_profesional_id` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_asignatura_escuela_profesional1_idx` (`escuela_profesional_id` ASC) VISIBLE,
  CONSTRAINT `fk_asignatura_escuela_profesional1`
    FOREIGN KEY (`escuela_profesional_id`)
    REFERENCES `db_unmsm`.`escuela_profesional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`solicitud` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `asunto` VARCHAR(60) NOT NULL,
  `tipo` CHAR(1) NOT NULL,
  `fecha` DATE NOT NULL,
  `estado` CHAR(1) NOT NULL,
  `tutorado_persona_id` INT NOT NULL,
  `asignatura_codigo` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fut_tutorado1_idx` (`tutorado_persona_id` ASC) VISIBLE,
  INDEX `fk_solicitud_asignatura1_idx` (`asignatura_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_fut_tutorado1`
    FOREIGN KEY (`tutorado_persona_id`)
    REFERENCES `db_unmsm`.`tutorado` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_asignatura1`
    FOREIGN KEY (`asignatura_codigo`)
    REFERENCES `db_unmsm`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`sesion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`sesion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `asunto` VARCHAR(45) NOT NULL,
  `informe` TEXT NULL,
  `resolucion` VARCHAR(45) NULL,
  `tipo` CHAR(1) NOT NULL,
  `observacion` TEXT NULL,
  `tutor_persona_id` INT NOT NULL,
  `asignatura_codigo` VARCHAR(30) NOT NULL,
  `tutorado_persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sesion_tutor1_idx` (`tutor_persona_id` ASC) VISIBLE,
  INDEX `fk_sesion_asignatura1_idx` (`asignatura_codigo` ASC) VISIBLE,
  INDEX `fk_sesion_tutorado1_idx` (`tutorado_persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_sesion_tutor1`
    FOREIGN KEY (`tutor_persona_id`)
    REFERENCES `db_unmsm`.`tutor` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sesion_asignatura1`
    FOREIGN KEY (`asignatura_codigo`)
    REFERENCES `db_unmsm`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sesion_tutorado1`
    FOREIGN KEY (`tutorado_persona_id`)
    REFERENCES `db_unmsm`.`tutorado` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_unmsm`.`preferencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_unmsm`.`preferencia` (
  `id` INT NOT NULL,
  `tipo` CHAR(1) NOT NULL,
  `tutor_persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_preferencia_tutor1_idx` (`tutor_persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_preferencia_tutor1`
    FOREIGN KEY (`tutor_persona_id`)
    REFERENCES `db_unmsm`.`tutor` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


---LENGUAJE DML