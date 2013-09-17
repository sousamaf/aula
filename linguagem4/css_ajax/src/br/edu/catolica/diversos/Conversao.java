package br.edu.catolica.diversos;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Conversao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1966790485889172984L;
	public int dias;
	public int horas;
	public int minutos;
	public int segundos;
	public int segundosTotais;
	
	public String getCalcular() {
		segundosTotais = segundos + (minutos * 60) + (horas * 3600) + (dias * 86400);
		return "Total de segundos: " + segundosTotais;
	}
	
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public int getSegundosTotais() {
		return segundosTotais;
	}
	public void setSegundosTotais(int segundosTotais) {
		this.segundosTotais = segundosTotais;
	}
	
}
