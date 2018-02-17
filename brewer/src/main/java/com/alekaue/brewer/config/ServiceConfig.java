package com.alekaue.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alekaue.brewer.service.CadastroCervejaService;
import com.alekaue.brewer.storage.FotoStorage;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, FotoStorage.class})
public class ServiceConfig {
	
/*	@Bean
	public FotoStorage fotoStorage(){
		return new FotoStorageLocal();
	}
*/
}
