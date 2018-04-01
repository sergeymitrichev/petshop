DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS user_addresses;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS companies;
DROP SEQUENCE IF EXISTS seq_users;
DROP SEQUENCE IF EXISTS seq_companies;
DROP SEQUENCE IF EXISTS seq_addresses;

CREATE SEQUENCE seq_users START 1;
CREATE SEQUENCE seq_companies START 1;
CREATE SEQUENCE seq_addresses START 1;

CREATE TABLE companies
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('seq_companies'),
  name       VARCHAR                 NOT NULL
);

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('seq_users'),
  name       VARCHAR                 NOT NULL,
  email      VARCHAR                 NOT NULL,
  phone      VARCHAR                 NOT NULL,
  password   VARCHAR                 NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL,
  enabled    BOOL DEFAULT TRUE       NOT NULL,
  company_id INTEGER,
  FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE user_addresses
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('seq_addresses'),
  user_id     INTEGER NOT NULL,
  postal      INTEGER NOT NULL,
  city        VARCHAR NOT NULL,
  street      VARCHAR NOT NULL,
  house       VARCHAR NOT NULL,
  flat        INTEGER,
  floor       INTEGER,
  description VARCHAR,
  CONSTRAINT user_addresses_idx UNIQUE (user_id, street, house, flat),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);