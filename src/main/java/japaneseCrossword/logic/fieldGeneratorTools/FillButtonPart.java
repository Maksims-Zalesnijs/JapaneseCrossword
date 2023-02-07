package japaneseCrossword.logic.fieldGeneratorTools;

public class FillButtonPart {

    public static int[][] fillButtons(int[][] pixels, int[][] updatedPixels, int xStartCoord, int yStartCoord){

        for(int y = yStartCoord; y < updatedPixels.length; y++)
            for(int x = xStartCoord; x < updatedPixels[0].length; x++){

                updatedPixels[y][x] = pixels[y-yStartCoord][x-xStartCoord];

            }
        return updatedPixels;
    }

}
