
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONGSONG
 */
public class ApplicationThread extends Thread {

    public void run() {

        final StatusFrame frame = new StatusFrame();
        // do some CPU intensive computations
        frame.showHalfWayDoneProgress();
        // do more CPU intensive computations

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.showHalfWayDoneProgress();
            }
        });

    }

}
