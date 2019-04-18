DROP TABLE IF EXISTS `my_base`.`store`;
CREATE TABLE `my_base`.`store`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(20) NOT NULL,
    `price`    INT         NOT NULL,
    `quantity` INT         NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);

DROP TABLE IF EXISTS `my_base`.`bucket`;
CREATE TABLE  `my_base`.`bucket`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(20) NOT NULL,
    `price`    INT         NOT NULL,
    `quantity` INT         NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
);

DROP TABLE IF EXISTS `my_base`.`orders`;
CREATE TABLE `my_base`.`orders`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `num_of_order` INT         NOT NULL,
    `name`         VARCHAR(20) NOT NULL,
    `price`        INT         NOT NULL,
    `quantity`     INT         NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
