/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;



/**
 *
 * @author Rhoymmer Granados
 */
public class Producto_venta implements Serializable {
    
    @Id
    private int id;
    
    @Column
    private int idProducto;
    
    @Column
    private int idVenta;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

    
}
