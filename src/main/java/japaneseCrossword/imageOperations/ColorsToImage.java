package japaneseCrossword.imageOperations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorsToImage {

    public static BufferedImage transformColorsToImage(Color[][] colors){

        BufferedImage newImage = new BufferedImage(colors[0].length, colors.length, BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < newImage.getHeight(); y++){
            for(int x = 0; x < newImage.getWidth(); x++){

                Color pixel = colors[y][x];
                newImage.setRGB(x, y, pixel.getRGB());

            }
        }

        return newImage;
    }

}
