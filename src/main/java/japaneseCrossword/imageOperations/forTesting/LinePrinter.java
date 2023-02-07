package japaneseCrossword.imageOperations.forTesting;

import java.util.ArrayList;

public class LinePrinter {

    public static void printLines(ArrayList<Integer>[] lists){

        for(int i = 0; i < lists.length; i++){
            for(int j = 0; j < lists[i].size(); j++){
                System.out.print(lists[i].get(j) + " ");
            }
            System.out.println();

        }

    }

}
