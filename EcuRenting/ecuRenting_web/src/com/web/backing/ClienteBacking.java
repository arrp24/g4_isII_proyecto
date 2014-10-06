package com.web.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;

import com.gestion.entity.Cliente;

import com.gestion.service.ClienteServicioLocal;


@ManagedBean(name = "clienteBacking")
@ViewScoped
public class ClienteBacking implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private ClienteServicioLocal clienteServicio;
	
	private List<Cliente> clientes;
	private Cliente cliente;
	private Cliente selectedCliente;
	
	
	 public ClienteBacking() {
	        this.cliente = new Cliente();
	 }

	    
	@PostConstruct
	public void init() {
		this.clientees = clienteServicio.getAll();
		
	}
	
    public ClienteServicioLocal getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteServicioLocal clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	public List<Cliente> getClientees() {
		return clientees;
	}

	public void setClientees(List<Cliente> clientees) {
		this.clientees = clientees;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(Cliente selectedCliente) {
		this.selectedCliente = selectedCliente;
	}
    
	public void crearCliente() {
		clienteServicio.crearCliente(cliente);
		cliente = new Cliente();
		clientees = clienteServicio.getAll();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Creación Exitosa",
				"Se ha creado un nuevo Cliente exitosamente!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarCliente() {
		clienteServicio.actualizarCliente(this.selectedCliente);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente el cliente \""
						+ this.selectedCliente.getNombre() + "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedCliente = null;
	}
	
	public void eliminarCliente() {
		
	}
	
}
