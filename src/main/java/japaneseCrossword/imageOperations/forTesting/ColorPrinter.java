package japaneseCrossword.imageOperations.forTesting;

import java.awt.*;

public class ColorPrinter {

    public static void printColor(Color[][] colors){
        for(int y = 0; y < colors.length; y++){
            for(int x = 0; x < colors[0].length; x++){
                int r = colors[y][x].getRed();
//                int g = colors[y][x].getGreen();
//                int b = colors[y][x].getBlue();
//                System.out.print("(" + r + " " + g + " " + b + ")");
                if(r < 128){
                    System.out.print(" XX");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

}
