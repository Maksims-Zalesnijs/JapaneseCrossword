package imageEditor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageReader {

    public static BufferedImage readImage(String filepath){
        BufferedImage image = null;

        try{

            image = ImageIO.read(new File(filepath));

        } catch(Exception ex){

        }

        return image;
    }

}
