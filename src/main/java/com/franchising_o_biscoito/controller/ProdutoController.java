package com.franchising_o_biscoito.controller;

import com.franchising_o_biscoito.model.Produto;
import com.franchising_o_biscoito.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos Controller")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @PostMapping
    public ResponseEntity<Produto> inserirProduto(Produto produto) {
        Integer idProduto = produto.getCod_produto();
        if (idProduto != null && produtoRepository.findById(idProduto).isPresent()) {
            throw new IllegalArgumentException("This product ID already exists!");
        };
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }
}
