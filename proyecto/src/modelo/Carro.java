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
public class Carro {

    private int idcarro;
    private Date fecha_creacion;
    private Cliente cliente;

    public Carro() {
    }

    public Carro(int idcarro, Date fecha_creacion, Cliente cliente) {
        this.idcarro = idcarro;
        this.fecha_creacion = fecha_creacion;
        this.cliente = cliente;
    }

    public int getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
