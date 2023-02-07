package imageEditor;

import java.awt.*;

public class RgbTransformer {

    public static int[][][] transformRGB(int[][] pixels){

        int[][][] newPixels = new int[pixels.length][pixels[0].length][3];

        for(int i = 0; i < pixels.length; i++){

            for(int j = 0; j < pixels[i].length; j++){

                Color color = new Color(pixels[i][j]);
                int[] colorRgb = {
                        color.getRed(),
                        color.getGreen(),
                        color.getBlue()
                };
                newPixels[i][j] = colorRgb;
                System.out.print("("+colorRgb[0]+" "+colorRgb[1]+" "+colorRgb[2]+") ");
            }
            System.out.println();
        }
        return newPixels;

    }

}
