package Main;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashSet;

public class Reader {


    //the path to read the file
    public String FilePath;
    //the set to store the words we read from the dictionary
    public HashSet<Dictionary> dict;

    public Reader(String FilePath)
    {
        this.FilePath = FilePath;
        this.dict = new HashSet<Dictionary>();
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public HashSet<Dictionary> getDict() {
        return dict;
    }

    public void setDict(HashSet<Dictionary> dict) {
        this.dict = dict;
    }

    public HashSet<Dictionary> ReadFile() throws IOException {
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
                //if the line is just blank,then skip it
                if (line.equals(""))
                {
                    line = in.readLine();
                    continue;
                }
                //initialize a dict object to store the word we get
                Dictionary dict = new Dictionary(line);
                //read the next line to get other info
                line = in.readLine();
                //get and set the pronuciation of the new word
                String pronunciation = getPronunciation(line);
                dict.setPronunciation(pronunciation);
                //get and set the property of the word
                String property = getProperty(line);
                dict.setProperty(property);
                System.out.println(dict.name + " " + dict.getPronunciation() + " " + dict.getProperty());
                line = in.readLine();


            }
            return this.dict;
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

    public String getProperty(String line)
    {
        if(line.equals("")) return "";

        //#define the index of the letter in the String
        int i = 0;
        if(line.charAt(0) == '/')
        {
            while (line.charAt(++i) != '/')
                ;
            i = i+2;
            if (line.substring(i,i+1).equals("n") && (line.substring(i+1,i+2).equals(" ") || line.substring(i+1,i+2).equals(".")))
                return "n";
            else if (line.substring(i,i+1).equals("v") && (line.substring(i+1,i+2).equals(" ") || line.substring(i+1,i+2).equals(".")))
                return "v";
            else if (line.substring(i,i+3).equals("adj") && (line.substring(i+3,i+4).equals(" ") || line.substring(i+3,i+4).equals(".")))
                return "adj";
            else if (line.substring(i,i+3).equals("adv") && (line.substring(i+3,i+4).equals(" ") || line.substring(i+3,i+4).equals(".")))
                return "adv";
            else if (line.substring(i,i+4).equals("abbr") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
                return "abbr";
            else if (line.substring(i,i+4).equals("pref") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
                return "pref";
            else if (line.substring(i,i+4).equals("suff") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
                return "suff";
            else if (line.substring(i,i+4).equals("symb") && (line.substring(i+4,i+5).equals(" ") || line.substring(i+4,i+5).equals(".")))
                return "symb";
            else return "";
        }
        else{
            if (line.substring(0,1).equals("n"))
                return "n";
            else if (line.substring(0,1).equals("v"))
                return "v";
            else if (line.substring(0,3).equals("adj"))
                return "adj";
            else if (line.substring(0,3).equals("adv"))
                return "adv";
            else if (line.substring(0,4).equals("abbr"))
                return "abbr";
            else if (line.substring(0,4).equals("pref"))
                return "pref";
            else if (line.substring(0,4).equals("suff"))
                return "suff";
            else if (line.substring(0,4).equals("symb"))
                return "symb";
            else return "";
        }
    }
}
