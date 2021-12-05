package pruebaFinal;

import java.io.Serializable;

public class Medicion implements Serializable {
	double horas;
	double minutos;
	String nombre;
	double[] audiencia_seg = new double[4];
	double total;

	public Medicion(double horas, double minutos, String nombre, double[] audiencia_seg) {
		this.horas = horas;
		this.minutos = minutos;
		this.nombre = nombre;
		this.audiencia_seg = audiencia_seg;
		total = audiencia_seg[0] + audiencia_seg[1] + audiencia_seg[2] + audiencia_seg[3];
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getMinutos() {
		return minutos;
	}

	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double[] getAudiencia_seg() {
		return audiencia_seg;
	}

	public void setAudiencia_seg(double[] audiencia_seg) {
		this.audiencia_seg = audiencia_seg;
	}
	
	
	public double getTotal() {
		return total;
	}
}
