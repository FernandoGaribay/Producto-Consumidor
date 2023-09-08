package main;

import java.awt.Dimension;

public class panelProducto extends javax.swing.JPanel {

    private ImageHandler objImagen;
    private String imagen;
    
    public panelProducto(String imagen) {
        initComponents();
        
        this.objImagen = new ImageHandler("/imagenes/");
        this.imagen
    }
    
    public void setImagen(String imagen){
        this.lblImagen.setIcon(objImagen.redimencionarImagen(imagen, new Dimension(210, 210)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 210));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}
