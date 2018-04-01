DROP TABLE user_addresses IF EXISTS;
DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE companies IF EXISTS;
DROP SEQUENCE seq_addresses IF EXISTS;
DROP SEQUENCE seq_companies IF EXISTS;
DROP SEQUENCE seq_users IF EXISTS;

CREATE SEQUENCE seq_addresses AS INTEGER START WITH 1;
CREATE SEQUENCE seq_companies AS INTEGER START WITH 1;
CREATE SEQUENCE seq_users AS INTEGER START WITH 1;

CREATE TABLE companies
(
  id         INTEGER GENERATED BY DEFAULT AS SEQUENCE seq_companies PRIMARY KEY,
  name       VARCHAR(255)                NOT NULL
);


CREATE TABLE users
(
  id         INTEGER GENERATED BY DEFAULT AS SEQUENCE seq_users PRIMARY KEY,
  name       VARCHAR(255)                 NOT NULL,
  email      VARCHAR(255)                 NOT NULL,
  phone      VARCHAR(255)                 NOT NULL,
  password   VARCHAR(255)                 NOT NULL,
  registered TIMESTAMP DEFAULT now()      NOT NULL,
  enabled    BOOLEAN DEFAULT TRUE         NOT NULL,
  company_id INTEGER,
  FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE user_addresses
(
  id          INTEGER GENERATED BY DEFAULT AS SEQUENCE seq_addresses PRIMARY KEY,
  user_id     INTEGER NOT NULL,
  postal      INTEGER NOT NULL,
  city        VARCHAR(255) NOT NULL,
  street      VARCHAR(255) NOT NULL,
  house       VARCHAR(255) NOT NULL,
  flat        INTEGER,
  floor       INTEGER,
  description VARCHAR(255),
  CONSTRAINT user_addresses_idx UNIQUE (user_id, street, house, flat),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX user_addresses_idx ON user_addresses(user_id, street, house, flat)