package trabajopractico;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import formulario.listaventa;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;

public class conexion {
    
    public static Connection con;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/venta";
    private String producto;
    private String categoria;
    private String vendedor;
    private double ventas;
    
    public void guardar(listaventa[] listado){
        
            PreparedStatement ps;
            String sql;
       
            
            try {
                con = getConnection();
                sql = "INSERT INTO producto(nom_pro, categoria, venta) values(?,?,?)";
                ps = con.prepareStatement(sql);
                
                for(int i=0; i<listado.length; i++){
                
                ps.setString(1, listado[i].getProducto());
                ps.setString(2, listado[i].getCategoria());
                ps.setDouble(3, listado[i].getVenta());
                ps.executeUpdate();
                
                }
         }   
              catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
            }
    }  
    
    
    public void guardarvendedor(String nombrevendedor ,String valor, String sueldo){
        
            PreparedStatement ps;
            String sql;

            try {
                con = getConnection();
                sql = "INSERT INTO vendedor(nombreven) values(?)";
                ps = con.prepareStatement(sql);
                  
                ps.setString(1, nombrevendedor);
                ps.setDouble(2, Double.parseDouble(valor));
                ps.setDouble(3, Double.parseDouble(sueldo));
                
                ps.executeUpdate();
                
                
         }   
              catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
            }
    } 
    
    public conexion() {
       
        con = null;
        try{
            
            Class.forName(DRIVER);
            con = (Connection)DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (con != null){
                
                System.out.println("CONEXION EXITOSA");
            }
        }catch (ClassNotFoundException | SQLException e){
            
        System.out.println("ERROR AL CONECTAR"+e);
        }
    }  
        
        public Connection getConnection(){
        return con;
        }
    
    public void buscar(String nombrvendedor){
        
            PreparedStatement ps;
            String sql;
       
            
            try {
                con = getConnection();
                sql = "SELECT * FROM venta.vendedor where nombreven = "+nombrvendedor;
                ps = con.prepareStatement(sql);
                
                
                ResultSet rsl = ps.executeQuery();
                
                while (rsl.next()) {
                System.out.println("valor 1 " + rsl.getString(1) + " valor 2 " + rsl.getString(2)+ " valor 3 " + rsl.getString(3));
                 }
                
                System.out.println("busqueda");
                
         }   
              catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
            }
    }
    
    public List<Producto> buscarProdutos(){
        
            PreparedStatement ps;
            String sql;
       
            List<Producto> productos = new ArrayList<Producto>();
            
            try {
                con = getConnection();
                sql = "SELECT * FROM venta.producto";
                ps = con.prepareStatement(sql);
                
                
                ResultSet rsl = ps.executeQuery();
                
                while (rsl.next()) {
                    Producto producto = new Producto();
                    producto.setCodigo(rsl.getString(1));
                    producto.setNombre(rsl.getString(2));
                    producto.setCategoria(rsl.getString(3));
                    producto.setPrecio(rsl.getFloat(4));
                    productos.add(producto);
                    System.out.println("valor 1 " + rsl.getString(1) + " valor 2 " + rsl.getString(2)+ " valor 3 " + rsl.getString(3));
                }
                
                System.out.println("busqueda");
                
         }   
              catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR DE GUARDADO:" + e.getMessage());
            }
            
            return productos;
    }
    
    
}
  