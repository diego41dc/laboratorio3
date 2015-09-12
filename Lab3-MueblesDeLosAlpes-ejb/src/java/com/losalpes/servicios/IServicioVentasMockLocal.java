/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * IServicioVentasMockLocal.java Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación Licenciado bajo el
 * esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.List;
import javax.ejb.Local;

/**
 * Servicios para consulta de ventas del sistema
 *
 */
@Local
public interface IServicioVentasMockLocal {

    /**
     * Devuelve todos las ventas del sistema
     *
     * @return ventas Vendedores del sistema
     */
    public List<RegistroVenta> getVentas();
}
