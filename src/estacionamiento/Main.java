package estacionamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    static HashSet<String> placas = new HashSet<>();
    static HashMap<String, Double> recaudacion = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== ESTACIONAMIENTO =====");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar todos los vehículos");
            System.out.println("3. Buscar vehículo por placa");
            System.out.println("4. Mostrar vehículo de mayor costo");
            System.out.println("5. Mostrar total general recaudado");
            System.out.println("6. Mostrar total recaudado por tipo");
            System.out.println("7. Salir");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    mostrarVehiculos();
                    break;
                case 3:
                    buscarVehiculo();
                    break;
                case 4:
                    mostrarMayorCosto();
                    break;
                case 5:
                    mostrarTotalGeneral();
                    break;
                case 6:
                    mostrarTotalPorTipo();
                    break;
                case 7:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    public static void registrarVehiculo() {

        System.out.println("\n===== REGISTRAR VEHÍCULO =====");

        String placa;

        while (true) {
            System.out.print("Placa: ");
            placa = scanner.nextLine().trim();

            if (placa.isEmpty()) {
                System.out.println("La placa no puede estar vacía.");
            } else if (placas.contains(placa)) {
                System.out.println("La placa ya está registrada.");
                return;
            } else {
                break;
            }
        }

        String propietario;

        while (true) {
            System.out.print("Propietario: ");
            propietario = scanner.nextLine().trim();

            if (propietario.isEmpty()) {
                System.out.println("El propietario no puede estar vacío.");
            } else {
                break;
            }
        }

        System.out.print("Hora de ingreso: ");
        String horaIngreso = scanner.nextLine().trim();

        int horasUtilizadas;

        while (true) {
            try {
                System.out.print("Horas utilizadas: ");
                horasUtilizadas = Integer.parseInt(scanner.nextLine());

                if (horasUtilizadas <= 0) {
                    System.out.println("Las horas deben ser mayores que cero.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");

            } finally {
                System.out.println("Validación de horas realizada.");
            }
        }

        int tipo;

        while (true) {
            try {
                System.out.println("\nTipo de vehículo:");
                System.out.println("1. Automóvil");
                System.out.println("2. Motocicleta");
                System.out.print("Seleccione el tipo: ");

                tipo = Integer.parseInt(scanner.nextLine());

                if (tipo == 1 || tipo == 2) {
                    break;
                }

                System.out.println("Tipo de vehículo inválido.");

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una opción numérica.");

            } finally {
                System.out.println("Validación del tipo realizada.");
            }
        }

        Vehiculo vehiculo;

        if (tipo == 1) {
            vehiculo = new Automovil(placa, propietario, horaIngreso, horasUtilizadas);
        } else {
            vehiculo = new Motocicleta(placa, propietario, horaIngreso, horasUtilizadas);
        }

        vehiculos.add(vehiculo);
        placas.add(placa);

        String tipoVehiculo;

        if (vehiculo instanceof Automovil) {
            tipoVehiculo = "Automóvil";
        } else {
            tipoVehiculo = "Motocicleta";
        }

        recaudacion.put(
                tipoVehiculo,
                recaudacion.getOrDefault(tipoVehiculo, 0.0) + vehiculo.calcularCosto()
        );

        System.out.println("\nVehículo registrado correctamente.");
        System.out.printf("Costo calculado: Q%.2f%n", vehiculo.calcularCosto());
    }

    public static void mostrarVehiculos() {

        if (vehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos registrados.");
            return;
        }

        System.out.println("\n===== VEHÍCULOS REGISTRADOS =====");

        for (Vehiculo vehiculo : vehiculos) {

            String tipo;

            if (vehiculo instanceof Automovil) {
                tipo = "Automóvil";
            } else {
                tipo = "Motocicleta";
            }

            System.out.println("------------------------------");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Propietario: " + vehiculo.getPropietario());
            System.out.println("Tipo: " + tipo);
            System.out.println("Horas utilizadas: " + vehiculo.getHorasUtilizadas());
            System.out.printf("Costo: Q%.2f%n", vehiculo.calcularCosto());
        }
    }

    public static void buscarVehiculo() {

        System.out.print("\nIngrese la placa a buscar: ");
        String placa = scanner.nextLine().trim();

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {

                System.out.println("\n===== VEHÍCULO ENCONTRADO =====");

                vehiculo.mostrarInformacion();

                if (vehiculo instanceof Automovil) {
                    System.out.println("Tipo: Automóvil");
                } else {
                    System.out.println("Tipo: Motocicleta");
                }

                System.out.printf("Costo: Q%.2f%n", vehiculo.calcularCosto());

                return;
            }
        }

        System.out.println("No se encontró un vehículo con esa placa.");
    }

    public static void mostrarMayorCosto() {

        if (vehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos registrados.");
            return;
        }

        Vehiculo mayor = vehiculos.get(0);

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.calcularCosto() > mayor.calcularCosto()) {
                mayor = vehiculo;
            }
        }

        System.out.println("\n===== VEHÍCULO DE MAYOR COSTO =====");
        mayor.mostrarInformacion();

        if (mayor instanceof Automovil) {
            System.out.println("Tipo: Automóvil");
        } else {
            System.out.println("Tipo: Motocicleta");
        }

        System.out.printf("Costo: Q%.2f%n", mayor.calcularCosto());
    }

    public static void mostrarTotalGeneral() {

        double total = 0;

        for (Vehiculo vehiculo : vehiculos) {
            total += vehiculo.calcularCosto();
        }

        System.out.println("\n===== TOTAL GENERAL =====");
        System.out.printf("Total recaudado: Q%.2f%n", total);
    }

    public static void mostrarTotalPorTipo() {

        recaudacion.clear();

        for (Vehiculo vehiculo : vehiculos) {

            String tipo;

            if (vehiculo instanceof Automovil) {
                tipo = "Automóvil";
            } else {
                tipo = "Motocicleta";
            }

            recaudacion.put(
                    tipo,
                    recaudacion.getOrDefault(tipo, 0.0) + vehiculo.calcularCosto()
            );
        }

        System.out.println("\n===== TOTAL POR TIPO =====");

        System.out.printf(
                "Automóvil: Q%.2f%n",
                recaudacion.getOrDefault("Automóvil", 0.0)
        );

        System.out.printf(
                "Motocicleta: Q%.2f%n",
                recaudacion.getOrDefault("Motocicleta", 0.0)
        );
    }

    public static int leerEntero(String mensaje) {

        while (true) {

            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");

            } finally {
                System.out.println("Lectura de opción finalizada.");
            }
        }
    }
}