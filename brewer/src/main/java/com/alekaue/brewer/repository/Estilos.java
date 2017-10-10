package com.alekaue.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alekaue.brewer.model.Estilo;
import com.alekaue.brewer.repository.helper.estilo.EstilosQueries;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {
	
	public Optional<Estilo> findByNomeIgnoreCase(String nome);
	
	
}
