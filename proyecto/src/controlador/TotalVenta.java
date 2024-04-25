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
public interface TotalVenta {

    //TRES CONSTANTES (IVA Y 2 DESCUENTOS DISTINTOS) 
    double IVA = 0.19;
    double DESCUENTO_A = 0.2;
    double DESCUENTO_B = 0.1;

    //METODOS ABSTRACTOS 
    public int obtenerIva();

    public int obtenerDescuento();

    public abstract int obtenerTotal();

}
