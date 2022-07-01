package com.tienda.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.tienda.conexion.db.conexion;
import com.tienda.excepciones.RegisterNoEncontradoException;
import com.tienda.modelos.Categoria;
import com.tienda.modelos.Producto;
import com.tienda.modelos.Producto_venta;
import com.tienda.modelos.Vendedor;
import com.tienda.modelos.Venta;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;



public class formulariotienda extends javax.swing.JFrame {

   conexion conn;
   int cantidad = 0;
   float preciounidad = 0;
   float total = 0;
   DefaultTableModel modelo = new DefaultTableModel();
   ArrayList<listaventa>listaVenta = new ArrayList<listaventa>();
   
    public formulariotienda() {
        initComponents();
        conn = new conexion();
        cargarCategorias();
        cargarComboCategorias();
        cargarProductos();
        cargarComboProductos(null);
        cargarVendedores();
        cargarComboVendedores();
        calcularPrecio();
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("VENDEDOR");
        modelo.addColumn("TOTAL");
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nompro = new javax.swing.JLabel();
        canpro = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        totalven = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventa = new javax.swing.JTable();
        comboxpro = new javax.swing.JComboBox<Producto>();
        catpro = new javax.swing.JLabel();
        nomven = new javax.swing.JLabel();
        botagre = new javax.swing.JButton();
        spincanpro = new javax.swing.JSpinner();
        botbuscar = new javax.swing.JButton();
        comboxven = new javax.swing.JComboBox<Vendedor>();
        comboxcat = new javax.swing.JComboBox<Categoria>();
        txtprecio = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        eticomision = new javax.swing.JLabel();
        txtcomision = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botGuardar.setText("GUARDAR");
        botGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botGuardarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(567, 567, 567)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        nompro.setText("NOMBRE PRODUCTO");

        canpro.setText("CANTIDAD PRODUCTOS");

        precio.setText("PRECIO");

        totalven.setText("TOTAL VENTA");

        tablaventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaventa);

        comboxpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxproActionPerformed(evt);
            }
        });

        catpro.setText("CATEGORIA");

        nomven.setText("NOMBRE VENDEDOR");

        botagre.setText("AGREGAR");
        botagre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botagreActionPerformed(evt);
            }
        });

        spincanpro.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));
        spincanpro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spincanproStateChanged(evt);
            }
        });

        botbuscar.setText("BUSCAR");
        botbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botbuscarActionPerformed(evt);
            }
        });

        txtprecio.setText("0");
        txtprecio.setToolTipText("");

        txttotal.setText("0");

        eticomision.setText("COMISION");

        txtcomision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcomisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nompro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboxpro, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(catpro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboxcat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(canpro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(precio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(botagre))
                            .addComponent(spincanpro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomven)
                            .addComponent(eticomision))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboxven, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcomision, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalven)
                        .addGap(18, 18, 18)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botbuscar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nompro)
                    .addComponent(comboxpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botagre)
                    .addComponent(nomven)
                    .addComponent(comboxven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spincanpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catpro)
                    .addComponent(comboxcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canpro)
                    .addComponent(eticomision)
                    .addComponent(txtcomision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(botbuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botGuardar)
                    .addComponent(totalven)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cargarProductos() {
        Producto producto = new Producto();
        producto.setCodigo("0001");
        producto.setNombre("PLAYSTATION 4");
        producto.setCategoriaId(1);
        producto.setPrecio(1000f);
        conn.guardarProducto(producto);
        Producto producto1 = new Producto();
        producto1.setCodigo("0002");
        producto1.setNombre("PLAYSTATION 5");
        producto1.setCategoriaId(1);
        producto1.setPrecio(2000f);
        conn.guardarProducto(producto1);
        Producto producto2 = new Producto();
        producto2.setCodigo("0003");
        producto2.setNombre("XBOX X");
        producto2.setCategoriaId(1);
        producto2.setPrecio(2500f);
        conn.guardarProducto(producto2);
    }
    
    private void cargarComboProductos(Categoria categoria){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        try {
            List<Producto> productos = categoria==null ? conn.buscarProdutos():conn.buscarProdutosPorCategoria(categoria.getId());
            for (Producto producto : productos) {
                comboModel.addElement(producto);
            }
        } catch (RegisterNoEncontradoException e) {
            txtprecio.setText(Moneda(0f));
            JOptionPane.showMessageDialog(null, "Aviso:" + e.getMessage());
        }
        comboxpro.setModel(comboModel);
        
    }
    
    private void cargarCategorias() {
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNombre("CONSOLA");
        conn.guardarCategoria(categoria);
        Categoria categoria1 = new Categoria();
        categoria1.setId(2);
        categoria1.setNombre("VIDEO JUEGOS");
        conn.guardarCategoria(categoria1);
        Categoria categoria2 = new Categoria();
        categoria2.setId(3);
        categoria2.setNombre("ACCESORIOS");
        conn.guardarCategoria(categoria2);
    }
    
    private void cargarComboCategorias() {
        DefaultComboBoxModel comboModel2 = new DefaultComboBoxModel();
        try {
            List<Categoria> categorias = conn.buscarCategorias();
            for (Categoria c : categorias) {
                comboModel2.addElement(c);
            }
        } catch (RegisterNoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Aviso:" + e.getMessage());
        }
        comboxcat.setModel(comboModel2);
        comboxcat.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    cargarComboProductos(((Categoria)comboxcat.getSelectedItem()));
                }
            }
        });
    }
    
    private void cargarVendedores() {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(1);
        vendedor.setNombre("RHOYMMER GRANADOS");
        vendedor.setSueldo(0f);
        conn.guardarvendedor(vendedor);
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setId(2);
        vendedor1.setNombre("MILDRA ALVAREZ");
        vendedor1.setSueldo(0f);
        conn.guardarvendedor(vendedor1);
    }
    
    private void cargarComboVendedores() {
        DefaultComboBoxModel comboModel3 = new DefaultComboBoxModel();
        try {
            List<Vendedor> vendedores = conn.buscarVendedores();
            for (Vendedor vendedor : vendedores) {
                comboModel3.addElement(vendedor);
            }
        } catch (RegisterNoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Aviso:" + e.getMessage());
        }
        comboxven.setModel(comboModel3);
       
    }

    private void botGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botGuardarActionPerformed
              
        int filas = tablaventa.getRowCount();
        Vendedor vendedor = null;
        Venta venta = new Venta();
        int numeroVenta = conn.numeroVenta();
        venta.setId(numeroVenta);
        venta.setFecha(new Date());
        float totalVenta = Float.parseFloat(txttotal.getText());
        venta.setTotal(totalVenta);
        List<Producto_venta> producto_ventas = new ArrayList<Producto_venta>();
        for (int i = 0; i < filas; i++) {
            Producto_venta producto_venta = new Producto_venta();

            Producto producto = (Producto) tablaventa.getValueAt(i, 0);
            producto_venta.setIdProducto(producto.getId());
            producto_venta.setIdVenta(numeroVenta);
            producto_venta.setId(conn.idProductoVenta());
            producto_ventas.add(producto_venta);
            vendedor = (Vendedor) tablaventa.getValueAt(i, 2);
            venta.setVendedorId(vendedor.getId());
        }

       float sueldoVendedor = vendedor.getSueldo() + totalVenta ;
       vendedor.setSueldo(Float.parseFloat(txttotal.getText()));
       conn.guardarVenta(venta);
       conn.actualizarVendedor(vendedor);
       JOptionPane.showMessageDialog(null, "Aviso: Venta registrada");
            
    }//GEN-LAST:event_botGuardarActionPerformed

    private void comboxproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxproActionPerformed
        
        calcularPrecio();
    }//GEN-LAST:event_comboxproActionPerformed

    private void botagreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botagreActionPerformed

        listaventa ventas = new listaventa(); 
        ventas.setProducto((Producto)comboxpro.getSelectedItem());
        ventas.setCategoria((Categoria)comboxcat.getSelectedItem());
        ventas.setVendedor((Vendedor)comboxven.getSelectedItem());
        ventas.setVentas(cantidad*preciounidad);
        listaVenta.add(ventas);
        actualizarTabla();
    }//GEN-LAST:event_botagreActionPerformed

    private void botbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botbuscarActionPerformed
       
       String nombrvendedor = null;
       try {
		conn.buscarProdutos();
	} catch (RegisterNoEncontradoException e) {
		JOptionPane.showMessageDialog(null, "Aviso:" + e.getMessage());
	}
