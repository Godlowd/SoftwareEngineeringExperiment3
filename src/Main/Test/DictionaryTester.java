package Main.Test;

import Main.utensil.Dictionary;
import Main.Speech;

public class DictionaryTester {
    public static void main(String args[]){
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
}
