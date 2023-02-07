package imageEditor;

import javax.swing.*;
import java.awt.*;

public class ColorMix {

    public static Color myColor() {
        Color c1 = new Color(150,28,100);
        Color c2 = new Color(63,120,204);
        Color c3 = new Color(150,53,50);
        Color c4 = new Color(200,73,164);

        Color[] colorSet = {c1, c2, c3, c4};
        Color customColor = averageColor(colorSet);

        return customColor;

    }

    private static Color averageColor(Color[] colors){

        float avRed = 0;
        float avGreen = 0;
        float avBlue = 0;

        for(Color c:colors){
            avRed = avRed + (float)c.getRed()/colors.length;
            avGreen = avGreen + (float)c.getGreen()/colors.length;
            avBlue = avBlue + (float)c.getBlue()/colors.length;
        }
        System.out.println((int)avRed+" "+(int)avGreen+" "+(int)avBlue);
        return new Color((int)avRed, (int)avGreen, (int)avBlue);

    }

}
