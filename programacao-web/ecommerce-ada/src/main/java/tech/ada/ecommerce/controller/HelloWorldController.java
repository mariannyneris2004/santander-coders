package tech.ada.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.service.ClienteService;
import tech.ada.ecommerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello World!");
        return "Olá Mundo";
    }


    @GetMapping("/{nome}")
    public List<Cliente> buscarClientes(@PathVariable("nome") String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @GetMapping("/preco/{preco}")
    public List<Produto> buscarProdutosPorPrecoMaximo(@PathVariable("preco") double preco) {
        return produtoService.buscarPorPrecoMaximo(preco);
    }

    @GetMapping("/preco/{preco1}/{preco2}")
    public List<Produto> buscarProdutosPorIntervaloDePreco(@PathVariable("preco1") double preco1,
                                                           @PathVariable("preco2") double preco2) {
        return produtoService.buscarPorPreco(preco1, preco2);
    }
}
