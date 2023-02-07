package japaneseCrossword.imageOperations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageRead {

    public static BufferedImage readImage(String filePath){

            BufferedImage image = null;

            try{

                image = ImageIO.read(new File(filePath));

            } catch(Exception ex){

            }

            return image;
        }


}
