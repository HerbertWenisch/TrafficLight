/**
 * @author (Herbert wenisch)
 * @version (08-12-23)
 */

import java.awt.Color;

public class TrafficLight {
    private final String version = "1.1";
    // Colors:
    private final Color green = new Color(21,153,39);
    private final Color red = Color.red;
    private final Color gray = Color.gray;
    // states: red (normal state), green
    private String state; // current state
    // lamps:
    private Lamp lampUpper;
    private Lamp lampLower;
    
    public TrafficLight(){
       state = "red";
       lampUpper = new Lamp(0, 80, red);
       lampLower = new Lamp(0, 30, gray);
       display();
    }
    
    
    public void display(){
        // frame:
        Turtlegrafik.turtle.setPenColor(Color.black);
        Turtlegrafik.turtle.setPenWidth(2);
        Turtlegrafik.turtle.setPos(30,0);
        for(int i = 0; i < 2; i++){
           Turtlegrafik.turtle.fd(110);
           Turtlegrafik.turtle.lt(90);
           Turtlegrafik.turtle.fd(60);
           Turtlegrafik.turtle.lt(90);
        }
        // lamps:
        lampUpper.display();
        lampLower.display();
    }
      
    public void switchGreen(){
        state = "green";
        lampUpper.setColor(green);
        lampLower.setColor(gray);
        display();
    }
}

