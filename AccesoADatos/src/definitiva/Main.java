package definitiva;

import java.util.Scanner;

public class Main {

	static App app = new App();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean bloqueador = true;
		int eleccion;

		while (bloqueador) {

			System.out.println(
					"Elige 1 para entrar en la gestion de empleados. introduce 2 para entrar en la gestion de departamentos. Introduce 3 para salir del programa.");

			eleccion = sc.nextInt();

			switch (eleccion) {
			case 1: {
				pestañaEmpleados();
				break;
			}
			case 2: {
				pestañaDepartamentos();
				break;
			}
			case 3: {
				bloqueador = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + eleccion);
			}
		}

	}

	public static void pestañaEmpleados() {
		Scanner entrada = new Scanner(System.in);

		System.out.println(
				"1: Insertar Empleado\n2: Modificar Empleado\n3: Borrar Empleado\n4: Listar todos los empleados\n5: Listar todos los empleados de un departamento\n6: Consultar empleados por nif/dni\n7: Consultar empleados que tengan un salario superior al introducido por el usuario\n8: Consultar empleados que tengan un salario igual o inferior al introducido por el usuario");

		int eleccion = entrada.nextInt();
		switch (eleccion) {
		// DONE
		case 1: {

			boolean bloqueador = true;
			boolean bloqueador2 = true;
			boolean bloqueador3 = true;

			System.out.println("*Insertar Empleado*\n");

			int iD = -1;

			while (bloqueador3) {
				System.out.println("Introduce el iD del empleado:");
				iD = entrada.nextInt();

				if (!app.comprobarIdEmpleado(iD)) {
					bloqueador3 = false;
				} else {
					System.out.println("El iD introducido ya existe(ya corresponde a otro empleado)\n");
				}
			}

			System.out.println("Introduce el dNI");
			String dNI = entrada.next();
			System.out.println("Introduce el nombre");
			String nombre = entrada.next();
			System.out.println("Introduce los apellidos");
			String apellidos = entrada.next();
			System.out.println("Introduce el salario");
			double salario = entrada.nextDouble();

			boolean genero = true;
			while (bloqueador) {

				System.out.println("Introduce el genero(Introduce 1 para masculino y 2 para femenino)");
				int generoN = entrada.nextInt();

				if (generoN == 0 || generoN == 1) {
					bloqueador = false;
					if (generoN == 0) {
						genero = true;
					} else {
						genero = false;
					}
				} else {
					System.out.println("No has introducido una opcion correcta, vuelve a intentarlo.");
				}

			}

			int iD_depart = -1;

			while (bloqueador2) {

				System.out.println("Introduce el iD del departamento al que pertenece");
				iD_depart = entrada.nextInt();

				if (app.comprobarIdDepartamento(iD_depart)) {
					bloqueador2 = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun departamento)\n");
				}

			}

			app.insertarNuevoEmpleado(iD, dNI, nombre, apellidos, salario, genero, iD_depart);
			break;
		}
		// DONE
		case 2: {

			boolean bloqueador = true;
			boolean bloqueador2 = true;
			boolean bloqueador3 = true;

			System.out.println("*Modificar Empleado*\n");

			int iD = -1;

			while (bloqueador) {
				System.out.println("Introduce el iD del empleado a modificar:");
				iD = entrada.nextInt();

				if (app.comprobarIdEmpleado(iD)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun empleado)\n");
				}
			}

			System.out.println("Inserta los nuevos datos del usuario:");
			System.out.println("Introduce el dNI");
			String dNI = entrada.next();
			System.out.println("Introduce el nombre");
			String nombre = entrada.next();
			System.out.println("Introduce los apellidos");
			String apellidos = entrada.next();
			System.out.println("Introduce el salario");
			double salario = entrada.nextDouble();

			boolean genero = true;
			while (bloqueador2) {

				System.out.println("Introduce el genero(Introduce 1 para masculino y 2 para femenino)");
				int generoN = entrada.nextInt();

				if (generoN == 0 || generoN == 1) {
					bloqueador2 = false;
					if (generoN == 0) {
						genero = true;
					} else {
						genero = false;
					}
				} else {
					System.out.println("No has introducido una opcion correcta, vuelve a intentarlo.");
				}

			}

			int iD_depart = -1;

			while (bloqueador3) {

				System.out.println("Introduce el iD del departamento al que pertenece");
				iD_depart = entrada.nextInt();

				if (app.comprobarIdDepartamento(iD_depart)) {
					bloqueador3 = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun departamento)\n");
				}

			}

			app.modificarEmpleado(iD, dNI, nombre, apellidos, salario, genero, iD_depart);

			break;
		}
		// DONE
		case 3: {

			boolean bloqueador = true;

			System.out.println("*Borrar Empleado*\n");

			int iD = -1;

			while (bloqueador) {
				System.out.println("Introduce el iD del empleado a modificar:");
				iD = entrada.nextInt();

				if (app.comprobarIdEmpleado(iD)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun empleado)\n");
				}
			}

			app.borrarEmpleado(iD);

			break;
		}
		// DONE
		case 4: {

			System.out.println("*Listar todos los empleados*\n");

			System.out.println(app.mostrarEmpleados());

			break;
		}
		// DONE
		case 5: {

			boolean bloqueador = true;

			System.out.println("*Listar todos los empleados de un departamento*\n");

			int iD_depart = -1;

			while (bloqueador) {

				System.out.println("Introduce el iD del departamento en cuestion");
				iD_depart = entrada.nextInt();

				if (app.comprobarIdDepartamento(iD_depart)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun departamento)\n");
				}

			}

			app.mostrarEmpleadosDepartamento(iD_depart);

			break;
		}
		// DONE
		case 6: {

			System.out.println("*Consultar empleados por nif/dni*\n");

			System.out.println("Introduce el nif del empleado a consultar");

			String dni = entrada.next();

			System.out.println(app.mostrarEmpleadoPorNif(dni));

			break;
		}
		// DONE
		case 7: {

			System.out.println("*Consultar empleados que tengan un salario superior al introducido por el usuario*\n");

			System.out.println("Introduce un salario:");

			double salario = entrada.nextDouble();

			System.out.println(app.mostrarEmpleadosSalarioSuperior(salario));

			break;
		}
		// DONE
		case 8: {

			System.out.println(
					"*Consultar empleados que tengan un salario inferior o igual al introducido por el usuario*\n");

			System.out.println("Introduce un salario:");

			double salario = entrada.nextDouble();

			System.out.println(app.mostrarEmpleadosSalarioInferior(salario));

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + eleccion);
		}
	}

	public static void pestañaDepartamentos() {
		Scanner entrada = new Scanner(System.in);

		System.out.println(
				"1: Insertar departamento\n2: Modificar departamento\n3: Eliminar departamento\n4: Listar todos los departamentos\n5: Ver informacion de un unico departamento");

		int eleccion = entrada.nextInt();

		switch (eleccion) {
		case 1: {

			boolean bloqueador = true;

			System.out.println("*Insertar departamento*\n");

			int iD_depart = -1;

			while (bloqueador) {

				System.out.println("Introduce el iD del departamento a crear");
				iD_depart = entrada.nextInt();

				if (!app.comprobarIdDepartamento(iD_depart)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido ya existe(ya corresponde con algun departamento)\n");
				}

			}

			System.out.println("Introduce el nombre del departamento");

			String nombre = entrada.next();

			app.insertarNuevoDepartamento(iD_depart, nombre);

			break;
		}
		case 2: {
			boolean bloqueador = true;

			System.out.println("*Modificar departamento*\n");

			int iD = -1;

			while (bloqueador) {

				System.out.println("Introduce el iD del departamento a modificar");
				iD = entrada.nextInt();

				if (app.comprobarIdDepartamento(iD)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun departamento)\n");
				}

			}

			System.out.println("Introduce el nombre que quieras que tenga el nuevo departamento");

			String nombre = entrada.next();

			app.modificarDepartamento(iD, nombre);

			break;
		}
		case 3: {

			boolean bloqueador = true;

			System.out.println("*Eliminar departamento*\n");

			int iD = -1;

			while (bloqueador) {

				System.out.println("Introduce el iD del departamento a eliminar");
				iD = entrada.nextInt();

				if (app.comprobarIdDepartamento(iD)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun departamento)\n");
				}

			}

			app.eliminarDepartamento(iD);

			break;
		}
		case 4: {

			System.out.println("*Listar todos los departamentos*\n");

			System.out.println(app.listarDepartamentos());

			break;
		}
		case 5: {

			boolean bloqueador = true;

			int iD = -1;

			System.out.println("*Ver informacion de un unico departamento*");

			while (bloqueador) {

				System.out.println("Introduce el iD del departamento del que vas a ver la info");
				iD = entrada.nextInt();

				if (app.comprobarIdDepartamento(iD)) {
					bloqueador = false;
				} else {
					System.out.println("El iD introducido no existe(no corresponde con ningun departamento)\n");
				}

			}

			app.mostrarInfoDepartamento(iD);

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + eleccion);
		}

	}

}
