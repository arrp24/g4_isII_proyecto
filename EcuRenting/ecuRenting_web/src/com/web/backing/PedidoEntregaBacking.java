package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;

import com.ls.gestion.entity.Inventario;
import com.ls.gestion.entity.InventarioTransito;
import com.ls.gestion.entity.PedidoEntrega;
import com.ls.gestion.service.InventarioServicioLocal;
import com.ls.gestion.service.PedidoEntregaServicioLocal;

@ManagedBean(name = "pedidoEntregaBacking")
@ViewScoped
public class PedidoEntregaBacking implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private PedidoEntregaServicioLocal pedidoEntregaServicio;

	@EJB
	private InventarioServicioLocal inventarioServicio;

	// Entidades de Pedido
	private List<PedidoEntrega> pedidoEntregas;
	private PedidoEntrega pedidoEntrega;
	private PedidoEntrega selectedPedidoEntrega;
	private List<PedidoEntrega> pedidoLista;
	

	private int cantidadMenos;
	private String bodega = " ";
	private String descrip_pedido = " ";
	private Date fechaEntrega = new Date();
	private Date fecha = new Date();
	private double pesoT;
	private double volumenT;
	private List<PedidoEntrega> listResult;


	// Entidades de Inventario
	private List<Inventario> inventarios;
	private Inventario inventario;
	private Inventario selectedInventario;


	public PedidoEntregaBacking() {
		this.pedidoEntrega = new PedidoEntrega();
	}

	@PostConstruct
	public void init() {
		this.pedidoEntregas = pedidoEntregaServicio.getAll();
		this.inventarios = inventarioServicio.getAll();
		this.pedidoLista = new ArrayList<PedidoEntrega>();
		this.listResult = new ArrayList<PedidoEntrega>();
	}
	

	// PEDIDO
	public PedidoEntregaServicioLocal getPedidoEntregaServicio() {
		return pedidoEntregaServicio;
	}

	public void setPedidoEntregaServicio(
			PedidoEntregaServicioLocal pedidoEntregaServicio) {
		this.pedidoEntregaServicio = pedidoEntregaServicio;
	}

	public List<PedidoEntrega> getPedidoEntregas() {
		return pedidoEntregas;
	}
	
	public List<PedidoEntrega> getListResult() {
		return listResult;
	}

	public void setListResult(List<PedidoEntrega> listResult) {
		this.listResult = listResult;
	}

	public void setPedidoEntregas(List<PedidoEntrega> pedidoEntregas) {
		this.pedidoEntregas = pedidoEntregas;
	}

	public PedidoEntrega getPedidoEntrega() {
		return pedidoEntrega;
	}

	public void setPedidoEntrega(PedidoEntrega pedidoEntrega) {
		this.pedidoEntrega = pedidoEntrega;
	}

	public PedidoEntrega getSelectedPedidoEntrega() {
		return selectedPedidoEntrega;
	}

	public void setSelectedPedidoEntrega(PedidoEntrega selectedPedidoEntrega) {
		this.selectedPedidoEntrega = selectedPedidoEntrega;
	}
	
	public String getBodega() {
		return bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String getDescrip_pedido() {
		return descrip_pedido;
	}

	public void setDescrip_pedido(String descrip_pedido) {
		this.descrip_pedido = descrip_pedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
    
    public int getCantidadMenos() {
		return cantidadMenos;
	}

	public void setCantidadMenos(int cantidadMenos) {
		this.cantidadMenos = cantidadMenos;
	}
	public double getPesoT() {
		return pesoT;
	}

	public void setPesoT(double pesoT) {
		this.pesoT = pesoT;
	}

	public double getVolumenT() {
		return volumenT;
	}

	public void setVolumenT(double volumenT) {
		this.volumenT = volumenT;
	}
	
	//, String fechaEmplace, String fechaEntrega
	
	public void getListaPedidos(int cod, String bodega){
		List<PedidoEntrega> temp = pedidoEntregaServicio.getAll();
		for (PedidoEntrega aux : temp) {
			if (aux.getOrdenPedido()== cod && aux.getBodega() == bodega ) {
				/**aux.getFechaEmplace().equals(fechaEmplace)&& 
				aux.getFechaEntrega().equals(fechaEntrega)) {*/
				System.out.println(aux.getOrdenPedido());
				System.out.println(aux.getBodega());
				listResult.add(aux);
			}
		}
	}

	

	// INVENTARIO
	public InventarioServicioLocal getInventarioServicio() {
		return inventarioServicio;
	}

	public void setInventarioServicio(InventarioServicioLocal inventarioServicio) {
		this.inventarioServicio = inventarioServicio;
	}

	public Inventario getSelectedInventario() {
		return selectedInventario;
	}

	public void setSelectedInventario(Inventario selectedInventario) {
		this.selectedInventario = selectedInventario;
	}

	public List<PedidoEntrega> getPedidoLista() {
		return pedidoLista;
	}

	public void setPedidoLista(List<PedidoEntrega> pedidoLista) {
		this.pedidoLista = pedidoLista;
	}
	
	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public void setInventario(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public void selectInventarioFromDialog(Inventario inv) {
		PedidoEntrega pedidoEntrega = new PedidoEntrega();
		pesoT = pesoT + inv.getPeso();
		volumenT = volumenT + inv.getVolumen();
		do {
			pedidoEntrega.setBodega(bodega);
			pedidoEntrega.setFechaEntrega(new Timestamp(fechaEntrega.getTime()));
			pedidoEntrega.setDescrip_pedido(descrip_pedido);
			pedidoEntrega.setCantidad(cantidadMenos);
			pedidoEntrega.setDescripcion(inv.getDescripcion());
			pedidoEntrega.setPeso(inv.getPeso());
			pedidoEntrega.setVolumen(inv.getVolumen());
			pedidoEntrega.setDescripcion(inv.getDescripcion());
			pedidoEntrega.setUbicacion(inv.getUbicacion());
			pedidoEntrega.setOrdenPedido(inv.getOrdenRetiro());
			pedidoEntrega.setFechaEmplace(new Timestamp(fecha.getTime()));
			/**
			 * FALTA FIJAR EL PESO Y VOLUMEN TOTAL DEL PEDIDO
			 * */
			pedidoLista.add(pedidoEntrega);
			pedidoEntrega = new PedidoEntrega();
			pedidoEntrega = null;
			
		} while (pedidoLista.size() != 0);
	}
	
	public void cancelaCrearInventario() {
		inventarios = new ArrayList();
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	// CRUD
	public void crearPedidoEntrega() {
		for (int i = 0; i <= pedidoLista.size(); i++) {
			this.pedidoEntregaServicio.crearPedidoEntrega(pedidoLista.get(i));
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Creación Exitosa",
					"Se ha creado un nuevo pedido exitosamente!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		pedidoLista = new ArrayList();

		
	}

	public void actualizarPedidoEntrega() {
		pedidoEntregaServicio
				.actualizarPedidoEntrega(this.selectedPedidoEntrega);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente el usuario \""
						+ this.selectedPedidoEntrega.getDescripcion() + "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedPedidoEntrega = null;
	}

	public void eliminarPedidoEntrega() {
		if (this.selectedPedidoEntrega != null) {
			pedidoEntregaServicio.eliminarPedidoEntrega(selectedPedidoEntrega
					.getIdOrdenEntrega());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Eliminación Exitosa",
					"Se ha borrado exitosamente la pedido \""
							+ this.selectedPedidoEntrega.getDescripcion()
							+ "\"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedPedidoEntrega = null;
			this.pedidoEntregas = pedidoEntregaServicio.getAll();
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error de Selección",
					"Ha ocurrido un error al seleccionar la pedido");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onRowToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"PedidoEntrega " + event.getVisibility(), "Descrip. Pedido: "
						+ ((PedidoEntrega) event.getData()).getDescrip_pedido());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}