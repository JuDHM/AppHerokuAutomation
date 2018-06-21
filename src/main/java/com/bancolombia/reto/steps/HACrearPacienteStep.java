package com.bancolombia.reto.steps;

import com.bancolombia.reto.dtos.PacienteDTO;
import com.bancolombia.reto.pages.HAAgregarPacientePage;

import net.thucydides.core.annotations.Step;

public class HACrearPacienteStep {
	HAAgregarPacientePage pacientePage;
	
	@Step
	public void crearPaciente(PacienteDTO paciente) {
		pacientePage.registrarPaciente(paciente);
	}
	
}