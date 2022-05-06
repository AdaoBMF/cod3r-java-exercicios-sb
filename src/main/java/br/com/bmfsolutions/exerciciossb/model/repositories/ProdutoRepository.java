package br.com.bmfsolutions.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.bmfsolutions.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {
	
	public Iterable<Produto> findByNomeContaining(String str);
	
	
	//variações dos possíveis metodos pré configurados usando convenção de assinatura
	
	// findByNameContaining
	// findByNameIsContaining
	// findByNameContains

	// findByNameStartsWith
	// findByNameEndsWith
	
	// findByNameNotContaining
	
	//anotation @Query possibilita criar uma query personalizada
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNaneLike(@Param("nome") String nome);
	
}
