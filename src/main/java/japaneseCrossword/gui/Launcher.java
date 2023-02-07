package japaneseCrossword.gui;

import japaneseCrossword.DemoLauncher;
import japaneseCrossword.gui.customButtons.LauncherButton;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher implements ActionListener {

    private JFrame frame;
    private JPanel buttonPanel;
    private JLabel label;
    private JButton startButton;
    private JButton selectFileButton;
    private JButton runDemoButton;
    private JButton exitButton;
    private DemoLauncher demoLauncher;
    private String filePath;


    public Launcher(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        buttonPanel.setPreferredSize(new Dimension(600,200));

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

        label = new JLabel();
        label.setPreferredSize(new Dimension(400,100));
        label.setFont(new Font("Georgia", Font.PLAIN, 20));
        label.setForeground(Color.DARK_GRAY);
        label.setBackground(Color.LIGHT_GRAY);
        label.setBorder(new MatteBorder(1,1,1,1, Color.DARK_GRAY));
        label.setText("Choose Picture");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        buttonPanel.add(startButton);
        buttonPanel.add(selectFileButton);
        buttonPanel.add(runDemoButton);
        buttonPanel.add(exitButton);
//        buttonPanel.setVisible(true);

        frame.add(label, BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.pack();
        frame.revalidate();

        demoLauncher = new DemoLauncher();

        filePath = null;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == runDemoButton){
            demoLauncher.runDemo();
            frame.dispose();
        }

        if(e.getSource() == selectFileButton){
            JFileChooser fileChooser = new JFileChooser();
            int response;
            response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                filePath = fileChooser.getSelectedFile().getAbsolutePath();
                label.setText(filePath);
            }

        }

        if(e.getSource() == exitButton){
            frame.dispose();
        }

    }
}
