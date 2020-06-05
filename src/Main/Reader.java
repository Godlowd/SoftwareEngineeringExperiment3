package Main;

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
            int count = 0;
            while (line != null)
            {
                //if the line is just blank,then skip it
                if (line.equals(""))
                {
                    line = in.readLine();
                    continue;
                }
                count++;
                if (count % 2 != 0)
                {
                    //initialize a dict object to store the word we get
                    Dictionary dict = new Dictionary(line);
                    //read the next line to get other info
                    line = in.readLine();
                    //this.dict.add(dict);
                    System.out.println(line);
                }

            }
            return this.dict;
        }
        else{
            System.out.println("The file doesn't exist! Please check the file path");
            return null;
        }
    }

    public String getPronunciation(String line){
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
