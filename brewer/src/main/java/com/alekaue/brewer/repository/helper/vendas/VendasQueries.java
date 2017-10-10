package com.alekaue.brewer.repository.helper.vendas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alekaue.brewer.model.Venda;
import com.alekaue.brewer.repository.filter.VendaFilter;

public interface VendasQueries {

	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
}