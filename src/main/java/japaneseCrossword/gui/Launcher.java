package japaneseCrossword.gui;

import imageEditor.ImageReader;
import japaneseCrossword.DemoLauncher;
import japaneseCrossword.GameLauncher;
import japaneseCrossword.gui.customButtons.LauncherButton;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Launcher implements ActionListener {

    private JFrame frame;
    private JPanel buttonPanel, plusMinusPanel;
    private JLabel label, sizeLabel;
    private JButton startButton, selectFileButton, runDemoButton, exitButton, plusButton, minusButton;
    private String filePath;
    private int currentHeight, pictureWidth, pictureHeight;
    private BufferedImage image;
    private boolean isImageResized;


    public Launcher(){

        currentHeight = 0;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,3));
        buttonPanel.setPreferredSize(new Dimension(600,200));

        plusMinusPanel = new JPanel();
        plusMinusPanel.setLayout(new GridLayout(1,2));

        startButton = new LauncherButton();
        startButton.addActionListener(this);
        startButton.setText("Start Game");

        selectFileButton = new LauncherButton();
        selectFileButton.addActionListener(this);
        selectFileButton.setText("Select File");

        runDemoButton = new LauncherButton();
        runDemoButton.addActionListener(this);
        runDemoButton.setText("Run Demo");

        exitButton = new LauncherButton();
        exitButton.addActionListener(this);
        exitButton.setText("Exit");

        plusButton = new LauncherButton();
        plusButton.addActionListener(this);
        plusButton.setText("+");
        plusButton.setEnabled(false);

        minusButton = new LauncherButton();
        minusButton.addActionListener(this);
        minusButton.setText("-");
        minusButton.setEnabled(false);

        label = new JLabel();
        label.setPreferredSize(new Dimension(400,100));
        label.setFont(new Font("Georgia", Font.PLAIN, 20));
        label.setForeground(Color.DARK_GRAY);
        label.setBackground(Color.LIGHT_GRAY);
        label.setBorder(new MatteBorder(1,1,1,1, Color.DARK_GRAY));
        label.setText("Choose Picture");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        sizeLabel = new JLabel();
        sizeLabel.setOpaque(true);
        sizeLabel.setFont(new Font("Georgia", Font.BOLD, 25));
        sizeLabel.setForeground(Color.LIGHT_GRAY);
        sizeLabel.setBackground(Color.DARK_GRAY);
        sizeLabel.setBorder(new MatteBorder(2,2,0,0, Color.LIGHT_GRAY));
        sizeLabel.setText("Height: " + currentHeight);
        sizeLabel.setVerticalAlignment(JLabel.CENTER);
        sizeLabel.setHorizontalAlignment(JLabel.CENTER);

        plusMinusPanel.add(minusButton);
        plusMinusPanel.add(plusButton);

        buttonPanel.add(startButton);
        buttonPanel.add(selectFileButton);
        buttonPanel.add(sizeLabel);
        buttonPanel.add(runDemoButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(plusMinusPanel);
//        buttonPanel.setVisible(true);

        frame.add(label, BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.pack();
        frame.revalidate();

        filePath = null;
        isImageResized = false;


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startButton){
            boolean isSuccess = true;
            if(pictureHeight > 30){
                isImageResized = true;
            }
            GameLauncher gameLauncher = new GameLauncher(image, isImageResized, currentHeight);
            isSuccess = gameLauncher.launchGame();
            if(isSuccess){
                frame.dispose();
            }
        }

        if(e.getSource() == runDemoButton){
            DemoLauncher demoLauncher = new DemoLauncher();
            demoLauncher.runDemo();
            frame.dispose();
        }

        if(e.getSource() == selectFileButton){
            JFileChooser fileChooser = new JFileChooser();
            int response;
            response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                filePath = fileChooser.getSelectedFile().getAbsolutePath();
            }
            try{
                image = ImageReader.readImage(filePath);
                pictureWidth = image.getWidth();
                pictureHeight = image.getHeight();
                label.setText("(" + pictureWidth + "x" + pictureHeight + ") " + filePath);

                if(image.getHeight() < 31){

                    currentHeight = pictureHeight;
                    plusButton.setEnabled(false);
                    minusButton.setEnabled(false);

                } else {

                    currentHeight = 15;
                    sizeLabel.setText("Height: " + currentHeight);
                    plusButton.setEnabled(true);
                    minusButton.setEnabled(true);

                }
            } catch (Exception ex){

            }

        }

        if(e.getSource() == exitButton){
            frame.dispose();
        }

        if(e.getSource() == plusButton){
            if(currentHeight > 4 && currentHeight < 30){
                currentHeight++;
                sizeLabel.setText("Height: " + currentHeight);
            }
        }

        if(e.getSource() == minusButton){
            if(currentHeight > 5){
                currentHeight--;
                sizeLabel.setText("Height: " + currentHeight);
            }
        }

    }

}
