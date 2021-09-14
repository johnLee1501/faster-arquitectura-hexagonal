CREATE TABLE compra (
  id INT(11) NOT NULL AUTO_INCREMENT,
  identificador_usuario INT(11) NULL,
  direccion VARCHAR(45) NULL,
  ciudad VARCHAR(45) NULL,
  codigo_producto VARCHAR(45) NULL,
  valor_producto INT NULL,
  tipo_usuario INT NULL,
  fecha_compra DATETIME NULL,
  fecha_entrega DATETIME NULL,
  PRIMARY KEY (id));