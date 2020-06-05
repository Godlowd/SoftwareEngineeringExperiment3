package Main;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        //String path = "src/Main/test.txt";
        String path = "src/Main/ox-edict-utf8.txt";
        Reader rd = new Reader(path);
        rd.ReadFile();
    }


}
