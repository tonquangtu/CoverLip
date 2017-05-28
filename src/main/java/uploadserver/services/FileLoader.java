package uploadserver.services;

import java.io.*;

/**
 * Created by Dell on 21-Apr-17.
 */
public class FileLoader {

    public void loadFile() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("test.txt");
//        InputStream is = FileLoader.class.getResourceAsStream("test.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder out = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(out.toString());

    }

    public static void main(String[] args) {
        new FileLoader().loadFile();
    }
}
