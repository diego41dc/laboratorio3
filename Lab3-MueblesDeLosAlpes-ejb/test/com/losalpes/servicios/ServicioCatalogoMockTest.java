/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * ServicioCatalogoMockTest.java Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación Licenciado bajo el
 * esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.TipoMueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.Properties;
import javax.naming.InitialContext;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de realizar pruebas unitarias
 *
 */
public class ServicioCatalogoMockTest {
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de catalogo en el sistema
     */
    private IServicioCatalogoMockRemote servicio;

    //-----------------------------------------------------------
    // Métodos de inicialización y terminación
    //-----------------------------------------------------------
    /**
     * Método que se ejecuta antes de comenzar la prueba unitaria Se encarga de
     * inicializar todo lo necesario para la prueba
     */
    @Before
    public void setUp() throws Exception {
        try {
            Properties env = new Properties();
            env.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            env.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            env.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext contexto;
            contexto = new InitialContext(env);
            servicio = (IServicioCatalogoMockRemote) contexto.lookup("com.losalpes.servicios.IServicioCatalogoMockRemote");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //-----------------------------------------------------------
    // Métodos de prueba
    //-----------------------------------------------------------
    /**
     * Método de prueba para agregar un mueble al sistema
     *
     * @throws com.losalpes.excepciones.OperacionInvalidaException
     */
    @Test
    public void testAgregarMueble() throws OperacionInvalidaException {
        Mueble mueble = new Mueble(8L, "Sala Comedor Combo", "Con diseño antiguo, perfecto para casas amplias de diseño colonial", TipoMueble.Interior, 85, "sillaClasica", 1000000);
        servicio.agregarMueble(mueble);
        assertTrue(servicio.darMuebles().contains(mueble));
    }

    /**
     * Método de prueba para eliminar un vendedor al sistema
     */
    @Test
    public void testEliminarMueble() throws OperacionInvalidaException {
        servicio.eliminarMueble(1L);
    }

}
