package Tarea_semana_7;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNacional();
                    break;

                case 2:
                    registrarInternacional();
                    break;

                case 3:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpción inválida.");
            }

        } while (opcion != 3);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n==============================================");
        System.out.println("             SISTEMA DE ENVÍOS");
        System.out.println("==============================================");
        System.out.println("Nombre: Angel Estuardo Campos Santay");
        System.out.println("Carné: 9941-25-4809");
        System.out.println("==============================================");
        System.out.println("1. Registrar envío nacional");
        System.out.println("2. Registrar envío internacional");
        System.out.println("3. Salir");
        System.out.println("==============================================");
    }

    public static int leerOpcion() {
        while (true) {
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion >= 1 && opcion <= 3) {
                    return opcion;
                }

                System.out.println("Error: seleccione una opción entre 1 y 3.");
            } else {
                System.out.println("Error: debe ingresar un número.");
                scanner.nextLine();
            }
        }
    }

    public static void registrarNacional() {
        System.out.println("\n===== REGISTRO DE ENVÍO NACIONAL =====");

        String codigo = leerTexto("Código del envío: ");
        String destinatario = leerTexto("Nombre del destinatario: ");
        double peso = leerDoublePositivo("Peso del paquete en kg: ");
        String departamento = leerTexto("Departamento de destino: ");
        double distancia = leerDoublePositivo("Distancia en kilómetros: ");

        Envio envio = new EnvioNacional(
                codigo,
                destinatario,
                peso,
                departamento,
                distancia
        );

        envio.mostrarResumen(true);

        preguntarOtroEnvio();
    }

    public static void registrarInternacional() {
        System.out.println("\n===== REGISTRO DE ENVÍO INTERNACIONAL =====");

        String codigo = leerTexto("Código del envío: ");
        String destinatario = leerTexto("Nombre del destinatario: ");
        double peso = leerDoublePositivo("Peso del paquete en kg: ");
        String pais = leerTexto("País de destino: ");

        Envio envio = new EnvioInternacional(
                codigo,
                destinatario,
                peso,
                pais
        );

        envio.mostrarResumen(true);

        preguntarOtroEnvio();
    }

    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("Error: este campo no puede estar vacío.");
        }
    }

    public static double leerDoublePositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextDouble()) {
                double valor = scanner.nextDouble();
                scanner.nextLine();

                if (valor > 0) {
                    return valor;
                }

                System.out.println("Error: el valor debe ser mayor que cero.");
            } else {
                System.out.println("Error: debe ingresar un valor numérico.");
                scanner.nextLine();
            }
        }
    }

    public static void preguntarOtroEnvio() {
        while (true) {
            System.out.print("\n¿Desea registrar otro envío? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return;
            }

            if (respuesta.equals("n")) {
                return;
            }

            System.out.println("Error: ingrese solamente 's' o 'n'.");
        }
    }
}
