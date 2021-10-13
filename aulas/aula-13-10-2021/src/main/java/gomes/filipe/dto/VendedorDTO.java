package gomes.filipe.dto;

import gomes.filipe.entity.Vendedor;

public class VendedorDTO {
	
	private String cpf;
	private String nome;
	private String cidade;
	private String uf;
	
	
	public VendedorDTO(String cpf, String nome, String cidade, String uf) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
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

	public static VendedorDTO converte(Vendedor vendedor) {
		return new VendedorDTO(vendedor.getCpf(), vendedor.getNome(), vendedor.getCidade(), vendedor.getUf());
	}
		
	public static Vendedor converte(VendedorDTO vendedorDTO) {
		return new Vendedor(vendedorDTO.getCpf(), vendedorDTO.getNome(), vendedorDTO.getCidade(), vendedorDTO.getCpf());
	}
}
