package com.franchising_o_biscoito.repository;

import com.franchising_o_biscoito.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
