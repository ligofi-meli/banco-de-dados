package gomes.filipe.dao;

import gomes.filipe.entity.FormaPagamento;
import gomes.filipe.entity.Venda;
import gomes.filipe.entity.Vendedor;
import gomes.filipe.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VendaPersistence {

	private EntityManager em;

	public VendaPersistence() {
		em = JPAUtil.getEntityManager();
	}

	// CREATE
	public void insere(Venda venda) {
		try {
			em.getTransaction().begin();
			em.persist(venda);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();
		}
	}


	// READ
	public Venda get(Long id) {
		return em.find(Venda.class, id);
	}

	public List<Venda> lista() {
		TypedQuery<Venda> query = em.createQuery("FROM venda", Venda.class);
		return query.getResultList();
	}

	// UPDATE
	public void atualiza (Venda venda) {
		em.getTransaction().begin();
		Venda v = em.find(Venda.class, venda.getId());
		v.setFormaPagamento(venda.getFormaPagamento());
		em.getTransaction().commit();
	}

	// DELETE
	public void delete(Long id) {
		em.getTransaction().begin();
		Venda v = em.find(Venda.class, id);	// garante que o objeto v esteja no estado managed
		em.remove(v);
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		//VendaPersistence vendaPersistence = new VendaPersistence();
		//VendedorPersistence vendedorPersistence = new VendedorPersistence();
		//Vendedor vendedor = vendedorPersistence.get("MLB077");
		//Vendedor vendedor = vendedorPersistence.get("MLB854");

		//vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(89889), FormaPagamento.A_PRAZO, vendedor));
		//vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(15000), FormaPagamento.A_PRAZO, vendedor));
		//vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(15000), FormaPagamento.A_VISTA, vendedor));
	}
}
