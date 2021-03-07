package com.Itau.Desafio2.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Itau.Desafio2.entity.Lancamento;


public class LancamentoService {
	
	private List<Lancamento> lancamentoList;

	public LancamentoService(RestTemplate restTemplate) {
		
		ResponseEntity<List<Lancamento>> responseEntity = 
				restTemplate.exchange(
						"/lancamentos",
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<Lancamento>>() {
						}
				);
		
		this.lancamentoList = responseEntity.getBody();
		
	}
	
	public List<Lancamento> getLancamentoList(){
		return this.lancamentoList;
	}
}
