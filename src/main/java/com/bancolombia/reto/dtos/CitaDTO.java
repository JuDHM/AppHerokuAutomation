package com.bancolombia.reto.dtos;

import java.util.List;

public class CitaDTO {
	private String idCaso;
	private String orientacion;
	private String tipoError;
	private String idDoctor;
	private String idPaciente;
	private String fechaCita;
	private String observaciones;
	private String mensajeEsperado;
	
	public void cargarDataDriven(List<String> info) {
		setIdCaso(info.get(0));
		setOrientacion(info.get(1));
		setTipoError(info.get(2));
		setIdDoctor(info.get(3));
		setIdPaciente(info.get(4));
		setFechaCita(info.get(5));
		setObservaciones(info.get(6));
		setMensajeEsperado(info.get(7));
	}
	
	public String getMensajeEsperado() {
		return mensajeEsperado;
	}
	
	public void setMensajeEsperado(String mensajeEsperado) {
		this.mensajeEsperado = mensajeEsperado;
	}
	
	public String getIdCaso() {
		return idCaso;
	}
	public void setIdCaso(String idCaso) {
		this.idCaso = idCaso;
	}
	public String getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}
	
	public String getTipoError() {
		return tipoError;
	}
	
	public void setTipoError(String tipoError) {
		this.tipoError = tipoError;
	}
	
	public String getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
