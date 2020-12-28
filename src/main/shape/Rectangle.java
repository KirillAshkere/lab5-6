package main.shape;

public class Rectangle implements Shape {
    private double side1;
    private double side2;

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0)
            throw new IllegalArgumentException("НЕВЕРНО ЗАДАНЫ РАЗМЕРЫ!!!!");
        else {
            this.side1 = a;
            this.side2 = b;
        }
    }

    @Override
    public double calcPerimeter() {
        return (this.side1 + this.side2) * 2;
    }

    @Override
    public double calcArea() {
        return this.side1 * this.side2;
    }

    @Override
    public String toString() {
        return "Прямоугольник (" + side1 + 'x' + side2 + ')';
    }

    @Override
    public Shape clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
