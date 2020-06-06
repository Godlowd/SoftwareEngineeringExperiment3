package Main;

import java.io.*;
import java.util.ArrayList;

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
        String testString2 = "/test/"+" "+ verb + " " + "测试样句aasasdbasdf";
        String testString3 = "/test/"+" "+ adj + " " + "测试样句aasfasdfasf";
        String testString4 = "/test/"+" "+ adv + " " + "测试样句aasasdbasdf";
        String testString5 = "/test/"+" "+ abbr + " " + " 测试样句aasasdbasdf";
        String testString6 = "/test/"+" "+ pref + ".";
        String testString7 = "/test/"+" "+ suff + " ";
        String testString8 = "/test/"+" "+ symb + " ";
        ArrayList<Dictionary> list = new ArrayList<Dictionary>();
        for(Integer i = 0; i <8; i++){
            Dictionary dict = new Dictionary(i.toString());
            list.add(dict);
        }
        rd.getProperty(testString1,list.get(0));
        rd.getProperty(testString2,list.get(1));
        rd.getProperty(testString3,list.get(2));
        rd.getProperty(testString4,list.get(3));
        rd.getProperty(testString5,list.get(4));
        rd.getProperty(testString6,list.get(5));
        rd.getProperty(testString7,list.get(6));
        rd.getProperty(testString8,list.get(7));


        System.out.println(list.get(0).getProperty() + " " + list.get(0).getExample());
        System.out.println(list.get(1).getProperty() + " " + list.get(1).getExample());
        System.out.println(list.get(2).getProperty() + " " + list.get(2).getExample());
        System.out.println(list.get(3).getProperty() + " " + list.get(3).getExample());
        System.out.println(list.get(4).getProperty() + " " + list.get(4).getExample());
        System.out.println(list.get(5).getProperty() + " " + list.get(5).getExample());
        System.out.println(list.get(6).getProperty() + " " + list.get(6).getExample());
        System.out.println(list.get(7).getProperty() + " " + list.get(7).getExample());
    }
}
