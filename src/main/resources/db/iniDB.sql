DROP TABLE IF EXISTS user_roles;
DROP SEQUENCE IF EXISTS global_seq;
DROP TABLE IF EXISTS users;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR                 NOT NULL,
  email      VARCHAR                 NOT NULL,
  phone      VARCHAR                 NOT NULL,
  password   VARCHAR                 NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL,
  enabled    BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE user_addresses
(
  user_id     INTEGER NOT NULL,
  postal      INTEGER NOT NULL,
  city        VARCHAR NOT NULL,
  street      VARCHAR NOT NULL,
  house       VARCHAR NOT NULL,
  flat        VARCHAR,
  description VARCHAR,
  CONSTRAINT user_addresses_idx UNIQUE (user_id, postal, house, flat),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);