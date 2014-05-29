package edu.catolica;

import java.util.Scanner;

public class Conversor {

	// Variável para conter a parte binária do Sinal.
	String sSinal;
	
	// Variável para conter a parte binária do Expoente.
	String sExpoente;
	
	//Variável para conter a parte binária da Mantissa.
	String sMantissa; 
	
	// Variável para conter o expoente convertido para inteiro em 
	// notação por excesso 3.
	int iExpoente;
	
	// Método Construtor.
	public Conversor()
	{
		// Variável para utilização nos laços for.
		int i = 0;
		
		// Início do bloco de comandos para entrada de dados via teclado.
		Scanner input = new Scanner(System.in);
		String entrada = new String();
		System.out.print("<<< ");
		entrada = input.next();
		// Fim do bloco de comandos para entrada de dados via teclado.
		
		String aux;
		sSinal = entrada.substring(0, 1);
		sExpoente = entrada.substring(1, 4);
		sMantissa = entrada.substring(4, 8);
		
		System.out.println("Sinal: " + sSinal);
		System.out.println("Exp: " + sExpoente);
		System.out.println("Mantissa: " + sMantissa);
		
		// Conversão de binário BCD8421 para decimal.
		for(i = 2; i >= 0; i--)
		{
			aux = "" + sExpoente.charAt(i);
			iExpoente += (Integer.parseInt(aux,10) * Math.pow(2, Math.abs(i - 2)));
		}
		// Notação por excesso 3.
		// iExpoente - 3 
		iExpoente = iExpoente - 3;
			
	}
	public static void main(String[] args) {
		new Conversor();
	}
}
