package com.Itau.Desafio2.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Double valor;
	private String origem;
	private Integer categoria;
	private Integer mes_lancamento;
	
	public Lancamento() {
		super();
	}
	
	public Lancamento(Long id, Double valor, String origem, Integer categoria, Integer mes_lancamento) {
		super();
		this.id = id;
		this.valor = valor;
		this.origem = origem;
		this.categoria = categoria;
		this.mes_lancamento = mes_lancamento;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public Integer getMes_lancamento() {
		return mes_lancamento;
	}
	public void setMes_lancamento(Integer mes_lancamento) {
		this.mes_lancamento = mes_lancamento;
	}
	
}