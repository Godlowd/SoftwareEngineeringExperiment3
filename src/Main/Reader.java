package Main;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Reader {


    //the path to read the file
    public String FilePath;
    //the set to store the words we read from the dictionary
    public HashMap<String, Dictionary> dictionary;

    public Reader(String FilePath)
    {
        this.FilePath = FilePath;
        this.dictionary = new HashMap<String, Dictionary>();
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public HashMap<String, Dictionary> getDict() {
        return dictionary;
    }

    public void setDict(HashMap<String, Dictionary> dict) {
        this.dictionary = dict;
    }

    public HashMap<String, Dictionary> ReadFile() throws IOException {
        File file = new File(this.FilePath);
        if(file.isFile() && file.exists())
        {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(FilePath));
            BufferedReader in = new BufferedReader(reader);
            String line = in.readLine();

            //count the lines
            int count = 1;
            while (line != null)
            {
                String name = line;
                //if the line is just blank,then skip it
                if (line.equals(""))
                {
                    line = in.readLine();
                    continue;
                }
                //initialize a dict object to store the word we get
                Dictionary dict = new Dictionary(name);
                //get the first letter of the word
                dict.setAlphabet(line.substring(0,1).toUpperCase());
                //read the next line to get other info
                line = in.readLine();
                //get and set the pronuciation of the new word
                String pronunciation = getPronunciation(line);
                dict.setPronunciation(pronunciation);
                //get and set the property of the word
                String property = getProperty(line,dict);
                dict.setProperty(property);
//                String example = getExample(dict);
//                dict.setExample(example);
                //System.out.println("单词名: " + dict.name + " " + "发音: " + dict.getPronunciation() + " " + "词性 " + dict.getProperty() + " " + "例句: " + dict.getExample());
                dictionary.put(name, dict);
                line = in.readLine();


            }
            return this.dictionary;
        }
        else{
            System.out.println("The file doesn't exist! Please check the file path");
            return null;
        }
    }

    public String getPronunciation(String line){
        if (line.equals(""))
            return "";
        else {    
            if(line.charAt(0)=='/'){
                int i = 1;
                while(line.charAt(i)!='/')
                    i++;
                return line.substring(0, ++i);
            }
            else
                return "";
        }
    }

    public String getProperty(String line, Dictionary dict)
    {
        if(line.equals("") || line.equals(".")) return "";

        //#define the index of the letter in the String
        int i = 0;
        if(line.charAt(0) == '/')
        {
            while (line.charAt(++i) != '/')
                ;
            i = i+2;
            if (line.substring(i,i+1).equals("n") && (line.substring(i+1,i+2).equals(" ") || line.substring(i+1,i+2).equals(".")))
            {
                if (line.substring(i+1,i+2).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+2));
                return "n";
            }
            else if (line.substring(i,i+1).equals("v") && (line.substring(i+1,i+2).equals(" ") || line.substring(i+1,i+2).equals(".")))
            {
                if (line.substring(i+1,i+2).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+2));
                return "v";
            }
            else if (line.substring(i,i+3).equals("adj") && (line.substring(i+3,i+4).equals(" ") || line.substring(i+3,i+4).equals(".")))
            {
                if (line.substring(i+3,i+4).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+4));
                return "adj";
            }
            else if (line.substring(i,i+3).equals("adv") && (line.substring(i+3,i+4).equals(" ") || line.substring(i+3,i+4).equals(".")))
            {
                if (line.substring(i+3,i+4).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+4));
                return "adv";
            }
            else if (line.substring(i,i+4).equals("abbr") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
            {
                if (line.substring(i+4,i+5).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+5));
                return "abbr";
            }
            else if (line.substring(i,i+4).equals("pref") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
            {
                if (line.substring(i+4,i+5).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+5));
                return "pref";
            }
            else if (line.substring(i,i+4).equals("suff") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
            {
                if (line.substring(i+4,i+5).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+5));
                return "suff";
            }
            else if (line.substring(i,i+4).equals("symb") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
            {
                if (line.substring(i+4,i+5).equals("."))
                    dict.setExample("");
                else dict.setExample(line.substring(i+5));
                return "symb";
            }
            else {
                dict.setExample(line.substring(0));
                return "";
            }
        }
        else{
            if (line.substring(0,1).equals("n"))
            {
                dict.setExample(line.substring(1));
                return "n";
            }
            else if (line.substring(0,1).equals("v"))
            {
                dict.setExample(line.substring(1));
                return "v";
            }
            else if (line.substring(0,3).equals("adj"))
            {
                dict.setExample(line.substring(3));
                return "adj";
            }
            else if (line.substring(0,3).equals("adv"))
            {
                dict.setExample(line.substring(3));
                return "adv";
            }
            else if (line.substring(0,4).equals("abbr"))
            {
                dict.setExample(line.substring(4));
                return "abbr";
            }
            else if (line.substring(0,4).equals("pref"))
            {
                dict.setExample(line.substring(4));
                return "pref";
            }
            else if (line.substring(0,4).equals("suff"))
            {
                dict.setExample(line.substring(4));
                return "suff";
            }
            else if (line.substring(0,4).equals("symb"))
            {
                dict.setExample(line.substring(4));
                return "symb";
            }
            else {
                dict.setExample(line.substring(0));
                return "";
            }
        }
    }

}
