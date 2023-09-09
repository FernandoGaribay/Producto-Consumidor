package paneles;

public class panelProducto extends javax.swing.JPanel {

    private String dirImagen;
    private String imagen;
    
    public panelProducto(String dirImagen, String imagen) {
        initComponents();
        
        this.dirImagen = dirImagen;
        this.imagen = imagen;
        this.setImagen(imagen);
    }
    
    public void setImagen(String imagen){
        lblImagen.setSize(120, 120);
        rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, dirImagen + imagen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagen.setMaximumSize(new java.awt.Dimension(120, 120));
        lblImagen.setMinimumSize(new java.awt.Dimension(120, 120));
        lblImagen.setPreferredSize(new java.awt.Dimension(120, 120));
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 120));
    }// </editor-fold>//GEN-END:initComponents

    public String getDirImagen() {
        return dirImagen;
    }

    public void setDirImagen(String dirImagen) {
        this.dirImagen = dirImagen;
    }

    public javax.swing.JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(javax.swing.JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables


}
