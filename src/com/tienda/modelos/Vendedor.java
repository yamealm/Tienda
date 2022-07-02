
package com.tienda.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;


public class Vendedor implements Serializable {

    @Id
    private int id;

    @Column
    private String nombre;

    @Column
    private Float sueldo;

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

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public String toString() {
        return this.nombre;
    }

}
