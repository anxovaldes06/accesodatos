package MetodoPago;

public class PagoEfectivo implements MetodoPago {

    private static final double LIMITE = 100;

    @Override
    public void realizarPago(double importe) {
        System.out.println("Pago de " + importe + " € realizado en efectivo.");
    }

    @Override
    public String obtenerDescripcion() {
        return "Pago en efectivo";
    }

    @Override
    public boolean aceptarPago(double importe) {
        return importe > 0 && importe <= LIMITE;
    }
}
