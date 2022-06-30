package com.tienda.conexion.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.tienda.controladores.listaventa;
import com.tienda.excepciones.RegisterNoEncontradoException;
import com.tienda.modelos.Categoria;
import com.tienda.modelos.Producto;
import com.tienda.modelos.Vendedor;

public class conexion {

	public static Connection con;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306/tienda?characterEncoding=utf8";


	public void guardar(listaventa[] listado) {

		PreparedStatement ps;
		String sql;

		try {
			con = getConnection();
			sql = "INSERT INTO producto(nom_pro, categoria, venta) values(?,?,?)";
			ps = con.prepareStatement(sql);

			for (int i = 0; i < listado.length; i++) {

				ps.setString(1, listado[i].getProducto());
				ps.setString(2, listado[i].getCategoria());
				ps.setDouble(3, listado[i].getVenta());
				ps.executeUpdate();

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
	}

	public void guardarvendedor(Vendedor vendedor) {

		PreparedStatement ps;
		String sql;

		try {
			con = getConnection();
			sql = "INSERT INTO vendedor(nombre,sueldo) values(?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, vendedor.getNombre());
			ps.setFloat(2, vendedor.getSueldo());

			ps.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
	}
	
	public void guardarProducto(Producto producto) {

		PreparedStatement ps;
		String sql;

		try {
			con = getConnection();
			sql =  "INSERT INTO producto(codigo, nombre, categoriaId, precio) values(?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, producto.getCodigo());
			ps.setString(2, producto.getNombre());
			ps.setInt(3, producto.getCategoria().getId());
			ps.setFloat(4, producto.getPrecio());

			ps.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
	}

	public conexion() {

		con = null;
		try {

			Class.forName(DRIVER);
			con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);

			if (con != null) {

				System.out.println("CONEXION EXITOSA");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR AL CONECTAR" + e);
		}
	}

	public Connection getConnection() {
		return con;
	}

	public void buscarVendedor(String nombreVendedor) throws RegisterNoEncontradoException {
		Vendedor vendedor = null;
		PreparedStatement ps;
		String sql;
		try {
			con = getConnection();
			sql = "SELECT * FROM tienda.vendedor where nombre = " + nombreVendedor;
			ps = con.prepareStatement(sql);

			ResultSet rsl = ps.executeQuery();

			while (rsl.next()) {
				vendedor = new Vendedor();
				vendedor.setId(rsl.getInt(1));
				vendedor.setNombre(rsl.getString(2));
				vendedor.setSueldo(rsl.getFloat(3));
			}

			System.out.println("busqueda de vendedor");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
		if (vendedor == null) {
			throw new RegisterNoEncontradoException("Vendedor no encontrado");
		}
	}

	public List<Vendedor> buscarVendedores() throws RegisterNoEncontradoException {
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		PreparedStatement ps;
		String sql;
		try {
			con = getConnection();
			sql = "SELECT * FROM tienda.vendedor";
			ps = con.prepareStatement(sql);

			ResultSet rsl = ps.executeQuery();

			while (rsl.next()) {
				Vendedor vendedor = new Vendedor();
				vendedor.setId(rsl.getInt(1));
				vendedor.setNombre(rsl.getString(2));
				vendedor.setSueldo(rsl.getFloat(3));
				vendedores.add(vendedor);
			}

			System.out.println("busqueda de vendedor");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
		if (vendedores.isEmpty()) {
			throw new RegisterNoEncontradoException("Vendedores no encontrado");
		}
		return vendedores;
	}
	
	public List<Categoria> buscarCategorias() throws RegisterNoEncontradoException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		PreparedStatement ps;
		String sql;
		try {
			con = getConnection();
			sql = "SELECT * FROM tienda.categoria" ;
			ps = con.prepareStatement(sql);

			ResultSet rsl = ps.executeQuery();

			while (rsl.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rsl.getInt(1));
				categoria.setNombre(rsl.getString(2));

				categorias.add(categoria);
			}

			System.out.println("busqueda de categoria");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
		if (categorias.isEmpty()) {
			throw new RegisterNoEncontradoException("Vendedores no encontrado");
		}
		return categorias;
	}

	public List<Producto> buscarProdutos() throws RegisterNoEncontradoException {
		PreparedStatement ps;
		String sql;

		List<Producto> productos = new ArrayList<Producto>();

		try {
			con = getConnection();
			sql = "SELECT * FROM tienda.producto";
			ps = con.prepareStatement(sql);

			ResultSet rsl = ps.executeQuery();

			while (rsl.next()) {
				Producto producto = new Producto();
				producto.setId(rsl.getInt(1));
				producto.setCodigo(rsl.getString(2));
				producto.setNombre(rsl.getString(3));
				Categoria categoria = new Categoria();
				categoria.setId(rsl.getInt(4));
				producto.setCategoria(categoria);
				producto.setPrecio(rsl.getFloat(5));
				productos.add(producto);
			}
			System.out.println("busqueda");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
		if (productos.isEmpty()) {
			throw new RegisterNoEncontradoException("Productos no encontrados");
		}
		return productos;
	}
        
        public List<Producto> buscarProdutosPorCategoria(int categoriaId) throws RegisterNoEncontradoException {
		PreparedStatement ps;
		String sql;

		List<Producto> productos = new ArrayList<Producto>();

		try {
			con = getConnection();
			sql = "SELECT * FROM tienda.producto where categoriaId="+categoriaId;
			ps = con.prepareStatement(sql);

			ResultSet rsl = ps.executeQuery();

			while (rsl.next()) {
				Producto producto = new Producto();
				producto.setId(rsl.getInt(1));
				producto.setCodigo(rsl.getString(2));
				producto.setNombre(rsl.getString(3));
				Categoria categoria = new Categoria();
				categoria.setId(rsl.getInt(4));
				producto.setCategoria(categoria);
				producto.setPrecio(rsl.getFloat(5));
				productos.add(producto);
			}
			System.out.println("busqueda");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
		if (productos.isEmpty()) {
			throw new RegisterNoEncontradoException("Productos no encontrados");
		}
		return productos;
	}

	public Producto buscarProdutoPorCodigo(String codigo) throws RegisterNoEncontradoException {
		Producto producto = null;
		PreparedStatement ps;
		String sql;

		try {
			con = getConnection();
			sql = "SELECT * FROM tienda.producto where codigo= '" + codigo + "'";
			ps = con.prepareStatement(sql);

			ResultSet rsl = ps.executeQuery();

			while (rsl.next()) {
				producto = new Producto();
				producto.setId(rsl.getInt(1));
				producto.setCodigo(rsl.getString(2));
				producto.setNombre(rsl.getString(3));
				Categoria categoria = new Categoria();
				categoria.setId(rsl.getInt(4));
				producto.setCategoria(categoria);
				producto.setPrecio(rsl.getFloat(5));
			}

			System.out.println("busqueda");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
		}
		if (producto == null) {
			throw new RegisterNoEncontradoException("Producto no encontrado");
		}

		return producto;
	}

}
