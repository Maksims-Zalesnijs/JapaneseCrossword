package japaneseCrossword.imageOperations.forTesting;

public class PixelPrinter {

    public static void printPixels(int[][] pixels){

        for(int y = 0; y < pixels.length; y++){
            for(int x = 0; x < pixels[0].length; x++){

                System.out.print(pixels[y][x]);

            }
            System.out.println();
        }

    }

}
