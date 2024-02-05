    package br.com.runa.ecommerce.ecommerce.controller;

    import br.com.runa.ecommerce.ecommerce.DTO.ProdutoCreateRequestDTO;
    import br.com.runa.ecommerce.ecommerce.DTO.ProdutoUpdateRequestDTO;
    import br.com.runa.ecommerce.ecommerce.model.Produto;
    import br.com.runa.ecommerce.ecommerce.service.ProdutoService;
    import jakarta.validation.Valid;
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
        @GetMapping("/categoria/{idCategoria}")
        public ResponseEntity<List<Produto>> getProdutoByCategoria_id(@PathVariable(value = "idCategoria")Long idCategoria){
            var produto = prodService.findByCategoriaId(idCategoria);
            return ResponseEntity.ok().body(produto);
        }

        @PostMapping
        public ResponseEntity addProduto(@RequestBody ProdutoCreateRequestDTO produto, UriComponentsBuilder uriBuilder){

            System.out.println("Produto: " + produto);
            var produtoSalvo =prodService.save(produto);
            var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

    @PutMapping
    public ResponseEntity updateProduto(@RequestBody @Valid Produto produto){
        var resultado = prodService.updateProduto(produto);
        return ResponseEntity.ok(resultado);
    }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteMapping(@PathVariable(value = "id")Long id){
            prodService.deleteProduto(id);
            return ResponseEntity.noContent().build();
        }
    }