//       conn.buscar(nombrvendedor);
    }//GEN-LAST:event_botbuscarActionPerformed

    private void spincanproStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spincanproStateChanged
        
        calcularPrecio();
    }//GEN-LAST:event_spincanproStateChanged

    private void txtcomisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcomisionActionPerformed
        
        calcularPrecio();
    }//GEN-LAST:event_txtcomisionActionPerformed
 
    public void calcularPrecio(){
        
        preciounidad=((Producto)comboxpro.getSelectedItem()).getPrecio();
        cantidad=Integer.parseInt(spincanpro.getValue().toString());
        txtprecio.setText(Moneda(cantidad*preciounidad));
    }
        
        public String Moneda (float preciounidad){
        
        return +Math.round(preciounidad*100.0)/100.0+"";
    }
  
    public void actualizarTabla(){
        
        while (modelo.getRowCount()>0){
        
            modelo.removeRow(0);
        }
        
        float subtotal = 0;
        
        for (listaventa v : listaVenta){
            Object x[] = new Object[4];
            x[0] = v.getProducto();
            x[1] = v.getCategoria();
            x[2] = v.getVendedor();
            x[3] = v.getVentas();
            subtotal+=v.getVentas();
            modelo.addRow(x);
        }  
        
        float total = subtotal;  
        float comision = 0;
        cantidad=Integer.parseInt(spincanpro.getValue().toString());
        txttotal.setText(Moneda(total));
          
        if (cantidad <=2){
         comision = total*0.05f;
         txtcomision.setText(Moneda(comision));
        }
        
        else {
            comision = total*0.10f;
            txtcomision.setText(Moneda(comision));
        }
                
        tablaventa.setModel(modelo);
    }  
      
 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formulariotienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botGuardar;
    private javax.swing.JButton botagre;
    private javax.swing.JButton botbuscar;
    private javax.swing.JLabel canpro;
    private javax.swing.JLabel catpro;
    private javax.swing.JComboBox<Categoria> comboxcat;
    private javax.swing.JComboBox<Producto> comboxpro;
    private javax.swing.JComboBox<Vendedor> comboxven;
    private javax.swing.JLabel eticomision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nompro;
    private javax.swing.JLabel nomven;
    private javax.swing.JLabel precio;
    private javax.swing.JSpinner spincanpro;
    private javax.swing.JTable tablaventa;
    private javax.swing.JLabel totalven;
    private javax.swing.JTextField txtcomision;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

}
