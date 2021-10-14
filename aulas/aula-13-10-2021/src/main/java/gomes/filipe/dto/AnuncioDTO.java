package gomes.filipe.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gomes.filipe.entity.Anuncio;

public class AnuncioDTO {

	private String codigo;
	@NotNull
	@NotEmpty
	@NotBlank
	@Length(min = 3, max = 1000)
	private String titulo;
	@NotNull
	@Min(value = 1)
	private BigDecimal preco;
	private Integer quantidade;
	@JsonIgnore
	private VendedorDTO vendedorDTO;


	public AnuncioDTO() {

	}

	public AnuncioDTO(String codigo, String titulo, BigDecimal preco, Integer quantidade, VendedorDTO vendedorDTO) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
		this.quantidade = quantidade;
		this.vendedorDTO = vendedorDTO;
	}

	public AnuncioDTO(String codigo, String titulo, BigDecimal preco, Integer quantidade) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public VendedorDTO getVendedorDTO() {
		return vendedorDTO;
	}

	public void setVendedorDTO(VendedorDTO vendedorDTO) {
		this.vendedorDTO = vendedorDTO;
	}

	public static Anuncio converte(AnuncioDTO anuncioDTO) {
		if (anuncioDTO.getVendedorDTO() != null) {
			return new Anuncio().comTitulo(
					anuncioDTO.getTitulo())
					.comPreco(anuncioDTO.getPreco())
					.comEstoqueDe(anuncioDTO.getQuantidade())
					.doVendedor(VendedorDTO.converte(anuncioDTO.getVendedorDTO()));
		} else {
			return new Anuncio()
					.comTitulo(anuncioDTO.getTitulo())
					.comPreco(anuncioDTO.getPreco())
					.comEstoqueDe(anuncioDTO.getQuantidade());
		}

	}
	
	public static List<AnuncioDTO> converte(List<Anuncio> anuncios) {
		List<AnuncioDTO> listaDeAnunciosDTO = new ArrayList<>();
		for (Anuncio anuncio: anuncios) {
			if (anuncio.getVendedor() != null) {
				listaDeAnunciosDTO.add(new AnuncioDTO(anuncio.getCodigo(), anuncio.getTitulo(), anuncio.getPreco(), anuncio.getQuantidade(), VendedorDTO.converte(anuncio.getVendedor())));
			} else {
				listaDeAnunciosDTO.add(new AnuncioDTO(anuncio.getCodigo(), anuncio.getTitulo(), anuncio.getPreco(), anuncio.getQuantidade()));
			}
		}
		return listaDeAnunciosDTO;
	}
	
	
	public static AnuncioDTO converte(Anuncio anuncio) {
		if (anuncio.getVendedor() != null) {
			VendedorDTO vendedorDTO = VendedorDTO.converte(anuncio.getVendedor());
			return new AnuncioDTO(anuncio.getCodigo(), anuncio.getTitulo(), anuncio.getPreco(), anuncio.getQuantidade(), vendedorDTO);
		} else {
			return new AnuncioDTO(anuncio.getCodigo(), anuncio.getTitulo(), anuncio.getPreco(), anuncio.getQuantidade());
		}
	}
	
	
	
	
	
	
	
	
	


}
