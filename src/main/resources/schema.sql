DROP TABLE IF EXISTS Ingredient_Ref;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS Taco;
DROP TABLE IF EXISTS Taco_Order;

DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE IF NOT EXISTS Taco_Order
(
    id              INTEGER PRIMARY KEY DEFAULT NEXTVAL('global_seq'),
    delivery_Name   VARCHAR(50) NOT NULL,
    delivery_Street VARCHAR(50) NOT NULL,
    delivery_City   VARCHAR(50) NOT NULL,
    delivery_State  VARCHAR(2)  NOT NULL,
    delivery_Zip    VARCHAR(10) NOT NULL,
    cc_number       VARCHAR(16) NOT NULL,
    cc_expiration   VARCHAR(5)  NOT NULL,
    cc_cvv          VARCHAR(3)  NOT NULL,
    placed_at       TIMESTAMP   NOT NULL
);

CREATE TABLE IF NOT EXISTS Taco
(
    id             INTEGER PRIMARY KEY DEFAULT NEXTVAL('global_seq'),
    name           VARCHAR(50) NOT NULL,
    taco_order     INTEGER      NOT NULL,
    taco_order_key INTEGER      NOT NULL,
    created_at     TIMESTAMP   NOT NULL
);

CREATE TABLE IF NOT EXISTS Ingredient_Ref
(
    ingredient VARCHAR(4) NOT NULL,
    taco       BIGINT     NOT NULL,
    taco_key   BIGINT     NOT NULL
);

CREATE TABLE IF NOT EXISTS Ingredient
(
    id   VARCHAR(4) PRIMARY KEY NOT NULL,
    name VARCHAR(25)            NOT NULL,
    type VARCHAR(10)            NOT NULL
);

ALTER TABLE Taco
    ADD FOREIGN KEY (taco_order) REFERENCES Taco_Order (id) on DELETE CASCADE;
ALTER TABLE Ingredient_Ref
    ADD FOREIGN KEY (ingredient) REFERENCES Ingredient (id);
