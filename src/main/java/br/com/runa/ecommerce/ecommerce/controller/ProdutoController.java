package br.com.runa.ecommerce.ecommerce.controller;

import br.com.runa.ecommerce.ecommerce.DTO.ProdutoRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.Produto;
import br.com.runa.ecommerce.ecommerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private ProdutoService prodService;

    public ProdutoController(ProdutoService produtoService) {

        this.prodService = produtoService;

    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(){
        var lista = prodService.findAll();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "idProduto")Long idProduto){
        var produto = prodService.findById(idProduto);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity addProduto(@RequestBody ProdutoRequestDTO produto, UriComponentsBuilder uriBuilder){

        var produtoSalvo =prodService.save(produto);
        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
