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
        lOben = new Lampe(30,30);
        lMitte = new Lampe(30, 80);
        lUnten = new Lampe(30, 130);
        setRed();
    }
    
    
    
    private void setRed(){
        phase = "red";
        lOben.setCol(Color.red);
        lMitte.setCol(Color.gray);
        lUnten.setCol(Color.gray);
        
    }
    
    private void setGreen(){
        phase = "green";
        lOben.setCol(Color.gray);
        lMitte.setCol(Color.gray);
        lUnten.setCol(Color.green);
        
     }
    
    public void setYellow(){
        phase = "yellow";
        lOben.setCol(Color.gray);
        lMitte.setCol(Color.yellow);
        lUnten.setCol(Color.gray);
        
    }
    
    private void setRedYellow(){
        phase = "redYellow";
        lOben.setCol(Color.red);
        lMitte.setCol(Color.yellow);
        lUnten.setCol(Color.gray);
    }
    
    public void next1(){
        
      if (phase == "green")     {setYellow(); return;};
      if (phase == "yellow")    {setRed(); return;};
      if (phase == "red")       {setRedYellow(); return;}
      if (phase == "redYellow") {setGreen(); return;}
    }
    
    public void next2(){ 
      if (phase == "green") setYellow();
      else if (phase == "yellow") setRed();
           else if (phase == "red") setRedYellow();
                else setGreen();  // RedYellow
    }
    
    public void next(){
      switch (phase) {
          case "green":     setYellow(); Timer.start(2000); break;
          case "yellow":    setRed(); Timer.start(10000); break;
          case "red":       setRedYellow(); Timer.start(1000); break;
          case "redYellow": setGreen(); Timer.start(10000); break;
      }
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
