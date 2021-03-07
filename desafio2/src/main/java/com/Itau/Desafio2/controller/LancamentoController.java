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
import com.Itau.Desafio2.entity.Lancamento;
import com.Itau.Desafio2.service.CategoriaService;
import com.Itau.Desafio2.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private RestTemplate restTemplate;

	
	@GetMapping()
	List<Lancamento> getLancamentos(){
		
		LancamentoService lancamentoModel = new LancamentoService(restTemplate);
		
		return lancamentoModel.getLancamentoList().stream().collect(Collectors.toList());
	}
	
	
	  @GetMapping("/{id}") 
	  List<Lancamento> getLancamentosById(@PathVariable("id") Long id){ 
		  List<Lancamento> lancamentos = getLancamentos(); 
		  List<Lancamento> result = lancamentos.stream()
				  .filter(i -> i.getId().equals(id)) 
				  .collect(Collectors.toList()); 
		  
		  return result; 
	  }
	  
	  @GetMapping("/categoria/{categoria}") 
	  List<Lancamento> getLancamentosByCategoria(@PathVariable("categoria") String categoria){
			CategoriaService categoriaModel = new CategoriaService(restTemplate);
			Categoria categoriaFind = categoriaModel
					.getCategoriaList().stream()
					.filter(n -> n.getNome().equals(categoria))
					.findAny()
					.orElse(null);
			
			List<Lancamento> lancamentoModel = getLancamentos();
			
			List<Lancamento> result =  lancamentoModel.stream()
					.filter(c -> Long.valueOf(c.getCategoria()).equals(categoriaFind.getId()))
					.collect(Collectors.toList());
			
			return result;
	  }
			
}
