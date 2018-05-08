import java.util.Scanner;

public class RepresentacaoDeDados {
	Integer decimal = (Integer) null;
	int[] binario = new int[8];
	int[] octal = new int[4];
	int[] hexadecimal = new int[4];
	Scanner entrada = new Scanner(System.in);	
	
	public void entradaDecimal()
	{
		System.out.print("Digite um valor decimal: ");
		decimal = entrada.nextInt();
	}
	
	public void menu() 
	{
		int opcao = 0;
		
		System.out.println("Representacao de Dados\n");
		
		if(decimal != null)
		{
			System.out.println("Valores carregados em memória:");
			System.out.println("\tBinario \t = ");
			System.out.println("\tOctal \t\t = ");
			System.out.println("\tDecimal \t = ");
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
			
			break;
		case 2:
			
			break;
		case 3:
			entradaDecimal();
			break;
		case 4:
			
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
