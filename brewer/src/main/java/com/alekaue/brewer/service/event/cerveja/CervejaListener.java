//não está sendo usado

/*package com.alekaue.brewer.service.event.cerveja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.alekaue.brewer.storage.FotoStorage;

@Component
public class CervejaListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#evento.temFoto() and #evento.novaFoto")
	public void cervejaSalva(CervejaSalvaEvent evento){
		System.out.println("Nova cerveja salva: " + evento.getCerveja().getNome());
		fotoStorage.salvar(evento.getCerveja().getFoto());	
	}
}
*/