
package formulario;

public class listaventa{
    
       String producto;
       String categoria;
       String vendedor;
       double ventas;
       
       public listaventa(){
} 
    public String getProducto(){
           
           return producto;
    }
       public void setProducto (String producto){
           
           this.producto=producto;
       }
     
       public String getCategoria(){
           
           return categoria;
    }
       public void setCategoria (String categoria){
           
           this.categoria=categoria;
       }      
           public String getVendedor(){
           
           return vendedor;
    }
       public void setVendedor (String vendedor){
           
           this.vendedor=vendedor;
       }
       public double getVenta(){
           
           return ventas;
    }
       public void setVenta (double ventas){
           
           this.ventas=ventas;
       }

}