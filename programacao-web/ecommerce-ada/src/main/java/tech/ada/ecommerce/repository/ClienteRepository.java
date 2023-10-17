package tech.ada.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Cliente;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.nomeCompleto ILIKE concat('%', :nome, '%')")
    List<Cliente> findByNomeCompletoCustom(@Param("nome") String nome);

    @Query(value = "UPDATE cliente SET ativo = :ativo WHERE id = :id", nativeQuery = true)
    void ativarUsuario(@Param("ativo") boolean ativo, @Param("id") Long id);

/*    List<Cliente> findByNomeCompleto(String nome);
    List<Cliente> findByNomeCompletoLike(String nome);
    Cliente findByDataNascimentoBetween(Date data1, Date data2);
    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> findByCustom();*/
}