package gomes.filipe.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import gomes.filipe.dto.VendedorDTO;
import gomes.filipe.entity.Vendedor;
import gomes.filipe.service.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@PostMapping(value = "cadastra")
	public ResponseEntity<VendedorDTO> cadastro(@RequestBody VendedorDTO vendedorDTO, UriComponentsBuilder uriBuilder) {
		Vendedor vendedor = VendedorDTO.converte(vendedorDTO);
		vendedorService.cadastrar(vendedor);
		URI uri = uriBuilder.path("/vendedores/{codigo}").buildAndExpand(vendedor.getCodigo()).toUri();
		VendedorDTO dto = VendedorDTO.converte(vendedor);
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping(value = "/listar")
	public List<Vendedor> lista() {
		return vendedorService.listar();
	}
	
	@DeleteMapping(value = "/deleta/{codigo}")
	public void deleta(@PathVariable("codigo") String codigo) {
		vendedorService.remover(codigo);
	}
}
