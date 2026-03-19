package com.atividade.GerenciamentoProduto.service;

import com.atividade.GerenciamentoProduto.entity.Produto;
import com.atividade.GerenciamentoProduto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarProdutoId(Long id){
        return produtoRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
