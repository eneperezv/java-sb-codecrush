package com.enp.codecrush.api.controller;

/*
 * @(#)CompilerController.java 1.0 08/12/2024
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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.codecrush.api.exception.CompilationException;
import com.enp.codecrush.api.exception.ExecutionTimeoutException;
import com.enp.codecrush.api.model.CodeExecutionRequest;
import com.enp.codecrush.api.model.CodeExecutionResponse;
import com.enp.codecrush.api.service.CompilerService;

@RestController
@RequestMapping("/api/v1/codecrush/compiler")
public class CompilerController {
	
	private final CompilerService compilerService;

    public CompilerController(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    @PostMapping("/execute")
    public ResponseEntity<CodeExecutionResponse> executeCode(@RequestBody CodeExecutionRequest request) {
        try {
            CodeExecutionResponse response = compilerService.executeCode(request);
            return ResponseEntity.ok(response);
        } catch (CompilationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new CodeExecutionResponse(null, e.getMessage(), 0, 1)
            );
        } catch (ExecutionTimeoutException e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(
                new CodeExecutionResponse(null, e.getMessage(), 0, 1)
            );
        }
    }

}
