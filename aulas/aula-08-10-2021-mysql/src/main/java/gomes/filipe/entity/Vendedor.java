package gomes.filipe.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedores")
public class Vendedor {

	@Id
	private String codigo;
	private String cpf;
	private String nome;
	@Enumerated(EnumType.STRING)
	private SituacaoVendedor situacao;
	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Endereco> enderecos;


	public Vendedor() {

	}

	public Vendedor(String codigo, String cpf, String nome, List<Endereco> enderecos) {
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.enderecos = enderecos;
	}

	public Vendedor(String codigo, String cpf, String nome, SituacaoVendedor situacao) {
		super();
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
		this.situacao = situacao;
	}

	public Vendedor(String codigo, String cpf, String nome) {
		this.codigo = codigo;
		this.cpf = cpf;
		this.nome = nome;
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


	public SituacaoVendedor getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoVendedor situacao) {
		this.situacao = situacao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Vendedor [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + ", situacao=" + situacao
				+ ", enderecos=" + enderecos + "]";
	}
}
