/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author ccs
 */
public class noadjacente implements Serializable {
  
   /**
	 * 
	 */
   private static final long serialVersionUID = -3926777131520637759L;
   private int n; 
   private int origem ;
   private int destino;
   private int custo;
   private char direcao;
  
   noadjacente (int n,int x,int y,int custo,char direcao){
   this.setN(n);
   this.setOrigem(x);
   this.setDestino(y);
   this.setCusto(custo);
   this.setDirecao(direcao);
   }
  public  noadjacente(){}
   
    public int getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(int origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * @return the custo
     */
    public int getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(int custo) {
        this.custo = custo;
    }

    /**
     * @return the direcao
     */
    public char getDirecao() {
        return direcao;
    }

    /**
     * @param direcao the direcao to set
     */
    public void setDirecao(char direcao) {
        this.direcao = direcao;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
   
}
