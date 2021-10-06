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

    public void insere(Venda venda) {
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        }
    }

    public Venda get(Long id) {
        return em.find(Venda.class, id);
    }

    public List<Venda> lista() {
        TypedQuery<Venda> query = em.createQuery("FROM Venda", Venda.class);
        return query.getResultList();
    }

    public void atualiza (Venda venda) {
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, venda.getId());
        em.remove(v);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, id);
        em.remove(v);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        VendaPersistence vendaPersistence = new VendaPersistence();
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        Vendedor vendedor = vendedorPersistence.get("MLB470");

        vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(1000), FormaPagamento.A_PRAZO, vendedor));
    }






}
