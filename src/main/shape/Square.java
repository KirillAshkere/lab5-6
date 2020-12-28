package main.shape;

public class Square implements Shape {
    private double A;

    public Square(double a) {
        if (a <= 0)
            throw new IllegalArgumentException("НЕВЕРНО ЗАДАНЫ РАЗМЕРЫ!!!!");
        else
            this.A = a;
    }

    @Override
    public double calcPerimeter() {
        return 4 * this.A;
    }

    @Override
    public double calcArea() {
        return Math.pow(this.A, 2);
    }

    @Override
    public String toString() {
        return "Квадрат (" + A + 'x' + A +')';
    }

    @Override
    public Shape clone() {
        try {
            return (Square) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
