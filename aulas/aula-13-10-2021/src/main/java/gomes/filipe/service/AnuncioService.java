package gomes.filipe.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gomes.filipe.entity.Anuncio;
import gomes.filipe.exception.ServiceException;
import gomes.filipe.persistence.AnuncioPersistence;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioPersistence persistence;

	public AnuncioService(AnuncioPersistence persistence) {
		super();
		this.persistence = persistence;
	}
	
	public AnuncioService() {
		super();
		this.persistence = new AnuncioPersistence();
	}
	
	public void cadastrar(Anuncio anuncio) {
		if (codigoNaoUtilizado(anuncio.getCodigo())) {
			anuncio.setCodigo(String.valueOf("MLB" + ThreadLocalRandom.current().nextInt(1000, 99999)));
			persistence.cadastro(anuncio);
		} else {
			throw new ServiceException("Código em uso");
		}
	}
	
	public Anuncio obter(Long id) {
		return persistence.obtem(id);
	}
	
	public List<Anuncio> listagem() {
		return persistence.listagem();
	}
	
	
	private boolean codigoNaoUtilizado(String codigo) {
		Optional<Anuncio> anuncio = persistence.listagem().stream().filter(a -> a.getCodigo().equalsIgnoreCase(codigo)).findAny();
		return !anuncio.isPresent();
	}
}
