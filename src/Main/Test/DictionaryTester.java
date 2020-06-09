package Main.Test;

import Main.utensil.Dictionary;
import Main.Speech;
import Main.utensil.Reader;

import java.util.ArrayList;

public class DictionaryTester {
    public static void main(String args[]){
        System.out.println("==================DictionaryTester======================");
        DictionaryTester();
        System.out.println("=================getExampleTester====================");
        testgetExample();
        System.out.println("==================getProunicaitionTester===================");
        testgetPronunciation();
    }
    public static void DictionaryTester()
    {
        Dictionary dict1 = new Dictionary("");
        Dictionary dict2 = new Dictionary("测试2");
        dict2.setName("修改后的测试2");
        dict2.setProperty(Speech.unknown);
        dict2.setExample("这是测试2的解释例句");
        dict2.setPronunciation("/testProuniciation/");
        System.out.println("name: " + dict1.getName());
        System.out.println("Prouniciation: " + dict1.getPronunciation());
        System.out.println("property: " + dict1.getProperty());
        System.out.println("Example: " + dict1.getExample());
        System.out.println("name: " + dict2.getName());
        System.out.println("Prouniciation: " + dict2.getPronunciation());
        System.out.println("property: " + dict2.getProperty());
        System.out.println("Example: " + dict2.getExample());
    }

    public static void testgetExample()
    {
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        String noun = "n";
        String verb = "v";
        String adj = "adj";
        String testString1 = "/test/"+" "+ noun + " ";
        String testString2 = "/test/"+" "+ verb + " " + "测试样句aasasdbasdf";
        String testString3 = "/test/"+" "+ adj + " " + "测试样句aasfasdfasf";
        ArrayList<Dictionary> list = new ArrayList<Dictionary>();
        for(Integer i = 0; i <3; i++){
            Dictionary dict = new Dictionary(i.toString());
            list.add(dict);
        }
        String property1 = rd.getProperty(testString1,list.get(0));
        String property2 = rd.getProperty(testString2,list.get(1));
        String property3 = rd.getProperty(testString3,list.get(2));


        System.out.println(property1 + " " + list.get(0).getExample());
        System.out.println(property2 + " " + list.get(1).getExample());
        System.out.println(property3 + " " + list.get(2).getExample());
    }

    public static void testgetPronunciation() {
        String path = "src/Main/utensil/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        String testString = "/agsdgsdgas";
        String anotherString = "gasdg/gagsd/";
        String test = testString + anotherString;
        String result = rd.getPronunciation(test);
        //it should put out fails
        if (result.equals(testString))
            System.out.println("test passes");
        else System.out.println("test fails");
        //it should put out passes
        String testString1 = "/agsdgsdgas/";
        String anotherString1 = "gasdg/gagsd/";
        String test1 = testString1 + anotherString1;
        String result1 = rd.getPronunciation(test1);
        //it should put out fails
        if (result1.equals(testString1))
            System.out.println("test passes");
        else System.out.println("test fails");
    }
}
