package com.bancolombia.reto.steps;

import com.bancolombia.reto.dtos.DoctorDTO;
import com.bancolombia.reto.pages.HAAgregarDoctorPage;

import net.thucydides.core.annotations.Step;

public class HACrearDoctorStep {
	HAAgregarDoctorPage doctorPage;
	
	@Step
	public void registrarDoctor(DoctorDTO doctor) {
		doctorPage.registrarDoctor(doctor);
	}
}
