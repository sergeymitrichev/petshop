DELETE FROM companies;
DELETE FROM user_addresses;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE seq_users RESTART WITH 1;
ALTER SEQUENCE seq_companies RESTART WITH 1;
ALTER SEQUENCE seq_addresses RESTART WITH 1;

INSERT INTO users (name, email, phone, password) VALUES
  ('User', 'user@yandex.ru', '79200226482', 'password'),
  ('Admin', 'admin@gmail.com', '79101451000', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 2);

INSERT INTO user_addresses (user_id, postal, city, street, house, flat, floor, description) VALUES
  (1, 123456, 'Нижний Новгород', 'Уличная', '2А', 124, 5, 'Направо, налево'),
  (2, 123351, 'Москва', 'Проспектная', '12А/2', 24, 12, NULL),
  (1, 123351, 'Москва', 'Проспектная', '12А/2', 24, 12, NULL);

INSERT INTO companies (name) VALUES
  ('Рога и копыта'),
  ('Пыль индийских дорог');