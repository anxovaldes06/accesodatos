package Arrays;

import java.util.Arrays;

public class PruebaTelefono {
	public static void main(String[] args) {
		Telefono telefono = new Telefono(3);
		registrar(telefono, "111");
		registrar(telefono, "222");
		registrar(telefono, "333");
		registrar(telefono, "444");
		registrar(telefono, "555");

		System.out.println(telefono.llamada(0));
		System.out.println(telefono.llamada(1));
		System.out.println(telefono.llamada(2));
		System.out.println(telefono.llamada(3));

		Telefono vacio = new Telefono(0);
		System.out.println(vacio.ultimaLlamada());

		Telefono capacidadUno = new Telefono(1);
		capacidadUno.llamar("111");
		capacidadUno.llamar("222");
		System.out.println(capacidadUno.ultimaLlamada());

		Telefono telefonoA = new Telefono(2);
		Telefono telefonoB = new Telefono(2);
		telefonoA.llamar("A");
		telefonoB.llamar("B");
		System.out.println(telefonoA.ultimaLlamada());
		System.out.println(telefonoB.ultimaLlamada());
	}

	private static void registrar(Telefono telefono, String numero) {
		telefono.llamar(numero);
		System.out.println(Arrays.toString(telefono.getHistorial())
				+ " indice=" + telefono.getUltimoIndice());
	}
}
