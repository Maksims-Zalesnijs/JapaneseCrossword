package japaneseCrossword.imageOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTransformer {

    public static Color[][] imageToColorArray(BufferedImage image){

        Color[][] imageColors = new Color[image.getHeight()][image.getWidth()];

        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                imageColors[y][x] = new Color(image.getRGB(x, y));
            }
        }
        return imageColors;

    }

}
