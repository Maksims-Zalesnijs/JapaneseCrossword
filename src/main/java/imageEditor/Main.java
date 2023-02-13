package imageEditor;

import japaneseCrossword.imageOperations.*;
import japaneseCrossword.imageOperations.forTesting.ImageViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {

        int heightInCells = 25;

        BufferedImage image = ImageRead.readImage("C:\\Users\\Max\\Pictures\\from_java\\thumbs_up.png");
        BufferedImage imageBW = ColorsToGreyConverter.imageToBW(image);
        System.out.println(imageBW.getWidth());
        System.out.println(imageBW.getHeight());
        Color[][] colors = ImageToColors.imageToColorArray(imageBW);
        Color[][] resizedImage = ImageSizeCorrector.resizeImage(colors, heightInCells);
        Color[][] greyCells = ImageToCells.imageToCells(resizedImage, resizedImage.length/heightInCells);
        imageBW = ColorsToImage.transformColorsToImage(greyCells);


        JFrame frame = ImageViewer.showImage(imageBW);
        System.out.println(imageBW.getWidth());
        System.out.println(imageBW.getHeight());
//        int[][] pixels = ImageToArray.getPixelsFromImage(image);
//        RgbTransformer.transformRGB(pixels);

    }
}
