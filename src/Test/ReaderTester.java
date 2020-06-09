package Test;

import Main.Dictionary;
import Main.Reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReaderTester {
    public static void main(String args[]) throws IOException {
        String path  = "src/Test/test.txt";
        //read from sepcific path
        Reader rd = new Reader(path);
        //create a hashmap to restore the result
        HashMap<String, Dictionary> dict = new HashMap<String, Dictionary>();
        //start to test the func
        dict = rd.ReadFile();
        //go over the hashmap
        for(Map.Entry<String,Dictionary> entry:dict.entrySet())
        {
            System.out.println("name: " + entry.getKey());
            System.out.println("value: " + entry.getValue().getName());
            System.out.println("音标: " + entry.getValue().getPronunciation());
            System.out.println("词性: " + entry.getValue().getProperty());
            System.out.println("解释: " + entry.getValue().getExample());
        }
    }
}
