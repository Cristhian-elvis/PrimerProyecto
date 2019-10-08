/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockdenotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTextArea;

/**
 *
 * @author Cristhian Elvis
 */
public class Fichero {

	public Fichero() {

	}

	public static class guardarComo {

		File file;
		JTextArea areatexto;

		public guardarComo(File file, JTextArea areatexto) throws IOException {
			if (file.getName().endsWith("txt")) {
				this.file = file;
			} else {
				this.file = new File(file + ".txt");
			}
			this.areatexto = areatexto;
			escribir();
		}

		private void escribir() throws IOException {
			file.createNewFile();
			try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(fw)) {
				pw.println(areatexto.getText());
				
			}
		}

	}

	public static class Abrir {

		private File file;
		private JTextArea areatexto;

		public Abrir(File file, JTextArea areatexto) throws IOException {
			this.file = file;
			this.areatexto = areatexto;
			leer();
		}
		private void leer() throws FileNotFoundException, IOException{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String texto;
			while((texto=br.readLine()) != null){
				System.out.println(texto);
				areatexto.append(texto+"\n");
			}
		}
	}
}
