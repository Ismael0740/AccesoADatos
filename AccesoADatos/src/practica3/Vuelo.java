package practica3;

public class Vuelo {

	private int id;
	private String compañia;
	private String origen;
	private String destino;
	private double precio;

	Vuelo(int id, String compañia, String origen, String destino, double precio) {
		this.id = id;
		this.compañia = compañia;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompañia() {
		return this.compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String toString() {

		String texto = "-Id: " + this.id + "\n-Compañia del vuelo: " + this.compañia + "\n-Origen del vuelo: "
				+ this.origen + "\n-Destino del vuelo: " + this.destino + "\n-Precio del vuelo: " + this.precio;

		return texto;
	}

}
