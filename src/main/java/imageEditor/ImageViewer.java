package imageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageViewer {

    public static JFrame showImage(BufferedImage image){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(image);

        JLabel label = new JLabel();
        label.setLayout(new FlowLayout());
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setIcon(imageIcon);

        frame.add(label);
        frame.pack();
        frame.setVisible(true);

        return frame;
    }

}
