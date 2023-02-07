package imageEditor;

import java.io.ByteArrayOutputStream;

public class Baos {

    public static void main(String[] args) {

        int[] arr = {1,5,4,12,127};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        System.out.println(baos.toByteArray()[4]);

    }

}
