package com.alekaue.brewer.repository.helper.vendas;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alekaue.brewer.dto.VendaMes;
import com.alekaue.brewer.dto.VendaOrigem;
import com.alekaue.brewer.model.Venda;
import com.alekaue.brewer.repository.filter.VendaFilter;

public interface VendasQueries {

	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
	
	public BigDecimal valorTotalNoAno();
	public BigDecimal valorTotalNoMes();	
	public BigDecimal valorTicketMedioNoAno();
	
	public List<VendaMes> totalPorMes();
	
	public List<VendaOrigem> totalPorOrigem();
	
}