package plantillaXML;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

	private ArrayList<Desayunos> lista;

	App() {
		lista = new ArrayList<Desayunos>();
	}

	public void mostrarFichero() {

		File file = new File("src/desayunos.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			NodeList nList = doc.getElementsByTagName("Food");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;

					if (eElement.hasChildNodes()) {
						NodeList nl = node.getChildNodes();
						for (int j = 0; j < nl.getLength(); j++) {
							Node nd = nl.item(j);
							System.out.println(nd.getTextContent());
						}
					}
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void crearDesayuno(String nombre, String precio, String description, String calories) {

		Desayunos desayuno = new Desayunos(nombre, precio, description, calories);
		lista.add(desayuno);

	}

	public void escribirDatos() {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();

			Element eRaiz = doc.createElement("breakfast_menu");
			doc.appendChild(eRaiz);

			for (int i = 0; i < lista.size(); i++) {

				Element eFood = doc.createElement("Food");
				eRaiz.appendChild(eFood);

				Element eNombre = doc.createElement("name");
				eNombre.appendChild(doc.createTextNode(lista.get(i).getNombre()));
				eFood.appendChild(eNombre);

				Element ePrice = doc.createElement("price");
				ePrice.appendChild(doc.createTextNode(lista.get(i).getPrecio() + ""));
				eFood.appendChild(ePrice);

				Element eDescription = doc.createElement("description");
				eDescription.appendChild(doc.createTextNode(lista.get(i).getDescription()));
				eFood.appendChild(eDescription);

				Element eCalories = doc.createElement("calories");
				eCalories.appendChild(doc.createTextNode(lista.get(i).getCalorias() + ""));
				eFood.appendChild(eCalories);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/desayunos.xml"));

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void recopilarInfo() {

		String nombre = null;
		String precio = null;
		String description = null;
		String calories = null;

		Desayunos desayuno;

		File file = new File("src/desayunos.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			NodeList nList = doc.getElementsByTagName("Food");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;

					if (eElement.hasChildNodes()) {
						NodeList nl = node.getChildNodes();
						for (int j = 0; j < nl.getLength(); j++) {
							Node nd = nl.item(j);

							if (j == 0) {
								nombre = nd.getTextContent();
							}
							if (j == 1) {
								precio = nd.getTextContent();
							}
							if (j == 2) {
								description = nd.getTextContent();
							}
							if (j == 3) {
								calories = nd.getTextContent();
							}
						}
						desayuno = new Desayunos(nombre, precio, description, calories);
						lista.add(desayuno);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
