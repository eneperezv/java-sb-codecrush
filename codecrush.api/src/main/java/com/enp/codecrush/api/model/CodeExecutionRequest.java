package com.enp.codecrush.api.model;

/*
 * @(#)CodeExecutionRequest.java 1.0 08/12/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones descritas en The MIT License (MIT)
 * en https://opensource.org/license/mit
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

public class CodeExecutionRequest {
	
	private String language; // Ejemplo: "java", "python", "c++"
    private String code;     // Código fuente
    private String input;    // Entrada del programa, si es necesario
    
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public String toString() {
		return "CodeExecutionRequest [language=" + language + ", code=" + code + ", input=" + input + "]";
	}

}
