package estacionamiento;

public class Motocicleta extends Vehiculo {

    public Motocicleta(String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {
        double costo = getHorasUtilizadas() * 6.0;

        if (getHorasUtilizadas() > 5) {
            costo = costo - (costo * 0.10);
        }

        return costo;
    }
}