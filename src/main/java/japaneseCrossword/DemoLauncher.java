package japaneseCrossword;

import japaneseCrossword.gui.GameBoard;

public class DemoLauncher {

    public void runDemo(){
        DemoPicture demoPicture = new DemoPicture();
        GameBoard gameBoard = new GameBoard(demoPicture.getDemo());
    }

}
