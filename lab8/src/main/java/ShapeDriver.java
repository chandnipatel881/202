import processing.core.*;

public class ShapeDriver extends PApplet {

    private static final long serialVersionUID = 1L;
    private Shape[] shapes;

    public void setup()
    {
        size (200, 200);
        smooth();

        // your code here
        shapes = new Shape[4];
        shapes[0] = new Circle(50,50,20,this);
        shapes[1] = new Circle(100,150,75,this);
        shapes[2] = new Rectangle(120,90,this,300,150);
        shapes[3] = new Rectangle(130,150,this,200,150);

    }

    public void draw()
    {
        background (127);

        for(int i = 0; i < shapes.length; i++){
            fill(i * 64);
            shapes[i].draw();
        }
    }

    public static void main(String[] args) {
        PApplet.main(args);
        //Instantiate an object of the driver class.
        //Call the setup method on the above object.
        //Call the draw method on the above object.
        ShapeDriver driver = new ShapeDriver();
        driver.setup();
        driver.draw();

    }

}
