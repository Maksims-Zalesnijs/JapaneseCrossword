package imageEditor;

import javax.swing.*;
import java.awt.*;

public class ColoredBackground {
    public static void main(String[] args) {

        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBounds(100,100,300,300);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setBackground(new Color(-14666560));
        frame.add(label);

        Color c = new Color(-1);
        //System.out.println(c.getRed()+" "+c.getGreen()+" "+c.getBlue());

        label.setBackground(ColorMix.myColor());
        frame.setVisible(true);


    }
}
