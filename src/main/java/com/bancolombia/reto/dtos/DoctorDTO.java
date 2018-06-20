package com.bancolombia.reto.dtos;

public class DoctorDTO {
	private String numID;
	private String nombre;
	private String apellido;
	private String telefono;
	private String tipoDoc;
	private String numDoc;
	
	public void setNumID(String idunico) {
		this.numID = idunico;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setTipoDoc(String tipodoc) {
		this.tipoDoc = tipodoc;
	}
	
	public void setNumDoc(String numdoc) {
		this.numDoc = numdoc;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	public String getNumID() {
		return numID;
	}
	
	public String getNombre() {
		return nombre;
	}
				
	public String getApellidos() {
		return apellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getTipoDoc() {
		return tipoDoc;
	}
	
	public String getNumDoc() {
		return numDoc;
	}
	
}
