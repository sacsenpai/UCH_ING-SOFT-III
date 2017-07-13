/*
Empresa        :  EGCC
Software       :  Sistema de Ventas
DBMS           :  MySQL
Esquema        :  VENTAS
Módulo         :  CATALOGO
Script         :  Crea las tablas del catalogo, promociones y capañas.
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
Creado el      :  05-NOV-2016
*/


-- =============================================
-- Activa la base de datos
-- =============================================

USE COMPUTRONIC;


-- =============================================
-- Crea las tablas
-- =============================================


CREATE TABLE CATEGORIA
(
	idcat                INTEGER NOT NULL AUTO_INCREMENT,
	nombre               VARCHAR(50) NOT NULL,
	descripcion          TEXT NOT NULL,
	CONSTRAINT PK_CATEGORIA PRIMARY KEY (idcat)
);



CREATE TABLE PRODUCTO
(
	idprod               INTEGER AUTO_INCREMENT,
	idcat                INTEGER NOT NULL,
	nombre               VARCHAR(100) NOT NULL,
	descripcion          TEXT NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	stock                INTEGER NOT NULL,
	estado               INTEGER NOT NULL default 1 check(estado in(1,0)),
    /*foto				 MEDIUMBLOB, */
	CONSTRAINT PK_PRODUCTO PRIMARY KEY (idprod),
	FOREIGN KEY FK_PRODUCTO_CATEGORIA (idcat) REFERENCES CATEGORIA (idcat)
);

/*


CREATE TABLE PROMOCION
(
	idprom               INTEGER NOT NULL,
	fecInicio            DATE NOT NULL,
	fecFin               DATE NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	oferta               NUMERIC(10,2) NOT NULL,
	idprod               INTEGER NOT NULL,
	estado               INTEGER NOT NULL,
	anulado              INTEGER NOT NULL,
	CONSTRAINT PK_PROMOCION PRIMARY KEY (idprom),
	FOREIGN KEY FK_PROMOCION_PRODUCTO (idprod) REFERENCES PRODUCTO (idprod)
);


CREATE TABLE CAMPANIA
(
	idcamp               INTEGER AUTO_INCREMENT,
	nombre               VARCHAR(150) NOT NULL,
	descripcion          TEXT NOT NULL,
	fecInicio            DATE NOT NULL,
	fecFin               DATE NOT NULL,
	estado               INTEGER NOT NULL,
	anulado              INTEGER NOT NULL,
	CONSTRAINT PK_CAMPANIA PRIMARY KEY (idcamp)
);



CREATE TABLE DETCAMPANIA
(
	idcamp               INTEGER NOT NULL,
	idprod               INTEGER NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	oferta               NUMERIC(10,2) NOT NULL,
	porcDcto             NUMERIC(10,2) NOT NULL,
	estado               INTEGER NOT NULL,
	anulado              INTEGER NOT NULL,
	CONSTRAINT PK_DETCAMPANIA PRIMARY KEY (idcamp,idprod),
	FOREIGN KEY FK_DETCAMPANIA_CAMPANIA (idcamp) REFERENCES CAMPANIA (idcamp),
	FOREIGN KEY FK_DETCAMPANIA_PRODUCTO (idprod) REFERENCES PRODUCTO (idprod)
);

*/
-- =============================================
-- Datos
-- =============================================

-- Tabla CATEGORIA

-- USAR EL ENLACE http://www.tiendadecomputoperu.com/juegos-electricos-c-3867.html COMO REFERENCIA PARA CATEGORIAS :V
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(100,'LAPTOPS','Ordenador personal portatil.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(101,'TABLETS','Ordenador móvil con una pantalla táctil de visualización.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(102,'TELEFONOS','Dispositivo de telecomunicación.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(103,'TELEVISORES','Aparato electrónico destinado a la recepción y reproducción de señales de televisión.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(104,'PORCESADORES','Circuito integrado que contiene todos los elementos de la CPU.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(105,'DISCOS EXTERNOS','Variados modelos para tus mejores ocaciones.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(106,'SERVIDORES','Es una aplicación en ejecución.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(107,'MONITORES','Principal dispositivo de salida (interfaz), que muestra datos o información al usuario.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(108,'IMPRESORAS','Dispositivo periférico del ordenador que permite producir una gama permanente de textos o gráficos de documentos almacenados en un formato electrónico,');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(109,'TECLADOS','Dispositivo o periférico de entrada, maquina de escribir.');
INSERT INTO CATEGORIA(IDCAT,NOMBRE,DESCRIPCION) VALUES(110,'PARLANTE','Transductor electroacústico utilizado para la reproducción de sonido.');

-- Tabla PRODUCTO

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1000,100,'COCINA',900.0,456,'La mejor cocina para tu mejor receta',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1001,101,'PANTALON',150.0,4567,'Diversos colores y modelos,',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1002,102,'REFRIGERADORA',1300.0,690,'Garantia de 2 años.',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1003,103,'POLO DE VERANO',95.00,150,'Colores frescos.',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1004,104,'CAMISA COLOR VERDE',140.00,250,'Lucete con una buena marca.',1);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1005,105,'CAMISA DE CUADROS PEQUEÑOS',140.00,350,'Modelo exclusivo.',0);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK,DESCRIPCION,ESTADO)
VALUES(1006,106,'PANTALON MODELO A1',1180.00,450,'Especial para lucirte con tu pareja.',1);


-- Tabla PROMOCION


-- idprom    fecInicio  fecFin     precio     oferta     idprod     estado     anulado   
/*
INSERT INTO PROMOCION VALUES(1,'20160701','20160731',950.0,799.0,1,1,0);
INSERT INTO PROMOCION VALUES(2,'20161101','20161130',900.0,750.0,1,1,0);

*/


