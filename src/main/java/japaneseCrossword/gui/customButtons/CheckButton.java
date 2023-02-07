package japaneseCrossword.gui.customButtons;

import javax.swing.*;
import java.awt.*;

public class CheckButton extends JButton {

    public CheckButton(String text){
        this.setBackground(new Color(200,170,150));
        this.setForeground(new Color(80,40,30));
        this.setFont(new Font("Georgia", Font.BOLD, 20));
        this.setFocusable(false);
        this.setText(text);
    }

}
