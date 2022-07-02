
package com.tienda.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;


public class Categoria implements Serializable {
    
    @Id
    private int id;
        
    @Column
    private String nombre;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString() {
        return this.nombre;
    }
    
}
