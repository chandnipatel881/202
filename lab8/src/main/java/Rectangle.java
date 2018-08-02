import processing.core.*;

public class Rectangle extends Shape{

    private int width;
    private int height;

    Rectangle(int x, int y, PApplet canvas, int width, int height){
        super(x,y,canvas);
        this.width = width;
        this.height = height;
    }

    public void draw(){
        getCanvas().rect(getX(),getY(),width,height);
    }
}
