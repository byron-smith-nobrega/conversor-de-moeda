package br.com.alura.conversor.temperatura;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Temperatura {

	public static Integer programa() {
		String valor = "";
		String trocaVirgulaPonto = null;
		String controle = "";
		int auxiliar = 0;
		Object[] converter = { "de Celsius a Kelvin", "de Celsius a Fahrenheit", "de Fahrenheit a Celsius", 
				"de Kelvin a Celsius","de Kelvin a Fahrenheit", "de Fahrenheit a Kelvin"};

		while (auxiliar != 1) {
			auxiliar = 1;
			valor = JOptionPane.showInputDialog("Insira um Temperatura:");
			if (valor == null) {
				System.exit(2);
			}
			/*
			 * if (!valor.trim().matches("\\d+")) { JOptionPane.showMessageDialog(null,
			 * "Temperatura inválido"); auxi = 0; }
			 */

		}

		trocaVirgulaPonto = valor.replace(".", "").replaceAll(",", ".");

		controle = (String) JOptionPane.showInputDialog(null,
				"Escolha a escala de temperatura para qual você deseja converter", "Temperatura",
				JOptionPane.PLAIN_MESSAGE, null, converter, null);
		switch (controle) {
		case "de Celsius a Kelvin":
			double celsiusK = (Double.parseDouble(trocaVirgulaPonto)+273.15);
			auxiliar = (Integer) conversorValor(celsiusK, "K ");
			break;
		case "de Celsius a Fahrenheit":
			double celsiusF = (1.8 * Double.parseDouble(trocaVirgulaPonto))+32;
			auxiliar = (Integer) conversorValor(celsiusF, "°F ");
			break;
		case "de Fahrenheit a Celsius":
			double FahrenheitC = (Double.parseDouble(trocaVirgulaPonto)-32)/1.8;
			auxiliar = (Integer) conversorValor(FahrenheitC, "°C ");
			break;
		case "de Kelvin a Celsius":
			double KelvinC = (Double.parseDouble(trocaVirgulaPonto)-273.15);
			auxiliar = (Integer) conversorValor(KelvinC, "°C ");
			break;
		case "de Kelvin a Fahrenheit":
			double KelvinF = (((Double.parseDouble(trocaVirgulaPonto)-273.15)*9/5)+32);
			auxiliar = (Integer) conversorValor(KelvinF, "°F ");
			break;
		case "de Fahrenheit a Kelvin":
			double FahrenheitK = (((Double.parseDouble(trocaVirgulaPonto)-32)*5/9)+273.15);
			auxiliar = (Integer) conversorValor(FahrenheitK, "K ");
			break;
		default:
			break;
		}

		return auxiliar;

	}

	private static Integer conversorValor(Double valor, String tipo) {
		StringBuilder mensagem = new StringBuilder();
		DecimalFormat df = new DecimalFormat("###,##0.00");
		mensagem.append("O valor da conversão é de " + tipo).append(df.format(valor)).append("");
		JOptionPane.showMessageDialog(null, mensagem);
		int controleFluxo = continuar();
		return controleFluxo;
	}

	private static Integer continuar() {
		int controleFluxo = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Select an Option",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (controleFluxo == 1 || controleFluxo == 2) {
			JOptionPane.showMessageDialog(null, "Programa finalizado");
		}
		return controleFluxo;
	}

}
