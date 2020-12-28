package main.helper;

import main.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeAccumulator {
    private List<Shape> shapeAccum;

    public ShapeAccumulator() {
        this.shapeAccum = new ArrayList<Shape>();
    }

    public ShapeAccumulator(List<? extends Shape> list) {
       this.shapeAccum = new ArrayList<>();
        for(Shape shape : list)
            this.shapeAccum.add(shape.clone());
    }

    public void add(Shape shape) {
        shapeAccum.add(shape);
    }

    public void addAll(List<? extends Shape> shapes) {
        shapeAccum.addAll(shapes);
    }

    public final Shape GetMaxAreaShape() {
        Shape maxAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (maxAreaShape.calcArea() < shape.calcArea()) {
                maxAreaShape = shape;
            }
        }
        return maxAreaShape;
    }

    public final Shape GetMinAreaShape() {
        Shape minAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (minAreaShape.calcArea() > shape.calcArea()) {
                minAreaShape = shape;
            }
        }
        return minAreaShape;
    }

    public final Shape GetMaxPerimeterShape() {
        Shape maxAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (maxAreaShape.calcPerimeter() < shape.calcPerimeter()) {
                maxAreaShape = shape;
            }
        }
        return maxAreaShape;
    }

    public final Shape GetMinPerimeterShape() {
        Shape minAreaShape = shapeAccum.get(0);
        for (Shape shape : shapeAccum) {
            if (minAreaShape.calcPerimeter() > shape.calcPerimeter()) {
                minAreaShape = shape;
            }
        }
        return minAreaShape;
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapeAccum) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for (Shape shape : shapeAccum) {
            totalPerimeter += shape.calcPerimeter();
        }
        return totalPerimeter;
    }
}
