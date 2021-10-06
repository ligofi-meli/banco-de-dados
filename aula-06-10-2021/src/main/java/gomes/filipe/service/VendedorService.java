package gomes.filipe.service;

import gomes.filipe.dao.VendedorPersistence;
import gomes.filipe.entity.Vendedor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VendedorService {

    private VendedorPersistence vendedorPersistence;

    public VendedorService(VendedorPersistence vendedorPersistence) {
        this.vendedorPersistence = vendedorPersistence;
    }

    private String codigoUnico() {
        return "MLB" + ThreadLocalRandom.current().nextInt(100, 999);
    }

    public void salva(Vendedor vendedor) {
        if (vendedor.getCodigo() != null
                || vendedor.getNome() != null
                || vendedor.getCpf() != null) {
            vendedor.setCodigo(codigoUnico());
            vendedorPersistence.insere(vendedor);
        } else {
            Vendedor vendedorExistente = vendedorPersistence.get(vendedor.getCodigo());
            if (vendedorExistente == null) {
                throw new RuntimeException("Erro ao cadastrar");
            }
            vendedorExistente.setCpf(vendedor.getCpf());
            vendedorExistente.setNome(vendedor.getNome());
            vendedorExistente.setEnderecos(vendedor.getEnderecos());
            vendedorPersistence.atualiza(vendedorExistente);
        }
    }

    public List<Vendedor> listagem() {
        List<Vendedor> lista = vendedorPersistence.lista();
        lista.sort((Vendedor v1, Vendedor v2) -> v1.getNome().compareTo(v2.getNome()));
        return lista;
    }

    public Vendedor obtem(String codigo) {
        return vendedorPersistence.get(codigo);
    }

    public void deleta(String codigo) {
        vendedorPersistence.exclui(codigo);
    }
}
