
package stGraph;

/**
 *
 * @author Herbert Wenisch
 */
    class Circle extends java.awt.geom.Ellipse2D.Double {
    
        Circle(double mx, double my, double r){
        super(mx - r, my - r, 2*r, 2*r);
        }
    
    }

