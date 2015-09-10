/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author da.lozano13
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal,IServicioCatalogoMockRemote {

     /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    @Override
    public void agregarMueble(Mueble mueble) {
        try {
            persistencia.create(mueble);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @Override
    public List<Mueble> darMuebles() {
        return persistencia.findAll(Mueble.class);
    }

    @Override
    public void removerEjemplarMueble(long id) {
        Mueble m = (Mueble)persistencia.findById(Mueble.class, id);
        m.setCantidad(m.getCantidad()-1);
    }

    @Override
    public void eliminarMueble(long id) {
        try {
            persistencia.delete((persistencia.findById(Mueble.class, id)));
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
