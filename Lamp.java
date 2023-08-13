/**
 * @author (Herbert Wenisch)
 * @version (08-12-23)
 */

import java.awt.Color;

public class Lamp {
    private double x;
    private double y;
    private Color color;
    
    public Lamp(double x, double y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void display(){
        Turtlegrafik.turtle.setPenColor(color);
        Turtlegrafik.turtle.setPos(x,y);
        Turtlegrafik.turtle.dot(40);  // Kreis mit Durchmesser als Parameter
        Turtlegrafik.turtle.ht();  // hide turtle
    }
}
