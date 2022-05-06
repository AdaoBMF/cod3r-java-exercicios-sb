package br.com.bmfsolutions.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmfsolutions.exerciciossb.model.entities.Produto;
import br.com.bmfsolutions.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public Iterable<Produto> getProdutos() {
		return produtoRepository.findAll();	
	}
	
	@GetMapping("page/{page}/{qtd}")
	public Iterable<Produto> getProdutosPag(@PathVariable int page, @PathVariable int qtd) {
		if (qtd > 5) qtd =5;
		PageRequest pgb = PageRequest.of(page, qtd, Sort.by(Direction.ASC, "nome"));
		return produtoRepository.findAll(pgb);
	}
	
	@GetMapping("{id}")
	public Optional<Produto> getProdutoById(@PathVariable int id) {
		return produtoRepository.findById(id);		
	}
	
	@GetMapping("nome/{qur}")
	public Iterable<Produto> getProdutosPorNome(@PathVariable String qur) {
//		return produtoRepository.findByNomeContaining(qur);
		return produtoRepository.searchByNaneLike(qur);
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto saveProduto(@Valid Produto prod) {
		produtoRepository.save(prod);
		return prod;
	}
 
	//subtituido pela opção de usar dois métodos no saveProduto
//	@PutMapping
//	public Produto editProduto(@Valid Produto prod) {
//		produtoRepository.save(prod);
//		return prod;		
//	}
	
	@DeleteMapping("{id}")
	public String deleteProduto(@PathVariable int id) {
		try {
			produtoRepository.deleteById(id);
			return "Produto removido do banco de dados";
		} catch (Exception e) {
			
			return "Não foi possivel remover o produto " + e.getMessage();
		}		
	}
	

}
