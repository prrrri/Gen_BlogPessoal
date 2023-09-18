package com.generation.blogpessoal.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tb_temas")
public class Tema {
	
	//ID indica que é uma chave primária
	@Id
	//GeneratedValue indica que esse ID também é um auto-increment
	//a cada passagem, eu vou incrementando mais algo ao meu Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//criando atributos da classe tema (ID e descrição do tema)
	private Long id;
	//@NotNull(message="O atributo descrição é obrigatório")
	@NotBlank(message="O atributo título é obrigatório")
	private String descricao;
	
	//no Tema, é um tema PARA muitas postagens (no Postagem, era ManyToOne)
	//fetchtype.lazy vou usar para carregar os dados de uma postagem, um por um, 
	//sem precisar carregar todos de uma vez só.
	//mappedBy: possui todas as infos para fazer o mapeamento do relacionamento
	//o tema será a classe proprietária dentro da relação
	//Cascade: 
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	//criando uma collection list para minhas muitas postagens
	private List<Postagem> postagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	

}
