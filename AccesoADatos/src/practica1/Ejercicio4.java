package practica1;

import java.io.File;
import java.util.Iterator;

public class Ejercicio4 {

	public void ejercicio4() {
		
		File f = new File("2DAM");
		
		String[] lista = f.list();
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}
	
}
