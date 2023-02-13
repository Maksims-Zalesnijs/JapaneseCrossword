package japaneseCrossword.imageOperations;

import java.awt.*;

public class ImageToCells {

    public static Color[][] imageToCells(Color[][] image, int cellSize){

        Color[][] greyCells = new Color[image.length / cellSize][image[0].length / cellSize];

        for(int yy = 0; yy < image.length; yy += cellSize){
            for(int xx = 0; xx < image[0].length; xx += cellSize){

                int avgRed;
                int totalRed = 0;
                int totalPixels = cellSize * cellSize;

                for(int y = 0; y < cellSize; y++){
                    for(int x = 0; x < cellSize; x++){

                        totalRed += image[yy+y][xx+x].getRed();

                    }
                }

                avgRed = totalRed/totalPixels;
                greyCells[yy/cellSize][xx/cellSize] = new Color(avgRed, avgRed, avgRed);
            }

        }
        return greyCells;
    }

}
