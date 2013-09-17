package br.edu.catolica.diversos;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="salario")
public class Salario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8580051254193841699L;
	private String nome;
	private float salarioBruto;
	private float salarioLiquido;
	private float descontoInss;
	private float descontoIrrf;
	private float descontoSindicato;
	
	public String getCalcular(){
		this.setDescontoInss(salarioBruto * (float) 0.08);
		this.setDescontoIrrf(salarioBruto * (float) 0.275);
		this.setDescontoSindicato(salarioBruto * (float) 0.005);
		
		this.setSalarioLiquido(salarioBruto - descontoInss - descontoIrrf - descontoSindicato);
		return "Salário líquido: " + salarioLiquido;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(float salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public float getSalarioLiquido() {
		return salarioLiquido;
	}
	public void setSalarioLiquido(float salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	public float getDescontoInss() {
		return descontoInss;
	}
	public void setDescontoInss(float descontoInss) {
		this.descontoInss = descontoInss;
	}
	public float getDescontoIrrf() {
		return descontoIrrf;
	}
	public void setDescontoIrrf(float descontoIrrf) {
		this.descontoIrrf = descontoIrrf;
	}
	public float getDescontoSindicato() {
		return descontoSindicato;
	}
	public void setDescontoSindicato(float descontoSindicato) {
		this.descontoSindicato = descontoSindicato;
	}

}
