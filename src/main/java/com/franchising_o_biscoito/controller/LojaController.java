package com.franchising_o_biscoito.controller;

import com.franchising_o_biscoito.model.Loja;
import com.franchising_o_biscoito.service.LojaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lojas")
@Tag(name = "Lojas Controller")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }


    @GetMapping
    public ResponseEntity<List<Loja>> listar() {
        List<Loja> lojas = lojaService.getLojas();
        if (lojas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lojas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Loja>> buscarPorId(@PathVariable int id) {
        Optional<Loja> loja = lojaService.getLoja(id);
        if (loja.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(loja);
    }

    @PostMapping
    public ResponseEntity<Loja> salvar(@RequestBody Loja newLoja) {
        var novaLoja = lojaService.abrirLoja(newLoja);
//        if (lojaCriada == null) {
//            return ResponseEntity.badRequest().build();
//        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaLoja.getIdLoja())
                .toUri();
        return ResponseEntity.created(location).body(novaLoja);
//        return ResponseEntity.ok(newLoja);
    }

}
