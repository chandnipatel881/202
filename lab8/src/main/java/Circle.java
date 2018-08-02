import processing.core.PApplet;

public class Circle extends Shape {

    private float radius;

    Circle(int x, int y, float radius, PApplet canvas){
        super(x,y,canvas);
        this.radius = radius;
    }

    public void draw(){
        getCanvas().ellipse(getX(),getY(),radius,radius);
    }
}
