package practica1;

import java.io.File;

public class Ejercicio3 {

	public void ejercicio3() {

		File f = new File("2DAM/AD/P1.txt");
		
		File a = new File("2DAM/AD/practica1.txt");
		
		f.renameTo(a);
	
	}

}
