import java.util.Scanner;

public class RepresentacaoDeDados {
	Integer decimal = (Integer) null;
	int[] binario = new int[8];
	int[] octal = new int[4];
	int[] hexadecimal = new int[4];
	Scanner entrada = new Scanner(System.in);	
	
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
		System.out.print("Digite um valor octal: ");
		decimal = entrada.nextInt();
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
		System.out.print("Digite um valor hexadecimal: ");
		decimal = entrada.nextInt();
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
