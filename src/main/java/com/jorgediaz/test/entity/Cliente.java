package com.jorgediaz.test.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.jorgediaz.test.utils.Genero;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private LocalDate fechaNacimiento;
	private Genero genero;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + "]";
	}
		
}
