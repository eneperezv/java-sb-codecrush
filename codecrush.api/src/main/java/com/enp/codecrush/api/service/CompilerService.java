package com.enp.codecrush.api.service;

/*
 * @(#)CompilerService.java 1.0 08/12/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.enp.codecrush.api.exception.CompilationException;
import com.enp.codecrush.api.exception.ExecutionTimeoutException;
import com.enp.codecrush.api.model.CodeExecutionRequest;
import com.enp.codecrush.api.model.CodeExecutionResponse;

@Service
public class CompilerService {
	
	@Value("${sandbox.api-url}")
    private String sandboxApiUrl;

    @Value("${sandbox.client-id}")
    private String clientId;

    @Value("${sandbox.client-secret}")
    private String clientSecret;

    private final RestTemplate restTemplate;
	
    public CompilerService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CodeExecutionResponse executeCode(CodeExecutionRequest request) throws CompilationException, ExecutionTimeoutException {
        // Validar datos
        if (request.getLanguage() == null || request.getCode() == null) {
            throw new CompilationException("El lenguaje y el código son obligatorios.");
        }

        // Crear payload para el sandbox externo
        Map<String, String> payload = new HashMap<>();
        payload.put("clientId", clientId);
        payload.put("clientSecret", clientSecret);
        payload.put("script", request.getCode());
        payload.put("language", request.getLanguage());
        payload.put("stdin", request.getInput());
        payload.put("versionIndex", "0");

        try {
            // Llamada HTTP al servicio externo
            ResponseEntity<Map> response = restTemplate.postForEntity(sandboxApiUrl, payload, Map.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map<String, Object> body = response.getBody();
                return new CodeExecutionResponse(
                    (String) body.get("output"),
                    (String) body.get("error"),
                    (long) body.getOrDefault("cpuTime", 0),
                    0
                );
            } else {
                throw new CompilationException("Error en la ejecución del código en el sandbox.");
            }
        } catch (HttpClientErrorException e) {
            throw new CompilationException("Fallo en el sandbox: " + e.getMessage());
        }
    }

}
