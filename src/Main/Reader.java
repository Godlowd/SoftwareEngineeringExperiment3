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
                if (line.equals(""))
                {
                    line = in.readLine();
                    continue;
                }
                count++;
                if (count % 2 != 0)
                {
                    //Dictionary dict = new Dictionary(line);
                    //this.dict.add(dict);
                    System.out.println(line);
                }
                line = in.readLine();
            }
            return this.dict;
        }
        else{
            System.out.println("The file doesn't exist! Please check the file path");
            return null;
        }
    }

}
