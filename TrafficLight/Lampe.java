
/**
 * @author (Herbert Wenisch) 
 * @version (26.8.17)
 */
package TrafficLight;

import java.awt.Color;
import stGraph.Canvas;

public class Lampe {
    private Color col;
    private int x;
    private int y;
    
    public Lampe(int x, int y){
        col = Color.gray;
        this.x = x;
        this.y = y;
    }
    
    public void setCol(Color col){
        this.col = col;
    }
    
    public void display(){
        Canvas.noBorder();
        Canvas.setColor(col);
        Canvas.circle(x, y, 20);
    }
}