package gomes.filipe.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gomes.filipe.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> getByData(LocalDate data);
	
	@Query(value = "SELECT a.codigo, a.titulo, a.vendedor, a.preco, a.data_anuncio, a.num_vendas"
			+ "FROM anuncios a, pedido_anuncios pa, pedido p WHERE a.codigo = pa.anuncios"
			+ "AND pa.pedido_id = p.id AND p.id =:id ", nativeQuery = true)
	
	List<Anuncio> retornaOsAnuncios(@Param("id") Long id);
	
	public interface Anuncio{
		String getCodigo();
		String getTitulo();
		String getVendedor_Codigo();
		BigDecimal getPreco();
		LocalDate getData_Anuncio();
		int getNum_Vendas();
	}
}
