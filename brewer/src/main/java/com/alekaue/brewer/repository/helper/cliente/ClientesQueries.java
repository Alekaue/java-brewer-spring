package com.alekaue.brewer.repository.helper.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alekaue.brewer.model.Cliente;
import com.alekaue.brewer.repository.filter.ClienteFilter;

public interface ClientesQueries {
	
	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageeable);

}
