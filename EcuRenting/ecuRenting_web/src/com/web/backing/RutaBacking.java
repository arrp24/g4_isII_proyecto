package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;

import com.ls.gestion.entity.Flota;
import com.ls.gestion.entity.InventarioTransito;
import com.ls.gestion.entity.PedidoRetiro;
import com.ls.gestion.entity.Ruta;
import com.ls.gestion.entity.Seguro;
import com.ls.gestion.service.FlotaServicioLocal;
import com.ls.gestion.service.PedidoRetiroServicioLocal;
import com.ls.gestion.service.RutaServicioLocal;
import com.ls.gestion.service.SeguroServicioLocal;


@ManagedBean(name = "rutaBacking")
@ViewScoped
public class RutaBacking implements Serializable{

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private RutaServicioLocal rutaServicio;
	
	@EJB
	private FlotaServicioLocal flotaServicio;
	
	@EJB
	private PedidoRetiroServicioLocal pedidoRetiroServicio;
	
	@EJB
	private SeguroServicioLocal seguroServicio;
	
	private List<Flota> flotas;
	
	
	private PedidoRetiro selectedPedidoRetiro;
	public PedidoRetiro getSelectedPedidoRetiro() {
		return selectedPedidoRetiro;
	}


	public void setSelectedPedidoRetiro(PedidoRetiro selectedPedidoRetiro) {
		this.selectedPedidoRetiro = selectedPedidoRetiro;
	}


	private List<Ruta> rutas;
	private List<PedidoRetiro> pedidosRetiro;
	private List<Seguro> seguros;
	private Seguro seguro;
	
	private List<Ruta> rutasTemp;
	
	private Ruta ruta;
	private Ruta selectedRuta;
	private long peso = 500;
	private int band = 0;
	private String dato ="0";
	private Date fechaEntrega = new Date();
	private List<String> choferesHabiles = new ArrayList();
	
	private boolean value1; 
    private boolean value2;
	
	 public RutaBacking() {
	        this.ruta = new Ruta();
	    }

	    
	@PostConstruct
	public void init() {
		
		this.rutas = rutaServicio.getAll();
		this.pedidosRetiro = pedidoRetiroServicio.getAll();
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public Seguro getSeguro() {
		return seguro;
	}


	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	 public RutaServicioLocal getRutaServicio() {
		return rutaServicio;
	}


	public void setRutaServicio(RutaServicioLocal rutaServicio) {
		this.rutaServicio = rutaServicio;
	}


	public List<Ruta> getRutas() {
		return rutas;
	}


	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}


