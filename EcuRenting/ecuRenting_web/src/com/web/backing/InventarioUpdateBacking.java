package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.ls.gestion.entity.Inventario;
import com.ls.gestion.entity.InventarioTransito;
import com.ls.gestion.entity.UbicacionInventario;
import com.ls.gestion.service.InventarioServicioLocal;
import com.ls.gestion.service.InventarioTransitoServicioLocal;
import com.ls.gestion.service.UbicacionInventarioServicioLocal;


@ManagedBean(name = "inventarioUpdateBacking")
@ViewScoped
public class InventarioUpdateBacking implements Serializable {
	
	private static final long serialVersionUID = 5297201599173897134L;
	
	@EJB
	private InventarioServicioLocal inventarioServicio;

	@EJB
	private InventarioTransitoServicioLocal inventarioTransitoServicio;
	
	@EJB
	private UbicacionInventarioServicioLocal ubicacionInventarioServicio;

	private List<Inventario> inventarios;
	private Inventario inventario;
	private Inventario selectedInventario;
	
	private List<InventarioTransito> inventariosTransito;
	private InventarioTransito inventarioTransito;
	private InventarioTransito selectedInventarioTransito;
	
	private List<UbicacionInventario> ubicacionesInventarios;
	private UbicacionInventario ubicacionInventario;
	private UbicacionInventario selectedUbicacionInventario;
	private String ubicacion;
	
	public InventarioUpdateBacking() {
	        this.inventario = new Inventario();
	        
	}

	    
	@PostConstruct
	public void init() {
		this.inventarios = inventarioServicio.getAll();
		this.inventariosTransito = inventarioTransitoServicio.getAll();
		this.ubicacionesInventarios = ubicacionInventarioServicio.getAll();
	}
	
	
	
	public InventarioTransitoServicioLocal getInventarioTransitoServicio() {
		return inventarioTransitoServicio;
	}


	public void setInventarioTransitoServicio(
			InventarioTransitoServicioLocal inventarioTransitoServicio) {
		this.inventarioTransitoServicio = inventarioTransitoServicio;
	}


	public List<InventarioTransito> getInventariosTransito() {
		return inventariosTransito;
	}


	public void setInventariosTransito(List<InventarioTransito> inventariosTransito) {
		this.inventariosTransito = inventariosTransito;
	}


	public InventarioTransito getInventarioTransito() {
		return inventarioTransito;
	}


	public void setInventarioTransito(InventarioTransito inventarioTransito) {
		this.inventarioTransito = inventarioTransito;
	}


	public InventarioTransito getSelectedInventarioTransito() {
		return selectedInventarioTransito;
	}


	public void setSelectedInventarioTransito(
			InventarioTransito selectedInventarioTransito) {
		this.selectedInventarioTransito = selectedInventarioTransito;
	}
	
	public InventarioServicioLocal getInventarioServicio() {
		return inventarioServicio;
	}


	public void setInventarioServicio(InventarioServicioLocal inventarioServicio) {
		this.inventarioServicio = inventarioServicio;
	}


