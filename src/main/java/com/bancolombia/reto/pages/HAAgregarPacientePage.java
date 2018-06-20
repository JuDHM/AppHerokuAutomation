package com.bancolombia.reto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bancolombia.reto.dtos.PacienteDTO;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HAAgregarPacientePage extends PageObject {
	
	@FindBy(name="name")
	private WebElement inpNombre;
	
	@FindBy(name="last_name")
	private WebElement inpApellidos;
	
	@FindBy(name="telephone")
	private WebElement inpTelefono;
	
	@FindBy(name="identification_type")
	private WebElement listTipoDocumento;
	
	@FindBy(name="identification")
	private WebElement inpNumId;
	
	@FindBy(name="prepaid")
	private WebElement chbOpcionPrepagada;
	
	@FindBy(xpath="//a[contains(text(), 'Guardar')]")
	private WebElement btnGuardar;
	
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
	
	public void registrarPaciente(PacienteDTO paciente) {
		diligenciarNombre(paciente.getNombre());
		diligenciarApellidos(paciente.getApellidos());
		diligenciarTelefono(paciente.getTelefono());
		diligenciarTipoDoc(paciente.getTipoDoc());
		digiligenciarNumDoc(paciente.getNumDoc());
		btnGuardar.click();
	}
	
	
	public String seleccionarOpcionListaID(String TipoID) {
		String opcionList;
		switch (TipoID) {
		case "CC":
			opcionList = "Cédula de ciudadanía";
			break;
		case "CE":
			opcionList = "Cédula de extrangería";
			break;
		case "PASS":
			opcionList = "Pasaportes";
			break;
		default:
			opcionList = "Cédula de ciudadanía";
			break;
		}
		return opcionList;
	}
}
