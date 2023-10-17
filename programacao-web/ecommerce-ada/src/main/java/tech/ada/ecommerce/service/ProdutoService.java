package tech.ada.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public List<Produto> buscarTodosOsProdutos() {
        List<Produto> produtos = produtoRepository.findByCustom();
        int page = 0;
        int total = 100;
        Pageable pageable = PageRequest.of(page, total);
        Page<Produto> produtos2 = produtoRepository.findAll(pageable);
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> optProduto = produtoRepository.findById(id);
        return optProduto.orElseThrow(() -> new RuntimeException("Não existe produto com esse id"));
    }

    public List<Produto> buscarPorNome(String nome) {
        List<Produto> produtos = produtoRepository.findByNomeCustom(nome);
        return produtos;
    }

    public List<Produto> buscarPorPrecoMaximo(double preco) {
        List<Produto> produtos = produtoRepository.findByPrecoMaximo(preco);
        return produtos;
    }

    public List<Produto> buscarPorPreco(double preco1, double preco2) {
        List<Produto> produtos = produtoRepository.findByPrecoBetween(preco1, preco2);
        return produtos;
    }
}