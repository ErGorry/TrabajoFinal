DROP SCHEMA IF EXISTS hoteles;
CREATE SCHEMA hoteles;
DROP TABLE IF EXISTS hoteles.hotel;
CREATE TABLE hoteles.hotel (id_hotel INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(255), categoria VARCHAR(255),precio DOUBLE,disponible BOOLEAN, PRIMARY KEY(id_hotel));
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Bonnavista','Apartahotel',120,1);
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Creations','Hotel',145.98,1);
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Avenue','Motel',99.99,1);
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Bronx','Vivienda Turistica',135,1);
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Yankees','Apartahotel',115.96,1);
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Resort','Hotel',200,1);
INSERT INTO hoteles.hotel (nombre,categoria,precio,disponible) VALUES ('Elements','Motel',105,1);