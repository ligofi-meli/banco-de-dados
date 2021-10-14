package gomes.filipe.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import gomes.filipe.entity.Vendedor;
import gomes.filipe.exception.ServiceException;
import gomes.filipe.persistence.VendedorPersistence;

@SuppressWarnings("rawtypes")
@Service
public class VendedorService {
	
	private VendedorPersistence persistence;
	
	private List<Validator> validadores = new ArrayList<>();

	public VendedorService(VendedorPersistence persistence, List<Validator> validadores) {
		super();
		this.persistence = persistence;
		this.validadores = validadores;
	}
	
	// POST
	@SuppressWarnings("unchecked")
	public void cadastrar(Vendedor vendedor) {
		if (!cpfUtilizado(vendedor.getCpf())) {
			validadores.forEach(validador -> validador.valida(vendedor));
			try {
				vendedor.setCodigo(String.valueOf("MLB" + ThreadLocalRandom.current().nextInt(1000, 9999)));
				persistence.cadastro(vendedor, true);
			} catch(IOException e) {
				throw new ServiceException("Erro ao cadastrar o vendedor");
			}
		} else {
			throw new ServiceException("CPF está em uso");
		}
	}
	
	// GET
	public List<Vendedor> listar() {
		return persistence.listagem();
	}
	
	// PUT

	
	// DELETE
	public void remover(String codigo) {
		List<Vendedor> vendedores = persistence.listagem();
		Iterator<Vendedor> iterator = vendedores.iterator();
		while (iterator.hasNext()) {
			Vendedor vendedor = iterator.next();
			if (vendedor.getCodigo().equalsIgnoreCase(codigo)) {
				iterator.remove();
			}
		}
		try {
			persistence.cadastro(vendedores);
		} catch(IOException e) {
			e.printStackTrace();
			throw new ServiceException("Erro ao persistir os vendedores");
		}
	}
	
	// Método utilizado no método cadastrar(POST)
	private boolean cpfUtilizado(String cpf) {
		Optional<Vendedor> vendedor = persistence.listagem().stream()
				.filter(v -> v.getCpf().equals(cpf))
				.findAny();
		return vendedor.isPresent();
	}
}
