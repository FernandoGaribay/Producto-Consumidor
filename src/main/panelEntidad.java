package main;

public class panelEntidad extends javax.swing.JPanel {

    private String dirImagen;
    private String imagen;

    public panelEntidad(String dirImagen, String imagen) {
        initComponents();

        this.dirImagen = dirImagen;
        this.imagen = imagen;
        this.setImagen(imagen);
    }

    public void setImagen(String imagen) {
        lblImagen.setSize(140, 140);
        rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, dirImagen + imagen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 140, 140));
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
