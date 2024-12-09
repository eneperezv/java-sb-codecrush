package com.enp.codecrush.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ExecutionLog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String language;
    @Lob
    private String code;
    private String output;
    private LocalDateTime executionDate;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public LocalDateTime getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(LocalDateTime executionDate) {
		this.executionDate = executionDate;
	}

	@Override
	public String toString() {
		return "ExecutionLog [id=" + id + ", userId=" + userId + ", language=" + language + ", code=" + code
				+ ", output=" + output + "]";
	}

}
