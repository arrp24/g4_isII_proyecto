package com.ls.gestion.web.backing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import net.sf.jasperreports.engine.util.MessageUtil;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.UploadedFile;
import com.ls.gestion.entity.Archivo;
import com.ls.gestion.service.ArchivoServicioLocal;


@ManagedBean(name = "archivoBacking")
@ViewScoped

public class ArchivoBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ArchivoServicioLocal archivoServicio;
	
	private List<Archivo> archivos;
	private Archivo archivo;
	private UploadedFile file;
	private String path2 = "";
	private String circuns = "";
	private int tipo;
	private int eleccion;
	private Archivo selectedArchivo;
	private String autoMapa;
	private String autoImagen;
	private String autoDocumento;
	private int id;
	
	
	
	@PostConstruct
	public void init() {

		this.archivos = archivoServicio.getAll();
		
	}
	
	public ArchivoBacking() {
		this.archivo = new Archivo();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Archivo getSelectedArchivo() {
		return selectedArchivo;
	}

	public void setSelectedArchivo(Archivo selectedArchivo) {
		this.selectedArchivo = selectedArchivo;
	}

	public ArchivoServicioLocal getArchivoServicio() {
			return archivoServicio;
		}
	
		public void setArchivoServicio(ArchivoServicioLocal archivoServicio) {
			this.archivoServicio = archivoServicio;
		}
	
		public List<Archivo> getArchivos() {
			return archivos;
		}
	
		public void setArchivos(List<Archivo> archivos) {
			this.archivos = archivos;
		}
	
		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public Archivo getArchivo() {
			return archivo;
		}
	
		public void setArchivo(Archivo archivo) {
			this.archivo = archivo;
		}
	
	
		public int getEleccion() {
			return eleccion;
		}

		public void setEleccion(int eleccion) {
			this.eleccion = eleccion;
		}


		public UploadedFile getFile() {
			return file;
		}


		public void setFile(UploadedFile file) {
			this.file = file;
		}


		public String getPath2() {
			return path2;
		}


		public void setPath2(String path2) {
			this.path2 = path2;
		}


		public String getCircuns() {
			return circuns;
		}


		public void setCircuns(String circuns) {
			this.circuns = circuns;
		}
		
	
		public String getAutoMapa() {
			return autoMapa;
		}

		public void setAutoMapa(String autoMapa) {
			this.autoMapa = autoMapa;
		}

		public String getAutoImagen() {
			return autoImagen;
		}

		public void setAutoImagen(String autoImagen) {
			this.autoImagen = autoImagen;
		}

		public String getAutoDocumento() {
			return autoDocumento;
		}

		public void setAutoDocumento(String autoDocumento) {
			this.autoDocumento = autoDocumento;
		}

		public void onRowToggle(ToggleEvent event) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Usuario " + event.getVisibility(), "Titulo: "
							+ ((Archivo) event.getData()).getDescripcion());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		
		public void handleFileUpload(FileUploadEvent event) {  
				
			/*try{			
				 file = event.getFile();
				
				//File targetFolder = new File("");
				InputStream inputStream = file.getInputstream();
				path = ""+event.getFile().getFileName();
				OutputStream out = new FileOutputStream(new File(path));				
				int read = 0;
				byte[] bytes = new byte[1024];
				
				while ((read = inputStream.read(bytes)) != -1) {	
					out.write(bytes, 0, read);
				}
		
				
				inputStream.close();
				out.flush();
				out.close();
				
				} catch (IOException e) {
					
				e.printStackTrace();
			
				}	*/
			
			
			@SuppressWarnings("unused")
				String path = "";
				file = event.getFile();
						 
				 String flag = "";
			        String os = System.getProperty("os.name").toLowerCase();
			        if (os.indexOf("win") >= 0)
			            flag = "\\";
			        else 
			            flag = "/";

				    FacesContext ctx = FacesContext.getCurrentInstance();
				    path = ctx.getExternalContext().getRealPath("/")
					    + "docs"+flag;
				    path2 = "../../docs/";
				   
				 
				    	
				    try{			
						 file = event.getFile();
						
						File targetFolder = new File(path);
						InputStream inputStream = file.getInputstream();
						path = ""+event.getFile().getFileName();
						path2 = path2+path;
						OutputStream out = new FileOutputStream(new File(targetFolder,
								event.getFile().getFileName()));				
						int read = 0;
						byte[] bytes = new byte[1024];
						
						while ((read = inputStream.read(bytes)) != -1) {	
							out.write(bytes, 0, read);
						}
						
						inputStream.close();
						out.flush();
						out.close();
						
						} catch (IOException e) {
							
						e.printStackTrace();
					}
				
		}

