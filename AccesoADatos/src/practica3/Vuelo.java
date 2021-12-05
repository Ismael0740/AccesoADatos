package practica3;

public class Vuelo {

	private int id;
	private String compa�ia;
	private String origen;
	private String destino;
	private double precio;

	Vuelo(int id, String compa�ia, String origen, String destino, double precio) {
		this.id = id;
		this.compa�ia = compa�ia;
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

	public String getCompa�ia() {
		return this.compa�ia;
	}

	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
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

		String texto = "-Id: " + this.id + "\n-Compa�ia del vuelo: " + this.compa�ia + "\n-Origen del vuelo: "
				+ this.origen + "\n-Destino del vuelo: " + this.destino + "\n-Precio del vuelo: " + this.precio;

		return texto;
	}

}
