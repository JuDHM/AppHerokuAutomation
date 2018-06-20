package com.bancolombia.reto.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

//@DefaultUrl("http://automatizacion.herokuapp.com/")
public class HAPrincipalPage extends PageObject {
	
	//@FindBy(xpath="//a[contains(text(), 'Agregar Doctor')]")
	@FindBy(linkText="Agregar Doctor")
	private WebElement lnkAdicionarDoc;
	
	@FindBy(linkText="Agregar Paciente")
	private WebElement lnkAdicionarPaciente;
	
	@FindBy(linkText="Agendar Cita")
	private WebElement lnkAgendarCita;
	
	public void ingresarAOpcionDoctor() {
		lnkAdicionarDoc.click();
	}
	
	public void ingresarAOpcionPaciente() {
		lnkAdicionarPaciente.click();
	}
	
	public void ingresarOpcionCitas() {
		lnkAgendarCita.click();
	}
	
}
