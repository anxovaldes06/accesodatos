package ConfiguracionVehiculo;

public class Coche implements ConfiguracionVehiculo {

    private int velocidad;

    public Coche() {
        this.velocidad = VELOCIDAD_MINIMA;
    }

    public Coche(int velocidad) {
        this.velocidad = validarVelocidad(velocidad);
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = validarVelocidad(velocidad);
    }

    private int validarVelocidad(int valor) {
        if (valor < VELOCIDAD_MINIMA) {
            return VELOCIDAD_MINIMA;
        }
        if (valor > VELOCIDAD_MAXIMA) {
            return VELOCIDAD_MAXIMA;
        }
        return valor;
    }

    @Override
    public int acelerar(int incremento) {
        if (incremento < 0) {
            return velocidad;
        }
        velocidad = validarVelocidad(velocidad + incremento);
        return velocidad;
    }

    public int frenar(int decremento) {
        if (decremento < 0) {
            return velocidad;
        }
        velocidad = validarVelocidad(velocidad - decremento);
        return velocidad;
    }

    public static void main(String[] args) {
        Coche c1 = new Coche();
        System.out.println(c1.acelerar(130));
        System.out.println(c1.acelerar(20));
        System.out.println(c1.frenar(40));
    }
}
