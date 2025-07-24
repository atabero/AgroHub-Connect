# AgroHub-Connect: Plataforma Logística para Cooperativas Agro-Alimentarias

## Descripción del Proyecto
**AgroHub-Connect** es un proyecto personal de desarrollo de software con fines puramente **educativos y de aprendizaje**. Su objetivo es simular la construcción de una **plataforma basada en microservicios** que gestione la cadena de suministro de una cooperativa agro-alimentaria. Aunque el escenario de negocio es "realista", este proyecto se enfoca en la **aplicación de tecnologías y patrones de diseño modernos** (Java, Spring Boot, Microservicios, Docker, colas de mensajes, etc.) más que en su viabilidad comercial en el mundo real.

La plataforma conectará a **agricultores y ganaderos locales** con una red diversa de **comercios y hostelería** (fruterías, carnicerías, pequeños comercios y restaurantes). Se busca optimizar la gestión de stock, pedidos y la logística de entrega, contemplando tanto productos agrícolas como cárnicos, con especial atención a la **cadena de frío** y la **trazabilidad**.

---

## Fases de Desarrollo: MVP 1 (Producto Mínimo Viable)

El desarrollo de AgroHub-Connect se abordará de forma incremental, comenzando con un **MVP 1 (Producto Mínimo Viable)** que sentará las bases de la arquitectura y las funcionalidades principales.

**Objetivos del MVP 1:**

* **Servicio de Gestión de Productores y Stock:** Permitirá a los agricultores y ganaderos registrarse en la plataforma y gestionar el stock básico de sus productos disponibles. Esto incluye la capacidad de diferenciar entre productos agrícolas y cárnicos, con información elemental de trazabilidad.
* **Servicio de Catálogo de Productos:** Expondrá a los clientes (fruterías, carnicerías, pequeños comercios, restaurantes) un catálogo actualizado de los productos disponibles, con sus precios.
* **Fundamentos de la Arquitectura de Microservicios:** Se establecerán los servicios básicos de infraestructura como un **Servicio de Descubrimiento (Eureka Server)**, permitiendo que los microservicios se registren y encuentren entre sí.
* **Bases de Datos Contenerizadas:** Se utilizará `docker-compose` para levantar instancias de PostgreSQL, proporcionando bases de datos separadas para los microservicios clave, asegurando un entorno de desarrollo consistente.

Este primer MVP se centrará en la **definición de entidades, la creación de los primeros endpoints REST y la configuración básica de la comunicación entre servicios**, sentando las bases para funcionalidades más complejas de gestión de pedidos, logística avanzada y cadena de frío en futuras iteraciones.

---

## Tecnologías Clave

Este proyecto es una oportunidad para aprender y aplicar diversas tecnologías y conceptos del ecosistema Java y desarrollo de sistemas distribuidos:

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3.x
* **Arquitectura:** Microservicios
* **Orquestación/Comunicación:** Spring Cloud (Eureka), REST APIs, y en futuras fases, colas de mensajes (Kafka/RabbitMQ).
* **Persistencia:** Spring Data JPA con PostgreSQL.
* **Contenerización:** Docker y Docker Compose.

---
