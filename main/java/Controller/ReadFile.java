package Controller;

import java.io.*;
import java.util.ArrayList;

public class ReadFile<T> {
    public ArrayList<T> readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<T>) objectInputStream.readObject();
        }
    }
}