package Arrays;

public class Telefono {
	private final String[] historial;
	private int ultimoIndice = -1;
	private int llamadasValidas;

	public Telefono(int capacidad) {
		if (capacidad < 1) {
			capacidad = 1;
		}
		historial = new String[capacidad];
	}

	public void llamar(String numero) {
		ultimoIndice = (ultimoIndice + 1) % historial.length;
		historial[ultimoIndice] = numero;
		if (llamadasValidas < historial.length) {
			llamadasValidas++;
		}
	}

	public String ultimaLlamada() {
		return llamada(0);
	}

	public String llamada(int n) {
		if (n < 0 || n >= llamadasValidas) {
			return null;
		}
		int indice = (ultimoIndice - n + historial.length) % historial.length;
		return historial[indice];
	}

	public String[] getHistorial() {
		return historial.clone();
	}

	public int getUltimoIndice() {
		return ultimoIndice;
	}

	public int getLlamadasValidas() {
		return llamadasValidas;
	}

	public void Llamar(String numero) {
		llamar(numero);
	}

	public String UltimaLlamada() {
		return ultimaLlamada();
	}

	public String Llamada(int n) {
		return llamada(n);
	}
}
