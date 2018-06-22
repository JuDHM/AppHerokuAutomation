package com.bancolombia.reto.definitions;

import java.util.List;

import org.junit.Assert;

import com.bancolombia.reto.steps.HAAgendarCitasStep;
import com.bancolombia.reto.steps.HACrearDoctorStep;
import com.bancolombia.reto.steps.HACrearPacienteStep;
import com.bancolombia.reto.steps.HAInicializarInformacionStep;
import com.bancolombia.reto.steps.HANavegarMenuStep;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HAAgendarCitasDefinition {
	
	@Steps
	HAInicializarInformacionStep inicializarData;
	
	@Steps
	HANavegarMenuStep ejecutarNavegacion;
	
	@Steps
	HACrearDoctorStep registrarDoctor;
	
	@Steps
	HACrearPacienteStep registrarPaciente;
	
	@Steps
	HAAgendarCitasStep agendarCita;
	
	
	@Given("^Juan navega a la app de Heroku$")
	public void juan_navega_a_la_app_de_Heroku(List<String> dataDriven) throws Exception {
		inicializarData.cargarInformacion(dataDriven);
		ejecutarNavegacion.navegarAlSitio();
		//agendarCita.navegarAlSitio();
		//agendarCita.cargarInformacion();
		System.out.println("1. Navegar en la app de Heroku.");
	}

	@When("^Juan adiciona un doctor en el app$")
	public void juan_adiciona_un_doctor_en_el_app() throws Exception {
		ejecutarNavegacion.irAOpcionDoctor();
		registrarDoctor.registrarDoctor(inicializarData.getDoctor());
		ejecutarNavegacion.regresarAPrincipal();
		//agendarCita.irAOpcionDoctor();
		//agendarCita.registrarDoctor();
		//agendarCita.irAPaginaPrincipal();
		System.out.println("2. Adicionar doctor.");
	}

	@When("^Juan adiciona un paciente$")
	public void juan_adiciona_un_paciente() throws Exception {
		ejecutarNavegacion.irAOpcionPaciente();
		registrarPaciente.crearPaciente(inicializarData.getPaciente());
		ejecutarNavegacion.regresarAPrincipal();
		
		System.out.println("3. Adicionar paciente.");
	}

	@When("^Juan adiciona una cita$")
	public void juan_adiciona_una_cita() {
		ejecutarNavegacion.irAOpcionCitas();
		//agendarCita.cargarDataDriven(dataDriven);
		agendarCita.registrarCita(inicializarData.getCita(), inicializarData.getDoctor(), inicializarData.getPaciente());
		System.out.println("4. Adicionar cita");
	}

	@Then("^Juan valida la informacion relacionada de la cita$")
	public void juan_valida_la_informacion_relacionada_de_la_cita() {
		Assert.assertTrue(agendarCita.validarMensajeCita(inicializarData.getCita()));
	    System.out.println("5. Verificar la informacion ingresada.");
	}
	
	@When("^Juan adiciona una cita con un doctor que no existe$")
	public void juan_adiciona_una_cita_con_un_doctor_que_no_existe() {
		//inicializarData.cargarInformacion(dataDriven);
		ejecutarNavegacion.irAOpcionCitas();
		//agendarCita.cargarDataDriven(dataDriven);
		agendarCita.registrarCita(inicializarData.getCita(), inicializarData.getDoctor(), inicializarData.getPaciente());
	}

	@Then("^Juan valida la informacion el mensaje esperado$")
	public void juan_valida_la_informacion_el_mensaje_esperado() {
		Assert.assertTrue(agendarCita.validarTituloError(inicializarData.getCita())); 
	}

}
