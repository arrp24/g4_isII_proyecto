/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.web.backing;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ls.gestion.entity.Log;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.service.LogServicioLocal;
import com.ls.gestion.service.RolPorUsuarioServicioLocal;

/**
 * <b> Clase que hace la autenticacion del Usuario. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 22/06/2013 $]
 *          </p>
 */
@ManagedBean(name = "authenticationBacking")
@SessionScoped
public class AuthenticationBacking implements Serializable {

    private static final long serialVersionUID = -1007641287529158083L;
    private String cedula;
    private String clave;
    private RolPorUsuario rolPorUsuarioActual;
    private Log logIntentoAcceso = new Log();

    @EJB
    private RolPorUsuarioServicioLocal rolPorUsuarioServicio;

    @EJB
    private LogServicioLocal logServicio;

    /**
     * <b> Metodo que realiza el logeo al sistema con las credenciales que se ingresan en el login. </b>
     * <p>
     * [Author: joselo, Date: 22/06/2013]
     * </p>
     * 
     * @return String "success" cuando es exitoso o "fail" cuando no lo es.
     */
    public String login() {
        String retorno = "";
        rolPorUsuarioActual = rolPorUsuarioServicio.buscarUsuarioPorCedulaYClave(this.cedula, md5(this.clave));
        // Se crea el log que guarda constancia de que se intentó acceder al sistema
        //logIntentoAcceso.setId(null);
        logIntentoAcceso.setNombreUsuario(this.cedula);
        logIntentoAcceso.setFechaHoraAcceso(new Date());

        if (rolPorUsuarioActual != null && rolPorUsuarioActual.getClave() != null
                && rolPorUsuarioActual.getClave().equals(md5(this.clave))) {
            // Se setea el usuario y el valor de exito al log de acceso al sistema
            logIntentoAcceso.setUsuario(rolPorUsuarioActual.getUsuario());
            logIntentoAcceso.setExitoso(true);

            retorno = "success";
        } else {
            // Se setea el usuario y el valor de fracaso al log de acceso al sistema
            logIntentoAcceso.setUsuario(null);
            logIntentoAcceso.setExitoso(false);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error en el Ingreso: <em>Usuario o Clave Incorrectos</em>", null));
            retorno = "fail";
        }

        // Se manda a guardar el log de acceso al sistema
        logServicio.crearLog(logIntentoAcceso);
        return retorno;

    }

    /**
     * <b> Devuelve un digest en MD5 de una cadena pasada por parámetro. </b>
     * <p>
     * [Author: joselo, Date: 02/07/2013]
     * </p>
     * 
     * @param textoPlano
     *            Cadena a ser digerida
     * @return String con el digest en md5
     */
    public static String md5(String textoPlano) {
        try {
            final char[] hEXADECIMALES = { '0', '1', '2', '3', '4', '5', '6',
                    '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            MessageDigest msgdgt = MessageDigest.getInstance("MD5");
            byte[] bytes = msgdgt.digest(textoPlano.getBytes());
            StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int low = (int) (bytes[i] & 0x0f);
                int high = (int) ((bytes[i] & 0xf0) >> 4);
                strCryptMD5.append(hEXADECIMALES[high]);
                strCryptMD5.append(hEXADECIMALES[low]);
            }
            return strCryptMD5.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * <b> Metodo que invalida la sesion actual. </b>
     * <p>
     * [Author: joselo, Date: 22/06/2013]
     * </p>
     */
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    /**
     * <b> Metodo que comprueba si existe una sesion valida actualmente. </b>
     * <p>
     * [Author: joselo, Date: 22/06/2013]
     * </p>
     * 
     * @return True si es que la sesion es valida, false caso contrario.
     * @throws IOException
     */
    public void isLoggedIn() throws IOException {
        if (this.cedula == null || this.clave == null || this.rolPorUsuarioActual == null) {
            // TODO: verificar que se tenga permiso para acceder a la pagina
            FacesContext.getCurrentInstance().getExternalContext()
                    .responseSendError(403, "No tienes autorización para acceder a esta página");
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public RolPorUsuario getRolPorUsuarioActual() {
        return rolPorUsuarioActual;
    }

}
