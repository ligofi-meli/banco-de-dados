package gomes.filipe.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import gomes.filipe.dto.AnuncioDTO;
import gomes.filipe.entity.Anuncio;
import gomes.filipe.service.AnuncioService;

@RestController
@RequestMapping(value = "/anuncios")
public class AnuncioController {
	
	private AnuncioService anuncioService;
	
	@PostMapping(value = "/cadastra")
	public ResponseEntity<AnuncioDTO> cadastro(@Valid @RequestBody AnuncioDTO anuncioDTO, UriComponentsBuilder uriBuilder) {
		Anuncio anuncio = AnuncioDTO.converte(anuncioDTO);
		anuncioService.cadastrar(anuncio);
		URI uri = uriBuilder.path("/anuncios/{id}").buildAndExpand(anuncio.getId()).toUri();
		return ResponseEntity.created(uri).body(AnuncioDTO.converte(anuncio));
	}
	
	@GetMapping(value = "/listar")
	public List<AnuncioDTO> lista() {
		List<Anuncio> listaDeAnuncios = anuncioService.listagem();
		return AnuncioDTO.converte(listaDeAnuncios);
	}
	
	@GetMapping(value = "/{id}")
	public AnuncioDTO obter(@PathVariable("id") Long id) {
		Anuncio anuncio = anuncioService.obter(id);
		return AnuncioDTO.converte(anuncio);
	}
}
