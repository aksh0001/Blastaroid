import blastaroid.Gameplay;

import javax.swing.*;

/**
 * Class that starts Blastaroid.
 * Disclaimer: I know the code is smelly
 */
public class Application {
    public static void main(String[] args) {
        JFrame jf = new JFrame(); // Create a new JFrame
        jf.setTitle("Blastaroid");
        jf.setBounds(10, 10, 700, 600);
        jf.setResizable(false); // don't make it resizeable
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(new Gameplay());



    }
}
