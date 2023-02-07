package japaneseCrossword.logic;

import java.util.ArrayList;

public class LineCounter {

    public static ArrayList<Integer> countLines(int[] pixels){
        ArrayList<Integer> lines = new ArrayList<>();
        int lineLength = 0;
        boolean linesDetected = false;

        for(int i = 0; i < pixels.length; i++){

            if(pixels[i] == -1){
                linesDetected = true;
                lineLength++;
            } else if(pixels[i] == -2 && linesDetected){
                lines.add(lineLength);
                lineLength = 0;
                linesDetected = false;
            }

        }
        if(linesDetected){
            lines.add(lineLength);
        }
        return lines;

    }

}
