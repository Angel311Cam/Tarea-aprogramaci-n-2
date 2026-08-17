# 🚗 Sistema de Control de Parqueo

## 👨‍💻 Datos del estudiante

**Nombre:** Angel Estuardo Campos Santay
**Carné:** 9941-25-4809

---

## 📌 Descripción

Este proyecto consiste en un programa desarrollado en **Java** para llevar el control de los vehículos que utilizan un parqueo.

El programa permite registrar varios vehículos, indicando su placa, tipo de vehículo, hora de entrada y salida, y si el conductor perdió el ticket.

Dependiendo del tipo de vehículo se aplica una tarifa diferente. También se calcula el subtotal, el descuento del 15 % cuando el vehículo permanece más de 8 horas y el recargo de Q50.00 cuando se pierde el ticket.

Al finalizar, el programa muestra un resumen de la jornada con la cantidad de vehículos registrados por tipo, los tickets perdidos, el dinero recaudado y el vehículo que realizó el pago más alto.

---

## 🛠️ Métodos creados

Durante el desarrollo del programa se utilizaron diferentes métodos para dividir las funciones y evitar realizar todo el proceso dentro del `main`.

### `obtenerTarifa(int tipoVehiculo)`

Se utiliza para obtener la tarifa correspondiente según el tipo de vehículo:

* Motocicleta: Q5.00 por hora.
* Automóvil: Q8.00 por hora.
* Pickup o camioneta: Q12.00 por hora.

### `obtenerNombreVehiculo(int tipoVehiculo)`

Devuelve el nombre del vehículo según la opción seleccionada por el usuario.

### `calcularDescuento(double subtotal, int horas)`

Calcula el descuento del 15 % cuando las horas cobradas son mayores de 8.

### `calcularPago(int horas, double tarifa)`

Calcula el pago normal multiplicando las horas cobradas por la tarifa correspondiente.

### `calcularPago(int horas, double tarifa, double recargo)`

Calcula el pago cuando existe un recargo por ticket perdido.

### `solicitarHora(Scanner entrada, String mensaje)`

Solicita la hora al usuario y valida que esté entre 0 y 23.

### `solicitarMinuto(Scanner entrada, String mensaje)`

Solicita los minutos y valida que estén entre 0 y 59.

### `calcularMinutosEstacionado(...)`

Calcula el tiempo exacto que permaneció el vehículo en el parqueo. También permite calcular correctamente el tiempo cuando la salida ocurre al día siguiente.

### `calcularHorasCobradas(int minutos)`

Convierte los minutos estacionados a horas cobradas. Si existe una fracción de hora, se cobra como una hora completa.

### `mostrarComprobante(...)`

Muestra los datos del vehículo, el tiempo estacionado, las horas cobradas, el subtotal, el descuento, el recargo y el total a pagar.

---

## 🔄 Sobrecarga de métodos

La sobrecarga se aplicó en el método `calcularPago`.

Se utilizaron dos métodos con el mismo nombre, pero con diferentes parámetros:

```java
public static double calcularPago(int horas, double tarifa)
```

y

```java
public static double calcularPago(int horas, double tarifa, double recargo)
```

El primero se utiliza cuando el conductor **no perdió el ticket**.

El segundo se utiliza cuando el conductor **sí perdió el ticket**, ya que recibe el recargo adicional de Q50.00.

De esta manera se demuestra una sobrecarga real de métodos, ya que los métodos tienen diferente cantidad de parámetros.

---

## 🧪 Casos de prueba

Se realizaron varios casos de prueba para comprobar que el programa funcionara correctamente.

Se probaron diferentes tipos de vehículos, diferentes cantidades de tiempo, validaciones de entrada, tickets perdidos y también horarios que pasan al día siguiente.

Uno de los casos utilizados fue el siguiente:

```text
========== VEHICULO 1 ==========

Ingrese el numero de placa: C343ABC

1. Motocicleta
2. Automovil
3. Pickup o camioneta

Seleccione el tipo de vehiculo: 3

Hora de entrada (0-23): 22
Minuto de entrada (0-59): 20

Hora de salida (0-23): 4
Minuto de salida (0-59): 10

¿Perdio el ticket? (S/N): N


========== COMPROBANTE ==========

Placa: C343ABC
Tipo: Pickup o camioneta
Hora de entrada: 22:20
Hora de salida: 04:10
Tiempo estacionado: 5 horas y 50 minutos
Horas cobradas: 6
Tarifa por hora: Q12.00
Subtotal: Q72.00
Descuento: Q0.00
Recargo por ticket perdido: Q0.00
TOTAL: Q72.00


========================================

          RESUMEN DE LA JORNADA

========================================

Cantidad de motocicletas: 0
Cantidad de automoviles: 0
Cantidad de pickups/camionetas: 1
Cantidad de tickets perdidos: 0
Total de dinero recaudado: Q72.00
Pago mas alto: Q72.00
Placa del pago mas alto: C343ABC
```

En este caso se comprobó también el funcionamiento del cálculo cuando el vehículo entra a las **22:20** y sale a las **04:10 del día siguiente**.

El tiempo total fue de **5 horas y 50 minutos**, por lo que el programa cobró **6 horas completas**.

---

## 🌙 Reto opcional

**Sí, realicé el reto opcional.**

Se agregó el control exacto de la hora y los minutos de entrada y salida.

El programa valida:

* Horas entre 0 y 23.
* Minutos entre 0 y 59.
* Salidas que ocurren al día siguiente.
* Cobro de una hora completa cuando existe una fracción de hora.

Por ejemplo:

```text
Entrada: 22:20
Salida: 04:10

Tiempo estacionado: 5 horas y 50 minutos
Horas cobradas: 6
```

El cálculo funciona aunque el horario cambie de día y no depende de valores fijos.

---
.
