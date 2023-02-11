package japaneseCrossword.imageOperations.forTesting;

public class MathRoundExamples {

    public static void main(String[] args) {

        int currentHeight = 275;
        int heightInCells = 30;

        int newHeight = (int) (Math.floor(currentHeight/heightInCells))*heightInCells;




        System.out.println(newHeight);

    }

}
