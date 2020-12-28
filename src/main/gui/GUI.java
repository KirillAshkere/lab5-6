package main.gui;

import main.helper.RWFile;
import main.shape.Shape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    public static void main(String[] args) {
        List<Shape> shapes = null;
        try {
            shapes = (List<Shape>)(RWFile.Read());
        }
         catch (IOException  | ClassNotFoundException exception) {
            shapes = new ArrayList<>();
        }
        finally {


        ShapeApp dialog = new ShapeApp(shapes);
        dialog.pack();
        dialog.setVisible(true);


        try {
            RWFile.Write(shapes);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла");
        }
    }
    }
}
