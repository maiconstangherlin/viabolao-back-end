CREATE TABLE `bolao`.`times`
(
  `id`         INT          NOT NULL AUTO_INCREMENT,
  `nome`       VARCHAR(45)  NOT NULL,
  `url_imagem` VARCHAR(500) NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `bolao`.`jogos`
(
  `id`     INT      NOT NULL AUTO_INCREMENT,
  `data`   DATETIME NOT NULL,
  `time_a` INT      NOT NULL,
  `time_b` INT      NOT NULL,
  `gols_a` SMALLINT NULL,
  `gols_b` SMALLINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_jogos_1_idx` (`time_a` ASC),
  INDEX `fk_jogos_2_idx` (`time_b` ASC),
  CONSTRAINT `fk_jogos_time_a`
    FOREIGN KEY (`time_a`)
      REFERENCES `bolao`.`times` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogos_time_b`
    FOREIGN KEY (`time_b`)
      REFERENCES `bolao`.`times` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