/*		
		public void crearArchivo(){
		
			String tipoArchivo = path2.substring(path2.length()-3, path2.length());
			archivo = archivoServicio.buscarArchivoPorCodigo(Integer.parseInt(circuns));
			
			
			if (tipoArchivo.contains("jpg"))
			{
				
				archivo.setPathImagen(path2);
			}
			
			if (tipoArchivo.contains("pdf"))
			{
				
				archivo.setPathPdf(path2);
			}		
			
				
			archivoServicio.actualizarArchivo(archivo);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Subida Exitosa",
					"Se ha subido un nuevo archivo exitosamente!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
		
		
		public void actualizarArchivo() {
			
			if (path2 != "")
			{
				if (tipo==1)
				{
					
					selectedArchivo.setPathImagen(path2);
					this.archivo.setAutoImagen(false);
				}
				
				if (tipo==2)
				{
					
					selectedArchivo.setPathDocumento(path2);
					this.archivo.setAutoDocumento(false);
				}		
					
				if (tipo==3)
				{
					
					selectedArchivo.setPathPdf(path2);
					this.archivo.setAutoPdf(false);
				}		
				
			}
			
			if (autoImagen.equals("0")|| autoImagen.equals("1"))
			{
				if (autoImagen.equals("0"))
				{
					selectedArchivo.setAutoImagen(false);
				}
				
				if (autoDocumento.equals("1"))
				{
					selectedArchivo.setAutoImagen(true);
				}
			}
			
			if (autoDocumento.equals("0")|| autoDocumento.equals("1"))
			{
				if (autoDocumento.equals("0"))
				{
					selectedArchivo.setAutoDocumento(false);
				}
				if (autoDocumento.equals("1"))
				{
					selectedArchivo.setAutoDocumento(true);
				}
			}
			if (autoMapa.equals("0")|| autoMapa.equals("1"))
			{
				if (autoMapa.equals("0"))
				{
					selectedArchivo.setAutoPdf(false);
				}	
				
				if (autoDocumento.equals("1"))
				{
					selectedArchivo.setAutoPdf(true);
				}
			}
				
		
			archivoServicio.actualizarArchivo(this.selectedArchivo);
			FacesMessage msg = new FacesMessage
					
					
					(FacesMessage.SEVERITY_INFO,
					"Actualización Exitosa",
					"Se ha actualizado exitosamente el documento \""
							+ this.selectedArchivo.getDescripcion() + "\"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedArchivo = null;
		}


		public void crearArchivoNuevo(){
						
			String tipoArchivo = path2.substring(path2.length()-3, path2.length());
						
			if (tipo==1)
			{
				
				this.archivo.setPathImagen(path2);
				this.archivo.setAutoImagen(false);
			}
			
			if (tipo==2)
			{
				
				this.archivo.setPathDocumento(path2);
				this.archivo.setAutoDocumento(false);
			}		
				
			if (tipo==3)
			{
			
				this.archivo.setPathPdf(path2);
				this.archivo.setAutoPdf(false);
			}		

			archivoServicio.crearArchivo(this.archivo);
			archivo = new Archivo();
			archivos = archivoServicio.getAll();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Subida Exitosa",
					"Se ha subido un nuevo archivo exitosamente!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
			
		public List<Archivo> presentacionAutorizados()
		{
			
			List<Archivo> autorizados = this.getArchivos();
			 for (int i=0; i<autorizados.size(); i++)
			 {     
				 if (autorizados.get(i).getAutoDocumento().equals(false)&& autorizados.get(i).getAutoImagen().equals(false) && autorizados.get(i).getAutoPdf().equals(false))

				 {
					autorizados.remove(i); 					 
				 }				 
			 }
			 
			 return autorizados;
		}
		*/
	/*	
		public List<Archivo> presentacionNoAutorizados()
		{
			
			List<Archivo> noAutorizados = this.getArchivos();
			 for (int i=0; i<noAutorizados.size(); i++)
			 {
				 if (noAutorizados.get(i).getAutoDocumento()==true && noAutorizados.get(i).getAutoImagen()==true && noAutorizados.get(i).getAutoPdf()==true )
				 {
					 noAutorizados.remove(i); 					 
				 }				 
			 }
			 
			 return noAutorizados;
		}
				
		
		public String eleccionImagen(int ele)
		{
			
			String pathArchivo = "";
				Archivo buscado =archivoServicio.buscarArchivoPorCodigo(ele);
				pathArchivo = buscado.getPathImagen();
			
			return pathArchivo;
			
		}
		
		
		public String obtenerUrlMapa(Archivo archivoPdf)
		{
						
			if (archivoPdf.getAutoPdf() == true)
			{    return archivoPdf.getPathPdf();}
			else
			{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error de Selección",
						"Ha ocurrido un error al seleccionar el documento");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		}
		

		public String obtenerUrlImagen(Archivo archivoPdf)
		{
						
			if (archivoPdf.getAutoImagen() == true)
			{    return archivoPdf.getPathImagen();}
			else
			{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error de Selección",
						"Ha ocurrido un error al seleccionar el documento");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		}
		

		public String obtenerUrlDocumento(Archivo archivoPdf)
		{
			
			if (archivoPdf.getAutoDocumento() == true)
			{    return archivoPdf.getPathDocumento();}
			else
			{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error de Selección",
						"Ha ocurrido un error al seleccionar el documento");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			}
		}
		*/
		
		public void eliminarArchivo() {
			if (this.selectedArchivo != null) {
				archivoServicio.eliminarArchivo(selectedArchivo.getId());

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Eliminación Exitosa",
						"Se ha borrado exitosamente el archivo \""
								+ this.selectedArchivo.getDescripcion() + "\"");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				this.selectedArchivo = null;
				this.archivos = archivoServicio.getAll();
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error de Selección",
						"Ha ocurrido un error al seleccionar el documento");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
}
	
	
