/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author pp
 */
public class Estado {

    private int idestado;
    private Pedido pedido;
    private Date fecha_estado;
    private String fase;

    public Estado() {
    }

    public Estado(int idestado, Pedido pedido, Date fecha_estado, String fase) {
        this.idestado = idestado;
        this.pedido = pedido;
        this.fecha_estado = fecha_estado;
        this.fase = fase;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Date getFecha_estado() {
        return fecha_estado;
    }

    public void setFecha_estado(Date fecha_estado) {
        this.fecha_estado = fecha_estado;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

}
