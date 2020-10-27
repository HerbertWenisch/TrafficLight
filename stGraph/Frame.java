
package stGraph;

/**
 *
 * @author Herbert Wenisch
 */

import javax.swing.JFrame;


// GraphicWindow:
    class Frame extends JFrame {
        
	Frame(){
        add(Canvas.gPanel, java.awt.BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
	}
}