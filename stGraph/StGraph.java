
package stGraph;


/**
* <h1>  Main class: don't change code </h1>
* @author Herbert Wenisch
*/

public class StGraph {

    
    private static final Drawing processing = new Drawing();
    
    public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
                        public void run() {
    				new Frame();
                                processing.setup();
                                processing.canvas.StartDrawing();
                                processing.draw();
			}
		});
    }
    
}
