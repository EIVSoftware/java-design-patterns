
CREATE TABLE sucursal (
    sucursal smallint NOT NULL PRIMARY KEY,
    descripcion varchar(50) NOT NULL,
    desc_reduc varchar(50) NOT NULL,
    calle varchar(50) NOT NULL,
    calle_nro varchar(50) NOT NULL,
    CONSTRAINT pk_sucursal PRIMARY KEY (sucursal)
);

CREATE TABLE lineas (
    operatoria smallint NOT NULL,
    linea smallint NOT NULL,
    concepto varchar(40) NOT NULL,
    concepto_red varchar(8) NOT NULL,
    CONSTRAINT pk_lineas PRIMARY KEY (operatoria, linea)
);

CREATE TABLE maestros_oper (
    sucursal smallint NOT NULL,
    operatoria smallint NOT NULL,
    linea smallint NOT NULL,
    nro_servicio int NOT NULL,
    estado smallint NOT NULL,
    CONSTRAINT pk_maestros_oper PRIMARY KEY (sucursal, operatoria, linea, nro_servicio)
);
ALTER TABLE maestros_oper
    ADD CONSTRAINT fk_maestros_oper_sucursal
    FOREIGN KEY(sucursal)
    REFERENCES sucursal (sucursal);
ALTER TABLE maestros_oper
    ADD CONSTRAINT fk_maestros_oper_lineas
    FOREIGN KEY (operatoria, linea)
    REFERENCES lineas (operatoria, linea);

CREATE TABLE ctacte_maesal (
    id bigint NOT NULL,
    sucursal smallint NOT NULL,
    operatoria smallint NOT NULL,
    linea smallint NOT NULL,
    nro_servicio int NOT NULL,
    fecha datetime NOT NULL,
    saldo decimal(13, 2) NOT NULL,
    CONSTRAINT pk_ctacte_maesal PRIMARY KEY (id)
);
ALTER TABLE ctacte_maesal 
    ADD CONSTRAINT fk_ctacte_maesal_maestros_oper 
    FOREIGN KEY (sucursal, operatoria, linea, nro_servicio)
    REFERENCES maestros_oper (sucursal, operatoria, linea, nro_servicio);

CREATE TABLE ctacte_movim (
    sucursal smallint NOT NULL,
    operatoria smallint NOT NULL,
    linea smallint NOT NULL,
    nro_servicio int NOT NULL,
    movimiento smallint NOT NULL,
    fecha_contable datetime NOT NULL,
    fecha_proceso datetime NOT NULL,
    orden smallint NOT NULL,
    importe_debito decimal(13, 2) NOT NULL,
    importe_credito decimal(13, 2) NOT NULL,
    estado smallint NOT NULL,
    CONSTRAINT pk_ctacte_movim PRIMARY KEY 
      (sucursal, operatoria, linea, nro_servicio, movimiento, fecha_contable, fecha_proceso, orden)
);
ALTER TABLE ctacte_movim 
    ADD CONSTRAINT fk_ctacte_movim_maestros_oper 
    FOREIGN KEY (sucursal, operatoria, linea, nro_servicio)
    REFERENCES maestros_oper (sucursal, operatoria, linea, nro_servicio);

