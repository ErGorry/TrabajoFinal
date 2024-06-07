DROP SCHEMA IF EXISTS reservas;
CREATE SCHEMA reservas;
DROP TABLE IF EXISTS reservas.reserva;
CREATE TABLE reservas.reserva (id_reserva INT NOT NULL AUTO_INCREMENT, nombre_cliente VARCHAR(255), dni VARCHAR(255), id_hotel INT, id_vuelo INT,numero_personas INT, PRIMARY KEY(id_reserva));
