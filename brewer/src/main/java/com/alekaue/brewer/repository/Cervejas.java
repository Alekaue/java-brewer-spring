package com.alekaue.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alekaue.brewer.model.Cerveja;
import com.alekaue.brewer.repository.helper.cerveja.CervejasQueries;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries{
	
	//public Optional<Cerveja> findBySkuIgnoreCase(String sku);
	
}
