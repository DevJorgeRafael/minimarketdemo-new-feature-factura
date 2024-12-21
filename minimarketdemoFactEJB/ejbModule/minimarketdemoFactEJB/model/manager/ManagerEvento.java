package minimarketdemoFactEJB.model.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import minimarketdemoFactEJB.model.entities.VwEvento;

/**
 * Session Bean implementation class ManagerEvento
 */
@Stateless
@LocalBean
public class ManagerEvento {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public ManagerEvento() {
        // 
    }
    
    public List<VwEvento> findAllEventos() {
    	Query q;
    	ArrayList<VwEvento> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM VwEvento o";
    	
    	q=em.createQuery(sentenciaJPQL);
    	listado=(ArrayList<VwEvento>) q.getResultList();
    	return listado;
    }

}
