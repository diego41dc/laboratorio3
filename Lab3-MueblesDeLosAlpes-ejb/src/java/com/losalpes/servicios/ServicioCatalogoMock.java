/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author da.lozano13
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal, IServicioCatalogoMockRemote {

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;

    @Override
    public void agregarMueble(Mueble mueble) throws OperacionInvalidaException {
        try {
            persistencia.create(mueble);
        } catch (OperacionInvalidaException ex) {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    public List<Mueble> darMuebles() {
        return persistencia.findAll(Mueble.class);
    }

    @Override
    public void removerEjemplarMueble(long id) throws OperacionInvalidaException {
        try {
            Mueble m = (Mueble) persistencia.findById(Mueble.class, id);
            m.setCantidad(m.getCantidad() - 1);
        } catch (Exception ex) {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    public void eliminarMueble(long id) throws OperacionInvalidaException {
        try {
            persistencia.delete((persistencia.findById(Mueble.class, id)));
        } catch (OperacionInvalidaException ex) {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }
}
