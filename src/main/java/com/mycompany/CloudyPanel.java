package com.mycompany;

/**
 * A custom JPanel that draws a semi-transparent beige overlay.
 * The overlay is used to fade the 2048 game board when the game ends,
 * while keeping the tiles underneath partially visible.
 * 
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID 2472007
 */

public class CloudyPanel extends javax.swing.JPanel {
    
    public CloudyPanel() {
        setOpaque(false);
    }
    
    /**
     * Paints a semi-transparent beige rectangle over the entire panel.
     * 
     * @param g the Graphics object used to draw the panel
     */
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(new java.awt.Color(238, 228, 218, 180));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}