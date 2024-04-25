

CREATE TABLE boleta (
    idboleta       INT(11) NOT NULL,
    fecha_emision  DATE NOT NULL,
    idpedido       INT(11) NOT NULL
);

ALTER TABLE boleta ADD CONSTRAINT boleta_pk PRIMARY KEY ( idboleta );

CREATE TABLE carro (
    idcarro         INT(11) NOT NULL,
    fecha_creacion  DATE NOT NULL,
    rut             VARCHAR(15) NOT NULL
);

ALTER TABLE carro ADD CONSTRAINT carro_pk PRIMARY KEY ( idcarro );

CREATE TABLE cliente (
    rut       VARCHAR(15) NOT NULL,
    nombre    VARCHAR(45) NOT NULL,
    email     VARCHAR(45) NOT NULL,
    telefono  VARCHAR(45) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( rut );

CREATE TABLE estado (
    idestado      INT(11) NOT NULL,
    idpedido      INT(11) NOT NULL,
    fecha_estado  DATE NOT NULL
);

ALTER TABLE estado ADD CONSTRAINT estado_pk PRIMARY KEY ( idestado,
                                                          idpedido );

CREATE TABLE pedido (
    idpedido         INT(11) NOT NULL,
    fecha_pedido     DATE NOT NULL,
    direccion_envio  VARCHAR(45) NOT NULL,
    idcarro          INT(11) NOT NULL
);

ALTER TABLE pedido ADD CONSTRAINT pedido_pk PRIMARY KEY ( idpedido );

CREATE TABLE producto (
    idproducto   INT(11) NOT NULL,
    nombre       VARCHAR(45) NOT NULL,
    marca        VARCHAR(45) NOT NULL,
    descripcion  VARCHAR(45) NOT NULL,
    precio       INT(11) NOT NULL,
    stock        INT(11) NOT NULL,
    tipo         CHAR(1) NOT NULL,
    disponible   CHAR(1) NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( idproducto );

CREATE TABLE producto_carro (
    idproducto    INT(11) NOT NULL,
    idcarro       INT(11) NOT NULL,
    precio_venta  INT(11) NOT NULL,
    cantidad      INT(11) NOT NULL
);

ALTER TABLE producto_carro ADD CONSTRAINT producto_carro_pk PRIMARY KEY ( idproducto,
                                                                          idcarro );

ALTER TABLE boleta
    ADD CONSTRAINT boleta_pedido_fk FOREIGN KEY ( idpedido )
        REFERENCES pedido ( idpedido );

ALTER TABLE carro
    ADD CONSTRAINT carro_cliente_fk FOREIGN KEY ( rut )
        REFERENCES cliente ( rut );

ALTER TABLE estado
    ADD CONSTRAINT estado_pedido_fk FOREIGN KEY ( idpedido )
        REFERENCES pedido ( idpedido );

ALTER TABLE pedido
    ADD CONSTRAINT pedido_carro_fk FOREIGN KEY ( idcarro )
        REFERENCES carro ( idcarro );

ALTER TABLE producto_carro
    ADD CONSTRAINT producto_carro_carro_fk FOREIGN KEY ( idcarro )
        REFERENCES carro ( idcarro );

ALTER TABLE producto_carro
    ADD CONSTRAINT producto_carro_producto_fk FOREIGN KEY ( idproducto )
        REFERENCES producto ( idproducto );



