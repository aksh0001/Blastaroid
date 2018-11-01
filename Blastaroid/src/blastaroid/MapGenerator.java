package blastaroid;

import java.awt.*;

/**
 * This class generates the map/setting of Blastaroid by initialising a 2D array representing bricks.
 *
 * @author a.k
 */
public class MapGenerator {
    /**
     * This field represents the collection of bricks. We use a 2D array data structure to model this. Could use HT's
     */
    public int[][] map;
    /**
     * The width of each brick
     */
    public int brickWidth;
    /**
     * The height of each brick
     */
    public int brickHeight;

    /**
     * This constructor initialises the maximum available bricks in the game specified by row,col.
     *
     * @param row number of bricks horizontally
     * @param col number of bricks vertically
     * @throws IllegalArgumentException if row/col is less than 1
     */
    public MapGenerator(int row, int col) // Inject row/col primitive constructor dependency (don't know if that's a thing)
    {
        if (row < 1 || col < 1) throw new IllegalArgumentException("Error: No bricks initialised");
        this.map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.map[i][j] = 1; // 1 represents an active brick
            }
        }
        this.brickHeight = 150 / row; // Will use hacky way for now
        this.brickWidth = 540 / col;
    }

    /**
     * This method draws all existing bricks.
     *
     * @param g a graphics object to draw.
     * @complexity O(N ^ 2) where N is the number of bricks
     */
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                if (this.map[i][j] > 0) {
                    g.setColor(Color.GRAY);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    // Define borders
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }

    }
}
