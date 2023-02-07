package japaneseCrossword.gui.customButtons;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class LauncherButton extends JButton {



    public LauncherButton(){

        this.setFocusable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.LIGHT_GRAY);
        this.setFont(new Font("Georgia", Font.BOLD, 25));
        this.setMargin(new Insets(1,1,1,1));
        this.setBorder(new MatteBorder(2,2,0,0, Color.LIGHT_GRAY));

    }

}
