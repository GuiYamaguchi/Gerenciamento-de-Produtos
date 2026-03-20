package com.atividade.GerenciamentoProduto.controller;

import com.atividade.GerenciamentoProduto.entity.Produto;
import com.atividade.GerenciamentoProduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto requeste = produtoService.criarProduto(produto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodosProdutos() {
        List<Produto> requeste = produtoService.listarTodosProdutos();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> buscarProdutoId(@PathVariable Long id){
        Optional<Produto> requeste = produtoService.buscarProdutoId(id);
        return ResponseEntity.ok(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
