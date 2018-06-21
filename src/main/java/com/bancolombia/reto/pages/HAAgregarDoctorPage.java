package com.bancolombia.reto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bancolombia.reto.dtos.DoctorDTO;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HAAgregarDoctorPage extends PageObject {
	
	@FindBy(id="name")
	private WebElement inpNombre;
	
	@FindBy(id="last_name")
	private WebElement inpApellidos;
	
	@FindBy(id="telephone")
	private WebElement inpTelefono;
	
	@FindBy(id="identification_type")
	private WebElement listTipoDocumento;
	
	@FindBy(id="identification")
	private WebElement inpNumId;
	
	@FindBy(xpath="//a[contains(text(), 'Guardar')]")
	private WebElement btnGuardar;
	
//	@FindBy(xpath="//a[contains(text(), 'Inicio')]")
//	private WebElement lnkInicio;

	public void diligenciarNombre(String nombre) {
		inpNombre.sendKeys(nombre);
	}
	
	public void diligenciarApellidos(String apellido) {
		inpApellidos.sendKeys(apellido);
	}
	
	public void diligenciarTelefono(String telefono) {
		inpTelefono.sendKeys(telefono);
	}
	
	public void diligenciarTipoDoc(String tipoDoc) {
		Select list = new Select(listTipoDocumento);
		list.selectByValue(seleccionarOpcionListaID(tipoDoc));		
	}
	
	public void digiligenciarNumDoc(String numeroDoc) {
		inpNumId.sendKeys(numeroDoc);
	}
	
	public void registrarDoctor(DoctorDTO doctor) {
		diligenciarNombre(doctor.getNombre());
		diligenciarApellidos(doctor.getApellidos());
		diligenciarTelefono(doctor.getTelefono());
		diligenciarTipoDoc(doctor.getTipoDoc());
		digiligenciarNumDoc(doctor.getNumDoc());
		btnGuardar.click();
	}
	
//	public void irAPrincipal() {
//		lnkInicio.click();
//	}
	
	public String seleccionarOpcionListaID(String TipoID) {
		String opcionList;
		switch (TipoID) {
		case "CC":
			opcionList = "Cédula de ciudadanía";
			break;
		case "CE":
			opcionList = "Cédula de extrangería";
			break;
		case "Pass":
			opcionList = "Pasaportes";
			break;
		default:
			opcionList = "Cédula de ciudadanía";
			break;
		}
		return opcionList;
	}
	
}