	public List<Inventario> getInventarios() {
		return inventarios;
	}


	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}


	public Inventario getInventario() {
		return inventario;
	}


	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}


	public Inventario getSelectedInventario() {
		return selectedInventario;
	}


	public void setSelectedInventario(Inventario selectedInventario) {
		this.selectedInventario = selectedInventario;
	}
	
	public List<UbicacionInventario> getUbicacionesInventarios() {
		return ubicacionesInventarios;
	}


	public void setUbicacionesInventarios(List<UbicacionInventario> ubicacionesInventarios) {
		this.ubicacionesInventarios = ubicacionesInventarios;
	}


	public UbicacionInventario getUbicacionInventario() {
		return ubicacionInventario;
	}


	public void setUbicacionInventario(UbicacionInventario ubicacionInventario) {
		this.ubicacionInventario = ubicacionInventario;
	}


	public UbicacionInventario getSelectedUbicacionInventario() {
		return selectedUbicacionInventario;
	}


	public void setSelectedUbicacionInventario(
			UbicacionInventario selectedUbicacionInventario) {
		this.selectedUbicacionInventario = selectedUbicacionInventario;
	}
	

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void crearInventario() {
		   Date fecha = new Date();
		   double peso = selectedInventarioTransito.getPeso()/selectedInventarioTransito.getMedida();
		   double volumen = selectedInventarioTransito.getVolumen()/selectedInventarioTransito.getMedida();
	       inventario.setCliente(selectedInventarioTransito.getId_cliente());
	       inventario.setOrdenRetiro(selectedInventarioTransito.getOrdenPedido());
	       inventario.setDescripcion(selectedInventarioTransito.getDescripcion());
	       inventario.setTipo(selectedInventarioTransito.getTipo());
	       inventario.setUni_media(selectedInventarioTransito.getUniMedia());
	       inventario.setExistencia(selectedInventarioTransito.getMedida());
	       inventario.setPeso(peso); 
	       inventario.setVolumen(volumen);
	       inventario.setFecha_ingreso(fecha);
	       inventario.setUbicacion(ubicacion);
	       selectedInventarioTransito.setEstado("Entregado");
	       inventarioTransitoServicio.actualizarInventarioTransito(selectedInventarioTransito);
	       selectedInventarioTransito = new InventarioTransito();
	       inventarioServicio.crearInventario(inventario);
		   inventario = new Inventario();
		   
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Increso Exitoso",
					"Se ha ingresado los items al inventario exitosamente!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void actualizarInventario() {
	        
	}
	 
	public void eliminarInventario() {
	        
	}
	    
	public void onRowToggle(ToggleEvent event) {
		
	}
	
	public TreeNode createDocuments() {
       /** TreeNode root = new DefaultTreeNode(new UbicacionInventario("Files", "-", "Folder"), null);
         
        TreeNode nivelI = new DefaultTreeNode(new UbicacionInventario("Nivel I", "-", "Folder"), root);
        TreeNode nivelII = new DefaultTreeNode(new UbicacionInventario("Nivel II", "-", "Folder"), root);
        TreeNode nivelIII = new DefaultTreeNode(new UbicacionInventario("Nivel II", "-", "Folder"), root);
         
        TreeNode work = new DefaultTreeNode(new UbicacionInventario("Work", "-", "Folder"), documents);
        TreeNode primefaces = new DefaultTreeNode(new UbicacionInventario("PrimeFaces", "-", "Folder"), documents);
         
        //Documents
        TreeNode expenses = new DefaultTreeNode("nivelI", new Document("Expenses.doc", "30 KB", "Word Document"), work);
        TreeNode resume = new DefaultTreeNode("nivelII", new Document("Resume.doc", "10 KB", "Word Document"), work);
        TreeNode refdoc = new DefaultTreeNode("nivelIII", new Document("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
         
        //Pictures
        TreeNode barca = new DefaultTreeNode("picture", new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
        TreeNode primelogo = new DefaultTreeNode("picture", new Document("logo.jpg", "45 KB", "JPEG Image"), pictures);
        TreeNode optimus = new DefaultTreeNode("picture", new Document("optimusprime.png", "96 KB", "PNG Image"), pictures);
         
        //Movies
        TreeNode pacino = new DefaultTreeNode(new Document("Al Pacino", "-", "Folder"), movies);
        TreeNode deniro = new DefaultTreeNode(new Document("Robert De Niro", "-", "Folder"), movies);
         
        TreeNode scarface = new DefaultTreeNode("mp3", new Document("Scarface", "15 GB", "Movie File"), pacino);
        TreeNode carlitosWay = new DefaultTreeNode("mp3", new Document("Carlitos' Way", "24 GB", "Movie File"), pacino);
         
        TreeNode goodfellas = new DefaultTreeNode("mp3", new Document("Goodfellas", "23 GB", "Movie File"), deniro);
        TreeNode untouchables = new DefaultTreeNode("mp3", new Document("Untouchables", "17 GB", "Movie File"), deniro);
         */
		TreeNode root = null;
        return root;
    }

}
