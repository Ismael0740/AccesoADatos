package practica1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner entrada = new Scanner(System.in);

		Ejercicio1 ej1 = new Ejercicio1();
		Ejercicio2 ej2 = new Ejercicio2();
		Ejercicio3 ej3 = new Ejercicio3();
		Ejercicio4 ej4 = new Ejercicio4();
		Ejercicio5 ej5 = new Ejercicio5();
		Ejercicio6 ej6 = new Ejercicio6();

		int seleccion;
		boolean bloqueador = true;

		while (bloqueador) {

			System.out.println(
					"\n\n1 = Ejercicio 1\n2 = Ejercicio 2\n3 = Ejercicio 3\n4 = Ejercicio 4\n5 = Ejercicio 5\n6 = Ejercicio 6\n0 = Salir\n");

			seleccion = entrada.nextInt();
			switch (seleccion) {
			case 0: {
				bloqueador = false;
				break;
			}
			case 1: {
				ej1.ejercicio1();
				break;
			}
			case 2: {
				ej2.ejercicio2();
				break;
			}
			case 3: {
				ej3.ejercicio3();
				break;
			}
			case 4: {
				ej4.ejercicio4();
				break;
			}

			case 5: {
				ej5.ejercicio5();
				break;
			}
			case 6: {
				ej6.ejercicio6();
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + seleccion);
			}
		}

	}

}
