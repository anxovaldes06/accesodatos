package MetodoPago;

public interface MetodoPago {

    void realizarPago(double importe);
    String obtenerDescripcion();
    boolean aceptarPago(double importe);
}
