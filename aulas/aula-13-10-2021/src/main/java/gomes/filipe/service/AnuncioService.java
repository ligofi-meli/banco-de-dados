package gomes.filipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gomes.filipe.persistence.VendedorPersistence;

@SuppressWarnings("rawtypes")
@Service
public class AnuncioService {
	
	private VendedorPersistence persistence;
	
	private List<Validator> validadores = new ArrayList<>();

	public AnuncioService(VendedorPersistence persistence, List<Validator> validadores) {
		super();
		this.persistence = persistence;
		this.validadores = validadores;
	}
}
