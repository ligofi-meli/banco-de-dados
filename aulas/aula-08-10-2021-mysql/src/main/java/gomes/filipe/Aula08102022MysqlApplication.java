package gomes.filipe;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gomes.filipe.entity.Pedido;
import gomes.filipe.repository.PedidoRepository;
import gomes.filipe.repository.PedidoRepository.Anuncio;
import gomes.filipe.repository.VendedorRepository;

@SpringBootApplication
public class Aula08102022MysqlApplication {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Aula08102022MysqlApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		List<Pedido> pedidosDeHoje = pedidoRepository.getByData(LocalDate.now());
		
		pedidosDeHoje.forEach(p -> {
			System.out.println(p.getId() + " " + p.getData().toString());
			List<Anuncio> anuncios = pedidoRepository.retornaOsAnuncios(p.getId());
			anuncios.forEach(a -> System.out.println(a.getCodigo() + " " + a.getTitulo()));
		});
	}

}
