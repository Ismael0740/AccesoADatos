package plantillaXML;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {

		App app = new App();

		Scanner sc = new Scanner(System.in);

		app.recopilarInfo();
		
		
		boolean bloqueador = true;
		while (bloqueador) {

			int eleccion = sc.nextInt();

			switch (eleccion) {
			case 1: {
				app.mostrarFichero();
				break;
			}
			case 2: {
				System.out.println("Introduce el nombre del desayuno");
				String nombre = sc.next();
				System.out.println("Introduce su precio");
				String precio = sc.next();
				System.out.println("Introduce su descripcion");
				String descripcion = sc.next();
				System.out.println("Introduce sus calorias");
				String calorias = sc.next();
				app.crearDesayuno(nombre, precio, descripcion, calorias);
				app.escribirDatos();
				break;
			}
			case 3: {
				System.out.println("Saliendo");
				bloqueador = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + eleccion);
			}

		}
	}

}
