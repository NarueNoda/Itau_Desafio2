package com.Itau.Desafio2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Itau.Desafio2.entity.Categoria;
import com.Itau.Desafio2.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping()
	List<Categoria> getCategorias(){
		
		CategoriaService categoriaModel = new CategoriaService(restTemplate);
		
		List<Categoria> result = categoriaModel.getCategoriaList().stream()
				.collect(Collectors.toList());
		
		return result;
		
	}
	
	
	  @GetMapping("/{id}") 
	  Categoria getCategoriaById(@PathVariable("id") Long id){ 
		  List<Categoria> categorias = getCategorias(); 
		  Categoria result = categorias.stream()
				  .filter(i -> i.getId().equals(id))
				  .findAny()
				  .orElse(null);
		  
		  return result; 
	  }
	 
}
