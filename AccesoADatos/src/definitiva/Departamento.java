package definitiva;

import java.util.ArrayList;

public class Departamento {

	int iD;
	String nombre;
	ArrayList<Empleado> listaEmpleados;

	Departamento(int iD, String nombre) {
		this.iD = iD;
		this.nombre = nombre;
		listaEmpleados = new ArrayList<Empleado>();
	}

	public int getiD() {
		return iD;
	}

	@Override
	public String toString() {
		return "Departamento [iD=" + iD + ", nombre=" + nombre + ", listaEmpleados=" + listaEmpleados + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//ESENCIAL CADA VEZ QUE SE CREA UN EMPLEADO DE ESTE DEPARTAMENTO
	public void añadirEmpleado(Empleado empleado) {
		listaEmpleados.add(empleado);
	}

//FUNCIONES EXTRA DE EDICION DEL ARRAY QUE SE REQUIEREN AL USAR EL APARTADO MODIFICAR EMPLEADO O BORRAR EMPLEADO
	public void quitarEmpleado(int iDEmpleado) {

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iDEmpleado) {
				listaEmpleados.remove(i);
			}
		}
	}

	public void modificarDniEmpleado(int iDEmpleado, String dNI) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iDEmpleado) {
				listaEmpleados.get(i).setdNI(dNI);
			}
		}
	}

	public void modificarNombreEmpleado(int iDEmpleado, String nombre) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iDEmpleado) {
				listaEmpleados.get(i).setNombre(nombre);
			}
		}
	}

	public void modificarApellidosEmpleado(int iDEmpleado, String Apellidos) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iDEmpleado) {
				listaEmpleados.get(i).setApellidos(Apellidos);
			}
		}
	}

	public void modificarSalarioEmpleado(int iDEmpleado, double salario) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iDEmpleado) {
				listaEmpleados.get(i).setSalario(salario);
			}
		}
	}

	public void modificarSalarioEmpleado(int iDEmpleado, boolean genero) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getiD() == iDEmpleado) {
				listaEmpleados.get(i).setGenero(genero);
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

}
