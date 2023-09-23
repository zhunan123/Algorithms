package week5.designpatternContinue.adapter.withAdapter;

import week5.designpatternContinue.adapter.withoutAdapter.Line;

public class LineShape implements Shape{
    private Line line = new Line();

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        line.drawLine(x1, y1, x2, y2);
    }
}
