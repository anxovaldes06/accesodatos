public class Maquina {

    private final Almacen agua = new Almacen(3);
    private final Almacen naranja = new Almacen(2);
    private final Almacen cola = new Almacen(2);

    private int precioAgua = 60;
    private int precioNaranja = 130;
    private int precioCola = 100;

    public boolean reponer(int codigo) {
        Almacen almacen = obtenerAlmacen(codigo);
        if (almacen == null) {
            return false;
        }
        almacen.rellenar();
        return true;
    }

    public int consultarExistencias(int codigo) {
        Almacen almacen = obtenerAlmacen(codigo);
if (almacen == null) {
    return -1;
} else {
    return almacen.getCantidad();
}    }

    public float getPrecio(int codigo) {
        switch (codigo) {
            case 0:
                return precioAgua;
            case 1:
                return precioNaranja;
            case 2:
                return precioCola;
            default:
                return -1;
        }
    }

    public boolean cambiarPrecio(int codigo, int precio) {
        if (precio <= 0) {
            return false;
        }
        switch (codigo) {
            case 0:
                precioAgua = precio;
                return true;
            case 1:
                precioNaranja = precio;
                return true;
            case 2:
                precioCola = precio;
                return true;
            default:
                return false;
        }
    }

    private Almacen obtenerAlmacen(int codigo) {
        switch (codigo) {
            case 0:
                return agua;
            case 1:
                return naranja;
            case 2:
                return cola;
            default:
                return null;
        }
    }


   
    public boolean comprar(int codigo, int pagoCentimos) {

    switch (codigo) {
        case 0:
            if (pagoCentimos == precioAgua && agua.getCantidad() > 0) {
                agua.setCantidad(agua.getCantidad() - 1);

                return true;
            }
            return false;

        case 1:
            if (pagoCentimos == precioNaranja && naranja.getCantidad() > 0) {
                naranja.setCantidad(naranja.getCantidad() - 1);

                return true;
            }
            return false;

        case 2:
            if (pagoCentimos == precioCola && cola.getCantidad() > 0) {
                cola.setCantidad(cola.getCantidad() - 1);

                return true;
            }
            return false;

        default:
            return false;
    }
}

    public static void main ( String [] args){
        Maquina uno = new Maquina();
        Maquina dos = new Maquina();
        dos.naranja.setCantidad(3);
        System.out.println(dos.comprar(1, 130));//Cantidad suficiente, precio y código correcto, devuelve TRUE
        System.out.println(dos.comprar(1, 130));
        System.out.println(dos.comprar(1, 130));//Aunque la Cantidad sea 3, la capacidad es 2, por lo que devuelve FALSE al intentar comprar un tercer.

        
        uno.agua.setCantidad(2);
        uno.cola.setCantidad(2);
       System.out.println(uno.comprar(0,60 )); //devuelve TRUE porque hay 2 aguas y el código y precio es correcto
       System.out.println(uno.comprar(0,60 ));
       System.out.println(uno.comprar(0,60 ));//al restar ya 2 aguas de las 2 totales, no se puede comprar otra, devuelve false
       System.out.println(uno.comprar(1, 130));//aunque precio y código correctos, al no haber cantidad creada de zumos, devuelve false
       System.out.println(uno.comprar(2,100));//hay 2 colas y código y precio correctos, devuelve TRUE

    }
}