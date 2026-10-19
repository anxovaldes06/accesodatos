package MetodoPago;

public class PagoPaypal implements MetodoPago {

    private static final double LIMITE = 300;

    @Override
    public void realizarPago(double importe) {
        System.out.println("Pago de " + importe + " € realizado con PayPal.");
    }

    @Override
    public String obtenerDescripcion() {
        return "Pago con PayPal";
    }

    @Override
    public boolean aceptarPago(double importe) {
        return importe > 0 && importe <= LIMITE;
    }
}