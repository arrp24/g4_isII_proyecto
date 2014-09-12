package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Local;
import com.ls.gestion.entity.OpcionMenu;

@Local
public interface OpcionMenuServicioLocal {

    /**
     * <b> Se recupera el listado total de los opcionMenues </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @return
     */
    List<OpcionMenu> buscarOpcionMenu();

    /**
     * <b> Se crea un nuevo OpcionMenu </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @param opcionMenu
     * @return
     */
    void crearOpcionMenu(OpcionMenu opcionMenu);

    /**
     * Se actualiza un opcionMenu <b> Incluir aqui­ la descripcion del metodo. </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @param opcionMenu
     * @return
     */
    void actualizarOpcionMenu(OpcionMenu opcionMenu);

    /**
     * <b> Devuelve una opcionMenu de acuerdo al PK. </b>
     * <p>
     * [Author: joselo, Date: 05/07/2013]
     * </p>
     * 
     * @return OpcionMenu encontrada
     */
    public OpcionMenu buscarPorId(String id);

}
