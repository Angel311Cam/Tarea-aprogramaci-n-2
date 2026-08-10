package Parcial_uno_cajero;
import java.util.Scanner;

public class CajeroAutomatico {

    static final String TITULAR = "Angel Estuardo Campos Santay";
    static final String NUMERO_CUENTA = "4809";
    static final int PIN_CORRECTO = 2026;
    static final double SALDO_INICIAL = 1000.00;
    static final double COMISION = 10.00;
    static final double MAX_DEPOSITO = 5000.00;
    static final double MAX_RETIRO = 2000.00;

    static double saldo = SALDO_INICIAL;
    static int cantidadDepositos = 0;
    static double totalDepositado = 0.00;
    static int cantidadRetiros = 0;
    static double totalRetirado = 0.00;
    static double totalComisiones = 0.00;
    static int operacionesRechazadas = 0;
    static int opcionesInvalidas =  1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("        CAJERO AUTOMATICO");
        System.out.println("        PROGRAMACION II");
        System.out.println("==========================================");
        System.out.println("Titular: " + TITULAR);
        System.out.println("Numero de cuenta: " + NUMERO_CUENTA);
        System.out.println();

        if (!validarAcceso(scanner)) {

            System.out.println();
            System.out.println("La cuenta ha sido bloqueada durante esta sesion.");
            System.out.println("El programa finalizara por seguridad.");

            scanner.close();
            return;
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("Bienvenido(a), " + TITULAR);
        System.out.println("Acceso concedido correctamente.");
        System.out.println("==========================================");

        mostrarMenu(scanner);

        scanner.close();

        System.out.println();
        System.out.println("Conexion cerrada de forma segura.");
    }

    public static boolean validarAcceso(Scanner scanner) {

        boolean accesoConcedido = false;

        for (int intento = 1; intento <= 3; intento++) {

            System.out.print("Ingrese su PIN: ");
            int pin = scanner.nextInt();

            if (pin == PIN_CORRECTO) {

                System.out.println("PIN correcto.");

                accesoConcedido = true;

                break;

            } else {

                int intentosRestantes = 3 - intento;

                if (intentosRestantes > 0) {

                    System.out.println(
                            "PIN incorrecto. Intentos restantes: "
                                    + intentosRestantes
                    );

                } else {

                    System.out.println(
                            "PIN incorrecto. No quedan intentos."
                    );
                }
            }
        }

        return accesoConcedido;
    }

