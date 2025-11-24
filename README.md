# Construccion2LeidyMonterroza
Sistema de Coordinación Estratégica del Cuerpo de Cazadores – Batalla del Castillo Infinito 

# Tecnologías
- Java 17
- Spring Boot 4.x.x
- MySQL


# Requisitos de Ejecución
Requisitos previos:

Java 17 JDK instalado
MySQL 8.0 o superior
Maven 3.6 o superior
Configuración de base de datos:

server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/cazadores?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

# Explicación Endpoints
PillarController
CrearPilar
POST http://localhost:8081/api/pilares
{
  "nombre": "Giyu Tomioka",
  "posX": -10.0,
  "posY": -20.0,
  "estado": "Herido"
}

ActualizarPosicion 
PUT http://localhost:8081/api/pilares/{id}/posicion
{
  "posX": -40.0,
  "posY": -20.0
}
Response
{
  "id": 1,
  "nombre": "Giyu Tomioka",
  "posX": -40.0,
  "posY": -20.0,
  "estado": "Herido",
  "updatedAt": "2025-11-24T04:15:19.980570200Z"
}

ObtenerPilar 
GET http://localhost:8081/api/pilares/{id}
Response 
{
  "id": 1,
  "nombre": "Giyu Tomioka",
  "posX": 50.0,
  "posY": 75.0,
  "estado": "Herido",
  "updatedAt": "2025-11-23T20:30:08Z"
}

MensajeController
CrearMensaje
POST http://localhost:8081/api/mensajes
{
  "id": 3,
  "pilarId": 1,
  "contenidoFragmentado": "Mensa d pru fragmen",
  "contenidoReconstruido": null
}

ReconstruirMensaje
PUT http://localhost:8081/api/mensajes/{id}/reconstruir
{
  "contenidoReconstruido": "Mensaje de prueba completo"
}

Response 
{
  "id": 3,
  "pilarId": 1,
  "contenidoFragmentado": "Mensa d pru fragmen",
  "contenidoReconstruido": "Mensaje de prueba completo",
  "timestamp": "2025-11-24T04:10:14.822777400Z"
}

ObtenerMensaje
GET http://localhost:8081/api/mensajes/{id}

Response 
{
  "id": 3,
  "pilarId": 1,
  "contenidoFragmentado": "Mensa d pru fragmen",
  "contenidoReconstruido": "Mensaje de prueba completo",
  "timestamp": "2025-11-24T04:10:14Z"
}






