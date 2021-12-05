package practica1;

import java.io.File;
import java.util.Iterator;

public class Ejercicio5 {

	public void ejercicio5() {

		File f = new File("2DAM");

		String[] lista = f.list();

		for (int i = 0; i < lista.length; i++) {
			File a = new File("2DAM/" + lista[i]);
			System.out.println(lista[i] + "  Ruta absoluta => " + a.getAbsolutePath());

			String[] listaProfunda = a.list();
			if (a.isFile()) {
			} else {
				System.out.println("Directorios dentro de " + lista[i] + ":");
				for (int j = 0; j < listaProfunda.length; j++) {
					System.out.println(listaProfunda[j] + "  Ruta absoluta => " + a.getAbsolutePath() + "/" + lista[j]);
				}
				System.out.println("Final de directorios dentro de " + lista[i]);
			}

		}

	}

}
