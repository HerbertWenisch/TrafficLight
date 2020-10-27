
package stGraph;


import java.awt.BasicStroke;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.geom.AffineTransform;
import java.awt.event.MouseEvent;

/**
 * <h1>Basic capabilities for creating drawings</h1>
 * @author Herbert Wenisch
 * @since 8.3.19 
 */

public abstract class Canvas extends TimerTask {
    
    private static final long DEFAULT_FRAME_RATE = 30;
    private static final float DEFAULT_PEN_RADIUS = 5f;
    private static final Color DEFAULT_COLOR = Color.darkGray;
    private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
    
    private final int width;
    private final int height;
 
    static GPanel gPanel;
    private static Timer timer;
    
    private static long frameRate = DEFAULT_FRAME_RATE;

    private static Color color = DEFAULT_COLOR;  // Füllfarbe
    private static Color penColor = DEFAULT_PEN_COLOR;
    private static float penRadius = DEFAULT_PEN_RADIUS;
    private static Stroke stroke;
    private static boolean border = true;
    private static Graphics2D g2D;
    private final static AffineTransform trans = new AffineTransform();
    
/** previous mousePosition */
    public static double pmouseX;
/** previous mousePosition  */
    public static double pmouseY;
/** mousePosition while calling draw() */
    public static double mouseX;
/** mousePosition while calling draw() */    
    public static double mouseY;
    
//  current mousePositions:
    private static double cmouseX;
    private static double cmouseY;
    
//  ----------------------------------------------------------------------
    public Canvas(int width, int height){
        this.width = width;
        this.height = height;
        gPanel = new GPanel(width, height);
        
        gPanel.addMouseMotionListener(new MouseAdapter(){
           @Override
           public void mouseMoved(MouseEvent evt) {     
               cmouseX = evt.getX();
               cmouseY = evt.getY();
           }
        });  
        
        gPanel.addMouseListener(new MouseAdapter(){
           @Override
           public void mousePressed(MouseEvent evt) {     
               _mousePressed();
           }
        });  
        
        g2D = gPanel.getG2D();
        timer = new Timer();
        stroke = new BasicStroke(penRadius, BasicStroke.CAP_BUTT, 
                                            BasicStroke.JOIN_MITER);
    }
//    ----------------------------------------------------------------------
    abstract protected void _draw();
    abstract protected void _mousePressed();
    
    
    /** clear graphic window */
    public static void clear(){
        gPanel.clear();
    }
    
    /** 
    * @param frameRate indicates how many times draw()is called per second 
    */
    public static void setFrameRate(long frameRate) {
        Canvas.frameRate = frameRate;
    }

   public void StartDrawing(){
       timer.schedule(this, 0, 1000/frameRate);
   }
   
   private static void actualizeMousePos(){
       pmouseX = mouseX;
       pmouseY = mouseY;
       mouseX = cmouseX;
       mouseY = cmouseY;
   }
   
   @Override
   public void run(){
       _draw();
       actualizeMousePos();
       gPanel.repaint();
   }
   
   /** @param color  filling color */
   public static void setColor(Color color){
       Canvas.color = color;
    }
   
   public static void setPenColor(Color color){
       Canvas.penColor = color;
       setStroke();
   }
   
   public static void setPenRadius (float penRadius){
       Canvas.penRadius = penRadius;
       setStroke();
   }
   
   
   public static void noBorder(){
       border = false;
   }
   
   public static void withBorder(){
       border = true;
   }
   
   private static void setStroke(){
       stroke = new BasicStroke(penRadius, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
   }
   
   private static void drawShape(Shape shape){
       g2D.setColor(penColor);
       g2D.setStroke(stroke);
       g2D.setTransform(trans);
       if(border) g2D.draw(shape);
       g2D.setColor(color);
       g2D.fill(shape);
   }
   
//   Primitives:
   
   /** graphic primitive */
   public static void circle(double mx, double my, double r){
       Shape circle = new Circle(mx,my,r);
       drawShape(circle);
    }
   
   /** graphic primitive */
   public static void point(double x, double y){
       Shape circle = new Circle(x,y,penRadius);
       boolean pborder = Canvas.border;
       Color pcolor = Canvas.color;
       Canvas.color = Canvas.penColor;
       border = false;
       drawShape(circle);
       Canvas.border = pborder;
       Canvas.color = pcolor;
   }
   
   /** graphic primitive */
   public static void triangle(double x1, double y1, double x2, double y2, double x3, double y3){
       Shape triangle = new Triangle(x1, y1, x2, y2, x3, y3);
       drawShape(triangle);
   }
   
   /** graphic primitive */
   public static void ellipse(double x, double y, double width, double height){
       Shape ellipse = new java.awt.geom.Ellipse2D.Double(x,y,width, height);
       drawShape(ellipse);
   }
   
   /** graphic primitive */
   public static void rect(double x, double y, double width, double height){
       Shape rect = new java.awt.geom.Rectangle2D.Double(x, y, width, height);
       drawShape(rect);
   }
   
   /** graphic primitive */
   public static void rectRound(double x, double y, double width, double height,
                         double arcWidth, double arcHeight){
       Shape rect = new java.awt.geom.RoundRectangle2D.Double(x, y, width, height,
                                                 arcWidth, arcHeight);
       drawShape(rect);
   }
   
   /** graphic primitive */
   public static void line(double x1, double y1, double x2, double y2){
       Shape line = new java.awt.geom.Line2D.Double(x1, y1, x2, y2);
       g2D.setColor(penColor);
       g2D.setStroke(stroke);
       g2D.setTransform(trans);
       g2D.draw(line);
   }
   
   /** graphic primitive */
   public static void text(String text, double x, double y){
       g2D.setStroke(stroke);
       g2D.setColor(color);
       g2D.setTransform(trans);
       g2D.drawString(text, (float)x, (float)y);
   }
   
   public static void setFont(String name, int size){
       g2D.setFont(new Font(name, Font.PLAIN, size));
   }
   
// Manipulationen des User-Koordinatensystem:  
   
   /** change User-Cosy */
   public static void translate(double tx, double ty){
       trans.translate(tx, ty);
   }
   
 
   /**
   * change User-Cosy 
   * @param phi in radians  */
   public static void rotate(double phi){
       trans.rotate(phi);
   }
   
/** reset User-Cosy  */
   public static void resetCosy(){
       trans.setToIdentity();
   }
   
}