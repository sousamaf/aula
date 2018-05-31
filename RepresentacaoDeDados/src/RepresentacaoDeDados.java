import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class RepresentacaoDeDados {
	Integer decimal = (Integer) null;
	int[] binario = new int[8];
	int[] octal = new int[4];
	int[] hexadecimal = new int[4];
	Scanner entrada = new Scanner(System.in);	
	
	public void converter2decimal()
	{
		int decimalParcial = 0;
		int i = 0;
		int p = 7;
		
		for(i = 0; i < 8; i++)
		{
			decimalParcial += binario[i] * Math.pow(2.0, (double) p);
			p--;
		}
		this.decimal = decimalParcial;
	}
	
	public void converter8decimal()
	{
		int decimalParcial = 0;
		int i = 0;
		int p = 3;
		
		for(i = 0; i < 4; i++)
		{
			decimalParcial += octal[i] * Math.pow(8.0, (double) p);
			p--;
		}
		this.decimal = decimalParcial;		
	}
	
	public void converter10binario()
	{
		/*
		 * Atividade 1
		 * Comente cada linha do método converter10Binario()
		 * relatando o que está acontecendo/qual sua necessidade.
		 * 
		 * A seguir o método com cada linha comentada.
		 * 
		 */
		// Variável local para armazenar o valor decimal.
		int decimalTemp = this.decimal;
		// Variável utlilzada para manter o resultado parcial da divisão.
		int divisao = 0;
		// Variável contem o valor da base de destino da conversão.
		int base = 2;
		// Variável para iteração nas estruturas de repetições existentes.
		int i = 0;
		// Variável utilizada para manter o índice referente a posição no vetor de destino.
		int p = 7;
		// Variável do tipo String para acumular o resto da divisão.
		String sBinario = "";
		
		// Estrutura de repetição responsável pela divisão sucessíva do valor pela base.
		while(decimalTemp >= base)
		{
			divisao = (int) decimalTemp / base;
			sBinario += (decimalTemp - (divisao * base));
			decimalTemp = divisao;
		}
		sBinario += decimalTemp;
		
		// Estrutura de repetição para inicializar/zerar o array de destino do valor convertido.
		for(i = 0; i < 8; i++)
		{
			this.binario[i] = 0;
		}
		// Estrutura de repetição para copiar o valor convertido para a posição correta no vetor de destino.
		for(i = 0; i < sBinario.length(); i++)
		{
			this.binario[p] = Integer.parseInt(sBinario.substring(i, (i+1)));
			p--;
		}
	}
	/*
	 * Atividade 2: Implemente a conversão da base 10 para octal.
	 * A seguir uma solução viável do problema. 
	 */
	public void converter10octal()
	{
		int decimalTemp = this.decimal;
		int divisao = 0;
		int base = 8;
		int i = 0;
		int p = 3;
		
		String sOctal = "";
		
		while(decimalTemp >= base)
		{
			divisao = (int) decimalTemp / base;
			sOctal += (decimalTemp - (divisao * base));
			//System.out.println("Divisao: " + divisao);
			decimalTemp = divisao;
		}
		sOctal += decimalTemp;
		
		for(i = 0; i < 4; i++)
		{
			this.octal[i] = 0;
		}
		
		for(i = 0; i < sOctal.length(); i++)
		{
			this.octal[p] = Integer.parseInt(sOctal.substring(i, (i+1)));
			p--;
		}		
	}
	
	/*
	 * Atividade 3: Implemente a conversão da base 10 para hexadecimal.
	 * A seguir uma possível solução do problema.
	 */	
	public void converter10hexadecimal()
	{
		int decimalTemp = this.decimal;
		int divisao = 0;
		int base = 16;
		int i = 0;
		int p = 3;
		
		int[] iHex = new int[4];
	
		for(i = 0; i < 4; i++)
		{
			this.hexadecimal[i] = 0;
			iHex[i] = 0;
		}
		i = 0;
		
		while(decimalTemp >= base)
		{
			divisao = (int) decimalTemp / base;
			iHex[i] = (decimalTemp - (divisao * base));
			decimalTemp = divisao;
			i++;
		}
		iHex[i] = decimalTemp;
		
		for(i = 0; i < iHex.length; i++)
		{
			this.hexadecimal[p] = iHex[i];
			p--;
		}		
	}
	
	public void converter16decimal()
	{
		int decimalParcial = 0;
		int i = 0;
		int p = 3;
		
		for(i = 0; i < 4; i++)
		{
			decimalParcial += hexadecimal[i] * Math.pow(16.0, (double) p);
			p--;
		}
		this.decimal = decimalParcial;			
	}
	
	public void exibeVetores(int qual)
	{
		int i;
		if(qual == 2)
		{
			System.out.print("[ ");
			for(i = 0; i < 8; i++)
				System.out.print(binario[i] + " ");
			System.out.println("]");
		}
		
		if(qual == 8)
		{
			for(i = 0; i < 4; i++)
				System.out.print(octal[i] + " ");
			System.out.println("");
		}
		
		if(qual == 16)
		{
			exibeHexadecimal();
			System.out.println("");
		}
	}
	
	public int entradaHexadecimalInt()
	{
		String valor = new String();
		int valorInteiro = 0;
		valor = entrada.next();
		
		switch (valor) {
		case "0":
			valorInteiro =  0;
			break;
		case "1":
			valorInteiro = 1;
			break;
		case "2":
			valorInteiro = 2;
			break;
		case "3":
			valorInteiro = 3;
			break;
		case "4":
			valorInteiro = 4;
			break;
		case "5":
			valorInteiro = 5;
			break;
		case "6":
			valorInteiro = 6;
			break;
		case "7":
			valorInteiro = 7;
			break;
		case "8":
			valorInteiro = 8;
			break;
		case "9":
			valorInteiro = 9;
			break;
		case "A":
			valorInteiro = 10;
			break;
		case "B":
			valorInteiro = 11;
			break;
		case "C":
			valorInteiro = 12;
			break;
		case "D":
			valorInteiro = 13;
			break;
		case "E":
			valorInteiro = 14;
			break;
		case "F":
			valorInteiro = 15;
			break;

		default:
			break;
		}
		return valorInteiro;
	}
	
	public void entradaBinario()
	{
		System.out.println("Digite um valor binário. ");

		int i;
		int p = 7;
		for(i = 0; i < 8; i++ )
		{
			System.out.print("binario[ " + p +" ]: ");
			binario[i] = entrada.nextInt();
			p--;
		}
		
		converter2decimal();
		converter10octal();
		converter10hexadecimal();
		menu();
	}
	
	public void entradaOctal()
	{
		System.out.println("Digite um valor octal. ");
		
		int i;
		int p = 3;
		for(i = 0; i < 4; i++ )
		{
			System.out.print("octal[ " + p +" ]: ");
			octal[i] = entrada.nextInt();
			p--;
		}
		
		converter8decimal();
		converter10binario();
		converter10hexadecimal();
		menu();
	}
		
	public void entradaDecimal()
	{
		System.out.print("Digite um valor decimal: ");
		decimal = entrada.nextInt();
		
		converter10binario();
		converter10octal();
		converter10hexadecimal();
		
		menu();
	}
	public void entradaHexadecimal()
	{
		System.out.println("Digite um valor hexadecimal.");
		
		int i;
		int p = 3;
		for(i = 0; i < 4; i++ )
		{
			System.out.print("hexadecimal[ " + p +" ]: ");
			hexadecimal[i] = entradaHexadecimalInt();
			p--;
		}
		
		converter16decimal();
		converter10octal();
		converter10binario();
		menu();
	}

	public void exibeHexadecimal()
	{
		int i;
		for(i = 0; i < 4; i++)
		{
			if(hexadecimal[i] < 10) 
			{
				System.out.print(hexadecimal[i]);
			}
			else
			{
				switch (hexadecimal[i]) {
				case 10:
					System.out.print("A");
					break;
				case 11:
					System.out.print("B");
					break;
				case 12:
					System.out.print("C");
					break;
				case 13:
					System.out.print("D");
					break;
				case 14:
					System.out.print("E");
					break;
				case 15:
					System.out.print("F");
					break;					
				default:
					break;
				}
			}
		}
	}
	
	public void menu() 
	{
		int opcao = 0;
		
		System.out.println("Representacao de Dados\n");
		
		if(decimal != null)
		{
			System.out.println("Valores carregados em memória:");
			System.out.print("\tBinario \t\t = ");
			exibeVetores(2);
			System.out.print("\tOctal \t\t = ");
			exibeVetores(8);
			System.out.println("\tDecimal \t\t = " + decimal);
			System.out.print("\tHexadecimal \t = ");
			exibeVetores(16);
		}
		
		System.out.println("Digite: ");
		System.out.println("\t1 para inserir binario.");
		System.out.println("\t2 para inserir octal.");
		System.out.println("\t3 para inserir decimal.");
		System.out.println("\t4 para inserir hexadecimal.");
		System.out.println("\t9 para sair.");
		
		System.out.print("Entrada: ");
		opcao = entrada.nextInt();
		
		switch (opcao) {
		case 9:
			System.out.println("Saindo.");
			break;
		case 1:
			entradaBinario();
			break;
		case 2:
			entradaOctal();
			break;
		case 3:
			entradaDecimal();
			break;
		case 4:
			entradaHexadecimal();
			break;

		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		RepresentacaoDeDados conversor = new RepresentacaoDeDados();
		conversor.menu();

	}

}