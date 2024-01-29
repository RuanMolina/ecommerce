package br.com.runa.ecommerce.ecommerce.controller;

import br.com.runa.ecommerce.ecommerce.DTO.PedidoRequestDTO;
import br.com.runa.ecommerce.ecommerce.model.Pedido;
import br.com.runa.ecommerce.ecommerce.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")

public class PedidoController {
    private PedidoService pedidoService;
    PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
    @GetMapping
    public ResponseEntity findAllPedidos(){
        return ResponseEntity.ok(pedidoService.findAll());
    }
    @PostMapping
    public ResponseEntity<PedidoRequestDTO> gerarPedido(@RequestBody PedidoRequestDTO pedido ){
        List<Long> lista = new ArrayList<>();
        Pedido pedidoResultado = pedidoService.gerarPedido(pedido);

        return ResponseEntity.ok(pedido);

    }
}