	public Ruta getRuta() {
		return ruta;
	}


	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}


	public Ruta getSelectedRuta() {
		return selectedRuta;
	}


	public void setSelectedRuta(Ruta selectedRuta) {
		this.selectedRuta = selectedRuta;
	}

	

	public long getPeso() {
		return peso;
	}


	public void setPeso(long peso) {
		this.peso = peso;
	}


	public void crearRuta() {
	       
	        rutaServicio.crearRuta(ruta);
	        ruta = new Ruta();
	        rutas = rutaServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado una nueva ruta exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	 
	    public void actualizarRuta() {
	    	rutaServicio.actualizarRuta(this.selectedRuta);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente la ruta");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedRuta = null;
	    }
	 

	    public void eliminarRuta() {
	        if (this.selectedRuta != null) {
	        	rutaServicio.eliminarRuta(selectedRuta.getId());

	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
	                    "Se ha borrado exitosamente la ruta");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            this.selectedRuta = null;
	            this.rutas = rutaServicio.getAll();
	        } else {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
	                    "Ha ocurrido un error al seleccionar la ruta");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
	    public void onRowToggle(ToggleEvent event) {
	    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente " + event.getVisibility(), "Nombre: "
	                + ((Ruta) event.getData()).getDescripcion());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
	    public void cambiarPeso(int pesoP){
	    	pesoP = value2 ? pesoP : (-1*pesoP);
	    		
	    if (band ==0){	
	    	if(pesoP==200)
	    		band=1;
	    	if(pesoP==300)
	    		band=3;
	    	if(pesoP==100)
	    		band=5;
	    	if(pesoP==500)
	    		band=7;
	    	
	    	this.peso = peso - pesoP;
	    }
	    
	    else
	    {
	    	if (band!=0)
	    	{
	    		if(pesoP==200)
		    		band=0;
		    	if(pesoP==300)
		    		band=0;
		    	if(pesoP==100)
		    		band=0;
		    	if(pesoP==500)
		    		band=0;
		    	
		    	this.peso = peso + pesoP;
	    		
	    	}
	    		
	    }
	       
	    	if(peso>=0)
	    	{RequestContext.getCurrentInstance().update("frmNuevoRuta:espacioDisp");
	    	}
	    	
	   
	    	else
	    	{
	    		 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Capacidad",
		                    "Ha superado la capacidad máxima");
		            FacesContext.getCurrentInstance().addMessage(null, msg);
		        
	    		
	    	}	
	    }
	    
	    public boolean isValue2() {
	        return value2;
	    }
	 
	    public void setValue2(boolean value2) {
	        this.value2 = value2;
	    }
	    
	    public void mensaje(){
	    	
	    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
                    "El vehículo tiene pico y placa");
            FacesContext.getCurrentInstance().addMessage(null, msg);
	    }


		public String getDato() {
			return dato;
		}


		public void setDato(String dato) {
			this.dato = dato;
		}
		public void verificaPicoPlaca(){
		
			Date dia = fechaEntrega;
			String datos[] = new String[3];
			datos = dato.split("-");
			int placaAux = Integer.parseInt(datos[1]);
			long hora = dia.getHours();
			long horaPicoF1 = 9;
			long horaPicoI1 = 7;
			long horaPicoF2 = 19;
			long horaPicoI2 = 16;
			int day = dia.getDay();
			String alerta = "El vehículo tiene pico y placa";
			this.peso = Integer.parseInt(datos[0]);
			
			if ((day == 1) && (placaAux == 1 || placaAux == 2)){
				if(((hora >= horaPicoI1) && (hora < horaPicoF1)) || ((hora >= horaPicoI2) && (hora <= horaPicoF2))){
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
								alerta);
			            FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
			if ((day == 2) && (placaAux == 3 || placaAux == 4)){
				if(((hora >= horaPicoI1) && (hora < horaPicoF1)) || ((hora >= horaPicoI2) && (hora <= horaPicoF2))){	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
						alerta);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
			if ((day == 3) && (placaAux == 5 || placaAux == 6)){
				if(((hora >= horaPicoI1) && (hora < horaPicoF1)) || ((hora >= horaPicoI2) && (hora <= horaPicoF2))){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
						alerta);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
			if ((day == 4) && (placaAux == 7 || placaAux == 8)){
				if(((hora >= horaPicoI1) && (hora < horaPicoF1)) || ((hora >= horaPicoI2) && (hora <= horaPicoF2))){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
						alerta);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
			if ((day == 5) && (placaAux == 9 || placaAux == 0)){
				if(((hora >= horaPicoI1) && (hora < horaPicoF1)) || ((hora >= horaPicoI2) && (hora <= horaPicoF2))){
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pico y Placa",
							alerta);
		            FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
            revisarTonelaje(Integer.parseInt(datos[0]),hora);
            cargarChoferes(datos[0],hora);
            
            verificarPermisos(datos[2]);
		}


		private void verificarPermisos(String placa) {
			
			List<Seguro> seguros = new ArrayList<Seguro>();
			this.seguros = seguroServicio.getAll();
			String [] aux = new String[3];
			aux = placa.split(" ");		
			
			String placaAux = aux[0]+"-"+aux[1];
			//String placaAux="LBK-1110";
			String alertaPermiso= "Los permisos caducados son: ";
			Date fechaSist = new Date();
			boolean alert = false;
			
			for(int i = 0; i < this.seguros.size(); i++){
				
				if(this.seguros.get(i).getPlaca().equals(placaAux)){
					
					seguros.add(this.seguros.get(i));
		
				}
			}
			if(!seguros.isEmpty()){
				for(int i = 0; i < seguros.size(); i++){
					
					if(seguros.get(i).getFechaCaducidad().getDate() <= fechaSist.getDate()
						&&	seguros.get(i).getFechaCaducidad().getMonth() <= fechaSist.getMonth()	
							&& seguros.get(i).getFechaCaducidad().getYear() <= fechaSist.getYear())
					
					{
						alert = true;
						alertaPermiso += "\n "+ seguros.get(i).getTipo();
						
					}
				}
				if(alert){
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "RESTRICCION DE PERMISOS",
							 "El vehículo no esta habilitado para circular por Quito. \n"+alertaPermiso);
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
				
		}


		private void cargarChoferes(String peso, long hora) {
			
			 int pesoAux = Integer.parseInt(peso);
			List <String> choferesHasta5000 = new ArrayList();
			List <String> choferesMas5000 = new ArrayList();
			
		//CHOFERES LICENCIA hasta 5000kg Noche
		if(hora >= 18){	
			choferesHasta5000.add("Luis Vega: Dificultad en la noche NO. Lic: E");choferesHasta5000.add("Calos Morales: Dificultad en la noche NO. Lic: E");choferesHasta5000.add("Jaime Rendón: Dificultad en la noche NO. Lic: E");
		}	
			//CHOFERES LICENCIA hasta 5000kg Dia
		else{
			choferesHasta5000.add("Luis Vega: Dificultad en la noche NO. Lic: E");choferesHasta5000.add("Calos Morales: Dificultad en la noche NO. Lic: E");choferesHasta5000.add("Jaime Rendón: Dificultad en la noche NO. Lic: E");
			choferesHasta5000.add("Pedro Almeida: Dificultad en la noche SI. Lic: E");choferesHasta5000.add("Marco Freire: Dificultad en la noche SI. Lic: E");
		}
		
		//CHOFERES LICENCIA MAS DE  5000kg	Dia
		if(hora >= 18){	
			choferesMas5000.add("Carlos Ponce: Dificultad en la noche NO. Lic: E1");choferesMas5000.add("Juan Freire: Dificultad en la noche NO. Lic: E1");choferesMas5000.add("Pablo Herrera: Dificultad en la noche NO. Lic: E1");
			//CHOFERES LICENCIA hasta 5000kg Dia
		}	
		else{
			choferesMas5000.add("Carlos Ponce: Dificultad en la noche NO. Lic: E1");choferesMas5000.add("Juan Freire: Dificultad en la noche NO. Lic: E1");choferesMas5000.add("Pablo Herrera: Dificultad en la noche NO. Lic: E1");
			choferesMas5000.add("Juan Mera: Dificultad en la noche SI. Lic: E1");choferesMas5000.add("Martin Mora: Dificultad en la noche SI. Lic: E1");
		}	
			if( pesoAux <= 5000){this.choferesHabiles = choferesHasta5000;}
			if( pesoAux > 5000){this.choferesHabiles = choferesMas5000;}
			
		}


		private void revisarTonelaje(int tonelaje, long hora) {
			
			if((tonelaje >= 3500) && (tonelaje <= 5000)){
					if(((hora <= 20) && (hora >= 6)) || ((hora <= 9) && (hora >= 15))){
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "RESTRICCION DE PESO",
			                    "El vehículo no esta habilitado para circular por Quito a las "+hora+" horas.");
			            FacesContext.getCurrentInstance().addMessage(null, msg);
					}
			}
			if(tonelaje >= 5000){
				if(((hora <= 20) && (hora >= 6))){
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "RESTRICCION DE PESO",
							 "El vehículo no esta habilitado para circular por Quito a las "+hora+" horas.");
			            FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}
			
		}
		
		public List<Flota> getFlotas() {
			return flotas;
		}


		public void setFlotas(List<Flota> flotas) {
			this.flotas = flotas;
		}


		public Date getFechaEntrega() {
			return fechaEntrega;
		}


		public void setFechaEntrega(Date fechaEntrega) {
			this.fechaEntrega = fechaEntrega;
		}


		public List<String> getChoferesHabiles() {
			return choferesHabiles;
		}


		public void setChoferesHabiles(List<String> choferesHabiles) {
			this.choferesHabiles = choferesHabiles;
		}


		public List<Ruta> getRutasTemp() {
			return rutasTemp;
		}


		public void setRutasTemp(List<Ruta> rutasTemp) {
			this.rutasTemp = rutasTemp;
		}


		public List<PedidoRetiro> getPedidosRetiro() {
			return pedidosRetiro;
		}


		public void setPedidosRetiro(List<PedidoRetiro> pedidosRetiro) {
			this.pedidosRetiro = pedidosRetiro;
		}
		
		
}