    public static void mostrarMenu(Scanner scanner) {

        int opcion;

        do {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("             MENU PRINCIPAL");
            System.out.println("==========================================");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Realizar retiro normal");
            System.out.println("4. Realizar retiro con comision");
            System.out.println("5. Mostrar resumen de la sesion");
            System.out.println("6. Salir");
            System.out.println("==========================================");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    consultarSaldo();
                    break;

                case 2:
                    procesarDeposito(scanner);
                    break;

                case 3:
                    procesarRetiro(scanner);
                    break;

                case 4:
                    procesarRetiro(scanner, COMISION);
                    break;

                case 5:
                    mostrarResumen();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Salida seleccionada.");
                    mostrarResumen();
                    System.out.println();
                    System.out.println("Gracias por utilizar el Cajero Automatico.");
                    break;

                default:
                    opcionesInvalidas++;
                    System.out.println();
                    System.out.println("Opcion inexistente. Intente nuevamente.");
                    continue;
            }

        } while (opcion != 6);
    }

    public static void consultarSaldo() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          CONSULTA DE SALDO");
        System.out.println("==========================================");

        System.out.println("Titular: " + TITULAR);
        System.out.println("Numero de cuenta: " + NUMERO_CUENTA);

        System.out.printf(
                "Saldo disponible: Q%.2f%n",
                saldo
        );
    }

    public static void procesarDeposito(Scanner scanner) {

        double monto;

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              DEPOSITO");
        System.out.println("==========================================");

        while (true) {

            System.out.print(
                    "Ingrese el monto a depositar: Q"
            );

            monto = scanner.nextDouble();

            if (monto <= 0) {

                System.out.println(
                        "Monto invalido: debe ser mayor que Q0.00."
                );

            } else if (monto > MAX_DEPOSITO) {

                System.out.println(
                        "Monto invalido: no puede superar Q5,000.00 por operacion."
                );

            } else {

                break;
            }
        }

        double saldoAnterior = saldo;

        saldo = saldo + monto;

        cantidadDepositos++;
        totalDepositado = totalDepositado + monto;

        System.out.println();
        System.out.printf(
                "Monto depositado: Q%.2f%n",
                monto
        );

        System.out.printf(
                "Saldo anterior: Q%.2f%n",
                saldoAnterior
        );

        System.out.printf(
                "Saldo actualizado: Q%.2f%n",
                saldo
        );
    }

    public static void procesarRetiro(@org.jetbrains.annotations.NotNull Scanner scanner) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           RETIRO NORMAL");
        System.out.println("==========================================");

        System.out.print(
                "Ingrese el monto a retirar: Q"
        );

        double monto = scanner.nextDouble();

        if (monto <= 0) {

            rechazarRetiro(
                    "El monto debe ser mayor que Q0.00."
            );

            return;
        }

        if (monto % 20 != 0) {

            rechazarRetiro(
                    "El monto debe ser multiplo de Q20.00."
            );

            return;
        }

        if (monto > MAX_RETIRO) {

            rechazarRetiro(
                    "El monto no puede superar Q2,000.00 por operacion."
            );

            return;
        }

        if (monto > saldo) {

            rechazarRetiro(
                    "Fondos insuficientes: el monto supera el saldo disponible."
            );

            return;
        }

        double saldoAnterior = saldo;

        saldo = saldo - monto;

        cantidadRetiros++;
        totalRetirado = totalRetirado + monto;

        System.out.println();
        System.out.println("RETIRO APROBADO");

        System.out.printf(
                "Monto solicitado: Q%.2f%n",
                monto
        );

        System.out.printf(
                "Saldo anterior: Q%.2f%n",
                saldoAnterior
        );

        System.out.printf(
                "Total debitado: Q%.2f%n",
                monto
        );

        System.out.printf(
                "Saldo actualizado: Q%.2f%n",
                saldo
        );
    }

    public static void procesarRetiro(
            Scanner scanner,
            double comision) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       RETIRO CON COMISION");
        System.out.println("==========================================");

        System.out.print(
                "Ingrese el monto a retirar: Q"
        );

        double monto = scanner.nextDouble();

        if (monto <= 0) {

            rechazarRetiro(
                    "El monto debe ser mayor que Q0.00."
            );

            return;
        }

        if (monto % 20 != 0) {

            rechazarRetiro(
                    "El monto debe ser multiplo de Q20.00."
            );

            return;
        }

        if (monto > MAX_RETIRO) {

            rechazarRetiro(
                    "El monto no puede superar Q2,000.00 por operacion."
            );

            return;
        }

        double totalDebitar = monto + comision;

        if (totalDebitar > saldo) {

            rechazarRetiro(
                    "Fondos insuficientes: el saldo no cubre el retiro mas la comision de Q10.00."
            );

            return;
        }

        double saldoAnterior = saldo;

        saldo = saldo - totalDebitar;

        cantidadRetiros++;
        totalRetirado = totalRetirado + monto;
        totalComisiones = totalComisiones + comision;

        System.out.println();
        System.out.println("RETIRO APROBADO");

        System.out.printf(
                "Monto solicitado: Q%.2f%n",
                monto
        );

        System.out.printf(
                "Comision: Q%.2f%n",
                comision
        );

        System.out.printf(
                "Total debitado: Q%.2f%n",
                totalDebitar
        );

        System.out.printf(
                "Saldo anterior: Q%.2f%n",
                saldoAnterior
        );

        System.out.printf(
                "Saldo actualizado: Q%.2f%n",
                saldo
        );
    }

    public static void rechazarRetiro(String motivo) {

        operacionesRechazadas++;

        System.out.println();
        System.out.println("RETIRO RECHAZADO");

        System.out.println(
                "Motivo: " + motivo
        );

        System.out.println(
                "El saldo no ha sido modificado."
        );
    }

    public static void mostrarResumen() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          RESUMEN DE LA SESION");
        System.out.println("==========================================");

        System.out.printf(
                "Saldo inicial: Q%.2f%n",
                SALDO_INICIAL
        );

        System.out.println(
                "Cantidad de depositos exitosos: "
                        + cantidadDepositos
        );

        System.out.printf(
                "Total depositado: Q%.2f%n",
                totalDepositado
        );

        System.out.println(
                "Cantidad de retiros exitosos: "
                        + cantidadRetiros
        );

        System.out.printf(
                "Total entregado en retiros: Q%.2f%n",
                totalRetirado
        );

        System.out.printf(
                "Total cobrado en comisiones: Q%.2f%n",
                totalComisiones
        );

        System.out.println(
                "Cantidad de operaciones rechazadas: "
                        + operacionesRechazadas
        );

        System.out.println(
                "Cantidad de opciones invalidas: "
                        + opcionesInvalidas
        );

        System.out.printf(
                "Saldo actual: Q%.2f%n",
                saldo
        );

        System.out.println(
                "=========================================="
        );
    }
}

