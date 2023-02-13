package japaneseCrossword.gui.customButtons;

import javax.swing.*;
import java.awt.*;

public class menuButton extends JButton {

    public menuButton(String text){
        this.setBackground(new Color(200,170,150));
        this.setForeground(new Color(80,40,30));
        this.setFont(new Font("Georgia", Font.BOLD, 18));
        this.setFocusable(false);
        this.setText(text);
    }

}
