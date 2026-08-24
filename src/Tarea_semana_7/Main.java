package Tarea_semana_7;

import java.util.Scanner;

class Envio {
    private String codigo;
    private String nombreDestinatario;
    private double peso;

    public Envio(String codigo, String nombreDestinatario, double peso) {
        this.codigo = codigo;
        this.nombreDestinatario = nombreDestinatario;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public double getPeso() {
        return peso;
    }

    public double calcularCostoBase() {
        return peso * 10.00;
    }

    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN DEL ENVÍO =====");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + nombreDestinatario);
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }

    public void mostrarResumen(boolean desglose) {
        if (desglose) {
            System.out.println("\n===== DESGLOSE DEL ENVÍO =====");
            System.out.println("Código: " + codigo);
            System.out.println("Destinatario: " + nombreDestinatario);
            System.out.printf("Peso del paquete: %.2f kg%n", peso);
            System.out.printf("Costo base: Q%.2f%n", calcularCostoBase());
            System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
        } else {
            mostrarResumen();
        }
    }
}

class EnvioNacional extends Envio {
    private String departamentoDestino;
    private double distancia;

    public EnvioNacional(String codigo, String nombreDestinatario, double peso,
                         String departamentoDestino, double distancia) {
        super(codigo, nombreDestinatario, peso);
        this.departamentoDestino = departamentoDestino;
        this.distancia = distancia;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase() + (distancia * 0.50);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN DEL ENVÍO NACIONAL =====");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getNombreDestinatario());
        System.out.println("Departamento: " + departamentoDestino);
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }

    @Override
    public void mostrarResumen(boolean desglose) {
        if (desglose) {
            System.out.println("\n===== DESGLOSE DEL ENVÍO NACIONAL =====");
            System.out.println("Código: " + getCodigo());
            System.out.println("Destinatario: " + getNombreDestinatario());
            System.out.println("Departamento: " + departamentoDestino);
            System.out.printf("Peso del paquete: %.2f kg%n", getPeso());
            System.out.printf("Costo base: Q%.2f%n", calcularCostoBase());
            System.out.printf("Distancia: %.2f km%n", distancia);
            System.out.printf("Cargo por distancia: Q%.2f%n", distancia * 0.50);
            System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
        } else {
            mostrarResumen();
        }
    }
}

class EnvioInternacional extends Envio {
    private String paisDestino;

    public EnvioInternacional(String codigo, String nombreDestinatario, double peso,
                              String paisDestino) {
        super(codigo, nombreDestinatario, peso);
        this.paisDestino = paisDestino;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase() + 75.00 + (calcularCostoBase() * 0.12);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN DEL ENVÍO INTERNACIONAL =====");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getNombreDestinatario());
        System.out.println("País: " + paisDestino);
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }

    @Override
    public void mostrarResumen(boolean desglose) {
        if (desglose) {
            double costoBase = calcularCostoBase();
            double recargo = costoBase * 0.12;

            System.out.println("\n===== DESGLOSE DEL ENVÍO INTERNACIONAL =====");
            System.out.println("Código: " + getCodigo());
            System.out.println("Destinatario: " + getNombreDestinatario());
            System.out.println("País: " + paisDestino);
            System.out.printf("Peso del paquete: %.2f kg%n", getPeso());
            System.out.printf("Costo base: Q%.2f%n", costoBase);
            System.out.printf("Cargo internacional: Q%.2f%n", 75.00);
            System.out.printf("Recargo del 12%%: Q%.2f%n", recargo);
            System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
        } else {
            mostrarResumen();
        }
    }
}

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
