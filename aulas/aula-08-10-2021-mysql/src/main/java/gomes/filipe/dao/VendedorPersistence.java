package gomes.filipe.dao;

import gomes.filipe.entity.SituacaoVendedor;
import gomes.filipe.entity.Vendedor;
import gomes.filipe.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VendedorPersistence {

    private Connection cnt;
    private EntityManager em;

    public VendedorPersistence() {
        em = JPAUtil.getEntityManager();
    }

    // CREATE
    public void insere(Vendedor vendedor) {
        em.getTransaction().begin();
        em.persist(vendedor);
        em.getTransaction().commit();
    }

    // READ
    public Vendedor get(String codigo) {
        return em.find(Vendedor.class, codigo);
    }

    // READ
    public List<Vendedor> lista() {
        TypedQuery<Vendedor> query = em.createQuery("FROM Vendedor", Vendedor.class);
        return query.getResultList();
    }

    // UPDATE
    public void atualiza(Vendedor vendedor) {
        em.getTransaction().begin();
        em.persist(vendedor);
        em.getTransaction().commit();
    }
    
    // UPDATE
    public void atualizaSituacaoVendedoresEmLote() {
    	em.getTransaction().begin();
    	List<Vendedor> vendedores = lista();
    	vendedores.forEach(v -> {
    		v.setSituacao(SituacaoVendedor.INATIVO);
    		em.merge(v);
    	});
    	em.getTransaction().commit();
    }

    // DELETE
    public void exclui(String codigo) {
        try{
            PreparedStatement ps = cnt.prepareStatement("DELETE FROM vendedores WHERE codigo = ?");
            ps.setString(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   public static void main(String[] args) {
	   new VendedorPersistence().atualizaSituacaoVendedoresEmLote();
   }
}
