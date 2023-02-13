package japaneseCrossword;

import imageEditor.ImageReader;
import japaneseCrossword.gui.GameBoard;
import japaneseCrossword.imageOperations.ColorsToInt;
import japaneseCrossword.imageOperations.ImageToColors;
import japaneseCrossword.imageOperations.RemoveWhiteLines;
import japaneseCrossword.logic.FieldGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameLauncher {

    private BufferedImage image;
    private String filePath;

    public GameLauncher(BufferedImage image){
        this.image = image;
    }

    public boolean launchGame(){

        boolean isSuccess = true;

        try {
//            BufferedImage image = ImageReader.readImage(filePath);
            Color[][] colors = ImageToColors.imageToColorArray(image);
            int[][] pixels = ColorsToInt.colorsToZeroOne(colors);

            pixels = RemoveWhiteLines.removeWhiteLines(pixels);
            pixels = FieldGenerator.generateField(pixels);

            GameBoard gameBoard = new GameBoard(pixels);
        } catch (Exception ex){
            isSuccess = false;
        }

        return isSuccess;
    }

}
