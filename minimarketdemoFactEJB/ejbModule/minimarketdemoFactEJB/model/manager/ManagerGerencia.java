package minimarketdemoFactEJB.model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import minimarketdemoFactEJB.model.entities.VwFacturasPorAnio;
import minimarketdemoFactEJB.model.entities.VwFacturasPorMe;
import minimarketdemoFactEJB.model.entities.VwPedidosResumen;

/**
 * Session Bean implementation class ManagerGerencia
 */
@Stateless
@LocalBean
public class ManagerGerencia {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ManagerGerencia() {
        // TODO Auto-generated constructor stub
    }
    
    public List<VwFacturasPorAnio> findAllFacturasPorAnio() {
    	Query q;
    	ArrayList<VwFacturasPorAnio> listado;
    	String sentenciaJPQL;
    	sentenciaJPQL = "SELECT o FROM VwFacturasPorAnio o";
    	
    	q = em.createQuery(sentenciaJPQL);
    	listado = (ArrayList<VwFacturasPorAnio>) q.getResultList();
    	return listado;
    }
    
    public List<VwFacturasPorMe> findAllFacturasPorMes() {
    	Query q;
    	ArrayList<VwFacturasPorMe> listado;
    	String sentenciaJPQL;
    	sentenciaJPQL = "SELECT o FROM VwFacturasPorMe o";
    	
    	q = em.createQuery(sentenciaJPQL);
    	listado = (ArrayList<VwFacturasPorMe>) q.getResultList();
    	return listado;
    }
    
    public List<VwPedidosResumen> findAllPedidosResumen() {
    	Query q;
    	ArrayList<VwPedidosResumen> listado;
    	String sentenciaJPQL;
    	sentenciaJPQL = "SELECT o FROM VwPedidosResumen o";
    	
    	q = em.createQuery(sentenciaJPQL);
    	listado = (ArrayList<VwPedidosResumen>) q.getResultList();
    	return listado;
    }

}
