package pruebaFinal;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		App app = new App();

		Scanner sc = new Scanner(System.in);

		boolean bloqueador = true;
		boolean comprobador1 = true;
		boolean comprobador2 = true;
		boolean comprobador3 = true;
		int eleccion;

		String ficheroOrigen = null;
		String ficheroDestino = null;
		String ficheroCuotas = null;

		while (bloqueador) {
			System.out.println(
					"Elige 1 para instanciar todos los datos y para crear un xml con dichos datos. Elige 2 para mostrar la cuota de pantalla por franja horaria. Elige 0 para salir.");

			eleccion = sc.nextInt();

			switch (eleccion) {
			case 1: {

				while (comprobador1) {

					System.out.println("Escribe el nombre del fichero del que cogeras los datos");
					ficheroOrigen = sc.next();
					if (ficheroOrigen.equals("mediciones")) {
						comprobador1 = false;
					} else {
						System.out.println("Nombre del archivo incorrecto");
					}

				}

				while (comprobador2) {
					System.out.println("Escribe el nombre del fichero donde introduciras los datos en formato xml");
					ficheroDestino = sc.next();
					if (ficheroDestino.equals("Audiencia")) {
						comprobador2 = false;
					} else {
						System.out.println("Nombre del archivo incorrecto");
					}
				}

				app.crear(ficheroOrigen, ficheroDestino);

				break;
			}
			case 2: {

				while (comprobador3) {
					System.out.println("Escribe el nombre del fichero donde generaras la tabla con las cuotas");
					ficheroCuotas = sc.next();
					if (ficheroCuotas.equals("Cuotas")) {
						comprobador3 = false;
					} else {
						System.out.println("Nombre del archivo incorrecto");
					}
				}

				app.crearCuotas(ficheroCuotas);

				break;
			}
			case 0: {

				bloqueador = false;

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + eleccion);
			}

		}

		System.out.println("Saliendo...");

	}

}
