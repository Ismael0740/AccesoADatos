package definitiva;

import java.util.ArrayList;

public class App {

	private ArrayList<Departamento> listaDepartamentos;
	private ArrayList<Empleado> listaEmpleados; // Esta lista sirve unicamente para agilizar el proceso de busqueda de
												// empleados (Toda la informacion se puede obtener unicamente del array
												// de Departamento).

	App() {
		listaDepartamentos = new ArrayList<Departamento>();
		listaEmpleados = new ArrayList<Empleado>();
	}

	public boolean comprobarIdEmpleado(int iD_empleado) {

		boolean estado = false;

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iD_empleado) {
				estado = true;
			}
		}

		return estado;
	}

	public boolean comprobarIdDepartamento(int iD_depart) {

		boolean estado = false;

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == iD_depart) {
				estado = true;
			}
		}

		return estado;
	}

	public void insertarNuevoEmpleado(int iD, String dNI, String nombre, String apellidos, double salario,
			boolean genero, int iD_depart) {

		Empleado empleado = new Empleado(iD, dNI, nombre, apellidos, salario, genero, iD_depart);
		listaEmpleados.add(empleado);

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == iD_depart) {
				listaDepartamentos.get(i).añadirEmpleado(empleado);
			}
		}

	}

	public void modificarEmpleado(int iD, String dNI, String nombre, String apellidos, double salario, boolean genero,
			int iD_depart) {

		Empleado empleado = new Empleado(iD, dNI, nombre, apellidos, salario, genero, iD_depart);

		int iD_departAntiguo = 0;

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iD) {
				iD_departAntiguo = listaEmpleados.get(i).getiD_depart();
				listaEmpleados.remove(i);
				listaEmpleados.add(empleado);
			}
		}

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == iD_departAntiguo) {
				listaDepartamentos.get(i).quitarEmpleado(iD);
			}
			if (listaEmpleados.get(i).getiD() == iD_depart) {
				listaDepartamentos.get(i).añadirEmpleado(empleado);
			}
		}

	}

	public void borrarEmpleado(int iD) {

		int iD_departAntiguo = 0;

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iD) {
				iD_departAntiguo = listaEmpleados.get(i).getiD_depart();
				listaEmpleados.remove(i);
			}
		}

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == iD_departAntiguo) {
				listaDepartamentos.get(i).quitarEmpleado(iD);
			}
		}

	}

	public String mostrarEmpleados() {

		String lista = "";

		for (int i = 0; i < listaEmpleados.size(); i++) {
			lista = lista + "\n" + listaEmpleados.get(i).toString();
		}

		return lista;
	}

	public String mostrarEmpleadosDepartamento(int iD_depart) {

		String lista = listaDepartamentos.get(iD_depart).mostrarEmpleados();

		return lista;
	}

	public String mostrarEmpleadoPorNif(String dNI) {

		String texto = "";

		int contador = 0;

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getdNI().equals(dNI)) {
				texto = listaEmpleados.get(i).toString();
				contador++;
			}

		}
		if (contador == 0) {
			texto = "No se ha encontrado ningun empleado con dicho NIF";
		}

		return texto;
	}

	public String mostrarEmpleadosSalarioSuperior(double salario) {

		String texto = "";

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getSalario() > salario) {
				texto = texto + "\n" + listaEmpleados.get(i).toString();
			}
		}

		return texto;
	}

	public String mostrarEmpleadosSalarioInferior(double salario) {

		String texto = "";

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getSalario() <= salario) {
				texto = texto + "\n" + listaEmpleados.get(i).toString();
			}
		}

		return texto;
	}

	public void insertarNuevoDepartamento(int iD, String nombre) {

		Departamento departamento = new Departamento(iD, nombre);
		listaDepartamentos.add(departamento);

	}

	public void modificarDepartamento(int id, String nombre) {

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == id) {
				listaDepartamentos.get(i).setNombre(nombre);
			}
		}

	}

	public void eliminarDepartamento(int id) {

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == id) {
				listaDepartamentos.remove(i);
			}
		}

	}

	public String listarDepartamentos() {

		String texto = "";

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			texto = texto + "\n" + listaDepartamentos.get(i).toString();
		}

		return texto;
	}

	public String mostrarInfoDepartamento(int id) {

		String texto = "";

		for (int i = 0; i < listaDepartamentos.size(); i++) {
			if (listaDepartamentos.get(i).getiD() == id) {
				texto = listaDepartamentos.get(i).toString();
			}
		}

		return texto;
	}

}
