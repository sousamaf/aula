package br.unitins.execucao;

import br.unitins.modelo.CarroACombustao;
import br.unitins.modelo.CarroEletrico;


public class Principal {
	
	public static void main(String[] args) {
		CarroEletrico ce = new CarroEletrico("i8", "preto", "50", 360);
		ce.detalhar();
		
		System.out.println("");
		
		CarroACombustao cc = new CarroACombustao("Civic", "verde", (float) 1.8, (float) 8.2);
		cc.detalhar();

		CarroACombustao d = new CarroACombustao("Discovery", (float) 3.8, (float) 10.2);
		d.detalhar();

	}

}
