
import java.util.Scanner;

public class Wordle {

	public static void main(String[] args) {
		/*
		 * Crear Wordle
		 * 
		 * Palabras de 5 letras
		 * 
		 * Se introduce una palabra y se enseña por consola si las letras existen en la
		 * palabra y si están colocadas correctamente
		 * 
		 * hay 6 intentos
		 */

		String palabraAdivinar = BancoPalabras();
		String palabraIntroducida;
		String numeros = "0123456789";
		int longitud = 5;
		boolean victoria = false;
		int contador = 0;
		String[] hueco = { "【 】【 】【 】【 】【 】", "【 】【 】【 】【 】【 】", "【 】【 】【 】【 】【 】", "【 】【 】【 】【 】【 】",
				"【 】【 】【 】【 】【 】", "【 】【 】【 】【 】【 】" };

		Scanner lector = new Scanner(System.in);

		System.out.println("" 
				+ "████████████████████████████████████████\r\n"
				+ "█▄─█▀▀▀█─▄█─▄▄─█▄─▄▄▀█▄─▄▄▀█▄─▄███▄─▄▄─█\r\n" 
				+ "██─█─█─█─██─██─██─▄─▄██─██─██─██▀██─▄█▀█\r\n"
				+ "▀▀▄▄▄▀▄▄▄▀▀▄▄▄▄▀▄▄▀▄▄▀▄▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▄▀\r\n" + "");

		System.out.println("¡𝐀𝐃𝐈𝐕𝐈𝐍𝐀 𝐋𝐀 𝐏𝐀𝐋𝐀𝐁𝐑𝐀 𝐎𝐂𝐔𝐋𝐓𝐀!");
		System.out.println(
				"𝐋𝐚 𝐩𝐚𝐥𝐚𝐛𝐫𝐚 𝐭𝐢𝐞𝐧𝐞 𝟓 𝐥𝐞𝐭𝐫𝐚𝐬 𝐲 𝐭𝐢𝐞𝐧𝐞𝐬 𝟔 𝐢𝐧𝐭𝐞𝐧𝐭𝐨𝐬 𝐩𝐚𝐫𝐚 𝐚𝐝𝐢𝐯𝐢𝐧𝐚𝐫𝐥𝐚.");
		System.out.println(
				"𝐈𝐧𝐭𝐫𝐨𝐝𝐮𝐜𝐞 𝐮𝐧𝐚 𝐩𝐚𝐥𝐚𝐛𝐫𝐚. 𝐕𝐚𝐧 𝐚𝐩𝐚𝐫𝐞𝐜𝐢𝐞𝐧𝐝𝐨 𝐥𝐚𝐬 𝐥𝐞𝐭𝐫𝐚𝐬 𝐚𝐜𝐞𝐫𝐭𝐚𝐝𝐚𝐬 𝐲 𝐛𝐢𝐞𝐧 𝐩𝐨𝐬𝐢𝐜𝐢𝐨𝐧𝐚𝐝𝐚𝐬 𝐞𝐧 𝐦𝐚𝐲ú𝐬𝐜𝐮𝐥𝐚𝐬:【𝐀】");
		System.out.println(
				"𝐒𝐢 𝐞𝐬𝐭á𝐧 𝐦𝐚𝐥 𝐩𝐨𝐬𝐢𝐜𝐢𝐨𝐧𝐚𝐝𝐚𝐬, 𝐚𝐩𝐚𝐫𝐞𝐜𝐞𝐧 𝐞𝐧 𝐦𝐢𝐧ú𝐬𝐜𝐮𝐥𝐚:【𝐚】");

		do {

			if (contador < 6) {

				do {
					System.out.println("");
					System.out.println("ɪɴᴛᴇɴᴛᴏ ɴº" + (contador + 1) + ":");
					palabraIntroducida = lector.nextLine();
					palabraIntroducida = palabraIntroducida.toUpperCase();
				} while (palabraIntroducida.length() != longitud || ContieneAlgo(palabraIntroducida, numeros, longitud)
						|| palabraIntroducida.isBlank()); // que sea del tamaño adecuado, no tenga números ni esté vacía

				// mete la palabra introducida al "tablero"
				hueco[contador] = PalabraIntroducida(palabraIntroducida, palabraAdivinar, longitud);

				if (palabraAdivinar.matches(palabraIntroducida)) {
					contador = 7;
					victoria = true;
				} else if (ContieneAlgo(palabraIntroducida, palabraAdivinar, longitud)) {
					System.out.println("Existen letras");
				} else {
					System.out.println("No existen las letras");
				}

				ImprimirHuecos(hueco, contador); // muestra por pantalla el "tablero"

			}
			contador++;
		} while (contador < 6);

		// finales de juego
		if (victoria) {
			System.out.println("\r\n"
					+ "▒█▀▀▀ ▒█▀▀▀ ▒█░░░ ▀█▀ ▒█▀▀█ ▀█▀ ▒█▀▀▄ ░█▀▀█ ▒█▀▀▄ ▒█▀▀▀ ▒█▀▀▀█ ░░ 　 ▒█░▒█ ░█▀▀█ ▒█▀▀▀█ 　 ░█▀▀█ ▒█▀▀█ ▒█▀▀▀ ▒█▀▀█ ▀▀█▀▀ ░█▀▀█ ▒█▀▀▄ ▒█▀▀▀█ \r\n"
					+ "▒█▀▀▀ ▒█▀▀▀ ▒█░░░ ▒█░ ▒█░░░ ▒█░ ▒█░▒█ ▒█▄▄█ ▒█░▒█ ▒█▀▀▀ ░▀▀▀▄▄ ▄▄ 　 ▒█▀▀█ ▒█▄▄█ ░▀▀▀▄▄ 　 ▒█▄▄█ ▒█░░░ ▒█▀▀▀ ▒█▄▄▀ ░▒█░░ ▒█▄▄█ ▒█░▒█ ▒█░░▒█ \r\n"
					+ "▒█░░░ ▒█▄▄▄ ▒█▄▄█ ▄█▄ ▒█▄▄█ ▄█▄ ▒█▄▄▀ ▒█░▒█ ▒█▄▄▀ ▒█▄▄▄ ▒█▄▄▄█ ░█ 　 ▒█░▒█ ▒█░▒█ ▒█▄▄▄█ 　 ▒█░▒█ ▒█▄▄█ ▒█▄▄▄ ▒█░▒█ ░▒█░░ ▒█░▒█ ▒█▄▄▀ ▒█▄▄▄█");
		} else {
			System.out.println("\r\n" 
					+ "▒█▀▀▀ ▀█▀ ▒█▄░▒█ 　 ▒█▀▀▄ ▒█▀▀▀ ▒█░░░ 　 ░░░▒█ ▒█░▒█ ▒█▀▀▀ ▒█▀▀█ ▒█▀▀▀█ \r\n"
					+ "▒█▀▀▀ ▒█░ ▒█▒█▒█ 　 ▒█░▒█ ▒█▀▀▀ ▒█░░░ 　 ░▄░▒█ ▒█░▒█ ▒█▀▀▀ ▒█░▄▄ ▒█░░▒█ \r\n"
					+ "▒█░░░ ▄█▄ ▒█░░▀█ 　 ▒█▄▄▀ ▒█▄▄▄ ▒█▄▄█ 　 ▒█▄▄█ ░▀▄▄▀ ▒█▄▄▄ ▒█▄▄█ ▒█▄▄▄█");
		}
		lector.close();
	}

