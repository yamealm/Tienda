
package com.tienda.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;


public class Venta implements Serializable {
    
    @Id
    private int id;
    
    @Column
    private Date fecha;
    
    @Column
    private float total;
    
    @Column
    private int vendedorId;
    
    @Column
    private List<Producto_venta> productos;
 

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

	public int getVendedorId() {
		return vendedorId;
	}

	public void setVendedorId(int vendedorId) {
		this.vendedorId = vendedorId;
	}

	public List<Producto_venta> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto_venta> productos) {
		this.productos = productos;
	}

    
}
