package com.bancolombia.reto.definitions;

import java.util.List;

import org.junit.Assert;

import com.bancolombia.reto.steps.HAAgendarCitasStep;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HAAgendarCitasDefinition {
	
	@Steps
	HAAgendarCitasStep agendarCita;
	
	
	@Given("^Juan navega a la app de Heroku$")
	public void juan_navega_a_la_app_de_Heroku() throws Exception {
		agendarCita.navegarAlSitio();
		agendarCita.cargarInformacion();
		System.out.println("1. Navegar en la app de Heroku.");
	}

	@When("^Juan adiciona un doctor en el app$")
	public void juan_adiciona_un_doctor_en_el_app() throws Exception {
		
		agendarCita.irAOpcionDoctor();
		agendarCita.registrarDoctor();
		agendarCita.irAPaginaPrincipal();
		System.out.println("2. Adicionar doctor.");
	}

	@When("^Juan adiciona un paciente$")
	public void juan_adiciona_un_paciente() throws Exception {
		agendarCita.irOpcionPaciente();
		agendarCita.registrarPaciente();
		agendarCita.irAPaginaPrincipal();
		System.out.println("3. Adicionar paciente.");
	}

//	@When("^Juan adiciona una cita$")
//	public void juan_adiciona_una_cita() throws Exception {
//		agendarCita.irOpcionAgendarCita();
//	    System.out.println("4. Adicionar una cita.");
//	}
	
	@When("^Juan adiciona una cita$")
	public void juan_adiciona_una_cita(List<String> dataDriven) {
	    agendarCita.cargarDataDriven(dataDriven);
	    agendarCita.irOpcionAgendarCita();
	    agendarCita.registrarCita();
	    System.out.println("4. Agendar cita");
	}

	@Then("^Juan valida la informacion relacionada de la cita$")
	public void juan_valida_la_informacion_relacionada_de_la_cita() {
	//	String resultado = agendarCita.validarMensajeCita();
		Assert.assertTrue(agendarCita.validarMensajeCita());
	    System.out.println("5. Verificar la informacion ingresada.");
	}
}
