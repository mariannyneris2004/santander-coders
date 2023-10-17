package tech.ada.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Override
    Page<Produto> findAll(Pageable pageable);

    @Query("UPDATE Produto p SET p.estoque = :qtd WHERE p.id = :id")
    void atualizarEstoque(@Param("qtd") int qtd, @Param("id") long id);

    @Query("SELECT p FROM Produto p WHERE p.preco BETWEEN :preco1 AND :preco2")
    List<Produto> findByPrecoBetween(@Param("preco1")double preco1, @Param("preco2") double preco2);

    @Query("SELECT p FROM Produto p WHERE p.nome ILIKE concat('%', :nome, '%')")
    List<Produto> findByNomeCustom(@Param("nome") String nome);

    @Query("SELECT p FROM Produto p WHERE p.preco <= :preco")
    List<Produto> findByPrecoMaximo(@Param("preco") double preco);

    /*    @Query(value = "SELECT * FROM produto", nativeQuery = true)
    List<Produto> findByCustom();*/
}