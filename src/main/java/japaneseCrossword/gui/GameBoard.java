package japaneseCrossword.gui;

import japaneseCrossword.gui.actions.BorderGenerator;
import japaneseCrossword.gui.customButtons.menuButton;
import japaneseCrossword.gui.customButtons.GridButton;
import japaneseCrossword.gui.customLabels.TextLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard implements ActionListener {

    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel lowerPanel, upperPanel;
    private JLabel sizeLabel;
    private GridButton[][] buttons;
    private JButton checkButton, resetButton, exitButton, answerButton;


    private int startXCoord;
    private int startYCoord;
    private int width;
    private int height;
    private boolean isWin;
    private int[][] solution;
    private int answerTimesPressed;

    public GameBoard(int[][] pixels){
        solution = pixels;
        width = pixels[0].length;
        height = pixels.length;
        startXCoord = findXStartCoord(solution);
        startYCoord = findYStartCoord(solution);
        isWin = false;
        answerTimesPressed = 3;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
//        frame.setSize(width*27, height*27 + 120);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(width * 27, height *27));
//        buttonPanel.setSize(pixels[0].length*20,pixels.length*20);
        buttonPanel.setLayout(new GridLayout(height, width));
        buttonPanel.setVisible(true);

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(2,2));
        lowerPanel.setPreferredSize(new Dimension(width*27, 80));
        upperPanel = new JPanel();
        upperPanel.setLayout(new GridLayout());
        upperPanel.setPreferredSize(new Dimension(width* 27, 50));

        sizeLabel = new TextLabel("Size: " + (width-startXCoord) + " x " + (height-startYCoord));

        checkButton = new menuButton("Check");
        checkButton.addActionListener(this);
        answerButton = new menuButton("Answer ("+ answerTimesPressed + ")");
        answerButton.addActionListener(this);
        resetButton = new menuButton("Reset");
        resetButton.addActionListener(this);
        exitButton = new menuButton("Exit");
        exitButton.addActionListener(this);

        buttons = new GridButton[height][width];

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                buttons[y][x] = new GridButton();
//                buttons[y][x].setButtonState(-2);
                buttons[y][x].setForeground(Color.BLACK);
                buttons[y][x].setFont(new Font("Arial", Font.PLAIN, 20));

                if(solution[y][x] == -1){
                    buttons[y][x].setButtonState(-2);
                } else if(solution[y][x] == -2){
                    buttons[y][x].setButtonState(-2);
                } else if(solution[y][x] >= 1){
                    buttons[y][x].setFont(new Font("Arial", Font.BOLD, 15));
                    buttons[y][x].setText(String.valueOf(pixels[y][x]));
                    buttons[y][x].setEnabled(false);
                } else {
                    buttons[y][x].setBackground(Color.LIGHT_GRAY);
                    buttons[y][x].setEnabled(false);
                }

                buttons[y][x] = BorderGenerator.generateBorder(buttons[y][x], startXCoord, startYCoord, x, y, buttons[0].length, buttons.length);
                buttons[y][x].addActionListener(this);

                buttonPanel.add(buttons[y][x]);
            }
        }

        lowerPanel.add(checkButton);
        lowerPanel.add(answerButton);
        lowerPanel.add(resetButton);
        lowerPanel.add(exitButton);
        upperPanel.add(sizeLabel);

        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
//        frame.add(checkButton, BorderLayout.SOUTH);
        frame.add(lowerPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.revalidate();

    }

    private int findYStartCoord(int[][] pixels){
        int i = 0;
        int lastXCoord = pixels[0].length-1;

        while(pixels[i][lastXCoord] != -2 && pixels[i][lastXCoord] != -1){

            i++;

        }
        return i;
    }

    private int findXStartCoord(int[][] pixels){
        int i = 0;
        int lastYCoord = pixels.length-1;

        while(pixels[lastYCoord][i] != -2 && pixels[lastYCoord][i] != -1){

            i++;

        }
        return i;
    }

    public JButton[][] getButtons(){
        return buttons;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == checkButton) {
            isWin = true;
            for(int y = startYCoord; y < buttons.length; y++){
                for(int x = startXCoord; x < buttons[0].length; x++){

                    if(buttons[y][x].getContentCode() != solution[y][x]){
                        isWin = false;
                            if(buttons[y][x].getButtonState() == -3){
                                buttons[y][x].setForeground(Color.RED);
                            } else if(buttons[y][x].getButtonState() == -1){
                                buttons[y][x].setBackground(Color.RED);
                            } else {}
                    }

                }
            }
            if(isWin){
                checkButton.setBackground(new Color(120, 240, 140));
                checkButton.setForeground(new Color(50, 100, 60));
            }
            System.out.println(isWin);
        }

        if(e.getSource() == answerButton){

            if(answerTimesPressed > 1){
                answerTimesPressed--;
                answerButton.setText("Answer ("+ answerTimesPressed + ")");
            } else {
                answerButton.setText("Answer");
                for (int y = startYCoord; y < buttons.length; y++) {
                    for (int x = startXCoord; x < buttons[0].length; x++) {

                        buttons[y][x].setButtonState(solution[y][x]);

                    }
                }
            }

        }

        if(e.getSource() == resetButton){
            frame.dispose();
            new GameBoard(solution);
        }

        if(e.getSource() == exitButton){
            frame.dispose();
            new Launcher();
        }

        for(int i = startYCoord; i < buttons.length; i++){
            for (int j = startXCoord; j < buttons[0].length; j++){
                if(e.getSource() == buttons[i][j]){

                    if(buttons[i][j].getButtonState() == -1){
                        buttons[i][j].setButtonState(-2);
                    } else if(buttons[i][j].getButtonState() == -2){
                        buttons[i][j].setButtonState(-3);
                    } else if(buttons[i][j].getButtonState() == -3){
                        buttons[i][j].setButtonState(-1);
                    }


                }
            }
        }

    }
}
