package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;

import com.ls.gestion.entity.InventarioTransito;
import com.ls.gestion.entity.PedidoRetiro;
import com.ls.gestion.service.InventarioServicioLocal;
import com.ls.gestion.service.InventarioTransitoServicioLocal;
import com.ls.gestion.service.PedidoRetiroServicioLocal;

@ManagedBean(name = "pedidoRetiroBacking")
@ViewScoped
public class PedidoRetiroBacking implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private PedidoRetiroServicioLocal pedidoServicio;

	@EJB
	private InventarioTransitoServicioLocal inventarioTransitoServicio;

	public InventarioTransitoServicioLocal getInventarioTransitoServicio() {
		return inventarioTransitoServicio;
	}

	public void setInventarioTransitoServicio(
			InventarioTransitoServicioLocal inventarioTransitoServicio) {
		this.inventarioTransitoServicio = inventarioTransitoServicio;
	}

	@EJB
	private InventarioServicioLocal inventarioServicio;

	private List<PedidoRetiro> pedidoRetiros;
	private List<InventarioTransito> invTransito;
	private InventarioTransito selectedinventarioTransito;
	private PedidoRetiro pedidoRetiro;
	private PedidoRetiro selectedPedidoRetiro;
	private List<String> clientes;
	private String nombre;
	private int codigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private int spinner;

	public PedidoRetiroBacking() {
		this.pedidoRetiro = new PedidoRetiro();
		invTransito = new ArrayList();
	}

	@PostConstruct
	public void init() {
		this.pedidoRetiros = pedidoServicio.getAll();
		invTransito = new ArrayList();
	}

	public int getSpinner() {
		return spinner;
	}

	public void setSpinner(int spinner) {
		this.spinner = spinner;
	}

	public PedidoRetiroServicioLocal getPedidoRetiroServicio() {
		return pedidoServicio;
	}

	public void setPedidoRetiroServicio(PedidoRetiroServicioLocal pedidoServicio) {
		this.pedidoServicio = pedidoServicio;
	}

	public List<PedidoRetiro> getPedidoRetiros() {
		return pedidoRetiros;
	}

	public void setPedidoRetiros(List<PedidoRetiro> pedidoRetiros) {
		this.pedidoRetiros = pedidoRetiros;
	}

	public PedidoRetiro getPedidoRetiro() {
		return pedidoRetiro;
	}

	public void setPedidoRetiro(PedidoRetiro pedidoRetiro) {
		this.pedidoRetiro = pedidoRetiro;
	}

	public PedidoRetiro getSelectedPedidoRetiro() {
		return selectedPedidoRetiro;
	}

	public void setSelectedPedidoRetiro(PedidoRetiro selectedPedidoRetiro) {
		this.selectedPedidoRetiro = selectedPedidoRetiro;
	}

	public InventarioTransito getSelectedinventarioTransito() {
		return selectedinventarioTransito;
	}

	public void setSelectedinventarioTransito(
			InventarioTransito selectedinventarioTransito) {
		this.selectedinventarioTransito = selectedinventarioTransito;
	}

	public void crearPedidoRetiro() {
		pedidoServicio.crearPedidoRetiro(pedidoRetiro);

		pedidoRetiro = new PedidoRetiro();
		pedidoRetiros = pedidoServicio.getAll();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Creación Exitosa",
				"Se ha creado un nuevo pedido exitosamente!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void actualizarPedidoRetiro() {
		pedidoServicio.actualizarPedidoRetiro(this.selectedPedidoRetiro);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente el usuario \""
						+ this.selectedPedidoRetiro.getDescripcion() + "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedPedidoRetiro = null;
	}

	public void eliminarPedidoRetiro() {
		if (this.selectedPedidoRetiro != null) {
			pedidoServicio.eliminarPedidoRetiro(selectedPedidoRetiro.getId());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Eliminación Exitosa",
					"Se ha borrado exitosamente la pedido \""
							+ this.selectedPedidoRetiro.getDescripcion() + "\"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedPedidoRetiro = null;
			this.pedidoRetiros = pedidoServicio.getAll();
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error de Selección",
					"Ha ocurrido un error al seleccionar la pedido");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onRowToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"PedidoRetiro " + event.getVisibility(), "Nombre: "
						+ ((PedidoRetiro) event.getData()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarDetallePedido() {
		inventarioTransitoServicio
				.actualizarInventarioTransito(this.selectedinventarioTransito);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente el Detalle del Pedido\""
						+ this.selectedinventarioTransito.getDescripcion()
						+ "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedPedidoRetiro = null;
	}

	public List<String> getClientes() {
		return clientes;
	}

	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void cargarOrden() {
		double peso = selectedPedidoRetiro.getPeso() / spinner;
		double volumen = selectedPedidoRetiro.getVolumen() / spinner;
		InventarioTransito inventarioTransito = new InventarioTransito();
		for (int i = 1; i <= spinner; i++) {
			inventarioTransito.setOrdenPedido(selectedPedidoRetiro.getId());
			inventarioTransito.setEstado("NoEntregado");
			inventarioTransito.setPeso(peso);
			inventarioTransito.setVolumen(volumen);
			inventarioTransito.setNumPackete(i);
			
			invTransito.add(inventarioTransito);
			inventarioTransito = new InventarioTransito();
		}
		inventarioTransito = null;

	}

	public List<InventarioTransito> getInvTransito() {
		return invTransito;
	}

	public void setInvTransito(List<InventarioTransito> invTransito) {
		this.invTransito = invTransito;
	}

	public void cancelaCrearInventarioTransito() {
		invTransito = new ArrayList();
	}

	public void crearInventarioTransito() {
		for (int i = 0; i < invTransito.size(); i++) {
			this.inventarioTransitoServicio.crearInventarioTransito(invTransito.get(i));
		}
		invTransito = new ArrayList();
	}

	public List<InventarioTransito> getInvTransito(int codigo) {
		List<InventarioTransito> temp = inventarioTransitoServicio.getAll();
		List<InventarioTransito> inv = new ArrayList<InventarioTransito>();
		for (InventarioTransito aux : temp) {
			if (aux.getOrdenPedido() == codigo) {
				inv.add(aux);
			}
		}

		System.out.println("" + inv);
		return inv;
	}

	public void setCodigoConsulta(int id) {
		this.codigo = id;
	}

}
