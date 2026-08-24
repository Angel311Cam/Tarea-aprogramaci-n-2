package Tarea_semana_7;

public class EnvioInternacional extends Envio {
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