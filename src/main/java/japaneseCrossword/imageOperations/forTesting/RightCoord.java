package japaneseCrossword.imageOperations.forTesting;

public class RightCoord {

    public static void main(String[] args) {

        int currentX = 12;
        int startXCoord = 7;


        boolean xTrigger = (currentX-startXCoord) % 5 == 0 && currentX-startXCoord >= 0;
        System.out.println(xTrigger);

    }

}
