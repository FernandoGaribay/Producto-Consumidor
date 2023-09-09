package main;

import logica.Productor;
import logica.estados.Productos;
import logica.estados.Estados;
import logica.Consumidor;
import logica.BufferListener;
import logica.Buffer;
import paneles.panelProducto;
import paneles.panelEntidad;
import java.util.ArrayList;
import java.util.List;
import static logica.estados.Estados.DURMIENDO;
import static logica.estados.Productos.GALLETA;

public class UIProductoConsumidor extends javax.swing.JFrame implements BufferListener {

    private Buffer buffer;
    private List<panelEntidad> pnlConsumidores;
    private List<panelEntidad> pnlProductores;

    public UIProductoConsumidor() {
        initComponents();
        initVariables();
        initEntidades();
    }

    public void initVariables() {
        pnlConsumidores = new ArrayList<>();
        pnlProductores = new ArrayList<>();
        buffer = new Buffer(5, 1, 1);
        buffer.addBufferListener(this); // Registra la instancia actual como oyente
    }

    public void initEntidades() {
        for (int i = 0; i < buffer.getNumConsumidores(); i++) {
            pnlConsumidores.add(new panelEntidad("src/imagenes/", "gato-dormir1.gif"));
            pnlContenedorConsumidores.add(pnlConsumidores.get(i));
        }
        for (int i = 0; i < buffer.getNumProductores(); i++) {
            pnlProductores.add(new panelEntidad("src/imagenes/", "gato-piano.gif"));
            pnlContenedorProductores.add(pnlProductores.get(i));
        }
    }

    @Override
    public void bufferActualizado(List<Productos> buffer, List<Consumidor> consumidores, List<Productor> productores) {
        pnlContenedorProductos.removeAll();

        for (int i = 0; i < buffer.size(); i++) {
            switch (buffer.get(i)) {
                case SUSHI:
                    pnlContenedorProductos.add(new panelProducto("src/imagenes/", "sushi.png"));
                    break;
                case CHEETOS:
                    pnlContenedorProductos.add(new panelProducto("src/imagenes/", "cheetos.png"));
                    break;
                case FIDEOS:
                    pnlContenedorProductos.add(new panelProducto("src/imagenes/", "fideos.png"));
                    break;
                case GALLETA:
                    pnlContenedorProductos.add(new panelProducto("src/imagenes/", "galleta.png"));
                    break;
            }
        }

        for (int i = 0; i < consumidores.size(); i++) {
            int id = i;
            Estados estado = consumidores.get(i).getEstado();

            switch (consumidores.get(i).getEstado()) {
                case DURMIENDO:
                    pnlConsumidores.get(i).setImagen("gato-dormir1.gif");
                    break;
                case CM_GALLETA:
                    pnlConsumidores.get(i).setImagen("gato-galleta.gif");
                    break;
                case CM_SUSHI:
                    pnlConsumidores.get(i).setImagen("gato-sushi.gif");
                    break;
                case CM_CHEETOS:
                    pnlConsumidores.get(i).setImagen("gato-cheto.gif");
                    break;
                case CM_FIDEOS:
                    pnlConsumidores.get(i).setImagen("gato-maruchan.gif");
                    break;
            }
            System.out.println("UI --- CONSUMIDOR: " + id + " ESTADO: " + estado);
        }

        for (int i = 0; i < productores.size(); i++) {
            int id = i;
            Estados estado = productores.get(i).getEstado();

            switch (productores.get(i).getEstado()) {
                case DURMIENDO:
                    pnlProductores.get(i).setImagen("gato-piano.gif");
                    break;
                case COCINANDO_1:
                    pnlProductores.get(i).setImagen("gato-masa.gif");
                    break;
            }
            System.out.println("UI --- PRODUCTOR: " + id + " ESTADO: " + estado);
        }

        pnlContenedorProductos.repaint();
        pnlContenedorProductos.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollContenedorProductores = new javax.swing.JScrollPane();
        pnlContenedorConsumidores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlContenedorProductos = new javax.swing.JPanel();
        scrollContenedorConsumidores = new javax.swing.JScrollPane();
        pnlContenedorProductores = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollContenedorProductores.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenedorProductores.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedorConsumidores.setLayout(new javax.swing.BoxLayout(pnlContenedorConsumidores, javax.swing.BoxLayout.Y_AXIS));
        scrollContenedorProductores.setViewportView(pnlContenedorConsumidores);

        jPanel1.add(scrollContenedorProductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 330));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlContenedorProductos.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        pnlContenedorProductos.setLayout(flowLayout1);
        jScrollPane2.setViewportView(pnlContenedorProductos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 740, 150));

        scrollContenedorConsumidores.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenedorConsumidores.setToolTipText("");
        scrollContenedorConsumidores.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedorProductores.setLayout(new javax.swing.BoxLayout(pnlContenedorProductores, javax.swing.BoxLayout.Y_AXIS));
        scrollContenedorConsumidores.setViewportView(pnlContenedorProductores);

        jPanel1.add(scrollContenedorConsumidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 190, 330));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton1.setText("INICIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 50));

        jButton2.setText("Añadir Productor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 130, -1));

        jButton3.setText("Añadir Consumidor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 320, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buffer.iniciar();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pnlConsumidores.add(new panelEntidad("src/imagenes/", "gato-dormir1.gif"));
        pnlContenedorConsumidores.add(pnlConsumidores.get(pnlConsumidores.size() - 1));
        
        pnlContenedorConsumidores.repaint();
        pnlContenedorConsumidores.revalidate();
        
        buffer.aumentarNumConsumidores();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pnlProductores.add(new panelEntidad("src/imagenes/", "gato-piano.gif"));
        pnlContenedorProductores.add(pnlProductores.get(pnlProductores.size() - 1));
        
        pnlContenedorProductores.repaint();
        pnlContenedorProductores.revalidate();
        
        buffer.aumentarNumProductores();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIProductoConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIProductoConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIProductoConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIProductoConsumidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIProductoConsumidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlContenedorConsumidores;
    private javax.swing.JPanel pnlContenedorProductores;
    private javax.swing.JPanel pnlContenedorProductos;
    private javax.swing.JScrollPane scrollContenedorConsumidores;
    private javax.swing.JScrollPane scrollContenedorProductores;
    // End of variables declaration//GEN-END:variables
}
