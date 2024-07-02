package com.franchising_o_biscoito.service;

import com.franchising_o_biscoito.model.Loja;
import com.franchising_o_biscoito.model.Produto;
import com.franchising_o_biscoito.repository.LojaRepository;
import com.franchising_o_biscoito.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaService {
    @Autowired
    private LojaRepository lojaRepository;
    @Autowired
    private ProdutoRepository produtosRepository;

    public List<Loja> getLojas() {
        return lojaRepository.findAll();
    }

    public Optional<Loja> getLoja(int id) {
        return lojaRepository.findById(id);
    }

    public Loja abrirLoja(Loja loja) {
        return lojaRepository.save(loja);
    }

    public Produto adicionarProduto(Produto produto) {
        return produtosRepository.save(produto);
    }

    public ResponseEntity<Object> produtosLoja(int id) {
        Loja loja = lojaRepository.getReferenceById(id);
        List<Produto> produtoList = loja.getProdutos();
        return ResponseEntity.ok(produtoList);
    }
}
