package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;

import java.awt.Color;
import java.util.Random;

public class Cell {
private static final double
        WIGGLINESS = -0.2,
        WANDER_FROM_CENTER = 60000;

    private Random rand = new Random();
    private Ellipse shape;
    private double radius;
    private double direction;

    public Cell(double x, double y, double radius, Color color) {
        this.radius=radius;
        shape.setFillColor(color);
        shape = new Ellipse(x, y,radius*2, radius*2);
        direction = normalizeRadians(Math.random() * Math.PI * 2);
    }
    
}

