package com.mycompany;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

/**
 * A custom JLabel that displays a 2048 tile with rounded corners. Draws an
 * anti-aliased background while preserving the label's text.
 *
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID 2472007
 */
public class RoundedTile extends JLabel {

    public RoundedTile() {
        setOpaque(false);
    }

    /**
     * Paints the tile's rounded background and displays its text
     *
     * @param g the graphics context used to paint the tile
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D tileGraphics;

        tileGraphics = (Graphics2D) g.create();
        tileGraphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        tileGraphics.setColor(getBackground());
        tileGraphics.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        tileGraphics.dispose();
        super.paintComponent(g);
    }
}
