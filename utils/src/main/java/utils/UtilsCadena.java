package utils;

public class UtilsCadena {
	
	private UtilsCadena() {
		throw new IllegalArgumentException("UtilsCadena class");
	}

	public static String subString(String cadena, int indiceInicial, int indiceFinal) {
		if (indiceInicial > indiceFinal) {
			throw new IndexOutOfBoundsException("Error, la posici�n inicial es mayor a la posici�n final, no seas pendejo.");
		}
		if (indiceFinal > cadena.length()) {
			return subString(cadena, indiceInicial, indiceFinal - 1);
		} else {
			return cadena.substring(indiceInicial, indiceFinal);
		}
	}
}
