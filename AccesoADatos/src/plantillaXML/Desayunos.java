package plantillaXML;

public class Desayunos {

	private String nombre;
	private String precio;
	private String description;
	private String calorias;
	
	Desayunos(String nombre, String precio, String description, String calorias){
		this.nombre = nombre;
		this.precio = precio;
		this.description = description;
		this.calorias = calorias;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPrecio() {
		return this.precio;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCalorias() {
		return this.calorias;
	}
	
}
