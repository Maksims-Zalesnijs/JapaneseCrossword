package japaneseCrossword.logic;

import japaneseCrossword.logic.fieldGeneratorTools.FillButtonPart;
import japaneseCrossword.logic.fieldGeneratorTools.FillDefault;
import japaneseCrossword.logic.fieldGeneratorTools.FillNumberPart;
import japaneseCrossword.logic.fieldGeneratorTools.MostLinesInRow;

import java.util.ArrayList;

public class FieldGenerator {


    //Main method for testing
    //
//    public static void main(String[] args) {
//        BufferedImage image = ImageRead.readImage("C:\\Users\\Max\\Pictures\\from_java\\mushroom.png");
//        Color[][] colors = ImageTransformer.imageToColorArray(image);
//        int[][] pixels = ColorsToInt.colorsToZeroOne(colors);
//
//
//
//        pixels = generateField(pixels);
//        ColorPrinter.printColor(colors);
//
//        GameBoard gameBoard = new GameBoard(pixels);
//
//    }
    //
    //End of Main


    public static int[][] generateField(int[][] pixels){

        int[][] updatedPixels;

        ArrayList<Integer>[] horizontalLines = checkHorizontalLines(pixels);
        ArrayList<Integer>[] verticalLines = checkVerticalLines(pixels);

        int xStartCoord = MostLinesInRow.findMostLines(horizontalLines);
        int yStartCoord = MostLinesInRow.findMostLines(verticalLines);

        updatedPixels = new int[pixels.length + yStartCoord][pixels[0].length + xStartCoord];

        updatedPixels = FillDefault.fillAllCells(updatedPixels);
        updatedPixels = FillButtonPart.fillButtons(pixels, updatedPixels, xStartCoord, yStartCoord);
        updatedPixels = FillNumberPart.fillNumberPart(updatedPixels, verticalLines, xStartCoord, yStartCoord, true);
        updatedPixels = FillNumberPart.fillNumberPart(updatedPixels, horizontalLines, xStartCoord, yStartCoord, false);

        return updatedPixels;
        }



//    private methods

    private static ArrayList<Integer>[] checkHorizontalLines(int[][] pixels){

        ArrayList<Integer>[] lists = new ArrayList[pixels.length];

        for(int y = 0; y < pixels.length; y++){

            lists[y] = LineCounter.countLines(pixels[y]);
        }

        return lists;

    }

    private static ArrayList<Integer>[] checkVerticalLines(int[][] pixels){

        ArrayList<Integer>[] lists = new ArrayList[pixels[0].length];

        for(int x = 0; x < pixels[0].length; x++){

            int[] numbers = new int[pixels.length];
            for(int y = 0; y < pixels.length; y++){

                numbers[y] = pixels[y][x];

            }

            lists[x] = LineCounter.countLines(numbers);

        }

        return lists;
    }

}
