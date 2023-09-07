package main;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageHandler {

    private static String dirImagen;

    public ImageHandler(String dirImagen) {
        this.dirImagen = dirImagen;
    }

    public ImageIcon redimencionarImagen(String nombreImagen, Dimension dimension) {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(dirImagen + nombreImagen));
        Image originalImage = originalIcon.getImage();

        int labelWidth = (int) dimension.getWidth();
        int labelHeight = (int) dimension.getHeight();

        Image resizedImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        return resizedIcon;
    }

    public static String getDirImagen() {
        return dirImagen;
    }

    public static void setDirImagen(String aDirImagen) {
        dirImagen = aDirImagen;
    }
}
