package Tarea_semana_7;

public class EnvioNacional extends Envio {
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