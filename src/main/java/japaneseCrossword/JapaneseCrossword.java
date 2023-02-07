package japaneseCrossword;

import imageEditor.ImageReader;
import japaneseCrossword.gui.GameBoard;
import japaneseCrossword.gui.Launcher;
import japaneseCrossword.imageOperations.ColorsToInt;
import japaneseCrossword.imageOperations.ImageRead;
import japaneseCrossword.imageOperations.ImageTransformer;
import japaneseCrossword.imageOperations.RemoveWhiteLines;
import japaneseCrossword.imageOperations.forTesting.ColorPrinter;
import japaneseCrossword.logic.FieldGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JapaneseCrossword {

    private GameBoard gameBoard;
    private BufferedImage bi;
    Color[][] colors;

    public JapaneseCrossword(){

        bi = ImageReader.readImage("C:\\Users\\Max\\Pictures\\from_java\\houses.png");
        colors = ImageTransformer.imageToColorArray(bi);
        GameBoard gameBoard;
    }

    public void runGame(){

        BufferedImage image = bi;
        Color[][] colors = ImageTransformer.imageToColorArray(image);
        int[][] pixels = ColorsToInt.colorsToZeroOne(colors);

        pixels = RemoveWhiteLines.removeWhiteLines(pixels);
        pixels = FieldGenerator.generateField(pixels);

//        DemoPicture d = new DemoPicture();
        Launcher launcher = new Launcher();
//        gameBoard = new GameBoard(pixels);
    }

    public void runDemo(){
        DemoPicture demoPicture = new DemoPicture();
        gameBoard = new GameBoard(demoPicture.getDemo());
    }

}