	private static boolean ContieneAlgo(String cadena, String validacion, int longitud) {
		boolean contiene = false;
		char letra;

		for (int i = 0; i < longitud; i++) {
			letra = cadena.charAt(i);
			if (validacion.indexOf(letra) != -1) {
				contiene = true;
			}
		}

		return contiene;
	}

	private static String PalabraIntroducida(String cadena, String validacion, int longitud) {
		char letra;
		String temporal = "";
		boolean escrita = false;

		for (int i = 0; i < longitud; i++) {
			letra = cadena.charAt(i);
			if (validacion.charAt(i) == letra) {
				temporal += " " + letra + " ";
			} else if (validacion.indexOf(letra) != -1) {
				if (LetrasRepetidas(cadena, longitud) && !escrita) {
					temporal += "【" + letra + "】";
					temporal = temporal.toLowerCase();
				} else {
					temporal += "【" + " " + "】";
				}
			} else {
				temporal += "【" + " " + "】";
			}
		}

		return temporal;
	}

	private static void ImprimirHuecos(String[] huecos, int contador) {
		for (int j = 0; j < 6; j++) {
			if (j == contador) {
				System.out.println(huecos[j].toString() + " ᐸ");
			} else {
				System.out.println(huecos[j].toString());
			}
		}
	}

	// si hay letras repetidas en la palabra introducida, solo se muestra una
	private static boolean LetrasRepetidas(String cadena, int longitud) {
		char letra;
		boolean repeticion = false;

		for (int i = 0; i < longitud; i++) {
			letra = cadena.charAt(i);
			for (int j = 0; j < longitud; j++) {
				if (letra == cadena.charAt(j)) {
					repeticion = true;
				}
			}
		}
		return repeticion;
	}

	private static String BancoPalabras() {
		String[] palabrasAleatorias = { "BRAZO", "CARPA", "CELTA", "CASCO", "ERIZO", "GAFAS", "FUSIL", "FOLIO", "HORNO",
				"LEJOS", "ARBOL", "EPICO", "ETICA", "VIDEO", "YOGUR" };
		int numero;
		numero = (int) (Math.random() * palabrasAleatorias.length);
		return palabrasAleatorias[numero];
	}

}
