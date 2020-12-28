package main.shape;

import java.io.Serializable;

public interface Shape extends Cloneable, Serializable {
    double calcPerimeter();
    double calcArea();
    Shape clone();
}
