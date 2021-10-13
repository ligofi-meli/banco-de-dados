package gomes.filipe.entity;

import java.time.LocalDate;

public class Vendedor {
	
	private String codigo;
	private String cpf;
	private String nome;
	private String cidade;
	private String uf;
	private LocalDate dataNascimento;
	
	
	public Vendedor(String codigo, String cpf, String nome, String cidade, String uf, LocalDate dataNascimento) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
		this.dataNascimento = dataNascimento;
	}
	
	public Vendedor(String cpf, String nome, String cidade, String uf, LocalDate dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
		this.dataNascimento = dataNascimento;
	}
	
	public Vendedor(String cpf, String nome, String cidade, String uf) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
