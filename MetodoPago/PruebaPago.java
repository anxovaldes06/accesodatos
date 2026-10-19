package MetodoPago;

import java.util.ArrayList;
import java.util.List;

public class PruebaPago {

    public static void main(String[] args) {
        List<MetodoPago> metodos = new ArrayList<>();
        metodos.add(new PagoTarjeta());
        metodos.add(new PagoPaypal());
        metodos.add(new PagoEfectivo());

        double[] importes = {120.5, 250.0, 80.0};

        for (int i = 0; i < metodos.size(); i++) {
            MetodoPago metodo = metodos.get(i);
            double importe = importes[i];

            if (metodo.aceptarPago(importe)) {
                System.out.println("Aceptado: " + metodo.obtenerDescripcion());
                metodo.realizarPago(importe);
            } else {
                System.out.println("Rechazado: " + metodo.obtenerDescripcion() + " para " + importe + " €");
            }
        }
    }
}
