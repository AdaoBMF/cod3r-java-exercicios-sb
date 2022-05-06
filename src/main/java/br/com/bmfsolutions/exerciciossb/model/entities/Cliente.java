package br.com.bmfsolutions.exerciciossb.model.entities;

public class Cliente {

	private long id;
	private String nome;
	private String cpf;
	
	public Cliente() {}

	public Cliente(long id, String nome, String cpf) {
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
}
