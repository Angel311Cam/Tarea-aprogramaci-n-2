
package Tarea_semana_7;

public class Envio {
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
