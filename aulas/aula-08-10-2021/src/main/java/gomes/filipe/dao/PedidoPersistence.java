package gomes.filipe.dao;

import gomes.filipe.entity.Anuncio;
import gomes.filipe.entity.Pedido;
import gomes.filipe.util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PedidoPersistence {

	private static final EntityManager em = JPAUtil.getEntityManager();

	// CREATE
	private static void insercao() {
		Anuncio iphone = em.find(Anuncio.class, "MLB07663411");
		List<Anuncio> anuncios = Arrays.asList(iphone);
		Pedido pedido = new Pedido(LocalDate.now(), anuncios);
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
	}
	
	
	// UPDATE
	public static void atualiza() {
		em.getTransaction().begin();
		Pedido pedido = em.find(Pedido.class, 2L);
		List<Anuncio> anuncios = pedido.getAnuncios();
		anuncios.add(em.find(Anuncio.class, "MLB01457688"));
		pedido.setAnuncios(anuncios);
		em.getTransaction().commit();
	}

	
	// DELETE
	public static void exclusao() {
		em.getTransaction().begin();
		Pedido pedido = em.find(Pedido.class, 1L);
		em.remove(pedido);
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		insercao();
		//atualiza();
		//exclusao();
	}
}
