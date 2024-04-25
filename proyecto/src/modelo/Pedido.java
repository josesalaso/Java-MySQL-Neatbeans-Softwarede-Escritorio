/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author pp
 */
public class Pedido {

    private int idpedido;
    private Date fecha_pedido;
    private String direccion_envio;
    private Carro carro;

    public Pedido() {
    }

    public Pedido(int idpedido, Date fecha_pedido, String direccion_envio, Carro carro) {
        this.idpedido = idpedido;
        this.fecha_pedido = fecha_pedido;
        this.direccion_envio = direccion_envio;
        this.carro = carro;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

}
