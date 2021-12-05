package pruebaFinal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class App {

	private ArrayList<Medicion> listaMediciones;

	App() {
		listaMediciones = new ArrayList<Medicion>();
	}

	public void crear(String ficheroOrigen, String ficheroDestino) throws IOException {

		guardarDatos(ficheroOrigen);
		cargarDatos(ficheroDestino);

	}

	// GUARDA LOS DATOS DEL FICHERO SELECCIONADO AL ARRAY
	public void guardarDatos(String ficheroOrigen) throws IOException {

		String horasT = "";
		String minutosT = "";
		String nombre = "";
		String[] audiencia_segT = { "", "", "", "" };

		String datos = "";
		int contador = 0;

		File f = new File("src/" + ficheroOrigen + ".txt");

		FileReader fr = new FileReader(f);

		int caracter = fr.read();

		for (int x = 0; x < 22; x++) {

			while (caracter != 13 && caracter != 10 && caracter != -1) {

				datos = "";
				while (caracter != 44 && caracter != 13 && caracter != 10 && caracter != -1) {
					datos = datos + (char) caracter;
					caracter = fr.read();
				}
				contador++;

				if (contador == 1 && horasT.equals("")) {
					horasT = datos;
				}
				if (contador == 2 && minutosT.equals("")) {
					minutosT = datos;
				}
				if (contador == 3 && nombre.equals("")) {
					nombre = datos;
				}
				if (contador == 4 && audiencia_segT[0].equals("")) {
					audiencia_segT[0] = datos;
				}
				if (contador == 5 && audiencia_segT[1].equals("")) {
					audiencia_segT[1] = datos;
				}
				if (contador == 6 && audiencia_segT[2].equals("")) {
					audiencia_segT[2] = datos;
				}
				if (contador == 7 && audiencia_segT[3].equals("")) {
					audiencia_segT[3] = datos;
				}

				caracter = fr.read();

			}
			contador = 0;

			double horas = 0;
			double minutos = 0;
			double[] audiencia_seg = new double[4];

			// Horas
			for (int i = 0; i < horasT.length(); i++) {
				switch (horasT.charAt(i)) {
				case 48: {

					break;
				}
				case 49: {
					horas = horas + (1 * Math.pow(10, (1 - i)));
					break;
				}
				case 50: {
					horas = horas + (2 * Math.pow(10, (1 - i)));
					break;
				}
				case 51: {
					horas = horas + (3 * Math.pow(10, (1 - i)));
					break;
				}
				case 52: {
					horas = horas + (4 * Math.pow(10, (1 - i)));
					break;
				}
				case 53: {
					horas = horas + (5 * Math.pow(10, (1 - i)));
					break;
				}
				case 54: {
					horas = horas + (6 * Math.pow(10, (1 - i)));
					break;
				}
				case 55: {
					horas = horas + (7 * Math.pow(10, (1 - i)));
					break;
				}
				case 56: {
					horas = horas + (8 * Math.pow(10, (1 - i)));
					break;
				}
				case 57: {
					horas = horas + (9 * Math.pow(10, (1 - i)));
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + horasT.charAt(i));
				}

			}

			// Minutos
			for (int i = 0; i < minutosT.length(); i++) {
				switch (minutosT.charAt(i)) {
				case 46: {

					break;
				}
				case 48: {

					break;
				}
				case 49: {
					minutos = minutos + (1 * Math.pow(10, (1 - i)));
					break;
				}
				case 50: {
					minutos = minutos + (2 * Math.pow(10, (1 - i)));
					break;
				}
				case 51: {
					minutos = minutos + (3 * Math.pow(10, (1 - i)));
					break;
				}
				case 52: {
					minutos = minutos + (4 * Math.pow(10, (1 - i)));
					break;
				}
				case 53: {
					minutos = minutos + (5 * Math.pow(10, (1 - i)));
					break;
				}
				case 54: {
					minutos = minutos + (6 * Math.pow(10, (1 - i)));
					break;
				}
				case 55: {
					minutos = minutos + (7 * Math.pow(10, (1 - i)));
					break;
				}
				case 56: {
					minutos = minutos + (8 * Math.pow(10, (1 - i)));
					break;
				}
				case 57: {
					minutos = minutos + (9 * Math.pow(10, (1 - i)));
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + minutosT.charAt(i));
				}

			}

			// Array
			int decimales;
			boolean decimo = false;
			for (int a = 0; a < audiencia_segT.length; a++) {

				decimales = 0;

				for (int z = 0; z < audiencia_segT[a].length(); z++) {
					if (audiencia_segT[a].charAt(z) == 46) {
						decimales = z;
					}
				}
				decimo = false;
				for (int i = 0; i < audiencia_segT[a].length(); i++) {

					switch (audiencia_segT[a].charAt(i)) {
					case 46: {
						decimo = true;
						break;
					}
					case 48: {

						break;
					}
					case 49: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (1 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (1 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 50: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (2 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (2 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 51: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (3 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (3 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 52: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (4 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (4 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 53: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (5 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (5 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 54: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (6 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (6 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 55: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (7 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (7 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 56: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (8 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (8 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}
					case 57: {
						if (decimo == true) {
							audiencia_seg[a] = audiencia_seg[a] + (9 * Math.pow(10, (decimales - i)));
						} else {
							audiencia_seg[a] = audiencia_seg[a] + (9 * Math.pow(10, ((decimales - i) - 1)));
						}
						break;
					}

					default:
						throw new IllegalArgumentException("Unexpected value: " + minutosT.charAt(i));
					}

				}

			}

			Medicion medicion = new Medicion(horas, minutos, nombre, audiencia_seg);
			listaMediciones.add(medicion);

			horasT = "";
			minutosT = "";
			nombre = "";
			audiencia_segT[0] = "";
			audiencia_segT[1] = "";
			audiencia_segT[2] = "";
			audiencia_segT[3] = "";

			caracter = fr.read();

		}

		fr.close();
	}

	// CARGA LOS DATOS DEL ARRAY AL FICHERO SELECCIONADO
	public void cargarDatos(String ficheroDestino) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();

			Element eRaiz = doc.createElement("listaMediciones");
			doc.appendChild(eRaiz);

			for (int i = 0; i < listaMediciones.size(); i++) {

				Element eMedicion = doc.createElement("medicion");
				eRaiz.appendChild(eMedicion);

				Element eHoras = doc.createElement("horas");
				eHoras.appendChild(doc.createTextNode(listaMediciones.get(i).getHoras() + ""));
				eMedicion.appendChild(eHoras);

				Element eMinutos = doc.createElement("minutos");
				eMinutos.appendChild(doc.createTextNode(listaMediciones.get(i).getMinutos() + ""));
				eMedicion.appendChild(eMinutos);

				Element eNombre = doc.createElement("nombre");
				eNombre.appendChild(doc.createTextNode(listaMediciones.get(i).getNombre()));
				eMedicion.appendChild(eNombre);

				Element eNiños = doc.createElement("niños");
				eNiños.appendChild(doc.createTextNode(listaMediciones.get(i).getAudiencia_seg()[0] + ""));
				eMedicion.appendChild(eNiños);

				Element eJovenes = doc.createElement("jovenes");
				eJovenes.appendChild(doc.createTextNode(listaMediciones.get(i).getAudiencia_seg()[1] + ""));
				eMedicion.appendChild(eJovenes);

				Element eAdultos = doc.createElement("adultos");
				eAdultos.appendChild(doc.createTextNode(listaMediciones.get(i).getAudiencia_seg()[2] + ""));
				eMedicion.appendChild(eAdultos);

				Element eMayores = doc.createElement("mayores");
				eMayores.appendChild(doc.createTextNode(listaMediciones.get(i).getAudiencia_seg()[3] + ""));
				eMedicion.appendChild(eMayores);

				Element eTotal = doc.createElement("total");
				eTotal.appendChild(doc.createTextNode(listaMediciones.get(i).getTotal() + ""));
				eMedicion.appendChild(eTotal);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/" + ficheroDestino + ".xml"));

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void crearCuotas(String ficheroCuotas) throws IOException {

		guardarDatos("mediciones");
		
		String cadenas[] = { "cad1", "cad2", "cad3" };

		double madrugadas[] = new double[3];
		double mañanas[] = new double[3];
		double tardes[] = new double[3];
		double primesTimes[] = new double[3];
		double totales[] = new double[3];

		for (int a = 0; a < 3; a++) {

			for (int i = 0; i < listaMediciones.size(); i++) {
				if (listaMediciones.get(i).getNombre().equals(cadenas[a])) {

					if (listaMediciones.get(i).getHoras() >= 0 && listaMediciones.get(i).horas <= 7) {
						madrugadas[a] = madrugadas[a] + listaMediciones.get(i).getTotal();
					}
					if (listaMediciones.get(i).getHoras() > 7 && listaMediciones.get(i).horas <= 14) {
						mañanas[a] = mañanas[a] + listaMediciones.get(i).getTotal();
					}
					if (listaMediciones.get(i).getHoras() > 14 && listaMediciones.get(i).horas <= 20) {
						tardes[a] = mañanas[a] + listaMediciones.get(i).getTotal();
					}
					if (listaMediciones.get(i).getHoras() > 20 && listaMediciones.get(i).horas <= 24) {
						primesTimes[a] = primesTimes[a] + listaMediciones.get(i).getTotal();
					}

				}
			}

			totales[a] = madrugadas[a] + mañanas[a] + tardes[a] + primesTimes[a];
		}

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();

			Element eRaiz = doc.createElement("listaMediciones");
			doc.appendChild(eRaiz);

			for (int i = 0; i < 3; i++) {

				Element eCadena = doc.createElement(cadenas[i]);
				eRaiz.appendChild(eCadena);

				Element eHoras = doc.createElement("Madrugada");
				eHoras.appendChild(doc.createTextNode(madrugadas[i] + ""));
				eCadena.appendChild(eHoras);

				Element eMinutos = doc.createElement("Mañana");
				eMinutos.appendChild(doc.createTextNode(mañanas[i] + ""));
				eCadena.appendChild(eMinutos);

				Element eNombre = doc.createElement("Tarde");
				eNombre.appendChild(doc.createTextNode(tardes[i] + ""));
				eCadena.appendChild(eNombre);

				Element eNiños = doc.createElement("PrimeTime");
				eNiños.appendChild(doc.createTextNode(primesTimes[i] + ""));
				eCadena.appendChild(eNiños);

				Element eTotal = doc.createElement("total");
				eTotal.appendChild(doc.createTextNode(totales[i] + ""));
				eCadena.appendChild(eTotal);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/" + ficheroCuotas + ".xml"));

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
