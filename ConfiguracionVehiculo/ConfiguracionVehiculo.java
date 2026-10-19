package ConfiguracionVehiculo;

public interface ConfiguracionVehiculo {

    int VELOCIDAD_MINIMA = 0;
    int VELOCIDAD_MAXIMA = 120;

    int acelerar(int incremento);
    int frenar(int decremento);
}
