package imageEditor;

import japaneseCrossword.imageOperations.*;
import japaneseCrossword.imageOperations.forTesting.ImageViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {

        BufferedImage image = ImageRead.readImage("C:\\Users\\Max\\Pictures\\from_java\\thumbs_up.png");
        BufferedImage imageBW = ColorsToGreyConverter.imageToBW(image);
        System.out.println(imageBW.getWidth());
        System.out.println(imageBW.getHeight());
        Color[][] colors = ImageToColors.imageToColorArray(imageBW);
        Color[][] resizedImage = ImageSizeCorrector.resizeImage(colors, 30);
        imageBW = ColorsToImage.transformColorsToImage(resizedImage);

        JFrame frame = ImageViewer.showImage(imageBW);
        System.out.println(imageBW.getWidth());
        System.out.println(imageBW.getHeight());
//        int[][] pixels = ImageToArray.getPixelsFromImage(image);
//        RgbTransformer.transformRGB(pixels);

    }
}
