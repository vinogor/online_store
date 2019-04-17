CREATE TABLE store
(
    id       INT AUTO_INCREMENT,
    name     VARCHAR(20) NOT NULL,
    price    INT         NOT NULL,
    quantity INT
);

CREATE UNIQUE INDEX store_id_uindex
    ON store (id);

CREATE UNIQUE INDEX store_name_uindex
    ON store (name);

ALTER TABLE store
    ADD CONSTRAINT store_pk
        PRIMARY KEY (id);
--

CREATE TABLE bucket
(
    id       INT AUTO_INCREMENT,
    name     VARCHAR(20) NOT NULL,
    price    INT         NOT NULL,
    quantity INT
);

CREATE UNIQUE INDEX bucket_id_uindex
    ON bucket (id);

CREATE UNIQUE INDEX bucket_name_uindex
    ON bucket (name);

ALTER TABLE bucket
    ADD CONSTRAINT bucket_pk
        PRIMARY KEY (id);

--

CREATE TABLE orders
(
    id           INT AUTO_INCREMENT,
    num_of_order INT,
    name         VARCHAR(20) NOT NULL,
    price        INT         NOT NULL,
    quantity     INT
);

CREATE UNIQUE INDEX orders_id_uindex
    ON orders (id);

ALTER TABLE orders
    ADD CONSTRAINT orders_pk
        PRIMARY KEY (id);

