package br.unitins.modelo;

public class CarroEletrico extends Carro{
	String torque;
	int autonomia;
	
	public CarroEletrico(String nome, String torque, int autonomia) {
		super(nome);
		
		this.torque = torque;
		this.autonomia = autonomia;
	}

	public CarroEletrico(String nome, String cor, String torque, int autonomia) {
		super(nome, cor);
		
		this.torque = torque;
		this.autonomia = autonomia;
	}

	public void detalhar(){
		System.out.println("Detalhes do carro elétrico");
		System.out.println("Nome:\t" + this.nome);
		System.out.println("Cor:\t" + this.cor);
		System.out.println("Torque:\t" + this.torque);
		System.out.println("Autonomia:\t" + this.autonomia);
	}
}
