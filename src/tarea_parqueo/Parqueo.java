package tarea_parqueo;


import java.util.Scanner;

public class Parqueo {

    // Método para obtener la tarifa según el tipo de vehículo
    public static double obtenerTarifa(int tipoVehiculo) {
        double tarifa;

        switch (tipoVehiculo) {
            case 1:
                tarifa = 5.00;
                break;
            case 2:
                tarifa = 8.00;
                break;
            case 3:
                tarifa = 12.00;
                break;
            default:
                tarifa = 0.00;
        }

        return tarifa;
    }

    // Método para obtener el nombre del vehículo
    public static String obtenerNombreVehiculo(int tipoVehiculo) {
        String nombre;

        switch (tipoVehiculo) {
            case 1:
                nombre = "Motocicleta";
                break;
            case 2:
                nombre = "Automovil";
                break;
            case 3:
                nombre = "Pickup o camioneta";
                break;
            default:
                nombre = "Desconocido";
        }

        return nombre;
    }

    // Método para calcular el descuento
    public static double calcularDescuento(double subtotal, int horas) {
        double descuento = 0;

        if (horas > 8) {
            descuento = subtotal * 0.15;
        }

        return descuento;
    }

    // Sobrecarga de calcularPago sin recargo
    public static double calcularPago(int horas, double tarifa) {
        return horas * tarifa;
    }

    // Sobrecarga de calcularPago con recargo
    public static double calcularPago(int horas, double tarifa, double recargo) {
        return (horas * tarifa) + recargo;
    }

    // Método para solicitar y validar la hora
    public static int solicitarHora(Scanner entrada, String mensaje) {
        int hora;

        do {
            System.out.print(mensaje);
            hora = entrada.nextInt();

            if (hora < 0 || hora > 23) {
                System.out.println(
                        "Error: la hora debe estar entre 0 y 23."
                );
            }

        } while (hora < 0 || hora > 23);

        return hora;
    }

    // Método para solicitar y validar los minutos
    public static int solicitarMinuto(Scanner entrada, String mensaje) {
        int minuto;

        do {
            System.out.print(mensaje);
            minuto = entrada.nextInt();

            if (minuto < 0 || minuto > 59) {
                System.out.println(
                        "Error: los minutos deben estar entre 0 y 59."
                );
            }

        } while (minuto < 0 || minuto > 59);

        return minuto;
    }

    // Método para calcular los minutos estacionados
    public static int calcularMinutosEstacionado(
            int horaEntrada,
            int minutoEntrada,
            int horaSalida,
            int minutoSalida) {

        int entrada = horaEntrada * 60 + minutoEntrada;
        int salida = horaSalida * 60 + minutoSalida;

        // Si la salida es menor, salió al día siguiente
        if (salida < entrada) {
            salida += 24 * 60;
        }

        return salida - entrada;
    }

    // Método para calcular las horas cobradas
    public static int calcularHorasCobradas(int minutos) {
        int horas = minutos / 60;

        // Si existe una fracción de hora,
        // se cobra una hora completa adicional
        if (minutos % 60 != 0) {
            horas++;
        }

        return horas;
    }

