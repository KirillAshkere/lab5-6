package main.shape;

public class Triangle implements Shape {
    private double A;
    private double B;
    private double C;

    public Triangle(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b ||
                a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("НЕВЕРНО ЗАДАНЫ РАЗМЕРЫ!!!!");
        else {
            this.A = a;
            this.B = b;
            this.C = c;
        }
    }

    @Override
    public double calcPerimeter() {
        return this.A + this.B + this.C;
    }

    @Override
    public double calcArea() {
        double p = calcPerimeter() / 2;
        return Math.sqrt(p * (p - this.A) * (p - this.B) * (p - this.C));
    }

    @Override
    public String toString() {
        return "Треугольник (" + A + ',' + B + ',' + C + ')';
    }

    @Override
    public Shape clone() {
        try {
            return (Triangle) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
