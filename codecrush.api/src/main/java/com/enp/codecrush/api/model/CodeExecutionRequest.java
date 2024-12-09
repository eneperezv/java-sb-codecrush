package com.enp.codecrush.api.model;

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
