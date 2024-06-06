
# Trabajo final del Master de Java 160h 👨🏻‍💻

Este trabajo fue propuesto por la instructora Isabel A.
El objetivo consistía en crear 3 microservicios independientes pero conectados entre ellos mediante REST. Todos los microservicios cuentan con un CRUD completo.
* Microservicio Hotel: disponiblidad, nombre, tipo, precio.
* Microservicio Vuelo: empresa, fecha, precio, plazas.
* Microservicio Reservas: nombre, dni, personas, hotel, vuelo.

La funcionalidad principal debía de ser la de las peticiones HTTP implementadas, aunque vi necesario generar una interfaz gráfica que aportase información al usuario.



## ¿Qué he aprendido?👨🏻‍🎓
* El uso de Maven y del Framework Spring.
* La librería de Hibernate y JPA para acceso a BBDD relacional.
* El mapeo ORM de objetos de Java.
* Protocolo HTTP.
* La arquitectura de microservicios.
* El uso de las librería ThymeLeaf.


## Instalación 💻

Descargar el proyecto y ejecutar los scripts SQL que se encuentran en la carpeta static de los microservicios. Esto creará cada una de las bases de datos y las tablas.
    
## Glosario de puertos ⚓

```
Cada microservicio levanta en un puerto diferente y las direcciones base son:
```
* Microservicio Hotel: http://localhost:7000/hoteles
* Microservicio Vuelo: http://localhost:8000/vuelos
* Microservicio Reservas: http://localhost:9000:/reservas
```
Las vistas se encuentran en un proyecto aparte que no tiene acceso a datos si no que 
conecta con cada microservicio independientemente:
```
* Web de Reserva de viajes a Menorca: http://localhost:8080
## API Reference 🔌

#### Get all

```http
  GET /{hoteles/vuelos/reseras}
```
#### Get by id

```http
  GET /{hoteles/vuelos/reseras}/{id}
```
#### Post item

```http
  POST /{hoteles/vuelos/reseras} Objeto sin id en el RequestBody
```
#### Put item

```http
  PUT /{hoteles/vuelos/reseras} Objeto sin id en el RequestBody
```
#### Delete by id

```http
  DELETE /{hoteles/vuelos/reseras}/{id}
```
## Autor 🧠

[Álvaro Babarro](https://www.github.com/ErGorry) 


## Feedback 🙌🏻

Cualquier duda o sugerencia alvaro.babarro@gmail.com
