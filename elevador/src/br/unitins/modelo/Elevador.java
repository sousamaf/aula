package br.unitins.modelo;

public class Elevador {
	private int andarAtual;
	private boolean solicitacao[];
	private boolean portaAberta;
	private int base;
	private int topo;
	
	public Elevador(int topo, int base){
		this.topo = topo;
		this.base = base;
		this.solicitacao = new boolean[this.getPisoTotal()];
		
		for (int i = 0; i < solicitacao.length; i++) {
			solicitacao[i] = false;
		}
		
	}
	
	public int getPisoTotal(){
		if(this.base < 0)
		{
			return this.topo + Math.abs(this.base) + 1;
		}
		return this.topo - this.base + 1;
	}
	
	public int getAndarAtual(){
		return andarAtual;
	}

	public boolean subir(){
		if(this.andarAtual < this.topo) {
			this.andarAtual++;
			return true;
		}
		return false;
	}
	
	public boolean descer(){
		if(this.andarAtual > this.base) {
			this.andarAtual--;
			return true;
		}
		return false;
	}
		
	public void setSolicitacao(int solicitacao){
		if(this.base < 0)
			this.solicitacao[solicitacao + Math.abs(this.base)] = true;
		else
			this.solicitacao[solicitacao - this.base] = true;
	}

}
