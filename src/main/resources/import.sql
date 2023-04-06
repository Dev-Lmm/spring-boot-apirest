/*Datos a importar*/
INSERT INTO roles (name) VALUE('ADMIN');
INSERT INTO roles (name) VALUE('USER');

INSERT INTO privileges (name) VALUE ('CREATE');
INSERT INTO privileges (name) VALUE ('READ');
INSERT INTO privileges (name) VALUE ('UPDATE');
INSERT INTO privileges (name) VALUE ('DELETE');

INSERT INTO privilege_role (privilege_id, role_id) VALUES (1, 1);
INSERT INTO privilege_role (privilege_id, role_id) VALUES (2, 1);
INSERT INTO privilege_role (privilege_id, role_id) VALUES (3, 1);
INSERT INTO privilege_role (privilege_id, role_id) VALUES (4, 1);

INSERT INTO privilege_role (privilege_id, role_id) VALUES (1, 2);
INSERT INTO privilege_role (privilege_id, role_id) VALUES (2, 2);
INSERT INTO privilege_role (privilege_id, role_id) VALUES (3, 2);




