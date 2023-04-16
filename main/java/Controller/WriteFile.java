package Controller;

import java.io.*;
import java.util.ArrayList;

public class WriteFile<T> {
    public void writeToFile(String filename, ArrayList<T> data) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(data);
        }
    }
}