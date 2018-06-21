package com.bancolombia.reto.steps;

import com.bancolombia.reto.pages.HABarraNavegacionPage;
import com.bancolombia.reto.pages.HAPrincipalPage;

import net.thucydides.core.annotations.Step;

public class HANavegarMenuStep {
	
	HAPrincipalPage principal;
	HABarraNavegacionPage barraNavegacion;
	
	@Step
	public void navegarAlSitio() {
		principal.open();
	}
	
	@Step
	public void irAOpcionPaciente() {
		principal.ingresarAOpcionPaciente();
	}
	
	@Step
	public void irAOpcionDoctor() {
		principal.ingresarAOpcionDoctor();
	}
	
	@Step
	public void irAOpcionCitas() {
		principal.ingresarOpcionCitas();
	}
	
	@Step
	public void regresarAPrincipal() {
		barraNavegacion.irAPrincipal();
	}
	
}
