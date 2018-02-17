package com.alekaue.brewer.service.event.venda;

import com.alekaue.brewer.model.Venda;

public class VendaEvent{

	private Venda venda;
	
	public VendaEvent(Venda venda){
		this.venda = venda;
	}

	public Venda getVenda() {
		return venda;
	}
		
}
