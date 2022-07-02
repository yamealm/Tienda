
package com.tienda.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;


public class Producto implements Serializable {
    
    @Id
    private int id;
    
    @Column
    private String codigo;
    
    @Column
    private String nombre;
    
    @Column
    private int categoriaId;
    
    @Column
    private Float precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    public String toString() {
        return this.nombre;
    }
    
    
}
