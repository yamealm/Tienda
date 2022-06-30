/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;



/**
 *
 * @author Rhoymmer Granados
 */
public class Venta implements Serializable {
    
    @Id
    private int id;
    
    @Column
    private Date fecha;
    
    @Column
    private float total;
    
    @Column
    private Vendedor vendedorId;
    
    @Column
    private List<Producto> productos;
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Vendedor getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(Vendedor vendedorId) {
		this.vendedorId = vendedorId;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

    
}
