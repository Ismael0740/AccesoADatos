package practica3;

import java.util.Date;

public class Viaje {

	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private Vuelo vueloIda;
	private Vuelo vueloVuelta;
	private Hotel hotel;

	Viaje(String nombre, Date fechaInicio, Date fechaFin, Vuelo vueloIda, Vuelo vueloVuelta, Hotel hotel) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.vueloIda = vueloIda;
		this.vueloVuelta = vueloVuelta;
		this.hotel = hotel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Vuelo getvueloIda() {
		return this.vueloIda;
	}

	public void setVueloIda(Vuelo vueloIda) {
		this.vueloIda = vueloIda;
	}

	public Vuelo getVueloVuelta() {
		return this.vueloVuelta;
	}

	public void setVueloVuelta(Vuelo vueloVuelta) {
		this.vueloVuelta = vueloVuelta;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String toString() {

		String texto = "-Nombre: " + this.nombre + "\n-Fecha de inicio del viaje: " + this.fechaInicio
				+ "\n-Fecha de fin del viaje: " + this.fechaFin + "\n-Id del vuelo de ida: " + this.vueloIda.getId()
				+ "\n-Id del vuelo de vuelta: " + this.vueloVuelta.getId() + "\n-Nombre del hotel: "
				+ this.hotel.getNombre();

		return texto;
	}

}
