/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author pp
 */
public class Validador {

    public boolean validarVacio(String texto) {
        if (texto.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarCombo(String texto) {
        if (texto.equals("Seleccione")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarNumeroEntero(String texto) {
        int valor;
        try {
            valor = Integer.parseInt(texto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validarNumeroEntero(int idproducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
