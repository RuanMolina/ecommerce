package br.com.runa.ecommerce.ecommerce.service;

import br.com.runa.ecommerce.ecommerce.DTO.PedidoRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.ItemPedido;
import br.com.runa.ecommerce.ecommerce.model.Pedido;
import br.com.runa.ecommerce.ecommerce.model.Produto;
import br.com.runa.ecommerce.ecommerce.repository.PedidoRepository;
import br.com.runa.ecommerce.ecommerce.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository pedRep;
    private ProdutoRepository prodRep;
    private EntityManager em;
    PedidoService(PedidoRepository pedRep, ProdutoRepository prodRep,EntityManager em ){
        this.pedRep = pedRep;
        this.prodRep = prodRep;
        this.em = em;
    }
    @Transactional(rollbackFor = RuntimeException.class)
    public Pedido gerarPedido(PedidoRequestDTO pedidoDTO){
        List<Produto> listaProd;
        List<Long> IdList =pedidoDTO.itensPedidos().stream().map(s -> s.id()).toList();
        listaProd = prodRep.findAllById(IdList);

        Pedido pedido = pedRep.save(new Pedido(listaProd));

        pedidoDTO.itensPedidos().forEach(item->{

            em.persist( new ItemPedido(pedido,prodRep.findById(item.id()).get(),item.quantidade()));
        });

        return pedido;

    }
    public List<Pedido> findAll(){
        return pedRep.findAll();
    }
}
