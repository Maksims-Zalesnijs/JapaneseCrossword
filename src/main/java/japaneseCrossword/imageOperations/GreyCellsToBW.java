package japaneseCrossword.imageOperations;

import java.awt.*;

public class GreyCellsToBW {

    public static Color[][] greyCellsToBW(Color[][] cells){

        Color[][] newCells = new Color[cells.length][cells[0].length];
        int highestRed = 0;
        int lowestRed = 255;
        int avgRed;

        for(int y = 0; y < cells.length; y++){
            for(int x = 0; x < cells[0].length; x++){

                if(cells[y][x].getRed() > highestRed){
                    highestRed = cells[y][x].getRed();
                }
                if(cells[y][x].getRed() < lowestRed){
                    lowestRed = cells[y][x].getRed();
                }

            }
        }

        avgRed = (highestRed + lowestRed) / 2;

        for(int y = 0; y < cells.length; y++){
            for(int x = 0; x < cells[0].length; x++){

                if(cells[y][x].getRed() > avgRed){
                    newCells[y][x] = new Color(255,255,255);
                } else {
                    newCells[y][x] = new Color(0,0,0);
                }

            }
        }
        return newCells;
    }

}
