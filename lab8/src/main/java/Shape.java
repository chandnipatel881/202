import java.util.*;
import processing.core.PApplet;

public abstract class Shape{

    private int x;
    private int y;
    private PApplet canvas;

    Shape(int x, int y, PApplet canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PApplet getCanvas() {
        return canvas;
    }

    public abstract void draw();
}
