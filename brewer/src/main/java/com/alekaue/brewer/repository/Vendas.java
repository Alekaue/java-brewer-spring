package com.alekaue.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alekaue.brewer.model.Venda;
import com.alekaue.brewer.repository.helper.vendas.VendasQueries;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries{

	

}
