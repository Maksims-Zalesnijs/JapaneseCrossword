package japaneseCrossword.imageOperations.forTesting;

import java.util.ArrayList;

public class TryOutOfBounds {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(0);

        for (int i = 1; i < 10; i++) {
            numbers.add(i + numbers.get(i - 1));

        }

        try {
            for (int i = 0; i < 11; i++)
                System.out.println(numbers.get(i));
        } catch (IndexOutOfBoundsException outOfBoundsException) {
            System.out.println("oops");
        }

    }
}
