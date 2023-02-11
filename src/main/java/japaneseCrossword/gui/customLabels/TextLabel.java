package japaneseCrossword.gui.customLabels;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {

    public TextLabel(String text){
        this.setOpaque(true);
        this.setForeground(Color.DARK_GRAY);
        this.setBackground(Color.LIGHT_GRAY);
        this.setFont(new Font("Georgia", Font.BOLD, 20));
        this.setText(text);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

}
