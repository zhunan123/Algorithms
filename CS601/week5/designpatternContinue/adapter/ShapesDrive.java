package week5.designpatternContinue.adapter;

import week5.designpatternContinue.adapter.withAdapter.LineShape;
import week5.designpatternContinue.adapter.withAdapter.RectangleShape;
import week5.designpatternContinue.adapter.withAdapter.Shape;
import week5.designpatternContinue.adapter.withoutAdapter.Line;
import week5.designpatternContinue.adapter.withoutAdapter.Rectangle;

public class ShapesDrive {

    public static void main(String[] args) {
        int x1 = 10, y1 = 20;
        int x2 = 30, y2 = 60;

        // Without the adapter: not elegant
        Object[] shapes = {new Line(), new Rectangle()};
        for (int i = 0; i < shapes.length; ++i) {
            if (shapes[i] instanceof Line) {
                ((Line) shapes[i]).drawLine(x1, y1, x2, y2);
            } else if (shapes[i] instanceof Rectangle) {
                ((Rectangle) shapes[i]).drawRec(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
            }
        }


        System.out.println("-------------------------------------------");
        // After using adapter: clean, general, elegant
        // let both LineShape and Rectangle Shape implement Shape interface which has draw method
        // then each LineShape and RectShape is like have a extra layer method called draw()
        // which draw is a more general method that must implement from Shape Interface
        // and in each draw, if is a Line instance call drawLine and if is Rectangle instance call drawRect()
        Shape[] shapesArr = {new LineShape(), new RectangleShape()};
        // A beginning and end point from a graphical editor
        for (int i = 0; i < shapesArr.length; ++i)
            shapesArr[i].draw(x1, y1, x2, y2);

    }
}
