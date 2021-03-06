CREATE DATABASE `client`;
CREATE USER 'mouse'@'localhost' IDENTIFIED BY 'mouse';
GRANT ALL PRIVILEGES ON `client`.* TO 'mouse'@'localhost';

USE `client`;

CREATE TABLE `client_user`
(
    `id`                    BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
    `username`              VARCHAR(16)                    NOT NULL DEFAULT '' COMMENT '用户名',
    `password`              VARCHAR(50)                    NOT NULL DEFAULT '' COMMENT '密码',
    `access_token`          VARCHAR(128)                   NOT NULL DEFAULT '' COMMENT 'access_token',
    `access_token_validity` DATETIME                       NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT 'access_token_validity',
    `refresh_token`         VARCHAR(128)                   NOT NULL DEFAULT '' COMMENT 'refresh_token',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT ='用户表';

INSERT INTO `client_user`(`username`, `password`) VALUE ('mouse', 'password');