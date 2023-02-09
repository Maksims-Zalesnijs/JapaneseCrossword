package japaneseCrossword;

import japaneseCrossword.gui.GameBoard;
import japaneseCrossword.logic.FieldGenerator;

public class DemoLauncher {

    public void runDemo(){
        DemoPicture demoPicture = new DemoPicture();
        int[][] pixels = FieldGenerator.generateField(demoPicture.getDemo());
        GameBoard gameBoard = new GameBoard(pixels);
    }

}
