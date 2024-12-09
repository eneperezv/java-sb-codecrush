package com.enp.codecrush.api.service;

import org.springframework.stereotype.Service;

import com.enp.codecrush.api.exception.CompilationException;
import com.enp.codecrush.api.exception.ExecutionTimeoutException;
import com.enp.codecrush.api.model.CodeExecutionRequest;
import com.enp.codecrush.api.model.CodeExecutionResponse;

@Service
public class CompilerService {
	
	public CodeExecutionResponse executeCode(CodeExecutionRequest request) throws CompilationException, ExecutionTimeoutException {
        // Validación inicial
        if (request.getLanguage() == null || request.getCode() == null) {
            throw new CompilationException("El lenguaje y el código son obligatorios.");
        }

        // Simulación de ejecución (reemplazar por integración real con Docker/API externa)
        try {
            String output = mockExecution(request.getCode(), request.getLanguage(), request.getInput());
            return new CodeExecutionResponse(output, null, 500, 0);
        } catch (Exception e) {
            throw new CompilationException("Error al compilar el código: " + e.getMessage());
        }
    }

    private String mockExecution(String code, String language, String input) {
        // Simula un tiempo de ejecución y salida
        return "Salida simulada para el código en " + language;
    }

}
