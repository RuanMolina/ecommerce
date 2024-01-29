package br.com.runa.ecommerce.ecommerce.service;

import br.com.runa.ecommerce.ecommerce.DTO.PedidoRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.ItemPedido;
import br.com.runa.ecommerce.ecommerce.model.Pedido;
import br.com.runa.ecommerce.ecommerce.model.Produto;
import br.com.runa.ecommerce.ecommerce.repository.PedidoRepository;
import br.com.runa.ecommerce.ecommerce.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
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
        listaProd = prodRep.findAllById(pedidoDTO.produtosID());

        Pedido pedido = pedRep.save( new Pedido(listaProd));

        listaProd.forEach((item)->{
            em.persist( new ItemPedido(pedido,item));
        });

        return pedido;
    }
    public List<Pedido> findAll(){
        return pedRep.findAll();
    }
}
