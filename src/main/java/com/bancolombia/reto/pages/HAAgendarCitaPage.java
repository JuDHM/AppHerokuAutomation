package com.bancolombia.reto.pages;

import org.openqa.selenium.WebElement;

import com.bancolombia.reto.dtos.CitaDTO;
import com.bancolombia.reto.dtos.DoctorDTO;
import com.bancolombia.reto.dtos.PacienteDTO;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;


public class HAAgendarCitaPage extends PageObject {

	@FindBy(id="datepicker")
	private WebElement inpFechaCita;
	
	@FindBy(xpath="//input[@placeholder='Ingrese el documento de identidad del paciente']")
	private WebElement inpDocPaciente;
	
	@FindBy(xpath="//input[@placeholder='Ingrese el documento de identidad del doctor']")
	private WebElement inpDocDoctor;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	private WebElement inpObservaciones;
	
	@FindBy(css=".panel-body > p")
	private WebElement lblMensajeExitoso;
	
	@FindBy(css=".panel-title")
	private WebElement lblTituloError;
	
	@FindBy(xpath="//a[contains(text(), 'Guardar')]")
	private WebElement btnGuardar;
	
	
	
	public void ingresarFecha(String fecha) {
		inpFechaCita.sendKeys(fecha);
	}
	
	public void ingresarDocPaciente(String numDocPaciente) {
		inpDocPaciente.sendKeys(numDocPaciente);
	}
	
	public void ingresarDocDoctor(String numDocDoctor) {
		inpDocDoctor.sendKeys(numDocDoctor);
	}
	
	public void ingresarObservacion(String observacion) {
		inpObservaciones.sendKeys(observacion);
	}
	
	public void registrarCita(CitaDTO cita, DoctorDTO doctor, PacienteDTO paciente) {
		ingresarFecha(cita.getFechaCita());
		ingresarDocPaciente(paciente.getNumDoc());
		ingresarDocDoctor(doctor.getNumDoc());
		ingresarObservacion(cita.getObservaciones());
		btnGuardar.click();
	}
	
	public String obtenerMensajeEsperado() {
		return lblMensajeExitoso.getText();
	}
	
	public String obtenerTituloError() {
		return lblTituloError.getText();
	}
}