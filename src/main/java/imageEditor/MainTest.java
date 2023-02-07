package imageEditor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {

        BufferedImage image = ImageReader.readImage("C:\\Users\\Max\\Pictures\\from_java\\testImage.png");

        int[][] pixels = ImageToArray.getPixelsFromImage(image);

        Color c1 = new Color(-1237980);
        Color c2 = new Color(-12629812);
        Color c3 = new Color(-3584);
        Color c4 = new Color(-6075996);

    }
}
