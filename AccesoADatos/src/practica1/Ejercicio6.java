package practica1;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio6 {
	
	public void ejercicio6() {
		
		//JLabel etiqueta = new JLabel();
		
		//SE CREA UN JFRAME CON SUS PARAMETROS
		
		JFrame cuadro = new JFrame();
		cuadro.setTitle("Lista de ficheros");
		cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cuadro.setSize(500,700);
		cuadro.setVisible(true);
		
		
		
		
		//SE AVERIGUAN LA CANTIDAD DE ITERACIONES DEL BUCLE(ES DECIR CUANTOS FICHEROS HAY)
		
		int contador = 0;
		
		File f = new File("2DAM");

		String[] listaRecuento = f.list();

		for (int i = 0; i < listaRecuento.length; i++) {
			File a = new File("2DAM/" + listaRecuento[i]);
			contador++;
			String[] listaProfunda = a.list();
			if (a.isFile()) {
			} else {
				contador++;
				for (int j = 0; j < listaProfunda.length; j++) {
					contador++;
				}
				contador++;
			}

		}
		
		
		
		//SE CREA UN ARRAY DE STRINGS CON CADA FICHERO Y SU RUTA
		
		String[] listaEtiquetas = new String[contador];
		

		File g = new File("2DAM");

		String[] lista = g.list();
		
		int contador2 = 0;

		for (int i = 0; i < lista.length; i++) {
			File a = new File("2DAM/" + lista[i]);
			listaEtiquetas[contador2] = (lista[i] + "  Ruta absoluta => " + a.getAbsolutePath());
			contador2++;
			

			String[] listaProfunda = a.list();
			if (a.isFile()) {
			} else {
				listaEtiquetas[contador2] = ("Directorios dentro de " + lista[i] + ":");
				contador2++;
				for (int j = 0; j < listaProfunda.length; j++) {
					listaEtiquetas[contador2] = (listaProfunda[j] + "  Ruta absoluta => " + a.getAbsolutePath() + "/" + lista[j]);
					contador2++;
				}
				listaEtiquetas[contador2] = ("Final de directorios dentro de " + lista[i]);
				contador2++;
			}

		}
		
		
		
		//SE CREA UN ARRAY DE JLABELS Y SE ASIGNA A CADA LABEL SU INFORMACION DEL ARRAY DE STRINGS
		
		
		JLabel[] informacion = new JLabel[contador];
		informacion[0].setText(listaEtiquetas[0]);
 		
        
	}
	
}
