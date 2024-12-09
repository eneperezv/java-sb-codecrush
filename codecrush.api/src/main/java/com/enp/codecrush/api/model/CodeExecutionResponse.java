package com.enp.codecrush.api.model;

public class CodeExecutionResponse {
	
	private String output;     // Salida del programa
    private String error;      // Errores de compilación/ejecución
    private long executionTime; // Tiempo en ms
    private int statusCode;    // 0 = éxito, 1 = error
    
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
