package japaneseCrossword.logic.fieldGeneratorTools;

import java.util.ArrayList;

public class MostLinesInRow {
    public static int findMostLines(ArrayList[] lists){
        int mostLines = 0;
        for (int i = 0; i < lists.length; i++){
            if(mostLines < lists[i].size()){
                mostLines = lists[i].size();
            }
        }
        return mostLines;
    }

}
