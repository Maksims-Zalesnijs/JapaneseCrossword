package imageEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        BufferedImage image = ImageReader.readImage("C:\\Users\\Max\\Pictures\\from_java\\thumbs_up.png");
        BufferedImage imageBW = BlackWhiteTransformer.imageToBlackWhite(image);

        JFrame frame = ImageViewer.showImage(imageBW);
//        int[][] pixels = ImageToArray.getPixelsFromImage(image);
//        RgbTransformer.transformRGB(pixels);

    }
}
