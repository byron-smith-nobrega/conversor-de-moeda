package br.com.alura.conversor;

import javax.swing.JOptionPane;

import br.com.alura.conversor.moeda.Moeda;
import br.com.alura.conversor.temperatura.Temperatura;

public class principal {

	public static void main(String[] args) {
		
		int auxi = 0;
		String controle;
		do {
			controle = inicio();
			
			if (controle == "Conversor de Moeda") {
				auxi = Moeda.programa();
			}else if(controle == "Conversor de Temperatura"){
				auxi = Temperatura.programa();
			}else {
				auxi = 1;
			}
		} while (auxi == 0);
	}

	private static String inicio() {
		String controle;
		Object[] possibilities = { "Conversor de Moeda", "Conversor de Temperatura" };
		controle = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.PLAIN_MESSAGE,
				null, possibilities, null);		
		return controle;
	}
}
