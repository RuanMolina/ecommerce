package br.com.runa.ecommerce.ecommerce.service;

import br.com.runa.ecommerce.ecommerce.DTO.ProdutoRequestDTO;
import br.com.runa.ecommerce.ecommerce.repository.ProdutoRepository;
import br.com.runa.ecommerce.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository prodRep;
    ProdutoService(ProdutoRepository produtoRepository){
        this.prodRep = produtoRepository;

    }
    public List<Produto> findAll(){
        return prodRep.findAll();
    }

    public Produto findById(Long id){
        return prodRep.findById(id).orElseThrow();
    }
    public Produto save(ProdutoRequestDTO produto){
        return prodRep.save(new Produto(produto.nome(),produto.valor()));
    }

}