package com.mycompany;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * A custom JPanel that displays a background with rounded corners. Draws an
 * anti-aliased rounded rectangle while preserving its child components and
 * their layout.
 *
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID 2472007
 */
public class RoundedPanel extends JPanel {

    public RoundedPanel() {
        setOpaque(false);
    }

    /**
     * Paints the panel's background as a rounded rectangle. Uses anti-aliasing
     * to create smooth corners while allowing Swing to paint the panel's child
     * components normally.
     *
     * @param g the graphics context used to paint the panel
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
