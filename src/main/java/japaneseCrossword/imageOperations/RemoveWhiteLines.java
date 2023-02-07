package japaneseCrossword.imageOperations;

public class RemoveWhiteLines {

    private static boolean isBlankPicture;
    public static int[][] removeWhiteLines(int[][] pixels){

        int[][] updatedPixels = null;

        isBlankPicture = true;

        int hFrontLines;
        int hBackLines ;
        int vFrontLines ;
        int vBackLines ;

        int newHeight;
        int newWidth;

        hFrontLines = countHFrontLines(pixels);

        if(!isBlankPicture) {

            hBackLines = countHBackLines(pixels);
            vFrontLines = countVFrontLines(pixels);
            vBackLines = countVBackLines(pixels);

            newHeight = pixels.length - hFrontLines - hBackLines;
            newWidth = pixels[0].length - vFrontLines - vBackLines;

            updatedPixels = new int[newHeight][newWidth];

            for (int y = 0; y < newHeight; y++){
                for(int x = 0; x < newWidth; x++){
                    updatedPixels[y][x] = pixels[y + hFrontLines][x + vFrontLines];
                }
            }
        }
        return updatedPixels;
    }

    private static int countHFrontLines(int[][] pixels){
        int lines = 0;
        for(int i = 0; i < pixels.length; i++){
            if(checkWhiteLine(pixels[i])){
                lines++;
            } else {
                isBlankPicture = false;
                break;
            }
        }
        return lines;
    }

    private static int countHBackLines(int[][] pixels){

        int lines = 0;
        for(int i = pixels.length - 1; i >= 0; i--){
            if(checkWhiteLine(pixels[i])){
                lines++;
            } else {
                break;
            }
        }
        return lines;
    }

    private static int countVFrontLines(int[][] pixels){

        int lines = 0;
        for(int i = 0; i < pixels[0].length; i++){
            int[] line = new int[pixels.length];
            for(int j = 0; j < line.length; j++){
                line[j] = pixels[j][i];
            }
            if(checkWhiteLine(line)){
                lines++;
            } else {
                break;
            }
        }
        return lines;
    }

    private static int countVBackLines(int[][] pixels){

        int lines = 0;
        for(int i = pixels[0].length - 1; i >= 0; i--) {
            int[] line = new int[pixels.length];
            for (int j = 0; j < line.length; j++) {
                line[j] = pixels[j][i];
            }
            if (checkWhiteLine(line)) {
                lines++;
            } else {
                break;
            }
        }
        return lines;
    }

    private static boolean checkWhiteLine(int[] line){
        boolean isWhiteLine = true;
        for(int i = 0; i < line.length; i++){
            if(line[i] == -1){
                isWhiteLine = false;
            }
        }
        return isWhiteLine;
    }

}