package Main.utensil;
import Main.Speech;
public class Dictionary {
    //the word be searched
    public String name;
    //the pronunciation of the word
    public String pronunciation;
    //the first letter of the word
    public String alphabet;
    //the example sentences of the word
    public String example;
    //the property of the word, such as n, adv, adj ,etc.
    public Speech property;

    public Dictionary(String name){
        this.name = name;
        this.pronunciation = "";
        this.alphabet = "";
        this.property = Speech.unknown;
        this.example = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Speech getProperty() {
        return property;
    }

    public void setProperty(Speech property) {
        this.property = property;
    }
}


