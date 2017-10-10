package com.alekaue.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alekaue.brewer.model.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long>{

	
}
