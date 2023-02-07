package japaneseCrossword.logic.fieldGeneratorTools;

import java.util.ArrayList;

public class FillNumberPart {

    public static int[][] fillNumberPart(int[][] pixels, ArrayList<Integer>[] numberGrid, int xStartCoord, int yStartCoord, boolean isTopPart) {

            for (int l = 0; l < numberGrid.length; l++) {
                for (int w = numberGrid[l].size() - 1; w >= 0; w--) {

                    if(isTopPart) {

                        int sizeDifference = yStartCoord - numberGrid[l].size();
                        pixels[w + sizeDifference][l + xStartCoord] = numberGrid[l].get(w);

                    } else {

                        int sizeDifference = xStartCoord - numberGrid[l].size();
                        pixels[l + yStartCoord][w + sizeDifference] = numberGrid[l].get(w);

                    }

                }
            }

        return pixels;

    }

}
