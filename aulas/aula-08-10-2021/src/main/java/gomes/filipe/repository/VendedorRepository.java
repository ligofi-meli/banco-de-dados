package gomes.filipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gomes.filipe.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,String>{

	Vendedor findByNome(String nome);
}
