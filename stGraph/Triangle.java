
package stGraph;

/**
 *
 * @author Herbert Wenisch
 */

    class Triangle extends java.awt.geom.GeneralPath.Double {
    
    Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        super();
        moveTo(x1,y1);
        lineTo(x2, y2);
        lineTo(x3, y3);
        closePath();
    }
}
