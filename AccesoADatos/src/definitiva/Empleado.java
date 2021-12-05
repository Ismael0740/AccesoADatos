package definitiva;

public class Empleado {
	
	@Override
	public String toString() {
		return "Empleado [iD=" + iD + ", dNI=" + dNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", salario="
				+ salario + ", genero=" + genero + ", iD_depart=" + iD_depart + "]";
	}


	int iD;
	String dNI;
	String nombre;
	String apellidos;
	double salario;
	boolean genero;
	int iD_depart;
	
	
	Empleado(int iD, String dNI, String nombre, String apellidos, double salario, boolean genero, int iD_depart){
		this.iD = iD;
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.genero = genero;
		this.iD_depart = iD_depart;
	}


	public int getiD() {
		return iD;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public String getdNI() {
		return dNI;
	}


	public void setdNI(String dNI) {
		this.dNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public boolean isGenero() {
		return genero;
	}


	public void setGenero(boolean genero) {
		this.genero = genero;
	}


	public int getiD_depart() {
		return iD_depart;
	}


	public void setiD_depart(int iD_depart) {
		this.iD_depart = iD_depart;
	}
	
}
