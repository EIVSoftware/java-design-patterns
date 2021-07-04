INSERT INTO sucursal
(sucursal_id,           nombre, abreviatura,         calle, calle_numero) VALUES
(         11, 'ROSARIO CENTRO',   'RCENTRO', 'SAN LORENZO',       '1255');

INSERT INTO linea
(operatoria,  linea_id,                                    nombre, moneda) VALUES
(  'CUENTA',       200, 'CUENTA PERS. DE AHORRO COMUN EN DOLARES',  'USD');

INSERT INTO servicio
(sucursal_id, operatoria, linea_id, servicio_id,   estado) VALUES
(         11,   'CUENTA',      200,          12, 'ACTIVO');

INSERT INTO cuenta_vista
(id, sucursal_id, operatoria, linea_id, servicio_id) VALUES
( 1,          11,   'CUENTA',      200,          12);

INSERT INTO cuenta_vista_saldo
(id, sucursal_id, operatoria, linea_id, servicio_id,        fecha,   saldo) VALUES
( 1,          11,   'CUENTA',      200,          12, '2021-07-02', 1234.56);

INSERT INTO cuenta_vista_acuerdo
(id, sucursal_id, operatoria, linea_id, servicio_id, importe) VALUES
( 1,          11,   'CUENTA',      200,          12,   10.00),
( 2,          11,   'CUENTA',      200,          12,    1.00),
( 3,          11,   'CUENTA',      200,          12,    0.10),
( 4,          11,   'CUENTA',      200,          12,    0.01);
