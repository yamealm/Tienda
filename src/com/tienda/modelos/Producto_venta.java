
package com.tienda.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

public class Producto_venta implements Serializable {
    
    @Id
    private int id;
    
    @Column
    private int idProducto;
    
    @Column
    private int idCantidad;
    
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
        
        public int getIdCantidad() {
		return idCantidad;
	}

	public void setIdCantidad(int idCantidad) {
		this.idCantidad = idCantidad;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

    
}
