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
        Vendedor vendedor = new Vendedor("MLB422", "007.003.002-21" ,"Valéria");

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
        Vendedor vendedor = new Vendedor("MLB422", "007.003.002-21" ,"Silvia");

        vendedorService.salva(vendedor);
    }

    private static void exclusao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorService vendedorService = new VendedorService(vendedorPersistence);
        String codigo = "MLB757";
        vendedorService.deleta(codigo);
    }
}
