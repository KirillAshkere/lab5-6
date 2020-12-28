package main.gui;

import main.helper.ShapeAccumulator;
import main.shape.Circle;
import main.shape.Rectangle;
import main.shape.Shape;
import main.shape.Triangle;
import main.shape.Square;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;


public class ShapeApp extends JDialog {
    private JPanel contentPane;
    private JButton upShapeButton;
    private JButton downShapeButton;
    private JButton deleteShapeButton;
    private JButton addCircleButton;
    private JButton addSquareButton;
    private JButton addRectangleButton;
    private JButton addTriangleButton;
    private JButton calcAreaButton;
    private JButton calcPerimeterButton;
    private JList<Object> jListShape;
    private JButton getTotalPerimeterButton;
    private JButton getTotalAreaButton;
    private JButton getMaxPerimeterShapeButton;
    private JButton getMaxAreaShapeButton;
    private JButton getMinPerimeterButton;
    private JButton getMinAreaShapeButton;
    private DefaultListModel<Object> defaultListModel;
    private List<Shape> listShape;


    public ShapeApp(List<Shape> listShape) {
        this.listShape = listShape;
        $$$setupUI$$$();
        setContentPane(contentPane);
        setModal(true);

        defaultListModel = new DefaultListModel<>();
        jListShape.setModel(defaultListModel);
        setInDefaultList();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        upShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jListShape.getSelectedIndex();
                if (selectedIndex != -1) {
                    if (selectedIndex != 0) {
                        Collections.swap(listShape, selectedIndex, selectedIndex - 1);
                        setInDefaultList();
                    }
                } else JOptionPane.showMessageDialog(null, "Выберите фигуру!");
            }
        });

        downShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jListShape.getSelectedIndex();
                if (selectedIndex != -1) {
                    if (selectedIndex != 0) {
                        Collections.swap(listShape, selectedIndex, selectedIndex + 1);
                        setInDefaultList();
                    }
                } else JOptionPane.showMessageDialog(null, "Выберите фигуру!");
            }
        });
        deleteShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jListShape.getSelectedIndex();
                if (selectedIndex != -1) {
                    listShape.remove(selectedIndex);
                    defaultListModel.remove(selectedIndex);
                } else JOptionPane.showMessageDialog(null, "Выберите фигуру!");
            }
        });
        addCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCircle editCircle = new EditCircle();
                editCircle.pack();
                editCircle.setVisible(true);
                Circle circle = editCircle.getCircle();
                if (circle != null) {
                    defaultListModel.addElement(circle);
                    listShape.add(circle);
                } else JOptionPane.showMessageDialog(null, "Введёные` данные не сохранились!");
            }
        });
        addRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditRectangle editRectangle = new EditRectangle();
                editRectangle.pack();
                editRectangle.setVisible(true);
                Rectangle rectangle = editRectangle.getRectangle();
                if (rectangle != null) {
                    defaultListModel.addElement(rectangle);
                    listShape.add(rectangle);
                } else JOptionPane.showMessageDialog(null, "Введёные данные не сохранились!");
            }
        });
        addTriangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditTriangle editTriangle = new EditTriangle();
                editTriangle.pack();
                editTriangle.setVisible(true);
                Triangle triangle = editTriangle.getTriangle();
                if (triangle != null) {
                    defaultListModel.addElement(triangle);
                    listShape.add(triangle);
                } else JOptionPane.showMessageDialog(null, "Введёные данные не сохранились!");
            }
        });
        addSquareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditSquare editSquare = new EditSquare();
                editSquare.pack();
                editSquare.setVisible(true);
                Square square = editSquare.getSquare();
                if (square != null) {
                    defaultListModel.addElement(square);
                    listShape.add(square);
                } else JOptionPane.showMessageDialog(null, "Введёные данные не сохранились!");
            }
        });
        calcPerimeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jListShape.getSelectedIndex();
                if (selectedIndex == -1)
                    JOptionPane.showMessageDialog(null, "Выберите фигуру для вычисления", "ОШИБКА!!!!!!", JOptionPane.PLAIN_MESSAGE);
                else {
                    Shape shape = (Shape) defaultListModel.get(selectedIndex);
                    JOptionPane.showMessageDialog(null, shape.calcPerimeter(), "Периметр: ", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        calcAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jListShape.getSelectedIndex();
                if (selectedIndex == -1)
                    JOptionPane.showMessageDialog(null, "Выберите фигуру для вычисления", "ОШИБКА!!!!!! ", JOptionPane.PLAIN_MESSAGE);
                else {
                    Shape shape = (Shape) defaultListModel.get(selectedIndex);
                    JOptionPane.showMessageDialog(null, shape.calcArea(), "Площадь: ", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });
        getTotalPerimeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeAccumulator shapeAccumulator = new ShapeAccumulator(listShape);
                JOptionPane.showMessageDialog(null, shapeAccumulator.getTotalPerimeter(), "Суммарный периметр фигур : ", JOptionPane.PLAIN_MESSAGE);
            }
        });
        getTotalAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeAccumulator shapeAccumulator = new ShapeAccumulator(listShape);
                JOptionPane.showMessageDialog(null, shapeAccumulator.getTotalArea(), "Суммарная площадь фигур : ", JOptionPane.PLAIN_MESSAGE);
            }
        });
        getMaxPerimeterShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeAccumulator shapeAccumulator = new ShapeAccumulator(listShape);
                JOptionPane.showMessageDialog(null, shapeAccumulator.GetMaxPerimeterShape().toString(), " Максимальный периметр у фигуры  : ", JOptionPane.PLAIN_MESSAGE);
            }
        });
        getMinPerimeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeAccumulator shapeAccumulator = new ShapeAccumulator(listShape);
                JOptionPane.showMessageDialog(null, shapeAccumulator.GetMinPerimeterShape().toString(), " Минимальный периметр у фигуры  : ", JOptionPane.PLAIN_MESSAGE);
            }
        });
        getMaxAreaShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeAccumulator shapeAccumulator = new ShapeAccumulator(listShape);
                JOptionPane.showMessageDialog(null, shapeAccumulator.GetMaxAreaShape().toString(), " Максимальная площадь у фигуры  : ", JOptionPane.PLAIN_MESSAGE);
            }
        });
        getMinAreaShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeAccumulator shapeAccumulator = new ShapeAccumulator(listShape);
                JOptionPane.showMessageDialog(null, shapeAccumulator.GetMinAreaShape().toString(), " Минимальная площадь у фигуры  : ", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    private void setInDefaultList() {
        defaultListModel = new DefaultListModel<>();
        for (Shape shape : listShape)
            defaultListModel.addElement(shape);
        jListShape.setModel(defaultListModel);

    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(17, 2, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        upShapeButton = new JButton();
        upShapeButton.setText("Поднять фигуру");
        panel1.add(upShapeButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        downShapeButton = new JButton();
        downShapeButton.setText("Опустить фигуру");
        panel1.add(downShapeButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteShapeButton = new JButton();
        deleteShapeButton.setText("Удалить фигуру");
        panel1.add(deleteShapeButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addCircleButton = new JButton();
        addCircleButton.setText("Добавить круг");
        panel1.add(addCircleButton, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addSquareButton = new JButton();
        addSquareButton.setText("Добавить квадрат");
        panel1.add(addSquareButton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addRectangleButton = new JButton();
        addRectangleButton.setText("Добавить прямоугольник");
        panel1.add(addRectangleButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addTriangleButton = new JButton();
        addTriangleButton.setText("Добавить треугольник");
        panel1.add(addTriangleButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        calcAreaButton = new JButton();
        calcAreaButton.setText("Посчитать площадь выбранной фигуры");
        panel1.add(calcAreaButton, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        calcPerimeterButton = new JButton();
        calcPerimeterButton.setText("Посчитать периметр  выбранной фигуры");
        panel1.add(calcPerimeterButton, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jListShape = new JList();
        panel1.add(jListShape, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 13, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        getTotalPerimeterButton = new JButton();
        getTotalPerimeterButton.setText("Вывести суммарный периметр фигур ");
        panel1.add(getTotalPerimeterButton, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getTotalAreaButton = new JButton();
        getTotalAreaButton.setText("Вывести суммарную площадь фигур");
        panel1.add(getTotalAreaButton, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getMaxPerimeterShapeButton = new JButton();
        getMaxPerimeterShapeButton.setText("Вывести фигуру с максимальным периметром");
        panel1.add(getMaxPerimeterShapeButton, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getMinPerimeterButton = new JButton();
        getMinPerimeterButton.setText("Вывести фигуру с минимальным периметром");
        panel1.add(getMinPerimeterButton, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getMaxAreaShapeButton = new JButton();
        getMaxAreaShapeButton.setText("Вывести фигуру с максимальной площадью");
        panel1.add(getMaxAreaShapeButton, new com.intellij.uiDesigner.core.GridConstraints(13, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        getMinAreaShapeButton = new JButton();
        getMinAreaShapeButton.setText("Вывести фигуру с минимальной площадью");
        panel1.add(getMinAreaShapeButton, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
