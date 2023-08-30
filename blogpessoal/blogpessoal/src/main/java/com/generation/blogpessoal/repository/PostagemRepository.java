package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoal.model.Postagem;abstract

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	
	
}
