package br.unitins.modelo;

public class CarroACombustao extends Carro{
	public float volume;
	public float consumo;
	
	public CarroACombustao(String nome, String cor, float volume, float consumo){
		super(nome, cor);
		this.volume = volume;
		this.consumo = consumo;
	}
	
	public CarroACombustao(String nome, float volume, float consumo){
		super(nome);
		this.volume = volume;
		this.consumo = consumo;
	}

	public void detalhar() {
		System.out.println("Detalhes do carro à Combustão");
		System.out.println("Nome:\t" + this.nome);
		System.out.println("Cor:\t" + this.cor);
		System.out.println("Volume:\t" + this.volume);
		System.out.println("Consumo:\t" + this.consumo);
	}
	

}
