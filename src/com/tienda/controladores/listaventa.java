
package com.tienda.controladores;
import com.tienda.modelos.Vendedor;
import com.tienda.modelos.Producto;
import com.tienda.modelos.Categoria;


public class listaventa{
    
       Producto producto;
       Cantidad cantidad;
       Categoria categoria;
       Vendedor vendedor;
       float ventas;
       
       public listaventa(){
} 

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
       
    public Cantidad getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Cantidad cantidad) {
        this.cantidad = cantidad;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public float getVentas() {
        return ventas;
    }

    public void setVentas(float ventas) {
        this.ventas = ventas;
    }
       
    
}