package Main;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        //String path = "src/Main/test.txt";
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        rd.ReadFile();
       // testgetPronunciation();
        //testgetProperty();
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

    public static void testgetProperty()
    {
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        String noun = "n";
        String verb = "v";
        String adj = "adj";
        String adv = "adv";
        String abbr = "abbr";
        String pref = "pref";
        String suff = "suff";
        String symb = "symb";
        String testString1 = "/test/"+" "+ noun + " ";
        String testString2 = "/test/"+" "+ verb + " ";
        String testString3 = "/test/"+" "+ adj + " ";
        String testString4 = "/test/"+" "+ adv + " ";
        String testString5 = "/test/"+" "+ abbr + " ";
        String testString6 = "/test/"+" "+ pref + " ";
        String testString7 = "/test/"+" "+ suff + " ";
        String testString8 = "/test/"+" "+ symb + " ";
        rd.getProperty(testString1);
        System.out.println(rd.getProperty(testString1));
        System.out.println(rd.getProperty(testString2));
        System.out.println(rd.getProperty(testString3));
        System.out.println(rd.getProperty(testString4));
        System.out.println(rd.getProperty(testString5));
        System.out.println(rd.getProperty(testString6));
        System.out.println(rd.getProperty(testString7));
        System.out.println(rd.getProperty(testString8));
    }
}
