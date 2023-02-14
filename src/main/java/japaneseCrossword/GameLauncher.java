package japaneseCrossword;

import imageEditor.ImageReader;
import japaneseCrossword.gui.GameBoard;
import japaneseCrossword.imageOperations.*;
import japaneseCrossword.imageOperations.forTesting.ImageViewer;
import japaneseCrossword.logic.FieldGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameLauncher {

    private BufferedImage image;
    private boolean isImageResized;
    private int heightInCells;

    public GameLauncher(BufferedImage image, boolean isImageResized, int height){
        this.image = image;
        this.isImageResized = isImageResized;
        this.heightInCells = height;
    }

    public boolean launchGame(){

        boolean isSuccess = true;

        try {

            image = ColorsToGreyConverter.imageToBW(image);
            Color[][] colors = ImageToColors.imageToColorArray(image);

            if(isImageResized){
                colors = ImageSizeCorrector.resizeImage(colors, heightInCells);
                colors = ImageToCells.imageToCells(colors, colors.length/heightInCells);
                colors = GreyCellsToBW.greyCellsToBW(colors);
            }

//            BufferedImage imageBW = ColorsToImage.transformColorsToImage(colors);
//            JFrame frame = ImageViewer.showImage(imageBW);

            int[][] pixels = ColorsToInt.colorsToZeroOne(colors);

            pixels = RemoveWhiteLines.removeWhiteLines(pixels);
            pixels = FieldGenerator.generateField(pixels);

            GameBoard gameBoard = new GameBoard(pixels);
        } catch (Exception ex){
            isSuccess = false;
            ex.printStackTrace();
        }

        return isSuccess;
    }

}
