package blastaroid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements ActionListener, KeyListener {
    /**
     * Boolean flag to indicate start of gameplay
     **/
    private boolean play = false;
    /**
     * The score of the player
     **/
    private int playerScore = 0;
    /**
     * The total number of tiles present in the game at any given time
     **/
    private int totalTiles = 21;
    /**
     * The ball's x position
     **/
    private int ballX = 120;
    /**
     * The ball's y position
     **/
    private int ballY = 350;
    /**
     * The ball's x direction
     **/
    private int ballXDir = -1;
    /**
     * The ball's y direction
     */
    private int ballYDir = -2;
    /**
     * The player's x postion
     */
    private int playerX = 310;
    /**
     * The delay for the timer
     */
    private int delay = 8;
    /**
     * Timer for the game
     */
    private Timer timer;

    public Gameplay() {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.timer = new Timer(this.delay, this);
        this.timer.start();

    }

    public void paint(Graphics g) {
        // background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        // border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        // slide
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);
        // ball
        g.setColor(Color.blue);
        g.fillRect(ballX, ballY, 20, 20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {// right arrow key - x pos should be incremented
            if (playerX >= 600) {
                playerX = 600; // Keep it within the border
            } else
                moveRight();

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {// left arrow key
            if (playerX < 10)
                playerX = 10; // Keep it within the border
            else
                moveLeft();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveRight() {
        play = true;
        playerX += 20; // Move 20px to the right
    }

    public void moveLeft() {
        play = true;
        playerX -= 20; // Move 20px to the left
    }
}
