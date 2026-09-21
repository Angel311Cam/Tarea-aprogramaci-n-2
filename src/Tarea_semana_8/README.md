# Control de Compras del Hogar

**Nombre:** Angel Estuardo Campos Santay  
**Carné:** 9941-25-4809  
**Curso:** Programación II
**Proyecto:** semana-08-control-compras  

---

## ¿Qué hace este programa?

Esta aplicación de consola desarrollada en Java permite llevar el control y análisis de las compras realizadas en un hogar durante la semana. 

El programa permite:
* Registrar un mínimo de 5 productos validando que los nombres, categorías, precios y cantidades sean correctos.
* Calcular automáticamente el subtotal de cada producto y el total general de la compra.
* Agrupar las categorías sin mostrar nombres repetidos.
* Sumar y mostrar el total gastado por cada categoría.
* Identificar cuál fue el producto con mayor gasto, el de menor gasto y la categoría en la que más se dinero se invirtió.
* Hacer consultas directas por categoría para saber rápidamente cuánto se gastó en ella.

---

## Estructura del Código (Clases Utilizadas)

El proyecto está organizado en dos clases principales dentro del paquete `Tarea_semana_8`:

1. **`Producto.java`**
   * Es la clase modelo que representa cada artículo comprado.
   * Contiene los atributos privados (`nombre`, `categoria`, `precioUnitario` y `cantidad`).
   * Incluye su constructor, métodos *getter* y el método `calcularSubtotal()` que multiplica el precio por la cantidad.

2. **`MainControlCompras.java`**
   * Es la clase principal que ejecuta la lógica del sistema y maneja la interacción con el usuario mediante `Scanner`.
   * Utiliza **tres colecciones de Java**:
     * `ArrayList<Producto>`: Para guardar la lista completa de productos respetando el orden de ingreso.
     * `HashSet<String>`: Para almacenar las categorías registradas sin permitir duplicados.
     * `HashMap<String, Double>`: Para relacionar cada categoría con el monto acumulado gastado en ella.

---

## ¿Cómo usar el programa?

1. **Ejecución:** Abre el proyecto en tu IDE preferido (NetBeans, IntelliJ, VS Code o Eclipse) y ejecuta la clase `MainControlCompras.java`.
2. **Ingreso de Datos:** El programa te irá pidiendo uno a uno los datos de los productos:
   * Nombre
   * Categoría
   * Precio unitario (debe ser mayor a 0)
   * Cantidad (debe ser mayor a 0)
   * *Nota: Si ingresas un valor inválido o dejas un texto vacío, el programa te mostrará un mensaje de error y te volverá a pedir el producto.*
3. **Resumen de Compras:** Al terminar de ingresar los 5 productos válidos, se imprimirá automáticamente en pantalla el desglose completo con todos los cálculos y estadísticas.
4. **Consulta:** Al final del resumen, el programa te pedirá ingresar el nombre de una categoría. Escribe la categoría que deseas buscar (por ejemplo: `lacteos`) y presiona Enter para ver el gasto total en esa sección.
