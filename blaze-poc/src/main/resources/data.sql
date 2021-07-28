INSERT INTO sucursal
(sucursal,       descripcion, desc_reduc,         calle, calle_nro) VALUES
(      11,  'ROSARIO CENTRO',  'RCENTRO', 'SAN LORENZO',      1255),
(      99, 'ROSARIO ALBERDI',     'ROSA',  'BV.RONDEAU',      3631);

INSERT INTO lineas
(operatoria, linea,                                   concepto, concepto_red) VALUES
(         3,   200, 'CUENTA PERSONAL DE AHORRO COMUN EN PESOS',   'CACPESOS'),
(         3,   203,  'CUENTA PERS. DE AHORRO COMUN EN DOLARES',   'CADOLARE');

INSERT INTO maestros_oper
(sucursal, operatoria, linea, nro_servicio, estado) VALUES
(      11,          3,   200,        31944,      1),
(      99,          3,   200,        31944,      1),
(      99,          3,   203,          779,      1);

INSERT INTO ctacte_maesal
(      id, sucursal, operatoria, linea, nro_servicio,        fecha,     saldo) VALUES
(13880300,       11,          3,   200,        31944, '2020-07-28', 147750.00),
(13880303,       11,          3,   200,        31944, '2020-07-31', 147583.07),
(13880324,       11,          3,   200,        31944, '2020-08-21', 205724.07),
(13880334,       11,          3,   200,        31944, '2020-08-31', 205620.34),
(13880341,       11,          3,   200,        31944, '2020-09-07', 155570.34),
(13880364,       11,          3,   200,        31944, '2020-09-30', 155463.23),
(13880366,       11,          3,   200,        31944, '2020-10-02', 204563.23),
(13880390,       11,          3,   200,        31944, '2020-10-26',  84513.23),
(13880392,       11,          3,   200,        31944, '2020-10-28',  69478.98),
(13880394,       11,          3,   200,        31944, '2020-10-30',  69379.31),
(13880404,       11,          3,   200,        31944, '2020-11-09',  92782.86),
(13880408,       11,          3,   200,        31944, '2020-11-13', 101702.86),
(13880425,       11,          3,   200,        31944, '2020-11-30',  86531.07),
(13880453,       11,          3,   200,        31944, '2020-12-28',  71496.82),
(13880455,       11,          3,   200,        31944, '2020-12-30',  71357.66),
(13880460,       11,          3,   200,        31944, '2021-01-04',  94166.03),
(13880474,       11,          3,   200,        31944, '2021-01-18', 116974.40),
(13880481,       11,          3,   200,        31944, '2021-01-25',  31890.15),
(13880485,       11,          3,   200,        31944, '2021-01-29',  54655.07),
(13880492,       11,          3,   200,        31944, '2021-02-05',  74233.07),
(13880509,       11,          3,   200,        31944, '2021-02-22', 108223.81),
(13880513,       11,          3,   200,        31944, '2021-02-26',  68077.75),
(13880523,       11,          3,   200,        31944, '2021-03-08', 112617.70),
(13880524,       11,          3,   200,        31944, '2021-03-09',  92617.70),
(13880525,       11,          3,   200,        31944, '2021-03-10',  83617.70),
(13880538,       11,          3,   200,        31944, '2021-03-23',  51617.70),
(13880545,       11,          3,   200,        31944, '2021-03-30',  36568.76),
(13880546,       11,          3,   200,        31944, '2021-03-31',  36423.87),
(13880552,       11,          3,   200,        31944, '2021-04-06',  24423.87),
(13880553,       11,          3,   200,        31944, '2021-04-07',   4423.87),
(21362765,       99,          3,   200,        31944, '2020-07-28',      0.00),
(21617520,       99,          3,   203,          779, '2018-10-22',  16000.00),
(21617523,       99,          3,   203,          779, '2018-10-25',  23000.00),
(21617529,       99,          3,   203,          779, '2018-10-31',  23016.93),
(21617559,       99,          3,   203,          779, '2018-11-30',  23026.37),
(21617585,       99,          3,   203,          779, '2018-12-26',      0.00),
(21617587,       99,          3,   203,          779, '2018-12-28',      7.87),
(21617704,       99,          3,   203,          779, '2019-04-24',  20007.87),
(21617710,       99,          3,   203,          779, '2019-04-30',  20009.79),
(21617720,       99,          3,   203,          779, '2019-05-10',  28239.10),
(21617741,       99,          3,   203,          779, '2019-05-31',  28250.05),
(21617751,       99,          3,   203,          779, '2019-06-10',      2.74),
(21617769,       99,          3,   203,          779, '2019-06-28',      6.22);

