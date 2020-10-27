package stGraph;

/**
 *
 * @author Herbert Wenisch
 */


import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.*;



/**
 *
 * @author Herbert Wenisch
 */
    class GPanel extends JPanel{
    
    private static GPanel gPanel;
    private static BufferedImage bi;
    private static Graphics2D graphics;
    private final int width, height;
    

    GPanel(int width, int height){
        this.width= width;
        this.height = height;
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = bi.createGraphics();
        setPreferredSize(new Dimension(width,height));
        clear();
    }

    final void clear(){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                bi.setRGB(x, y, -1);  // white
            }
        }
    }
    
    Graphics2D getG2D(){
        return graphics;
    }
    
    @Override public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
//      weiche Zeichnung:
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);   
        
        g2D.drawImage(bi, 0, 0, null);
    }
    
}