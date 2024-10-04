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
    

    
    public Point getCenter(){
        return shape.getCenter();


    }

    public Ellipse getShape(){
        return shape;
    }

    public void grow(double amount){
        setRadius(radius + amount);

    }

    private void setRadius(double newRadius){
        if (newRadius < 0){
            newRadius = 0;
        }
        radius = newRadius;
        Point previousCenter = shape.getCenter();
        shape.getCenter();
        shape.setSize(new Point(newRadius*2, newRadius*2));
    }

    public Point getCenter() {
        return shape.getCenter();
    }

    /**
     * Causes this cell to interact with the other given cell. If the two
     * cells overlap and both have a positive radius, then the larger cell
     * absorbs area from the smaller cell so that the total area is the
     * same, but the two cells are now tangent.
     */
    public void interactWith(Cell otherCell) {
        if (radius == 0 || otherCell.radius == 0) {
            return;
        }
        if (overlapAmount(otherCell) < 0) {
            return;
        }

        if (radius > otherCell.radius) {
            absorb(otherCell);
        } else {
            otherCell.absorb(this);
        }
    }

    private double overlapAmount(Cell otherCell) {
        return radius + otherCell.radius - getCenter().distance(otherCell.getCenter());
    }

    private void absorb(Cell otherCell) {
        double d = getCenter().distance(otherCell.getCenter());
        double a = sqr(radius) + sqr(otherCell.radius);
        double newRadius = (d + Math.sqrt(2 * a - sqr(d))) / 2;

        setRadius(newRadius);
        otherCell.setRadius(d - newRadius);
    }

    private static double sqr(double x) {
        return x * x;
    }
]}

    

