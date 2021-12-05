package practica3;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException, ParseException {

		Scanner entrada = new Scanner(System.in);

		boolean bloqueador = true;

		App app = new App();

		while (bloqueador) {

			System.out.println(
					"Introduce 1 para entrar en el apartado de vuelos. Introduce 2 para entrar en el apartado de hoteles. Introduce 3 para entrar en el apartado de paquetes de viaje:"
							+ "(ADVERTENCIA: Para poder listar los vuelos hoteles y viajes primero debes introducir y terminar una ejecucion del programa. De otra manera si intentas acceder al fichero satlara error. ya que no hay ningun dato guardado.)");
			int eleccion = entrada.nextInt();

			if (eleccion != 1 & eleccion != 2 & eleccion != 3 & eleccion != 0) {
				System.out.println("No has introducido una opcion valida");
			} else {
				switch (eleccion) {
				case 1: {

					System.out.println("**GESTIONAR VUELOS**");
					System.out
							.println("Escribe 1 para listar los vuelos\nEscribe 2 para introducir modificar o borrar");
					eleccion = entrada.nextInt();
					if (eleccion == 1) {
						listarVuelos(app);
					}
					if (eleccion == 2) {
						operarVuelos(app);
					}

					break;
				}
				case 2: {
					System.out.println("**GESTIONAR HOTELES**");
					System.out
							.println("Escribe 1 para listar los hoteles\nEscribe 2 para introducir modificar o borrar");
					eleccion = entrada.nextInt();
					if (eleccion == 1) {
						listarHoteles(app);
					}
					if (eleccion == 2) {
						operarHoteles(app);
					}
					break;
				}
				case 3: {
					System.out.println("**GESTIONAR PAQUETES DE VIAJES**");
					System.out.println(
							"Escribe 1 para listar los paquetes\nEscribe 2 para introducir modificar o borrar");
					eleccion = entrada.nextInt();
					if (eleccion == 1) {
						listarPaquetes(app);
					}
					if (eleccion == 2) {
						operarPaquetes(app);
					}
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
		}
		app.guardarInfo();

	}

	public static void listarVuelos(App app) throws IOException {

		app.listarVuelos();

	}

	public static void operarVuelos(App app) throws ParseException {
		Scanner entrada = new Scanner(System.in);

		boolean bloqueador = true;

		while (bloqueador) {

			System.out
					.println("Elige 1, 2 o 3 para introducir, modificar o borrar algun vuelo. Introduce 0 para salir:");

			int eleccion = entrada.nextInt();

			switch (eleccion) {
			case 1: {
				System.out.println("Introduce un numero que identifique el vuelo:");
				int id = entrada.nextInt();

				// Comprueba si existe un vuelo con ese ID

				if (!app.comprobarIdVuelo(id)) {
					System.out.println("Ya existe un vuelo con dicho numero");
					break;
				}

				System.out.println("Introduce la compañia del vuelo:");
				String compañia = entrada.next();
				System.out.println("Introduce la ciudad de donde sale el vuelo:");
				String origen = entrada.next();
				System.out.println("Introduce la ciudad donde se dirige el vuelo:");
				String destino = entrada.next();
				System.out.println("Introduce el precio del vuelo:");
				double precio = entrada.nextDouble();
				app.añadirVuelo(id, compañia, origen, destino, precio);
				break;
			}
			case 2: {

				break;
			}
			case 3: {
				System.out.println("Introduce el id del vuelo a borrar:");
				int id = entrada.nextInt();

				// Comprueba si existe un vuelo con ese ID

				if (app.comprobarIdVuelo(id)) {
					System.out.println("No existe el vuelo al que te estas refiriendo");
					break;
				}

				app.borrarVuelo(id);
				System.out.println("Vuelo borrado");
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
	}

	public static void listarHoteles(App app) throws IOException {

		app.listarHoteles();

	}

	public static void operarHoteles(App app) {

		Scanner entrada = new Scanner(System.in);

		boolean bloqueador = true;

		while (bloqueador) {

			System.out
					.println("Elige 1, 2 o 3 para introducir, modificar o borrar algun hotel. Introduce 0 para salir:");

			int eleccion = entrada.nextInt();

			switch (eleccion) {
			case 1: {
				System.out.println("Introduce el nombre del hotel:");
				String nombre = entrada.next();

				// Comprueba si existe un hotel con ese nombre

				if (!app.comprobarNombreHotel(nombre)) {
					System.out.println("Ya existe un hotel con dicho nombre");
					break;
				}

				System.out.println("Introduce la descripcion del hotel:");
				String descripcion = entrada.next();
				System.out.println("Introduce la ciudad del hotel:");
				String ciudad = entrada.next();
				System.out.println("Introduce su precio por noche:");
				double precioNoche = entrada.nextDouble();
				app.añadirHotel(nombre, descripcion, ciudad, precioNoche);
				break;
			}
			case 2: {

				break;
			}
			case 3: {
				System.out.println("Introduce el nombre del hotel a borrar:");
				String nombre = entrada.next();

				// Comprueba si existe un vuelo con ese ID

				if (app.comprobarNombreHotel(nombre)) {
					System.out.println("No existe el vuelo al que te estas refiriendo");
					break;
				}

				app.borrarHotel(nombre);
				System.out.println("Hotel borrado");
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

	}

	public static void listarPaquetes(App app) throws IOException {

		app.listarPaquetes();

	}

	public static void operarPaquetes(App app) throws ParseException {

		Scanner entrada = new Scanner(System.in);

		boolean bloqueador = true;

		while (bloqueador) {

			System.out.println(
					"Elige 1, 2 o 3 para introducir, modificar o borrar algun paquete. Introduce 0 para salir:");

			int eleccion = entrada.nextInt();

			switch (eleccion) {
			case 1: {
				System.out.println("Introduce el nombre del paquete de viaje:");
				String nombre = entrada.next();

				if (!app.comprobarNombreViaje(nombre)) {
					System.out.println("Ya existe un hotel con dicho nombre");
					break;
				}

				// Creamos la primera fecha

				Date date1 = null;
				boolean bloqueador2 = true;
				Scanner input = new Scanner(System.in);
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Introduce la fecha de inicio del paquete (gg/aa/yy):");
				String cinput = input.nextLine();
				while (bloqueador2) {
					if (null != cinput && cinput.trim().length() > 0) {
						date1 = format.parse(cinput);
						bloqueador2 = false;
					} else {
						System.out.println("No has introducido un valor valido, vuelve a intentarlo.");
					}
				}
				// Creamos la segunda fecha

				Date date2 = null;
				boolean bloqueador3 = true;
				Scanner input2 = new Scanner(System.in);
				SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Introduce la fecha de fin del paquete (gg/aa/yy):");
				String cinput2 = input2.nextLine();
				while (bloqueador3) {
					if (null != cinput2 && cinput2.trim().length() > 0) {
						date2 = format2.parse(cinput2);
						bloqueador3 = false;
					} else {
						System.out.println("No has introducido un valor valido, vuelve a intentarlo.");
					}
				}

				// Comprobamos si las fechas cuadran

				if (!app.comprobarFechaVuelo(date1, date2)) {
					System.out.println(
							"Las fechas introducidas no tienen sentido(La fecha de ida es posterior a la de vuelta.)");
					break;
				}

				// Añadimos los datos del vuelo de ida

				System.out.println("Introduce el id del vuelo de ida:");
				int idIda = entrada.nextInt();
				System.out.println("Introduce la compañia del vuelo de ida:");
				String compañiaIda = entrada.next();
				System.out.println("Introduce la ciudad de donde sale el vuelo de ida:");
				String origenIda = entrada.next();
				System.out.println("Introduce la ciudad donde se dirige el vuelo de ida:");
				String destinoIda = entrada.next();
				System.out.println("Introduce el precio del vuelo de ida:");
				double precioIda = entrada.nextDouble();

				// Añadimos los datos del vuelo de vuelta

				System.out.println("Introduce el id del vuelo de vuelta:");
				int idVuelta = entrada.nextInt();
				System.out.println("Introduce la compañia del vuelo de vuelta:");
				String compañiaVuelta = entrada.next();
				System.out.println("Introduce la ciudad de donde sale el vuelo de vuelta:");
				String origenVuelta = entrada.next();
				System.out.println("Introduce la ciudad donde se dirige el vuelo de vuelta:");
				String destinoVuelta = entrada.next();
				System.out.println("Introduce el precio del vuelo de vuelta:");
				double precioVuelta = entrada.nextDouble();

				// Añadimos los datos del hotel

				System.out.println("Introduce el nombre del hotel:");
				String nombreHotel = entrada.next();
				System.out.println("Introduce la descripcion del hotel:");
				String descripcionHotel = entrada.next();
				System.out.println("Introduce la ciudad del hotel:");
				String ciudadHotel = entrada.next();
				System.out.println("Introduce su precio por noche:");
				double precioNocheHotel = entrada.nextDouble();

				app.añadirPaquete(nombre, date1, date2, idIda, compañiaIda, origenIda, destinoIda, precioIda, idVuelta,
						compañiaVuelta, origenVuelta, destinoVuelta, precioVuelta, nombreHotel, descripcionHotel,
						ciudadHotel, precioNocheHotel);

				break;
			}
			case 2: {

				break;
			}
			case 3: {

				System.out.println("Introduce el nombre del viaje a borrar:");
				String nombre = entrada.next();

				// Comprueba si existe un vuelo con ese ID

				if (app.comprobarNombreViaje(nombre)) {
					System.out.println("No existe el viaje al que te estas refiriendo");
					break;
				}

				app.borrarPaquete(nombre);
				System.out.println("Paquete borrado");
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

	}

}
