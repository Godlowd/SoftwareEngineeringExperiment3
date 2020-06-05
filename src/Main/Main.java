package Main;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        //String path = "src/Main/test.txt";
//        String path = "src/Main/ox-edict-utf8.txt";
//        Reader rd = new Reader(path);
//        rd.ReadFile();
        testgetPronunciation();
    }

    public static void testgetPronunciation()
    {
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        String testString = "/agsdgsdgas";
        String anotherString = "gasdg/gagsd/";
        String test = testString + anotherString;
        String result = rd.getPronunciation(test);
        if(result.equals(testString))
            System.out.println("test passes");
        else System.out.println("test fails");
    }
}
