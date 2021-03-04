package com.jorgediaz.test.utils;

public enum Genero {
	
	MASCULINO("Masculino"),
	
	FEMENINO("Femenino");
	
	private final String value;
	
	private Genero (String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
