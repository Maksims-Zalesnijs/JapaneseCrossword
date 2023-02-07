package japaneseCrossword.imageOperations;

import java.awt.*;

public class ColorsToInt {

    public static int[][] colorsToZeroOne(Color[][] colors){

        int[][] pixels = new int[colors.length][colors[0].length];
        for(int y = 0; y < colors.length; y++){
            for(int x = 0; x < colors[0].length; x++){

                if(colors[y][x].getRed() < 128){
                    pixels[y][x] = -1;
                } else {
                    pixels[y][x] = -2;
                }

            }
        }
        return pixels;

    }

}
