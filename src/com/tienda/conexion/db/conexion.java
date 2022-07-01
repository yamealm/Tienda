package com.tienda.conexion.db;

import java.util.ArrayList;
import java.util.List;
import com.tienda.excepciones.RegisterNoEncontradoException;
import com.tienda.modelos.Categoria;
import com.tienda.modelos.Producto;
import com.tienda.modelos.Vendedor;
import com.tienda.modelos.Venta;

public class conexion {

    private List<Categoria> categorias = new ArrayList<Categoria>();
    private List<Producto> productos = new ArrayList<Producto>();
    private List<Vendedor> vendedores = new ArrayList<Vendedor>();
    private List<Venta> ventas = new ArrayList<Venta>();
    private int numeroVenta = 1;
    private int idProductoVenta =1;

    

    public conexion() {

       
    }

  
    public void guardarvendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public Vendedor buscarVendedor(String nombreVendedor) throws RegisterNoEncontradoException {
        Vendedor vendedor = null;
        for (Vendedor ven : vendedores) {
            if (ven.getNombre().equals(nombreVendedor)) {
                vendedor = ven;
            }
        }
        if (vendedor == null) {
            throw new RegisterNoEncontradoException("Vendedor no encontrado");
        }
        return vendedor;
    }

	

    public List<Vendedor> buscarVendedores() throws RegisterNoEncontradoException {
        return vendedores;
    }
    
    public void actualizarVendedor(Vendedor vendedor) {
        for (Vendedor ven : vendedores) {
            if (vendedor.getId() == ven.getId()) {
                ven.setSueldo(vendedor.getSueldo());
            }
        }
    }

    public void guardarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> buscarProdutos() throws RegisterNoEncontradoException {
        return productos;
    }

    public List<Producto> buscarProdutosPorCategoria(int categoriaId) throws RegisterNoEncontradoException {
        List<Producto> list = new ArrayList<Producto>();
        for (Producto p : productos) {
            if (p.getCategoriaId()==categoriaId) {
                list.add(p);
            }
        }
        return list;
    }

    public Producto buscarProdutoPorCodigo(String codigo) throws RegisterNoEncontradoException {
       Producto producto = null;
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                producto = p;
            }
        }
        if (producto == null) {
            throw new RegisterNoEncontradoException("Vendedor no encontrado");
        }
        return producto;
    }
    
    public void guardarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }
       
    public List<Categoria> buscarCategorias() throws RegisterNoEncontradoException {
        return categorias;
    }
    
    public void guardarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> buscarVentasPorVendedor(int vendedorId) throws RegisterNoEncontradoException {
        List<Venta> list = new ArrayList<Venta>();
        for (Venta v : ventas) {
            if (v.getVendedorId()==vendedorId) {
                list.add(v);
            }
        }
        if (list.isEmpty()) {
            throw new RegisterNoEncontradoException("El vendedor no posee ventas realizadas");
        }
        return list;
    }
    
    public float calcularSueldoVendedor(int vendedorId) {
        float sueldo = 0f;
        for (Venta v : ventas) {
            if (v.getVendedorId()==vendedorId) {
                sueldo += v.getTotal();
            }
        }
        return sueldo;
    }
    
    public int numeroVenta() {
        return numeroVenta ++;
    }
     
    public int idProductoVenta() {
        return idProductoVenta ++;
    }
}
