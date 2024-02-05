    package br.com.runa.ecommerce.ecommerce.service;

    import br.com.runa.ecommerce.ecommerce.DTO.ProdutoCreateRequestDTO;
    import br.com.runa.ecommerce.ecommerce.repository.ProdutoRepository;
    import br.com.runa.ecommerce.ecommerce.model.Produto;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class ProdutoService {

        private final ProdutoRepository prodRep;
        ProdutoService(ProdutoRepository produtoRepository){
            this.prodRep = produtoRepository;

        }
        public List<Produto> findAll(){
            return prodRep.findAll();
        }

        public Produto findById(Long id){
            return prodRep.findById(id).orElseThrow();
        }

        public List<Produto> findByCategoriaId(Long id){
            return prodRep.findByCategorias_id(id);
        }
        public Produto save(ProdutoCreateRequestDTO produto){
            return prodRep.save(new Produto(produto.nome(),produto.valor(),produto.categorias()));
        }


        public Produto updateProduto(Produto produtoAlterado){
            if(!prodRep.existsById(produtoAlterado.getId())){
                throw new RuntimeException("Produto com id # não existe.".replace("#",produtoAlterado.getId().toString()));
            }

           produtoAlterado = prodRep.save(produtoAlterado);
           return produtoAlterado;
        }

        public void deleteProduto(Long id){
            prodRep.deleteById(id);
        }

    }
