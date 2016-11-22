import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Leitura 
{
	ArrayList<String> arrayVertice;
	ArrayList<String> arrayAdjAux;
	ArrayList<String> arrayCustoAux;
	ArrayList<String[]> arrayAdj;
	ArrayList<String[]> arrayCusto;
	String sValorPeso;
	String sValorAdj;
	int p = 0;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void leia(String directory) 
	{

		File arq = new File(directory);
		
		arrayVertice = new ArrayList(); //Arrya para armazenar os vertices
		arrayAdj = new ArrayList<String[]>();
		arrayCusto = new ArrayList<String[]>();

		try
		{
			//Indicamos o arquivo que será lido
			FileReader fileReader = new FileReader(arq);

			//Criamos o objeto bufferReader que nos
			// oferece o método de leitura readLine()
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			//String que irá receber cada linha do arquivo
			String linha = "";

			//Fazemos um loop linha a linha no arquivo,
			// enquanto ele seja diferente de null.
			//O método readLine() devolve a linha na
			// posicao do loop para a variavel linha.
			while ( ( linha = bufferedReader.readLine() ) != null) 
			{
				StringTokenizer prStringToken = new StringTokenizer(linha," "); //Ocorre a quebra da linha

				int cont = prStringToken.countTokens(); //Variavel que guarda a quantidade de quebras feitas
				
				arrayAdjAux = new ArrayList<String>(); //Cria um array para amarzenar suas adjacencias
				arrayCustoAux = new ArrayList<String>();

				arrayVertice.add(prStringToken.nextToken()); //Adiciona os vertices ao array

				for(int j = 1; j < cont; j++) 
				{
					String sAdj_Peso = prStringToken.nextToken(); //Esta armazenando as adjacencias e caso houver, o peso
					StringTokenizer prStringToken0 = new StringTokenizer(sAdj_Peso,";"); //Ocorre a quebra da linha para separar adjacencia do peso
					int cont1 = prStringToken0.countTokens(); //Variavel que guarda a quantidade de quebras feitas 

					for(p = 0; p < cont1; p++)
					{
						if(p == 1)
						{
							sValorPeso = prStringToken0.nextToken(); //Esta armazenando o peso da ligação
							arrayCustoAux.add(sValorPeso); //Adiciona o peso a um array que esta sendo criado de acordo com a posição do array da adjacencia

						}
						else
						{
							sValorAdj = prStringToken0.nextToken(); //Esta armazenando a adjacencia do vertice
							arrayAdjAux.add(sValorAdj); // Adiciona as adjacencias dentro do arrya
						}
					}
				}
				
				String[] aux1 = new String[arrayCustoAux.size()];
				aux1 = arrayCustoAux.toArray(aux1);
				arrayCusto.add(aux1);
				
				String[] aux2 = new String[arrayAdjAux.size()];
				aux2 = arrayAdjAux.toArray(aux2);
				arrayAdj.add(aux2);
			}

			//liberamos o fluxo dos objetos 
			// ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
