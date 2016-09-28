
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JuanAndrés
 */
public class DiccionarioTest {
    
    public DiccionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertarNodo method, of class Diccionario.
     */
    @Test
    public void testInsertarNodo() {
        System.out.println("insertarNodo");
        BinaryTree<Association<String, String>> padre = null;
        Association<String, String> dato = null;
        Diccionario instance = new Diccionario();
        instance.insertarNodo(padre, dato);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of traducirPalabra method, of class Diccionario.
     */
    @Test
    public void testTraducirPalabra() {
        System.out.println("traducirPalabra");
        BinaryTree<Association<String, String>> padre = null;
        String palabra = "";
        Diccionario instance = new Diccionario();
        String expResult = "";
        String result = instance.traducirPalabra(padre, palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
