package japaneseCrossword.logic.fieldGeneratorTools;

public class FillDefault {

    public static int[][] fillAllCells(int[][] pixels){

        for(int y = 0; y < pixels.length; y++){
            for (int x = 0; x < pixels[0].length; x++){
                pixels[y][x] = 0;
            }
        }

        return pixels;
    }

}
