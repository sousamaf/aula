package br.edu.catolica;

import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class Comum implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6580678000312906920L;
	private String name;
	private String pass;
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSayWelcome(){

		   if("".equals(name) || name ==null)
		   {
			   return "";
		   }else
		   {
			   return "Uai, é ajax : Welcome " + name;
		   }
	}	
	public String getValidaNome()
	{
		if("".equals(name) || name == null)
		{
			return "Digite um nome valido";
		}
		else if(this.name.equals("marco"))
		{
			return "Que cara lindo";
		}
		else
		{
			return "Usuário feio";
		}
	}
	public void getVoid(ActionEvent ae){
		name = "";
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
