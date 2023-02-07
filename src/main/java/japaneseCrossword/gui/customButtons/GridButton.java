package japaneseCrossword.gui.customButtons;

import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton {


    private int buttonState;

    private int contentCode;

    public GridButton(){
        buttonState = 0;
        this.setFocusable(false);
        this.setMargin(new Insets(0,0,0,0));
    }

    public int getButtonState() {
        return buttonState;
    }

    public int getContentCode() {
        return contentCode;
    }

    public void setButtonState(int buttonState) {
        this.buttonState = buttonState;
        if(buttonState == -1) {
            contentCode = -1;
            this.setBackground(Color.BLACK);
            this.setText("");
        }
        if(buttonState == -2) {
            contentCode = -2;
            this.setBackground(Color.WHITE);
            this.setText("");
        }
        if(buttonState == -3) {
            contentCode = -2;
            this.setBackground(Color.WHITE);
            this.setForeground(Color.BLACK);
            this.setText("X");
        }

    }

}
