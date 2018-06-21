package com.bancolombia.reto.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HABarraNavegacionPage extends PageObject {
	
	@FindBy(xpath="//a[contains(text(), 'Inicio')]")
	private WebElement lnkInicio;
	
	
	public void irAPrincipal() {
		lnkInicio.click();
	}
}
