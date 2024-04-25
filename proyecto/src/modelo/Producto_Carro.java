/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pp
 */
public class Producto_Carro {

    private Producto producto;
    private Carro carro;
    private int precio_venta;
    private int cantidad;

    public Producto_Carro() {
    }

    public Producto_Carro(Producto producto, Carro carro, int precio_venta, int cantidad) {
        this.producto = producto;
        this.carro = carro;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
