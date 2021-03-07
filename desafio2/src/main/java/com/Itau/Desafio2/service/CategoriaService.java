package com.Itau.Desafio2.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Itau.Desafio2.entity.Categoria;


public class CategoriaService {
		
	private List<Categoria> categoriaList;

	public CategoriaService(RestTemplate restTemplate) {
		
		ResponseEntity<List<Categoria>> responseEntity = 
				restTemplate.exchange(
						"/categorias",
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<Categoria>>() {
						}
				);
		
		this.categoriaList = responseEntity.getBody();
		
	}
	
	public List<Categoria> getCategoriaList(){
		return this.categoriaList;
	}
	

}
