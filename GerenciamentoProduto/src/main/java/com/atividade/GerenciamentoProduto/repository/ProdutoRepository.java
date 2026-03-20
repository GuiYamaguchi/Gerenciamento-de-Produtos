package com.atividade.GerenciamentoProduto.repository;

import com.atividade.GerenciamentoProduto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
