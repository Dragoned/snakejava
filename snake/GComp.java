package snake;

import javax.swing.JPanel;
import java.awt.Color;

public class GComp extends JPanel {

    private static final long serialVersionUID = 1L;

    public GComp(Color b){
        this.setBackground(b);
    }
    
    public void CColor(Color b){
        this.setBackground(b);
        this.repaint();
    }
}