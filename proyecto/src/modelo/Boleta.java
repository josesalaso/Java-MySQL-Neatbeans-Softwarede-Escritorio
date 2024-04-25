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
public class Boleta {

    private int idboleta;
    private Date fecha_emision;
    private Pedido pedido;

    public Boleta() {
    }

    public Boleta(int idboleta, Date fecha_emision, Pedido pedido) {
        this.idboleta = idboleta;
        this.fecha_emision = fecha_emision;
        this.pedido = pedido;
    }

    public int getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(int idboleta) {
        this.idboleta = idboleta;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
