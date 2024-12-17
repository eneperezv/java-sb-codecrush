package com.enp.codecrush.api.model;

/*
 * @(#)CodeExecutionResponse.java 1.0 08/12/2024
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

public class CodeExecutionResponse {
	
	private String output;     // Salida del programa
    private String error;      // Errores de compilación/ejecución
    private long executionTime; // Tiempo en ms
    private int statusCode;    // 0 = éxito, 1 = error
    
	public CodeExecutionResponse(String output, String error, long executionTime, int statusCode) {
		super();
		this.output = output;
		this.error = error;
		this.executionTime = executionTime;
		this.statusCode = statusCode;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "CodeExecutionResponse [output=" + output + ", error=" + error + ", executionTime=" + executionTime
				+ ", statusCode=" + statusCode + "]";
	}

}
