package japaneseCrossword.imageOperations;

import java.awt.image.BufferedImage;

public class ColorsToGreyConverter {

    public static BufferedImage imageToBW(BufferedImage image){

        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage imageBW = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);

        for(int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){

                imageBW.setRGB(x, y, image.getRGB(x, y));

            }
        }

        return imageBW;
    }

}
