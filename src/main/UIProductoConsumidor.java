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

public class UIProductoConsumidor extends javax.swing.JFrame implements BufferListener {

    private Buffer buffer;
    private List<panelEntidad> pnlConsumidores;
    private List<panelEntidad> pnlProductores;

    // <editor-fold defaultstate="collapsed" desc="Constructor e Inicializadores"> 
    public UIProductoConsumidor() {
        initComponents();
        initVariables();
        initEntidades();
    }

    public void initVariables() {
        pnlConsumidores = new ArrayList<>();
        pnlProductores = new ArrayList<>();
        buffer = new Buffer(5, 1, 1);
        buffer.addBufferListener(this);
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualizador Buffer UI">
    @Override
    public void bufferActualizado(List<Productos> buffer, List<Consumidor> consumidores, List<Productor> productores) {
        elementosBuffer(buffer);
        elementosConsumidores(consumidores);
        elementosProductores(productores);
    }

    private void elementosBuffer(List<Productos> buffer) {
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
                case PIZZA:
                    pnlContenedorProductos.add(new panelProducto("src/imagenes/", "pizza.png"));
                    break;
            }
        }

        pnlContenedorProductos.repaint();
        pnlContenedorProductos.revalidate();
    }

    private void elementosConsumidores(List<Consumidor> consumidores) {
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
                case CM_PIZZA:
                    pnlConsumidores.get(i).setImagen("gato-pizza.gif");
                    break;
            }
            System.out.println("UI --- CONSUMIDOR: " + id + " ESTADO: " + estado);
        }
    }

    private void elementosProductores(List<Productor> productores) {
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
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        scrollContenedorProductores = new javax.swing.JScrollPane();
        pnlContenedorConsumidores = new javax.swing.JPanel();
        scrollContenedorProductos = new javax.swing.JScrollPane();
        pnlContenedorProductos = new javax.swing.JPanel();
        scrollContenedorConsumidores = new javax.swing.JScrollPane();
        pnlContenedorProductores = new javax.swing.JPanel();
        pnlConfiguracion = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        btnAñadirProductor = new javax.swing.JButton();
        btnAñadirConsumidor = new javax.swing.JButton();
        btnEliminarConsumidor = new javax.swing.JButton();
        btnEliminarProductor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollContenedorProductores.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenedorProductores.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedorConsumidores.setLayout(new javax.swing.BoxLayout(pnlContenedorConsumidores, javax.swing.BoxLayout.Y_AXIS));
        scrollContenedorProductores.setViewportView(pnlContenedorConsumidores);

        background.add(scrollContenedorProductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 330));

        scrollContenedorProductos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollContenedorProductos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlContenedorProductos.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        pnlContenedorProductos.setLayout(flowLayout1);
        scrollContenedorProductos.setViewportView(pnlContenedorProductos);

        background.add(scrollContenedorProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 740, 150));

        scrollContenedorConsumidores.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenedorConsumidores.setToolTipText("");
        scrollContenedorConsumidores.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedorProductores.setLayout(new javax.swing.BoxLayout(pnlContenedorProductores, javax.swing.BoxLayout.Y_AXIS));
        scrollContenedorConsumidores.setViewportView(pnlContenedorProductores);

        background.add(scrollContenedorConsumidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 190, 330));

        pnlConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 50));

        btnAñadirProductor.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnAñadirProductor.setText("Añadir Productor");
        btnAñadirProductor.setToolTipText("");
        btnAñadirProductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProductorActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnAñadirProductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 30));

        btnAñadirConsumidor.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnAñadirConsumidor.setText("Añadir Consumidor");
        btnAñadirConsumidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirConsumidorActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnAñadirConsumidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 30));

        btnEliminarConsumidor.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnEliminarConsumidor.setText("Eliminar Consumidor");
        btnEliminarConsumidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConsumidorActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnEliminarConsumidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 140, 30));

        btnEliminarProductor.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnEliminarProductor.setText("Eliminar Productor");
        btnEliminarProductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductorActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnEliminarProductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 125, 140, 30));

        background.add(pnlConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 320, 330));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        buffer.iniciar();
        btnIniciar.setEnabled(false);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnAñadirConsumidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirConsumidorActionPerformed
        pnlConsumidores.add(new panelEntidad("src/imagenes/", "gato-dormir1.gif"));
        pnlContenedorConsumidores.add(pnlConsumidores.get(pnlConsumidores.size() - 1));

        pnlContenedorConsumidores.repaint();
        pnlContenedorConsumidores.revalidate();

        buffer.aumentarNumConsumidores();
    }//GEN-LAST:event_btnAñadirConsumidorActionPerformed

    private void btnAñadirProductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProductorActionPerformed
        pnlProductores.add(new panelEntidad("src/imagenes/", "gato-piano.gif"));
        pnlContenedorProductores.add(pnlProductores.get(pnlProductores.size() - 1));

        pnlContenedorProductores.repaint();
        pnlContenedorProductores.revalidate();

        buffer.aumentarNumProductores();
    }//GEN-LAST:event_btnAñadirProductorActionPerformed

    private void btnEliminarConsumidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConsumidorActionPerformed
        if (buffer.getNumConsumidores() > 0) {
            pnlConsumidores.remove(pnlConsumidores.size() - 1);
            pnlContenedorConsumidores.remove(pnlContenedorConsumidores.getComponents().length - 1);

            pnlContenedorConsumidores.repaint();
            pnlContenedorConsumidores.revalidate();

            buffer.disminuirNumConsumidores();
        }
    }//GEN-LAST:event_btnEliminarConsumidorActionPerformed

    private void btnEliminarProductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductorActionPerformed
        if (buffer.getNumProductores()> 0) {
            pnlProductores.remove(pnlProductores.size() - 1);
            pnlContenedorProductores.remove(pnlContenedorProductores.getComponents().length - 1);

            pnlContenedorProductores.repaint();
            pnlContenedorProductores.revalidate();

            buffer.disminuirNumProductores();
        }
    }//GEN-LAST:event_btnEliminarProductorActionPerformed

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
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAñadirConsumidor;
    private javax.swing.JButton btnAñadirProductor;
    private javax.swing.JButton btnEliminarConsumidor;
    private javax.swing.JButton btnEliminarProductor;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel pnlConfiguracion;
    private javax.swing.JPanel pnlContenedorConsumidores;
    private javax.swing.JPanel pnlContenedorProductores;
    private javax.swing.JPanel pnlContenedorProductos;
    private javax.swing.JScrollPane scrollContenedorConsumidores;
    private javax.swing.JScrollPane scrollContenedorProductores;
    private javax.swing.JScrollPane scrollContenedorProductos;
    // End of variables declaration//GEN-END:variables
}
