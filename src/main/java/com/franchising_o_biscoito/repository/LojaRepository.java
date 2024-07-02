package com.franchising_o_biscoito.repository;

import com.franchising_o_biscoito.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

}
