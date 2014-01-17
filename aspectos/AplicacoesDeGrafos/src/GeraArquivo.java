/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
/**
 *
 * @author ccs
 */
public class GeraArquivo {

/*********************************************************************
 * Faculdade: Católica do Tocantins
 * Disciplina: Aspectos Teóricos
 * Professor: Marco Souza
 * @author Cássio, Cosme e Washington
 * Linguagem: JAVA
 * Objetivo: Implementar o projeto proposto, que gere um arquivo com
 * os parâmetros necessários para posterior leitura.
 ********************************************************************/
	public GeraArquivo() {

           try{   
		int N = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de v�rtices: "));
                   
                int A = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de arestas:\n"+
                        " obs: quant. de arestas menor ou igual a: N*(N-1) e A>=N. N= n� de v�rtices."));
                   
		String direcao = JOptionPane.showInputDialog("Digite sim para direcionado ou nao para n�o direcionado: ");
		 char direc = direcao.charAt(0);
               
//                String metrica = JOptionPane.showInputDialog("Digite a m��trica");
//                System.out.println("M��trica utilizada: " + metrica); 
//		
//		int escolha =Integer.parseInt( JOptionPane.showInputDialog("Digite 1: Matriz de arestas Adjacente\n"
//						+ "Digite 2: Matriz Incidente\n"
//						+ "Digite 3: Lista Adjacente\n"
//						+ "Digite 4: Lista Adjacente de um grafo direcionado\n"));
		
                if( (direc=='s'||direc=='n') && (A<=(N*(N-1))&& (A>=N)) )
                {
                           metodosGrafo mtg = new metodosGrafo();
                            if(direc=='s')
                              mtg.gerargrafoCompleto(N,A, 's');
                                if(direc=='n')
                                   mtg.gerargrafoCompleto(N,A, 'n');
                }
                else
                    JOptionPane.showMessageDialog(null, "Digite as entradas corretamente!");
           }catch(NumberFormatException  e){
        	   
         }
      }
}                            
    