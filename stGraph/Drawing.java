
package stGraph;
import TrafficLight.Ampel;
import TrafficLight.Timer;


/** <h1> template methods setup() and draw() like in processing </h1> */
    class Drawing { 
    
//  set here the size of the graphic:
    final int width = 100;
    final int height = 200;

// your variables:
   Ampel ampel;
   
// template methods:   
   void setup(){
       ampel = new Ampel();
   }
   
   void draw(){
     Canvas.clear();
     if(Timer.isFinished()) ampel.next();
     ampel.display();
   }
   
   void mousePressed(){}
   
   
   // ----------------------------------------------------------
    final Canvas canvas = new Canvas(width, height){
          @Override
          public void _draw(){
             draw();
         }
          @Override
          public void _mousePressed(){
              mousePressed();
          }
       };  
// ----------------------------------------------------------
    
}
