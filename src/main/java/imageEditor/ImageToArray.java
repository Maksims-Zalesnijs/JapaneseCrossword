package imageEditor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class ImageToArray {

    public static int[][] getPixelsFromImage(BufferedImage image){

        int w = image.getWidth();
        int h = image.getHeight();

        int[][] pixels = new int[h][w];

        for(int i = 0; i < h; i++){

            for(int j = 0; j < w; j++){

                pixels[i][j] = image.getRGB(j, i);

                //System.out.print(pixels[i][j]+" ");

            }
            //System.out.println();

        }

        return pixels;
    }

}
