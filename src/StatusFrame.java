
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONGSONG
 */
public class StatusFrame extends JFrame {

    public StatusFrame() {

        // init frame
        setVisible(true);

    }
    
    synchronized 
    public void showHalfWayDoneProgress() {

        myPanel.add(new JLabel("50%"));

    }

}
