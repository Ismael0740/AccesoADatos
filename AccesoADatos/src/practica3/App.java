package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class App {

	File f = new File("lista.txt");

	private ArrayList<Viaje> listaViajes;
	private ArrayList<Hotel> listaHoteles;
	private ArrayList<Vuelo> listaVuelos;

	App() {
		listaViajes = new ArrayList<Viaje>();
		listaHoteles = new ArrayList<Hotel>();
		listaVuelos = new ArrayList<Vuelo>();
	}

	public void guardarInfo() throws IOException {

		if (listaViajes.size() == 0 && listaHoteles.size() == 0 && listaVuelos.size() == 0) {

			System.out.println("No has introducido ningun dato");
		} else {

			FileWriter fw = new FileWriter(f, false);

			fw.write("------------------------------------------------\n\n\nLista Viajes: \n\n\n");
			for (int i = 0; i < listaViajes.size(); i++) {

				fw.write((i + 1) + ":\t" + listaViajes.get(i).toString() + "\n\n");

			}

			fw.write("~\nLista Hoteles: \n\n");
			for (int i = 0; i < listaHoteles.size(); i++) {

				fw.write((i + 1) + ":\t" + listaHoteles.get(i).toString() + "\n\n");

			}

			fw.write("@\nLista Vuelos: \n\n");
			for (int i = 0; i < listaVuelos.size(); i++) {

				fw.write((i + 1) + ":\t" + listaVuelos.get(i).toString() + "\n\n");

			}
			fw.write("*");
			fw.close();
		}
	}

	public void listarVuelos() throws IOException {
		FileReader fr = new FileReader(f);

		int caracter = fr.read();

		while (caracter != 64) {
			caracter = fr.read();
		}

		while (caracter != 42) {
			System.out.print((char) caracter);
			caracter = fr.read();
		}

		fr.close();

	}

	public void listarHoteles() throws IOException {
		FileReader fr = new FileReader(f);
		int caracter = fr.read();

		while (caracter != 126) {
			caracter = fr.read();
		}

		while (caracter != 64) {
			System.out.print((char) caracter);
			caracter = fr.read();
		}

		fr.close();
	}

	public void listarPaquetes() throws IOException {
		FileReader fr = new FileReader(f);
		int caracter = fr.read();

		while (caracter != 126) {
			System.out.print((char) caracter);
			caracter = fr.read();
		}

		fr.close();
	}

	// GESTION VUELOS

	public void añadirVuelo(int id, String compañia, String origen, String destino, double precio) {

		Vuelo vuelo = new Vuelo(id, compañia, origen, destino, precio);
		listaVuelos.add(vuelo);
	}

	public void borrarVuelo(int id) {

		for (int i = 0; i < listaVuelos.size(); i++) {
			if (listaVuelos.get(i).getId() == id) {
				listaVuelos.remove(i);
			}
		}

	}

	// GESTION HOTELES

	public void añadirHotel(String nombre, String descripcion, String ciudad, double precioNoche) {

		Hotel hotel = new Hotel(nombre, descripcion, ciudad, precioNoche);
		listaHoteles.add(hotel);
	}

	public void borrarHotel(String nombre) {

		for (int i = 0; i < listaVuelos.size(); i++) {
			if (listaHoteles.get(i).getNombre().equals(nombre)) {
				listaVuelos.remove(i);
			}
		}

	}

	// GESTION PAQUETES

	public void añadirPaquete(String nombre, Date fechaInicio, Date fechaFin, int idIda, String compañiaIda,
			String origenIda, String destinoIda, double precioIda, int idVuelta, String compañiaVuelta,
			String origenVuelta, String destinoVuelta, double precioVuelta, String nombreHotel, String descripcionHotel,
			String ciudadHotel, double precioNocheHotel) {

		Vuelo vueloIda = new Vuelo(idIda, compañiaIda, origenIda, destinoIda, precioIda);
		Vuelo vueloVuelta = new Vuelo(idVuelta, compañiaVuelta, origenVuelta, destinoVuelta, precioVuelta);
		Hotel hotel = new Hotel(nombreHotel, descripcionHotel, ciudadHotel, precioNocheHotel);

		Viaje viaje = new Viaje(nombre, fechaInicio, fechaFin, vueloIda, vueloVuelta, hotel);
		listaViajes.add(viaje);
	}

	public void borrarPaquete(String nombre) {

		for (int i = 0; i < listaVuelos.size(); i++) {
			if (listaViajes.get(i).getNombre().equals(nombre)) {
				listaViajes.remove(i);
			}
		}

	}

	// COMPROBADORES DE ATRIBUTOS DE CLASES

	public boolean comprobarFechaVuelo(Date fechaInicio, Date fechaFin) {

		boolean comprobante = true;

		if (fechaInicio.after(fechaFin)) {
			comprobante = false;
		}

		return comprobante;
	}

	public boolean comprobarIdVuelo(int id) {

		boolean comprobador = true;

		for (int i = 0; i < listaVuelos.size(); i++) {
			if (listaVuelos.get(i).getId() == id) {
				comprobador = false;
			}
		}

		return comprobador;
	}

	public boolean comprobarNombreHotel(String nombre) {

		boolean comprobador = true;

		for (int i = 0; i < listaVuelos.size(); i++) {
			if (listaHoteles.get(i).getNombre().equals(nombre)) {
				comprobador = false;
			}
		}

		return comprobador;
	}

	public boolean comprobarNombreViaje(String nombre) {

		boolean comprobador = true;

		for (int i = 0; i < listaVuelos.size(); i++) {
			if (listaViajes.get(i).getNombre().equals(nombre)) {
				comprobador = false;
			}
		}

		return comprobador;
	}

}
