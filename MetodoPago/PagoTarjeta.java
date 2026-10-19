package MetodoPago;

public class PagoTarjeta implements MetodoPago {

    private static final double LIMITE = 500;

    @Override
    public void realizarPago(double importe) {
        System.out.println("Pago de " + importe + " € realizado con tarjeta.");
    }

    @Override
    public String obtenerDescripcion() {
        return "Pago con tarjeta";
    }

    @Override
    public boolean aceptarPago(double importe) {
        return importe > 0 && importe <= LIMITE;
    }
}