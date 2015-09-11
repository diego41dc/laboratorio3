/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * IServicioCatalogoMockRemote.java Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación Licenciado bajo el
 * esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Remote;

/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 *
 */
@Remote
public interface IServicioCatalogoMockRemote {

    /**
     * Agrega un mueble al sistema
     *
     * @param mueble Nuevo mueble
     * @throws com.losalpes.excepciones.OperacionInvalidaException
     */
    public void agregarMueble(Mueble mueble) throws OperacionInvalidaException;

    /**
     * Elimina un mueble del sistema
     *
     * @param id Identificador único del mueble a eliminar
     * @throws com.losalpes.excepciones.OperacionInvalidaException
     */
    public void eliminarMueble(long id) throws OperacionInvalidaException;

    /**
     * Devuelve todos los muebles del sistema
     *
     * @return muebles Lista de muebles
     */
    public List<Mueble> darMuebles();

    /**
     * Remueve un ejemplar del mueble (no el mueble)
     *
     * @param id Identificador único del mueble
     * @throws com.losalpes.excepciones.OperacionInvalidaException
     */
    public void removerEjemplarMueble(long id) throws OperacionInvalidaException;

}
