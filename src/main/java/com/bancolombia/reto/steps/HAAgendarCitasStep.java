package com.bancolombia.reto.steps;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import com.bancolombia.reto.dtos.CitaDTO;
import com.bancolombia.reto.dtos.DoctorDTO;
import com.bancolombia.reto.dtos.PacienteDTO;
import com.bancolombia.reto.pages.HAAgendarCitaPage;
import com.bancolombia.reto.pages.HAAgregarDoctorPage;
import com.bancolombia.reto.pages.HAAgregarPacientePage;
import com.bancolombia.reto.pages.HAPrincipalPage;
import com.bancolombia.reto.utils.DBManagerExcel;
import com.codoid.products.fillo.Recordset;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class HAAgendarCitasStep {
	
	HAPrincipalPage principalPage;
	HAAgregarDoctorPage doctorPage;
	HAAgregarPacientePage pacientePage;
	HAAgendarCitaPage citaPage;
	
	DoctorDTO doctor;
	PacienteDTO paciente;
	CitaDTO cita;
	
	@Step
	public void navegarAlSitio() {
		principalPage.open();
	}
	
	@Step
	public void cargarInformacion() {
		Recordset resultado;
		/*
		 * Properties del proyecto
		 */
		Properties properties = new Properties();
		
		try {
			doctor = new DoctorDTO();
			paciente = new PacienteDTO();
			cita = new CitaDTO();
			
			
			File _objclasspathRoot = new File(System.getProperty("user.dir"));
			String _strFilePath = _objclasspathRoot.getAbsolutePath();
			properties.load(new FileReader(_strFilePath + "/propiedades.properties"));
			DBManagerExcel manager = new DBManagerExcel(properties.getProperty("RutaExcel"));
			resultado = manager.leerExcel(properties.getProperty("QueryDoctor")); 
			resultado.moveNext();
			doctor.setNumID(resultado.getField("NumID"));
			doctor.setNombre(resultado.getField("Nombre"));
			doctor.setApellido(resultado.getField("Apellido"));
			doctor.setTelefono(resultado.getField("Telefono"));
			doctor.setTipoDoc(resultado.getField("TipoDocumento"));
			doctor.setNumDoc(resultado.getField("Documento"));
			resultado.close();
			
			resultado = manager.leerExcel(properties.getProperty("QueryPaciente")); 
			resultado.moveNext();
			paciente.setNumID(resultado.getField("NumID"));
			paciente.setNombre(resultado.getField("Nombre"));
			paciente.setApellido(resultado.getField("Apellido"));
			paciente.setTelefono(resultado.getField("Telefono"));
			paciente.setTipoDoc(resultado.getField("TipoDocumento"));
			paciente.setNumDoc(resultado.getField("Documento"));
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No es posible cargar variables de entorno");
			}
	}
	
	
	@Step
	public void irAOpcionDoctor() {
		principalPage.ingresarAOpcionDoctor();
	}
	
	@Step
	public void irAPaginaPrincipal() {
		doctorPage.irAPrincipal();
	}
	
	@Step
	public void registrarDoctor() {
		doctorPage.registrarDoctor(doctor);
	}
	
	@Step
	public void irOpcionPaciente() {
		principalPage.ingresarAOpcionPaciente();
	}
	
	@Step
	public void registrarPaciente() {
		pacientePage.registrarPaciente(paciente);
	}
	
	@Step
	public void irOpcionAgendarCita() {
		principalPage.ingresarOpcionCitas();
	}
	
	@Step
	public void cargarDataDriven(List<String> dataPrueba) {
		cita.cargarDataDriven(dataPrueba);
		Serenity.setSessionVariable("Cita").to(cita);;
	}
	
	@Step
	public void registrarCita() {
		citaPage.registrarCita(cita, doctor, paciente);
	}
	
	@Step
	public boolean validarMensajeCita() {
		return citaPage.obtenerMensajeEsperado().equalsIgnoreCase(cita.getMensajeEsperado());
	}
	
}
