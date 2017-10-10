package com.alekaue.brewer.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alekaue.brewer.model.Cidade;
import com.alekaue.brewer.repository.filter.CidadeFilter;

public interface CidadesQueries {
	
	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageeable);

}
