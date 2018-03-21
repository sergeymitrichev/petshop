DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, phone, password) VALUES
  ('User', 'user@yandex.ru', '79200226482', 'password'),
  ('Admin', 'admin@gmail.com', '79101451000', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

