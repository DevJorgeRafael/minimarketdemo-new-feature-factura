package minimarketdemo.controller.evento;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemoFactEJB.model.entities.VwEvento;
import minimarketdemoFactEJB.model.manager.ManagerEvento;

@Named
@SessionScoped
public class BeanEvento implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerEvento me;
	
	private List<VwEvento> listaEventos;
	
	public BeanEvento() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaEventos = me.findAllEventos();
	}

	public List<VwEvento> getListaEventos() {
		return listaEventos;
	}
	


}
