package Main;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        initial();

        //String path = "src/Main/test.txt";
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        //rd.ReadFile();
       // testgetPronunciation();
        //testgetexample();
    }
    public static void initial() throws IOException {
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        HashMap<String, Dictionary> dict = new HashMap<String, Dictionary>();
        dict = rd.ReadFile();
        System.out.println("What do you want to do?");
        System.out.println("1. search word");
        System.out.println("2. add word to the dictionanry");
        System.out.println("if you want to quit, please press the q");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
//        while(input.equals("1") ||input.equals("2") || input.equals("q"))
//            ;
        switch (input)
        {
            case "1": search(dict);
            break;
            case "2": add(dict);
            break;
            case "q": {
                System.out.println("Program exit");
                System.exit(0);
            }
            break;
        }


    }
    public static void add(HashMap<String, Dictionary> dict)
    {
        System.out.println("这是添加方法");
        System.out.println("Please input the word you want to add: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Dictionary newword = new Dictionary(input);
        //set new word's pronunciation
        System.out.println("Please input its pronunciation: ");
        input = sc.nextLine();
        newword.setPronunciation(input);
        //set new word's property
        System.out.println("Please input its property: ");
        input = sc.nextLine();
        newword.setProperty(input);
        //set new word's example
        System.out.println("Please input its example: ");
        input = sc.nextLine();
        newword.setExample(input);
        //add the word to the dictionary
        dict.put(newword.getName(), newword);
        //output the word's info
        System.out.println("word: " + newword.getName());
        System.out.println("pronunciation: " + newword.getPronunciation());
        System.out.println("property: " + newword.getProperty());
        System.out.println("example: " + newword.getExample());
    }

    public static void search(HashMap<String, Dictionary> dict)
    {
        System.out.print("Please input the word that you want to search: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Set<String> names = dict.keySet();
        if (names.contains(input))
        {
            System.out.println("查询的单词为: " + input);
            System.out.println("单词发音为: "+ dict.get(input).getPronunciation());
            System.out.println("词性为: " + dict.get(input).getProperty());
            System.out.println("解释为: " + dict.get(input).getExample());
        }
        else {
            System.out.println("the dictionary doesn't have the word, try to add it?");
        }

        //System.out.println("这是搜索方法");
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

    public static void testgetExample()
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
