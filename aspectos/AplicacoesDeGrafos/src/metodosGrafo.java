/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.*;
import java.io.File;
import java.io.FileWriter;
//import java.io.FileReader;
import java.io.IOException;
//import java.io.FileNotFoundException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import javax.swing.JOptionPane;

public class metodosGrafo extends noadjacente
{
      /**
	 * 
	 */
	private static final long serialVersionUID = -3717786688836847040L;
	int  valor;
      String a=""; String b=" "; String c="";
      int mat[][];  
      noadjacente no = new noadjacente();
     
      FileWriter arq=null; 
     
      public FileWriter criaArquivo()
      {
        try {
               arq= new FileWriter(new File("d:\\arquivoGrafo.txt"));   
        }catch (IOException e) {  
        	
        }
          JOptionPane.showMessageDialog(null," Arquivo "+ "d:\\arquivoGrafo.txt" +" criado com sucesso!");
        return arq;
      }
      
      public  metodosGrafo(int n,int x,int y,int custo,char direcao)
      {
            super(n,x,y,custo, direcao);
      }
      
      public  metodosGrafo(){
         this(0,0,0,0,'s');
      }
     
      public void inicializarMat(int N,int A,char direc) //matriz de adjacencias por arestas
      {
           inicializarmatriz(N);
           char acerta=direc;
           int count=0;
           while(count<A)
           {
                 int g = gerarumrand( N);
                 int h = gerarumrand( N);
                 if(g!=h &&mat[g][h]==0&&(acerta=='s'))
                 {
                     mat[g][h]=g+h; count++;
                 }
                 else if(g!=h &&mat[g][h]==0&&(acerta=='n'))
                 {
                       mat[g][h]=g+h;
                       count++;
                 }
                 else
                 if(g!=h &&mat[g][h]!=0&&(acerta=='n'))
                 {
                          if(mat[h][g]==0){
                               mat[h][g]=h+g; 
                               count++;
                          }
                 }
//                 if(count>= A) return;
           }    
      }
       
      public String verificar(int k,int N)
      {
          int conta=0;
          for(int j=0;j<N;j++)
          {
             if(mat[k][j]==0) 
                  conta++;
          }
          if(conta==N)
            return ""; 
          else 
              return "v"+k;
       }
     
     public void gerargrafoCompleto(int N,int A,char direc) // grafo não randomico, máximo de arestas = N*(N-1)/2, sem ciclos e paralelos.
     {
       try{
             PrintWriter gravarArq = new PrintWriter(criaArquivo()); 
             inicializarMat(N,A,direc); // inicializa com custo=0 e um vertice t=semente
              for(int i=0;i< N;i++)
              {
                   c=verificar(i,N); if("".equals(c))  continue;     
                 for(int j=0;j<N;j++)
                 {
                        if( mat[i][j]!=0)
                        {                     
                            b =" "+"v"+j+";"+(mat[i][j]);
                            c = c + b;
//                           System.out.println("  "+i+"       "+j +"      "+(mat[i][j])); //para teste
                        }
                        no.setN(N); no.setOrigem(i); no.setDestino(j); no.setCusto(i+j);
                        no.setDirecao(direc);
                   }
                   gravarArq.println(c);
                   gravarArq.flush();
                   c="";
               } 
               gravarArq.close();    
        }catch(Exception e){
        
        }
    } 
 
      public void inicializarmatriz(int v)
      {  
         mat = new int[v][v];  
         for(int i=0;i<v;i++){
          for(int j=0;j<v;j++){
               mat[i][j]=0;
          }
        }
      }
         
     public int gerarumrand(int N)
     {       
          valor = (int)(Math.random()*N); 
          return valor;
     }
}  
 

