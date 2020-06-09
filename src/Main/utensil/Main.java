package Main.utensil;

import java.io.*;
import java.util.*;
import Main.Speech;

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
        try {
            String path = "src/Main/utensil/ox-edict-utf8.txt";
            Reader rd = new Reader(path);
            HashMap<String, Dictionary> dictionary = new HashMap<String, Dictionary>();
            dictionary = rd.ReadFile();
            while (true) {

                System.out.println("What do you want to do?");
                System.out.println("1. search word");
                System.out.println("2. add word to the dictionanry");
                System.out.println("if you want to quit, please press the q");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                switch (input) {
                    case "1":
                        search(dictionary);
                        break;
                    case "2":
                        add(dictionary);
                        break;
                    case "q": {
                        System.out.println("Program exit");
                        System.exit(0);
                    }
                    break;
                    default:
                        continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Error! check the path you set!");
        }
    }

    public static void add(HashMap<String, Dictionary> dict) throws IllegalArgumentException {
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
        try {
            Speech speech = Speech.valueOf(input);
            newword.setProperty(speech);
        } catch (IllegalArgumentException e) {
            System.out.println("The speech you input is illegal");
            return;
        }
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

    public static void search(HashMap<String, Dictionary> dict) {
        System.out.print("Please input the word that you want to search: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Set<String> names = dict.keySet();
        if (names.contains(input)) {
            System.out.println("查询的单词为: " + input);
            System.out.println("单词发音为: " + dict.get(input).getPronunciation());
            System.out.println("词性为: " + dict.get(input).getProperty());
            System.out.println("解释为: " + dict.get(input).getExample());
        } else {
            System.out.println("the dictionary doesn't have the word, try to add it?");
        }
        //System.out.println("这是搜索方法");
    }

}

