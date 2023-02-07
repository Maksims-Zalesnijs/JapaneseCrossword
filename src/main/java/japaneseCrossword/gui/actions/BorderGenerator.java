package japaneseCrossword.gui.actions;

import japaneseCrossword.gui.customButtons.GridButton;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class BorderGenerator {

    public static GridButton generateBorder(GridButton button, int startXCoord, int startYCoord,
                                            int currentX, int currentY, int width, int height){

        int rightBorder = 0;
        int bottomBorder = 0;
        int topBorder = 1;
        int leftBorder = 1;

        if(currentX == width-1) rightBorder = 1;
        if(currentY == height-1) bottomBorder = 1;
        if((currentX-startXCoord) % 5 == 0 && currentX-startXCoord >= 0) leftBorder = 4;
        if((currentY-startYCoord) % 5 == 0 && currentY-startYCoord >= 0) topBorder = 4;

        button.setBorder(new MatteBorder(topBorder,leftBorder,bottomBorder,rightBorder, new Color(75,75,75)));

        return button;
    }

}
