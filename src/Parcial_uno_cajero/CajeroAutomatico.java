package Parcial_uno_cajero;

import java.util.Scanner;

public class CajeroAutomatico {

    static Scanner entrada = new Scanner(System.in);
    static double saldo = 1000.00;
    static int pin = 1234;
    static String historial = "";

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("         CAJERO AUTOMÁTICO");
        System.out.println("==========================================");
        System.out.println("Nombre: Angel Estuardo Campos Santay");
        System.out.println("Código: 9941-25-4809");
        System.out.println("PIN de acceso: 1234");
        System.out.println("==========================================");

        if (!iniciarSesion()) {
            System.out.println("Acceso bloqueado.");
            entrada.close();
            return;
        }

        int opcion;

        do {
            mostrarMenu();
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a depositar: Q");
                    double deposito = entrada.nextDouble();
                    depositar(deposito);
                    break;

                case 3:
                    System.out.print("Ingrese la cantidad a retirar: Q");
                    double retiro = entrada.nextDouble();
                    retirar(retiro);
                    break;

                case 4:
                    mostrarHistorial();
                    break;

                case 5:
                    mostrarMensaje();
                    break;

                default:
                    mostrarMensaje("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);

        entrada.close();
    }

    public static boolean iniciarSesion() {

        int intentos = 0;
        boolean acceso = false;

        while (intentos < 3 && !acceso) {

            System.out.print("Ingrese su PIN: ");
            int pinIngresado = entrada.nextInt();

            if (pinIngresado == pin) {
                acceso = true;
                System.out.println("PIN correcto. Bienvenido.");
            } else {
                intentos++;
                System.out.println("PIN incorrecto.");
                System.out.println("Intentos restantes: " + (3 - intentos));
            }
        }

        return acceso;
    }

    public static void mostrarMenu() {

        System.out.println();
        System.out.println("========== MENÚ PRINCIPAL ==========");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Historial de movimientos");
        System.out.println("5. Salir");
        System.out.println("====================================");
        System.out.print("Seleccione una opción: ");
    }

    public static void consultarSaldo() {
        mostrarSaldo(saldo);
    }

    public static void mostrarSaldo() {
        System.out.println("Saldo disponible: Q" + saldo);
    }

    public static void mostrarSaldo(double cantidad) {
        System.out.println("Saldo disponible: Q" + cantidad);
    }

    public static void depositar(double cantidad) {

        if (cantidad > 0) {
            saldo = saldo + cantidad;

            historial = historial + "Depósito: +Q" + cantidad + "\n";

            System.out.println("Depósito realizado correctamente.");
            mostrarSaldo();
        } else {
            mostrarMensaje("La cantidad debe ser mayor que cero.");
        }
    }

    public static void retirar(double cantidad) {

        if (cantidad <= 0) {

            mostrarMensaje("La cantidad debe ser mayor que cero.");

        } else if (cantidad <= saldo) {

            saldo = saldo - cantidad;

            historial = historial + "Retiro: -Q" + cantidad + "\n";

            System.out.println("Retiro realizado correctamente.");
            mostrarSaldo();

        } else {

            mostrarMensaje("Saldo insuficiente.");
        }
    }

    public static void mostrarHistorial() {

        System.out.println();
        System.out.println("========== HISTORIAL ==========");

        if (historial.equals("")) {
            System.out.println("No hay movimientos registrados.");
        } else {
            System.out.print(historial);
        }

        System.out.println("===============================");
    }

    public static void mostrarMensaje() {
        System.out.println("Gracias por utilizar el cajero automático.");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}