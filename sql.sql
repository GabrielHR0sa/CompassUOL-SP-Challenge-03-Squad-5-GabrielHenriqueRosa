INSERT INTO users(id, email, first_name, last_name, password)
VALUES (1, 'operator@gmail.com', 'operator', 'operator', '$2a$10$eUr7IPl2bWVh9eK1wq358ONgz5HrguxYf/XUQedZLDcMXW5e273cW');

INSERT INTO users(id, email, first_name, last_name, password)
VALUES (2, 'admin@gmail.com', 'admin', 'admin', '$2a$10$a0R.lrF//bJlt/b817j60OxlX8COwYw.Hs22LpKdUGD5wNJqN.VAi');

INSERT INTO roles(id, name)
VALUES (1, 'ROLE_OPERATOR');

INSERT INTO roles(id, name)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);

INSERT INTO user_role(user_id, role_id)
VALUES (2, 2);



