package imageEditor;

import java.awt.image.BufferedImage;

public class BlackWhiteTransformer {

    public static BufferedImage imageToBlackWhite(BufferedImage image){

        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage imageBW = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);

        int[][] pixels = new int[h][w];

        for(int i = 0; i < h; i++){

            for(int j = 0; j < w; j++){

                imageBW.setRGB(j, i, image.getRGB(j, i));

            }

        }

        return imageBW;
    }

}
