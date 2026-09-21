# Parcial II – Sistema de Estacionamiento

**Nombre:** Angel Estuardo Campos Santay
**Carné:** 9941-25-4809

## Descripción

Este proyecto consiste en una aplicación de consola desarrollada en Java para administrar el ingreso y salida de vehículos de un estacionamiento. El programa permite registrar automóviles y motocicletas, consultar los vehículos registrados, buscar por placa y calcular los costos según las horas utilizadas.

El proyecto también incluye una base de datos en PostgreSQL con la tabla `vehiculo` y diferentes consultas SQL para demostrar el manejo de información.

## Tecnologías utilizadas

* Java
* IntelliJ IDEA
* PostgreSQL
* pgAdmin 4
* GitHub

## Estructura del proyecto

```text
estacionamiento/
├── src/
│   └── estacionamiento/
│       ├── Main.java
│       ├── Vehiculo.java
│       ├── Automovil.java
│       └── Motocicleta.java
│
├── database/
│   └── estacionamiento.sql
│
├── evidencias/
│   └── capturas del proyecto
│
├── .gitignore
└── README.md
```

## Funcionalidades

El programa cuenta con un menú con las siguientes opciones:

1. Registrar vehículo
2. Mostrar todos los vehículos
3. Buscar vehículo por placa
4. Mostrar vehículo de mayor costo
5. Mostrar total general recaudado
6. Mostrar total recaudado por tipo
7. Salir

## Cálculo de costos

Para los automóviles se cobra **Q10.00 por hora**.

Para las motocicletas se cobra **Q6.00 por hora**.

Cuando un vehículo utiliza el estacionamiento por más de 5 horas, se aplica un **10% de descuento** sobre el costo total.

## Cómo usar el programa

1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar el archivo `Main.java`.
3. En el menú principal seleccionar la opción que se desea utilizar.
4. Para registrar un vehículo, ingresar la placa, propietario, hora de ingreso, horas utilizadas y tipo de vehículo.
5. El programa valida que los datos necesarios sean correctos y que la placa no esté repetida.
6. Se pueden consultar los vehículos registrados y buscar uno utilizando su placa.
7. También se puede consultar el mayor costo, el total general y el total recaudado por cada tipo de vehículo.
8. Para finalizar el programa se debe seleccionar la opción 7.

## Programación orientada a objetos

En el proyecto se utiliza una clase abstracta llamada `Vehiculo`, de la cual heredan las clases `Automovil` y `Motocicleta`.

También se utilizan:

* Encapsulamiento mediante atributos privados y métodos getters.
* Herencia entre `Vehiculo`, `Automovil` y `Motocicleta`.
* Abstracción mediante la clase `Vehiculo`.
* Sobrescritura del método `calcularCosto()`.
* Polimorfismo utilizando referencias de tipo `Vehiculo`.
* Colecciones `ArrayList`, `HashSet` y `HashMap`.
* Validaciones y manejo de excepciones mediante `try`, `catch` y `finally`.

## Base de datos

La carpeta `database` contiene el archivo `estacionamiento.sql`, donde se encuentra la creación de la tabla `vehiculo`, los registros de prueba y las consultas solicitadas para el proyecto.

La aplicación Java no necesita conectarse directamente a PostgreSQL para funcionar.

## Evidencias

La carpeta `evidencias` contiene las capturas de pantalla correspondientes a la ejecución del programa en Java y las operaciones realizadas en PostgreSQL.

## Autor

**Angel Estuardo Campos Santay**
**Carné: 9941-25-4809**
