package gomes.filipe;

import gomes.filipe.dao.VendedorPersistence;
import gomes.filipe.entity.Vendedor;
import gomes.filipe.service.VendedorService;

public class Main {


    public static void main(String[] args) {
        insercao();
        //listagem();
        //atualizacao();
        //exclusao();
    }

    private static void insercao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorService vendedorService = new VendedorService(vendedorPersistence);
        Vendedor vendedor = new Vendedor(
                "002.005.008-56",
                "Carlos",
                "Avenida C",
                "Niterói",
                "RJ");

        vendedorService.salva(vendedor);
    }

    private static void listagem() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorService vendedorService = new VendedorService(vendedorPersistence);
        vendedorService.listagem().forEach(v -> System.out.println(v));
    }

    private static void atualizacao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorService vendedorService = new VendedorService(vendedorPersistence);
        Vendedor vendedor = new Vendedor(
                "MLB227",
                "009.005.002-45",
                "Mario",
                "Avenida M",
                "Recife",
                "PB");

        vendedorService.salva(vendedor);
    }

    private static void exclusao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorService vendedorService = new VendedorService(vendedorPersistence);
        String codigo = "MLB757";
        vendedorService.deleta(codigo);
    }
}
