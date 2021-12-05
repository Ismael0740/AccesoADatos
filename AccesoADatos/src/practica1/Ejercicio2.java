package practica1;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

	public void ejercicio2() throws IOException {

		
		//CREAMOS 2DAM
		
		File f = new File("2DAM");
		f.mkdir();
		
		//CREAMOS AD DENTRO DE 2DAM Y TODOS SUS ARCHIVOS
		
		File a = new File("2DAM/AD");
		a.mkdir();
		
		File a1 = new File("2DAM/AD/P1.txt");
		File a2 = new File("2DAM/AD/UD1.txt");
		File a3 = new File("2DAM/AD/UD2.txt");
		a1.createNewFile();
		a2.createNewFile();
		a3.createNewFile();
		
		//CREAMOS PSP DENTRO DE 2DAM Y TODOS SUS ARCHIVOS
		
		File b = new File("2DAM/PSP");
		b.mkdir();
		
		File b1 = new File("2DAM/PSP/UD1.txt");
		File b2 = new File("2DAM/PSP/UD2.txt");
		b1.createNewFile();
		b2.createNewFile();
		
		//CREAMOS MISNOTAS DENTRO DE 2DAM
		
		File c = new File("2DAM/misNotas.txt");
		c.createNewFile();
	}

}
