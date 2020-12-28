package main.helper;

import java.io.*;

public class RWFile {
    public static void Write(Object obj) throws IOException {
        try (FileOutputStream fileOutput = new FileOutputStream("SHAPE.FILE")) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(obj);
        }

    }

    public static Object Read() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInput = new FileInputStream("SHAPE.FILE");) {
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            return objectInput.readObject();
        }


    }
}
