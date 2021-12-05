package practica1;

import java.io.File;

public class Ejercicio1 {

	public void ejercicio1() {

		String ruta = "src/";
		String nombre = "file001.txt";
		File f = new File(ruta+nombre);
		
		f.setExecutable(false);
		
		System.out.println("Nombre " + f.getName());
		System.out.println("Ruta " + f.getAbsolutePath());
		System.out.println("Directorio padre: " + f.getParent());
		if (f.exists()) {
			System.out.println("El fichero existe!");
			System.out.println("Permisos(rwx)=> " + f.canRead()+f.canWrite() + f.canExecute());
			System.out.println("Longitud del fichero " + f.length() + " bytes");
			
		} else {
			System.out.println("El fichero no existe");
		}
		
	
	}

}
