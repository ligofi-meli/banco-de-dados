package gomes.filipe.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id será gerado automaticamente com autoincremento
	private Long id;
	private LocalDate data;
	private BigDecimal valorTotal;
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	@ManyToOne
	private Vendedor vendedor;


	public Venda() {

	}

	public Venda(Long id, LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento, Vendedor vendedor) {
		this.id = id;
		this.data = data;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.vendedor = vendedor;
	}

	public Venda(LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento, Vendedor vendedor) {
		this.data = data;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.vendedor = vendedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}
