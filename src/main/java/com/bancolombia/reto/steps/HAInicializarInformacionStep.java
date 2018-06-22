package com.bancolombia.reto.steps;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import com.bancolombia.reto.dtos.CitaDTO;
import com.bancolombia.reto.dtos.DoctorDTO;
import com.bancolombia.reto.dtos.PacienteDTO;
import com.bancolombia.reto.utils.DBManagerExcel;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import net.thucydides.core.annotations.Step;

public class HAInicializarInformacionStep {
	
	private DoctorDTO doctor;
	private PacienteDTO paciente;
	private CitaDTO cita;
	
	public DoctorDTO getDoctor() {
		return doctor;
	}
	
	public PacienteDTO getPaciente() {
		return paciente;
	}
	
	public CitaDTO getCita() {
		return cita;
	}
	
	
	public void cargarInformacionDoctor(Recordset registroDoctor) {
		try {
			doctor.setNumID(registroDoctor.getField("NumID"));
			doctor.setNombre(registroDoctor.getField("Nombre"));
			doctor.setApellido(registroDoctor.getField("Apellido"));
			doctor.setTelefono(registroDoctor.getField("Telefono"));
			doctor.setTipoDoc(registroDoctor.getField("TipoDocumento"));
			doctor.setNumDoc(registroDoctor.getField("Documento"));
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			registroDoctor.close();
		}
	}
	
	
	public void cargarInformacionPaciente(Recordset registroPaciente) {
		try {
			paciente.setNumID(registroPaciente.getField("NumID"));
			paciente.setNombre(registroPaciente.getField("Nombre"));
			paciente.setApellido(registroPaciente.getField("Apellido"));
			paciente.setTelefono(registroPaciente.getField("Telefono"));
			paciente.setTipoDoc(registroPaciente.getField("TipoDocumento"));
			paciente.setNumDoc(registroPaciente.getField("Documento"));
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			registroPaciente.close();
		}
	}
	
	public void cargarInformacionCita(List<String> dataPrueba) {
			cita.cargarDataDriven(dataPrueba);
	}
	
	public Properties cargarProperties() {
		Properties properties = new Properties();
		try {
			File _objclasspathRoot = new File(System.getProperty("user.dir"));
			String _strFilePath = _objclasspathRoot.getAbsolutePath();
			properties.load(new FileReader(_strFilePath + "/propiedades.properties"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}
		return properties;
	}
	
	
	@Step
	public void cargarInformacion(List<String> dataPrueba) {
		Recordset resultado;
		/*
		 * Properties del proyecto
		 */
		Properties properties = new Properties();
		
		try {
			doctor = new DoctorDTO();
			paciente = new PacienteDTO();
			cita = new CitaDTO();
			properties = cargarProperties();
					
			DBManagerExcel manager = new DBManagerExcel(properties.getProperty("RutaExcel"));
			resultado = manager.leerExcel(properties.getProperty("QueryDoctor")); 
			resultado.moveNext();
			cargarInformacionDoctor(resultado);
			
			resultado = manager.leerExcel(properties.getProperty("QueryPaciente")); 
			resultado.moveNext();
			cargarInformacionPaciente(resultado);
			
			cargarInformacionCita(dataPrueba);
			
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No es posible cargar variables de entorno");
			}
	}
}
