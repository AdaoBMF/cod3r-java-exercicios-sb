package br.com.bmfsolutions.exerciciossb.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String nome;
	
	@Min(0)
	private double preco;
	
	@Min(0)
	@Max(1)
	private double desconto;
	
	public Produto() {
		
	}

	public Produto(String nome, double preco) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setDesconto(0);
	}
	

	public Produto(String nome, double preco, double desconto) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setDesconto(desconto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco >= 1.99) {
			this.preco = preco;
		} else {
			this.preco = this.preco >=1.99 ? this.preco : 1.99;
		}
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		if (desconto >=0 && desconto <= 1) {
			this.desconto = desconto;	
		} else {
			this.desconto = this.desconto >=0 && this.desconto <=1 ? this.desconto : 0;
		}
	}
	
	
}
