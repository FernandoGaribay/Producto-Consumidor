package main;

import java.util.List;

public class UIProductoConsumidor extends javax.swing.JFrame implements BufferListener {

    private Buffer buffer;

    public UIProductoConsumidor() {
        initComponents();
        buffer = new Buffer(10);
        Productor p1 = new Productor(buffer);
        Productor p2 = new Productor(buffer);
        Consumidor c1 = new Consumidor(buffer);

        p1.start();
        p2.start();
        c1.start();
        buffer.addBufferListener(this); // Registra la instancia actual como oyente

        panelEntidad productor1 = new panelEntidad("src/imagenes/", "gato-cocina.gif");
        panelEntidad productor2 = new panelEntidad("src/imagenes/", "gato-masa.gif");
        pnlContenedorProductores.add(productor1);
        pnlContenedorProductores.add(productor2);

        panelEntidad consumidor1 = new panelEntidad("src/imagenes/", "gato-pizza.gif");
        panelEntidad consumidor2 = new panelEntidad("src/imagenes/", "gato-sushi.gif");
        pnlContenedorConsumidores.add(consumidor1);
        pnlContenedorConsumidores.add(consumidor2);
    }

    @Override
    public void bufferActualizado(List<Character> buffer) {
        pnlContenedorProductos.removeAll();
        for (int i = 0; i < buffer.size(); i++) {
            pnlContenedorProductos.add(new panelProducto("src/imagenes/", "cheetos.png"));
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
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 320, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
