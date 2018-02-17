package com.alekaue.brewer.repository.helper.cerveja;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alekaue.brewer.dto.CervejaDTO;
import com.alekaue.brewer.dto.ValorItensEstoque;
import com.alekaue.brewer.model.Cerveja;
import com.alekaue.brewer.repository.filter.CervejaFilter;

public interface CervejasQueries {
	
		
	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageeable);
	
	public List<CervejaDTO> porSkuOuNome (String skuOuNome);
	
	public ValorItensEstoque valorItensEstoque();
}
