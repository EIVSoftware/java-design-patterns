INSERT INTO dummies (id, nombre) VALUES (1, 'd1');
INSERT INTO dummies (id, nombre) VALUES (2, 'd2');

INSERT INTO authorities (id, nombre) VALUES (1, 'ROLE_USER');
INSERT INTO usuarios (id, correo, habilitado, nombre_completo, username) VALUES (1, 'dcairone@eiva.com.ar', 1, 'CAIRONE, DIEGO', 'diego.cairone');
INSERT INTO usuarios_authorities (usuario_id, authority_id) VALUES (1, 1);
