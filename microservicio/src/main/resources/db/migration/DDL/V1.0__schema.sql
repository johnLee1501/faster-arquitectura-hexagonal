CREATE TABLE producto (
  id INT(11) NOT NULL AUTO_INCREMENT,
  codigo_producto VARCHAR(45) NULL,
  nombre VARCHAR(45) NULL,
  valor_producto INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT uq_producto_codigo_producto UNIQUE (codigo_producto)
);

insert into producto (codigo_producto, nombre, valor_producto) values ('FGH12D', 'Iphone 12', 4000000);
insert into producto (codigo_producto, nombre, valor_producto) values ('FGJ10E', 'USB HubX', 140000);
insert into producto (codigo_producto, nombre, valor_producto) values ('FGK12Z', 'Xiaomi Note 8', 160000);

CREATE TABLE compra (
  id INT(11) NOT NULL AUTO_INCREMENT,
  identificador_usuario INT(11) NULL,
  direccion VARCHAR(45) NULL,
  ciudad VARCHAR(45) NULL,
  producto_id INT(11),
  tipo_usuario INT NULL,
  fecha_compra DATETIME NULL,
  fecha_entrega DATETIME NULL,
  PRIMARY KEY (id),
  foreign key (producto_id) references producto (id));

CREATE TABLE ciudad (
  id INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id));

insert into ciudad (nombre) values ('Bogotá');
insert into ciudad (nombre) values ('Medellín');
insert into ciudad (nombre) values ('Cali');
insert into ciudad (nombre) values ('Barranquilla');
insert into ciudad (nombre) values ('Cartagena de Indias');
insert into ciudad (nombre) values ('Cúcuta');
insert into ciudad (nombre) values ('Soledad');
insert into ciudad (nombre) values ('Ibagué');