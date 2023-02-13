package japaneseCrossword.imageOperations;

import imageEditor.Main;

import java.awt.*;

public class ImageSizeCorrector {

    public static Color[][] resizeImage(Color[][] image, int heightInCells){

        Color[][] resizedImage;
        int cellSize;
        int widthInCells;
        int currentHeight = image.length;
        int currentWidth = image[0].length;
        int xStartCoord;
        int yStartCoord;

        cellSize = (int) Math.floor(currentHeight/heightInCells);
        int newHeight = heightInCells * cellSize;
        widthInCells = (int) Math.floor(currentWidth/cellSize);
        int newWidth = widthInCells * cellSize;

        yStartCoord = (int) Math.floor((currentHeight - newHeight) /2);
        xStartCoord = (int) Math.floor((currentWidth - newWidth) /2);

        resizedImage = new Color[newHeight][newWidth];

        for(int y = 0; y < resizedImage.length; y++){
            for(int x = 0; x < resizedImage[0].length; x++){

                resizedImage[y][x] = image[yStartCoord + y][xStartCoord + x];

            }
        }

        return resizedImage;
    }

}
