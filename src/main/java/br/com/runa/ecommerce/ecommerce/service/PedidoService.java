package br.com.runa.ecommerce.ecommerce.service;

import br.com.runa.ecommerce.ecommerce.DTO.ItemPedidoDTO;
import br.com.runa.ecommerce.ecommerce.DTO.PedidoRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.ItemPedido;
import br.com.runa.ecommerce.ecommerce.model.Pedido;
import br.com.runa.ecommerce.ecommerce.model.Produto;
import br.com.runa.ecommerce.ecommerce.model.Usuario;
import br.com.runa.ecommerce.ecommerce.repository.PedidoRepository;
import br.com.runa.ecommerce.ecommerce.repository.ProdutoRepository;
import br.com.runa.ecommerce.ecommerce.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedRep;
    private final ProdutoRepository prodRep;
    private final UsuarioRepository userRep;
    private final EntityManager em;
    PedidoService(PedidoRepository pedRep, ProdutoRepository prodRep,EntityManager em,UsuarioRepository userRep ){
        this.pedRep = pedRep;
        this.prodRep = prodRep;
        this.em = em;
        this.userRep = userRep;
    }
    @Transactional(rollbackFor = RuntimeException.class)
    public Pedido createPedido(PedidoRequestDTO pedidoDTO){
        List<Produto> listaProd;
        List<Long> IdList =pedidoDTO.itensPedidos().stream().map(ItemPedidoDTO::id).toList();
        listaProd = prodRep.findAllById(IdList);

        Usuario usuario = userRep.findById(pedidoDTO.usuario_id()).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        Pedido pedido = pedRep.save(new Pedido(listaProd,usuario));

        pedidoDTO.itensPedidos().forEach(item->{
            em.persist( new ItemPedido(pedido,prodRep.findById(item.id()).get(),item.quantidade()));
        });

        return pedido;

    }
    public List<Pedido> findAll(){
        return pedRep.findAll();
    }

    public Pedido findById(Long id) {
        return pedRep.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
    }
}
