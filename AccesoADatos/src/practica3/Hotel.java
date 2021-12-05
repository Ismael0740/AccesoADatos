package practica3;

public class Hotel {

	private String nombre;
	private String descripcion;
	private String ciudad;
	private double precioNoche;

	Hotel(String nombre, String descripcion, String ciudad, double precioNoche) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ciudad = ciudad;
		this.precioNoche = precioNoche;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getPrecioNoche() {
		return this.precioNoche;
	}

	public void setPrecioNoche(double precioNoche) {
		this.precioNoche = precioNoche;
	}

	public String toString() {

		String texto = "-Nombre: " + this.nombre + "\n-Descripcion del hotel: " + this.descripcion
				+ "\n-Ciudad del hotel: " + this.ciudad + "\n-Precio por noche del hotel: " + this.precioNoche;

		return texto;
	}

}
