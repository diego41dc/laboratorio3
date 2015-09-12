/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * IServicioVendedoresMockRemote.java Universidad de los Andes (Bogotá -
 * Colombia) Departamento de Ingeniería de Sistemas y Computación Licenciado
 * bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.List;
import javax.ejb.Remote;

/**
 * Contrato funcional de los servicios de administración de los vendedores del
 * sistema
 *
 */
@Remote
public interface IServicioVentasMockRemote {

    /**
     * Devuelve todos las ventas del sistema
     *
     * @return ventas Vendedores del sistema
     */
    public List<RegistroVenta> getVentas();
}