INSERT INTO ctacte_movim
(sucursal, operatoria, linea, nro_servicio, movimiento, fecha_contable, fecha_proceso, orden, importe_debito, importe_credito, estado) VALUES
(      11,          3,   200,        31944,        643,   '2020-07-28',  '2020-07-28',     1,           0.00,       147750.00,     83),
(      11,          3,   200,        31944,        595,   '2020-07-31',  '2020-07-31',     1,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2020-07-31',  '2020-08-05',     2,           0.00,            8.07,     83),
(      11,          3,   200,        31944,        501,   '2020-08-21',  '2020-08-21',     1,      147583.00,            0.00,     83),
(      11,          3,   200,        31944,        120,   '2020-08-21',  '2020-08-21',     2,           0.00,       205724.00,     83),
(      11,          3,   200,        31944,        595,   '2020-08-31',  '2020-08-31',     1,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2020-08-31',  '2020-09-03',     2,           0.00,           71.27,     83),
(      11,          3,   200,        31944,        501,   '2020-09-07',  '2020-09-07',     1,          50.00,            0.00,     83),
(      11,          3,   200,        31944,        625,   '2020-09-07',  '2020-09-07',     2,       50000.00,            0.00,     83),
(      11,          3,   200,        31944,        595,   '2020-09-30',  '2020-09-30',     1,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2020-09-30',  '2020-10-06',     2,           0.00,           67.89,     83),
(      11,          3,   200,        31944,        120,   '2020-10-02',  '2020-10-02',     1,           0.00,        49100.00,     83),
(      11,          3,   200,        31944,        501,   '2020-10-26',  '2020-10-26',     1,          50.00,            0.00,     83),
(      11,          3,   200,        31944,        625,   '2020-10-26',  '2020-10-26',     2,      120000.00,            0.00,     83),
(      11,          3,   200,        31944,        501,   '2020-10-28',  '2020-10-28',     1,       15034.25,            0.00,     83),
(      11,          3,   200,        31944,        595,   '2020-10-30',  '2020-10-30',     1,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2020-10-30',  '2020-11-05',     2,           0.00,           75.33,     83),
(      11,          3,   200,        31944,        120,   '2020-11-09',  '2020-11-09',     1,           0.00,        23403.55,     83),
(      11,          3,   200,        31944,        501,   '2020-11-13',  '2020-11-13',     1,       50000.00,            0.00,     83),
(      11,          3,   200,        31944,        120,   '2020-11-13',  '2020-11-13',     2,           0.00,        58920.00,     83),
(      11,          3,   200,        31944,        501,   '2020-11-30',  '2020-11-30',     1,       15034.26,            0.00,     83),
(      11,          3,   200,        31944,        595,   '2020-11-30',  '2020-11-30',     2,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2020-11-30',  '2020-12-03',     3,           0.00,           37.47,     83),
(      11,          3,   200,        31944,        501,   '2020-12-28',  '2020-12-28',     1,       15034.25,            0.00,     83),
(      11,          3,   200,        31944,        595,   '2020-12-30',  '2020-12-30',     1,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2020-12-30',  '2021-01-06',     2,           0.00,           35.84,     83),
(      11,          3,   200,        31944,        120,   '2021-01-04',  '2021-01-04',     1,           0.00,        22808.37,     83),
(      11,          3,   200,        31944,        120,   '2021-01-18',  '2021-01-18',     1,           0.00,        22808.37,     83),
(      11,          3,   200,        31944,        501,   '2021-01-25',  '2021-01-25',     1,       85084.25,            0.00,     83),
(      11,          3,   200,        31944,        120,   '2021-01-29',  '2021-01-29',     1,           0.00,        22903.80,     83),
(      11,          3,   200,        31944,        595,   '2021-01-29',  '2021-01-29',     2,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2021-01-29',  '2021-02-03',     3,           0.00,           36.12,     83),
(      11,          3,   200,        31944,        120,   '2021-02-05',  '2021-02-05',     1,           0.00,        19578.00,     83),
(      11,          3,   200,        31944,        501,   '2021-02-22',  '2021-02-22',     1,       15034.26,            0.00,     83),
(      11,          3,   200,        31944,        120,   '2021-02-22',  '2021-02-22',     2,           0.00,        49025.00,     83),
(      11,          3,   200,        31944,        501,   '2021-02-26',  '2021-02-26',     1,       40000.00,            0.00,     83),
(      11,          3,   200,        31944,        595,   '2021-02-26',  '2021-02-26',     2,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2021-02-26',  '2021-03-03',     3,           0.00,           28.94,     83),
(      11,          3,   200,        31944,        120,   '2021-03-08',  '2021-03-08',     1,           0.00,        44539.95,     83),
(      11,          3,   200,        31944,        660,   '2021-03-09',  '2021-03-09',     1,       20000.00,            0.00,     83),
(      11,          3,   200,        31944,        660,   '2021-03-10',  '2021-03-10',     1,        9000.00,            0.00,     83),
(      11,          3,   200,        31944,        660,   '2021-03-23',  '2021-03-23',     1,       32000.00,            0.00,     83),
(      11,          3,   200,        31944,        501,   '2021-03-30',  '2021-03-30',     1,       15048.94,            0.00,     83),
(      11,          3,   200,        31944,        595,   '2021-03-31',  '2021-03-31',     1,         175.00,            0.00,     83),
(      11,          3,   200,        31944,        170,   '2021-03-31',  '2021-04-06',     2,           0.00,           30.11,     83),
(      11,          3,   200,        31944,        660,   '2021-04-06',  '2021-04-06',     1,       12000.00,            0.00,     83),
(      11,          3,   200,        31944,        660,   '2021-04-07',  '2021-04-07',     1,       14000.00,            0.00,     83),
(      11,          3,   200,        31944,        660,   '2021-04-07',  '2021-04-07',     2,        6000.00,            0.00,     83),
(      11,          3,   200,        31944,        662,   '2021-04-07',  '2021-04-07',     3,           0.00,         6000.00,     83),
(      11,          3,   200,        31944,        660,   '2021-04-07',  '2021-04-07',     4,        6000.00,            0.00,     83),
(      11,          3,   200,        31944,        662,   '2021-04-07',  '2021-04-07',     5,           0.00,         6000.00,     83),
(      11,          3,   200,        31944,        660,   '2021-04-07',  '2021-04-07',     6,        6000.00,            0.00,     83),
(      99,          3,   200,        31944,        121,   '2020-07-28',  '2020-07-28',     1,           0.00,       147750.00,     83),
(      99,          3,   200,        31944,        641,   '2020-07-28',  '2020-07-28',     1,      147750.00,            0.00,     83),
(      99,          3,   203,          779,        101,   '2018-10-22',  '2018-10-22',     1,           0.00,        16000.00,     83),
(      99,          3,   203,          779,        101,   '2018-10-25',  '2018-10-25',     1,           0.00,         7000.00,     83),
(      99,          3,   203,          779,        170,   '2018-10-31',  '2018-11-05',     1,           0.00,           16.93,     83),
(      99,          3,   203,          779,        170,   '2018-11-30',  '2018-12-05',     1,           0.00,            9.44,     83),
(      99,          3,   203,          779,        634,   '2018-12-26',  '2018-12-26',     1,       23026.37,            0.00,     83),
(      99,          3,   203,          779,        170,   '2018-12-28',  '2019-01-04',     1,           0.00,            7.87,     83),
(      99,          3,   203,          779,        101,   '2019-04-24',  '2019-04-24',     1,           0.00,        20000.00,     83),
(      99,          3,   203,          779,        170,   '2019-04-30',  '2019-05-06',     1,           0.00,            1.92,     83),
(      99,          3,   203,          779,        133,   '2019-05-10',  '2019-05-10',     1,           0.00,         8229.31,     83),
(      99,          3,   203,          779,        170,   '2019-05-31',  '2019-06-05',     1,           0.00,           10.95,     83),
(      99,          3,   203,          779,        501,   '2019-06-10',  '2019-06-10',     1,       28247.31,            0.00,     83),
(      99,          3,   203,          779,        170,   '2019-06-28',  '2019-07-03',     1,           0.00,            3.48,     83);

/*
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
*/
