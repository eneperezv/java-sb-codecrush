package com.enp.codecrush.api.repository;

/*
 * @(#)UserRepository.java 1.0 08/12/2024
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

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.enp.codecrush.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByUsername(String username);

}
