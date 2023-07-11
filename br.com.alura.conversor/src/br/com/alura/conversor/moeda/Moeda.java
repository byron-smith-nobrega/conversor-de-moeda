package br.com.alura.conversor.moeda;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Moeda {
	
	public static Integer programa() {
		String valor = "";
		String trocaVirgulaPonto = null;
		String controle = "";
		int auxi = 0;
		Object[] converter = { "de Reais a Dólares", "de Reais a Euros", "de Reais a Libras", "de Reais a Yenes",
				"de Reais a Won Coreano", "de Dólares a Reais", "de Euros a Reais", "de Libras a Reais" };

		while (auxi != 1) {
			auxi = 1;
			valor = JOptionPane.showInputDialog("Insira um valor:");
			if (valor == null) {
				System.exit(2);
			}
			if (!valor.trim().matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				auxi = 0;
			}

		}

		trocaVirgulaPonto = valor.replace(".", "").replaceAll(",", ".");

		controle = (String) JOptionPane.showInputDialog(null,
				"Escolha a moeda para qual você deseja girar seu dinheiro", "Moedas", JOptionPane.PLAIN_MESSAGE, null,
				converter, null);
		switch (controle) {
		case "de Reais a Dólares":
			double emDola = Double.parseDouble(trocaVirgulaPonto) / 4.90;
			auxi = (Integer) conversorValor(emDola, "US$ ");
			break;
		case "de Reais a Euros":
			double emEuro = Double.parseDouble(trocaVirgulaPonto) / 5.39;
			auxi = (Integer) conversorValor(emEuro, "€ ");
			break;
		case "de Reais a Libras":
			double emLibra = Double.parseDouble(trocaVirgulaPonto) / 6.33;
			auxi = (Integer) conversorValor(emLibra, "£ ");
			break;
		case "de Reais a Yenes":
			double emYene = Double.parseDouble(trocaVirgulaPonto) / 0.035;
			auxi = (Integer) conversorValor(emYene, "¥ ");
			break;
		case "de Reais a Won Coreano":
			double emWon = Double.parseDouble(trocaVirgulaPonto) / 0.0038;
			auxi = (Integer) conversorValor(emWon, "₩ ");
			break;
		case "de Dólares a Reais":
			double emDolaReais = Double.parseDouble(trocaVirgulaPonto) * 4.90;
			auxi = (Integer) conversorValor(emDolaReais, "R$ ");
			break;
		case "de Euros a Reais":
			double emEuroReais = Double.parseDouble(trocaVirgulaPonto) * 5.39;
			auxi = (Integer) conversorValor(emEuroReais, "R$ ");
			break;
		case "de Libras a Reais":
			double emLibraReais = Double.parseDouble(trocaVirgulaPonto) * 6.33;
			auxi = (Integer) conversorValor(emLibraReais, "R$ ");
			break;
		default:
			break;
		}

		return auxi;

	}

	private static Integer conversorValor(Double valor, String s) {
		StringBuilder mensagem = new StringBuilder();
		DecimalFormat df = new DecimalFormat("###,##0.00");
		mensagem.append("O valor da conversão é de " + s).append(df.format(valor)).append("");
		JOptionPane.showMessageDialog(null, mensagem);
		int cont = continuar();
		return cont;
	}

	private static Integer continuar() {
		int n = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Select an Option",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (n == 1 || n == 2) {
			JOptionPane.showMessageDialog(null, "Programa finalizado");
		}
		return n;
	}

}