    // Método para mostrar el comprobante
    public static void mostrarComprobante(
            String placa,
            int tipoVehiculo,
            int horaEntrada,
            int minutoEntrada,
            int horaSalida,
            int minutoSalida,
            int horasExactas,
            int minutosExactos,
            int horasCobradas,
            double tarifa,
            double subtotal,
            double descuento,
            double recargo,
            double total) {

        System.out.println();
        System.out.println("========== COMPROBANTE ==========");
        System.out.println("Placa: " + placa);
        System.out.println(
                "Tipo: " + obtenerNombreVehiculo(tipoVehiculo)
        );

        System.out.printf(
                "Hora de entrada: %02d:%02d%n",
                horaEntrada,
                minutoEntrada
        );

        System.out.printf(
                "Hora de salida: %02d:%02d%n",
                horaSalida,
                minutoSalida
        );

        System.out.println(
                "Tiempo estacionado: "
                        + horasExactas
                        + " horas y "
                        + minutosExactos
                        + " minutos"
        );

        System.out.println(
                "Horas cobradas: " + horasCobradas
        );

        System.out.printf(
                "Tarifa por hora: Q%.2f%n",
                tarifa
        );

        System.out.printf(
                "Subtotal: Q%.2f%n",
                subtotal
        );

        System.out.printf(
                "Descuento: Q%.2f%n",
                descuento
        );

        System.out.printf(
                "Recargo por ticket perdido: Q%.2f%n",
                recargo
        );

        System.out.printf(
                "TOTAL: Q%.2f%n",
                total
        );

        System.out.println("=================================");
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Presentación del estudiante
        System.out.println("========================================");
        System.out.println("       SISTEMA DE CONTROL DE PARQUEO");
        System.out.println("========================================");
        System.out.println("Nombre: Angel Estuardo Campos Santay");
        System.out.println("Codigo: 9941-25-4809");
        System.out.println("========================================");
        System.out.println();

        int cantidadVehiculos;

        // Validar cantidad de vehículos
        do {
            System.out.print(
                    "Ingrese la cantidad de vehiculos a registrar: "
            );

            cantidadVehiculos = entrada.nextInt();

            if (cantidadVehiculos <= 0) {
                System.out.println(
                        "Error: la cantidad debe ser mayor que cero."
                );
            }

        } while (cantidadVehiculos <= 0);

        // Contadores
        int cantidadMotocicletas = 0;
        int cantidadAutomoviles = 0;
        int cantidadPickups = 0;
        int cantidadTicketsPerdidos = 0;

        // Acumulador
        double totalRecaudado = 0;

        // Variables para encontrar el pago más alto
        double pagoMasAlto = 0;
        String placaPagoMasAlto = "";

        // Procesar cada vehículo
        for (int i = 1; i <= cantidadVehiculos; i++) {

            System.out.println();
            System.out.println(
                    "========== VEHICULO " + i + " =========="
            );

            // Solicitar placa
            System.out.print("Ingrese el numero de placa: ");
            String placa = entrada.next();

            // Solicitar tipo de vehículo
            int tipoVehiculo;

            do {
                System.out.println();
                System.out.println("1. Motocicleta");
                System.out.println("2. Automovil");
                System.out.println("3. Pickup o camioneta");
                System.out.print(
                        "Seleccione el tipo de vehiculo: "
                );

                tipoVehiculo = entrada.nextInt();

                if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                    System.out.println(
                            "Error: seleccione una opcion entre 1 y 3."
                    );
                }

            } while (tipoVehiculo < 1 || tipoVehiculo > 3);

            // Hora de entrada
            int horaEntrada = solicitarHora(
                    entrada,
                    "Hora de entrada (0-23): "
            );

            // Minuto de entrada
            int minutoEntrada = solicitarMinuto(
                    entrada,
                    "Minuto de entrada (0-59): "
            );

            // Hora de salida
            int horaSalida = solicitarHora(
                    entrada,
                    "Hora de salida (0-23): "
            );

            // Minuto de salida
            int minutoSalida = solicitarMinuto(
                    entrada,
                    "Minuto de salida (0-59): "
            );

            // Calcular minutos estacionado
            int minutosEstacionado = calcularMinutosEstacionado(
                    horaEntrada,
                    minutoEntrada,
                    horaSalida,
                    minutoSalida
            );

            // Validar que el tiempo sea mayor que cero
            while (minutosEstacionado <= 0) {

                System.out.println();
                System.out.println(
                        "Error: el tiempo estacionado debe ser mayor que cero."
                );
                System.out.println(
                        "Ingrese nuevamente los datos de entrada y salida."
                );

                horaEntrada = solicitarHora(
                        entrada,
                        "Hora de entrada (0-23): "
                );

                minutoEntrada = solicitarMinuto(
                        entrada,
                        "Minuto de entrada (0-59): "
                );

                horaSalida = solicitarHora(
                        entrada,
                        "Hora de salida (0-23): "
                );

                minutoSalida = solicitarMinuto(
                        entrada,
                        "Minuto de salida (0-59): "
                );

                minutosEstacionado = calcularMinutosEstacionado(
                        horaEntrada,
                        minutoEntrada,
                        horaSalida,
                        minutoSalida
                );
            }

            // Obtener horas y minutos exactos
            int horasExactas = minutosEstacionado / 60;
            int minutosExactos = minutosEstacionado % 60;

            // Calcular horas que serán cobradas
            int horasCobradas = calcularHorasCobradas(
                    minutosEstacionado
            );

            // Preguntar por el ticket
            char ticket;

            do {
                System.out.print(
                        "¿Perdio el ticket? (S/N): "
                );

                ticket = entrada.next().toUpperCase().charAt(0);

                if (ticket != 'S' && ticket != 'N') {
                    System.out.println(
                            "Error: solamente puede ingresar S o N."
                    );
                }

            } while (ticket != 'S' && ticket != 'N');

            // Obtener tarifa
            double tarifa = obtenerTarifa(tipoVehiculo);

            // Calcular subtotal
            double subtotal = calcularPago(
                    horasCobradas,
                    tarifa
            );

            // Calcular descuento
            double descuento = calcularDescuento(
                    subtotal,
                    horasCobradas
            );

            // Determinar recargo
            double recargo = 0;

            if (ticket == 'S') {
                recargo = 50.00;
                cantidadTicketsPerdidos++;
            }

            // Calcular total
            double total;

            if (ticket == 'S') {

                total = calcularPago(
                        horasCobradas,
                        tarifa,
                        recargo
                ) - descuento;

            } else {

                total = calcularPago(
                        horasCobradas,
                        tarifa
                ) - descuento;
            }

            // Actualizar contadores
            if (tipoVehiculo == 1) {

                cantidadMotocicletas++;

            } else if (tipoVehiculo == 2) {

                cantidadAutomoviles++;

            } else {

                cantidadPickups++;
            }

            // Acumular total recaudado
            totalRecaudado += total;

            // Determinar el pago más alto
            if (total > pagoMasAlto) {
                pagoMasAlto = total;
                placaPagoMasAlto = placa;
            }

            // Mostrar comprobante
            mostrarComprobante(
                    placa,
                    tipoVehiculo,
                    horaEntrada,
                    minutoEntrada,
                    horaSalida,
                    minutoSalida,
                    horasExactas,
                    minutosExactos,
                    horasCobradas,
                    tarifa,
                    subtotal,
                    descuento,
                    recargo,
                    total
            );
        }

        // Resumen de la jornada
        System.out.println();
        System.out.println("========================================");
        System.out.println("          RESUMEN DE LA JORNADA");
        System.out.println("========================================");

        System.out.println(
                "Cantidad de motocicletas: "
                        + cantidadMotocicletas
        );

        System.out.println(
                "Cantidad de automoviles: "
                        + cantidadAutomoviles
        );

        System.out.println(
                "Cantidad de pickups/camionetas: "
                        + cantidadPickups
        );

        System.out.println(
                "Cantidad de tickets perdidos: "
                        + cantidadTicketsPerdidos
        );

        System.out.printf(
                "Total de dinero recaudado: Q%.2f%n",
                totalRecaudado
        );

        System.out.printf(
                "Pago mas alto: Q%.2f%n",
                pagoMasAlto
        );

        System.out.println(
                "Placa del pago mas alto: "
                        + placaPagoMasAlto
        );

        System.out.println("========================================");
        System.out.println("     FIN DEL PROGRAMA");
        System.out.println("========================================");

        entrada.close();
    }
}

