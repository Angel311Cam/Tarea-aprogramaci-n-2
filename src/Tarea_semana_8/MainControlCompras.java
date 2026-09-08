package Tarea_semana_8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class MainControlCompras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> listaProductos = new ArrayList<>();
        HashSet<String> categoriasUnicas = new HashSet<>();
        HashMap<String, Double> totalesPorCategoria = new HashMap<>();

        System.out.println("=== REGISTRO DE COMPRAS DEL HOGAR ===");
        System.out.println("Debe registrar un minimo de 5 productos validos.\n");

        int productosValidosCount = 0;
        int intento = 1;

        while (productosValidosCount < 5) {
            System.out.println("--- Ingrese Producto #" + intento + " ---");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: ");
            double precioUnitario = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Producto no registrado: El nombre no puede estar vacío.\n");
            } else if (categoria.isEmpty()) {
                System.out.println("Producto no registrado: La categoría no puede estar vacía.\n");
            } else if (precioUnitario <= 0) {
                System.out.println("Producto no registrado: El precio debe ser mayor que cero.\n");
            } else if (cantidad <= 0) {
                System.out.println("Producto no registrado: La cantidad debe ser mayor que cero.\n");
            } else {
                Producto producto = new Producto(nombre, categoria, precioUnitario, cantidad);
                listaProductos.add(producto);

                categoriasUnicas.add(categoria);

                double subtotal = producto.calcularSubtotal();
                double totalActual = totalesPorCategoria.getOrDefault(categoria, 0.0);
                totalesPorCategoria.put(categoria, totalActual + subtotal);

                productosValidosCount++;
                System.out.println("¡Producto registrado con éxito!\n");
            }
            intento++;
        }

        System.out.println("\n========================================");
        System.out.println("======== RESUMEN DE COMPRAS ========");
        System.out.println("========================================\n");

        double totalGeneral = 0.0;
        Producto prodMayorGasto = listaProductos.get(0);
        Producto prodMenorGasto = listaProductos.get(0);

        for (Producto p : listaProductos) {
            double subtotal = p.calcularSubtotal();
            totalGeneral += subtotal;

            System.out.printf("%s | %s | Q%.2f x %d | Subtotal: Q%.2f\n",
                    p.getNombre(), p.getCategoria(), p.getPrecioUnitario(), p.getCantidad(), subtotal);

            if (subtotal > prodMayorGasto.calcularSubtotal()) {
                prodMayorGasto = p;
            }
            if (subtotal < prodMenorGasto.calcularSubtotal()) {
                prodMenorGasto = p;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categoriasUnicas);

        System.out.println("\nTotal por categoría:");
        String catMayorGasto = "";
        double maxGastoCat = -1.0;

        for (Map.Entry<String, Double> entry : totalesPorCategoria.entrySet()) {
            System.out.printf("%s: Q%.2f\n", entry.getKey(), entry.getValue());

            if (entry.getValue() > maxGastoCat) {
                maxGastoCat = entry.getValue();
                catMayorGasto = entry.getKey();
            }
        }

        System.out.println("\nProductos registrados: " + listaProductos.size());
        System.out.printf("Total general: Q%.2f\n\n", totalGeneral);

        System.out.printf("Producto con mayor gasto:\n%s - Q%.2f\n\n",
                prodMayorGasto.getNombre(), prodMayorGasto.calcularSubtotal());

        System.out.printf("Producto con menor gasto:\n%s - Q%.2f\n\n",
                prodMenorGasto.getNombre(), prodMenorGasto.calcularSubtotal());

        System.out.printf("Categoría con mayor gasto:\n%s - Q%.2f\n",
                catMayorGasto, maxGastoCat);

        System.out.println("\n========================================");
        System.out.print("Ingrese una categoría para consultar: ");
        String consultaCat = scanner.nextLine().trim();

        if (totalesPorCategoria.containsKey(consultaCat)) {
            System.out.printf("Total gastado en %s: Q%.2f\n",
                    consultaCat, totalesPorCategoria.get(consultaCat));
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }

        scanner.close();
    }
}