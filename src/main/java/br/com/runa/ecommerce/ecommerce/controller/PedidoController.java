package br.com.runa.ecommerce.ecommerce.controller;

import br.com.runa.ecommerce.ecommerce.DTO.PedidoRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.Pedido;
import br.com.runa.ecommerce.ecommerce.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    private final PedidoService pedidoService;
    PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> findAllPedidos(){
        return ResponseEntity.ok(pedidoService.findAll());
    }
    @GetMapping("/id")
    public ResponseEntity<Pedido> findPedido(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(pedidoService.findById(id));

    }
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoRequestDTO pedido ){
        Pedido pedidoResultado = pedidoService.createPedido(pedido);

        return ResponseEntity.ok(pedidoResultado);

    }
}
