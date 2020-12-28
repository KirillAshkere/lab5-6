package main.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double a) {
        if(a <= 0)
            throw new IllegalArgumentException("НЕВЕРНО ЗАДАНЫ РАЗМЕРЫ!!!!");
        else
            this.radius = a;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public Shape clone()  {
        try {
            return (Circle) super.clone();
        }
        catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public String toString() {
        return "Круг c радиусом "+radius;
    }


}
