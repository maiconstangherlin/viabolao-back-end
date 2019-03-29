
CREATE TABLE `bolao`.`lances_details`
(
  `id`                 INT      NOT NULL AUTO_INCREMENT,
  `ultima_atualizacao` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `bolao`.`lances`
(
  `id`              INT         NOT NULL AUTO_INCREMENT,
  `jogador`         VARCHAR(45) NOT NULL,
  `jogo_id`         INT         NOT NULL,
  `gols_a`          INT         NULL,
  `gols_b`          INT         NULL,
  `lance_detail_id` INT         NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lances_1_idx` (`lance_detail_id` ASC),
  CONSTRAINT `fk_lances_1`
    FOREIGN KEY (`lance_detail_id`)
      REFERENCES `bolao`.`lances_details` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);



