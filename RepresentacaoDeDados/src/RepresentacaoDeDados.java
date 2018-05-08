import java.util.Scanner;

public class RepresentacaoDeDados {
	Integer decimal = (Integer) null;
	int[] binario = new int[8];
	int[] octal = new int[4];
	int[] hexadecimal = new int[4];
	Scanner entrada = new Scanner(System.in);	
	
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
		for(i = 0; i < 8; i++ )
		{
			System.out.print("binario[ " + i +" ]: ");
			binario[i] = entrada.nextInt();
		}
		
		menu();
	}
	
	public void entradaOctal()
	{
		System.out.println("Digite um valor octal. ");
		
		int i;
		for(i = 0; i < 4; i++ )
		{
			System.out.print("octal[ " + i +" ]: ");
			octal[i] = entrada.nextInt();
		}
		
		menu();
	}
		
	public void entradaDecimal()
	{
		System.out.print("Digite um valor decimal: ");
		decimal = entrada.nextInt();
		menu();
	}
	public void entradaHexadecimal()
	{
		System.out.println("Digite um valor hexadecimal.");
		
		int i;
		for(i = 0; i < 4; i++ )
		{
			System.out.print("hexadecimal[ " + i +" ]: ");
			hexadecimal[i] = entradaHexadecimalInt();
		}
		
		menu();
	}
	
	public void menu() 
	{
		int opcao = 0;
		
		System.out.println("Representacao de Dados\n");
		
		if(decimal != null)
		{
			System.out.println("Valores carregados em memória:");
			System.out.println("\tBinario \t\t = ");
			System.out.println("\tOctal \t\t = ");
			System.out.println("\tDecimal \t\t = " + decimal);
			System.out.println("\tHexadecimal \t = ");
		}
		
		System.out.println("Digite: ");
		System.out.println("\t1 para inserir binario.");
		System.out.println("\t2 para inserir octal.");
		System.out.println("\t3 para inserir decimal.");
		System.out.println("\t4 para inserir hexadecimal.");
		
		System.out.print("Entrada: ");
		opcao = entrada.nextInt();
		
		switch (opcao) {
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
