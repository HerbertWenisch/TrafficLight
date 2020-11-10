/**
 * @author (Herbert Wenisch) 
 * @version (25.08.17)
 */

package TrafficLight;
import java.awt.Color;
import stGraph.Canvas;

public class Ampel {
    private int x;
    private int y;
    private String phase;
    private Lampe lOben;
    private Lampe lMitte;
    private Lampe lUnten;
    
    public Ampel(){
        x = 0;
        y = 0;
        phase = "green";
        lOben = new Lampe(30,30);
        lMitte = new Lampe(30, 80);
        lUnten = new Lampe(30, 130);
        lUnten.setCol(Color.green);
    }
    
    public void setRed(){
        phase = "red";
        lOben.setCol(Color.red);
        lMitte.setCol(Color.black);
        lUnten.setCol(Color.black);
    }
    
    public void display(){
        // Gehäuse:
        Canvas.setColor(Color.lightGray);
        Canvas.rect(0,0,60,160);
        // Lampen:
        lOben.display();
        lMitte.display();
        lUnten.display();
    }
}
