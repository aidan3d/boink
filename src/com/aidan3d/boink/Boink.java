/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aidan3d.boink;

import Eureka.EurekaPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import math.geom2d.Vector2D;


/**
 *
 * @author hardnett
 */
public class Boink extends EurekaPanel {
    private final Circle bill;
    private final Tank boinkTop;
    private final Font boinkFont;
    private final FontMetrics metrics;

    public Boink() {
        this(null, 0L);
    } // end of Boink()


    public Boink(Tank bunk, long p) {
        super(p);

        boinkTop = bunk;

        setBackground(Color.cyan);
        setPreferredSize(new java.awt.Dimension(PWIDTH, PHEIGHT));

        // create game components here
        bill = new Circle(new Vector2D(0.0F, 0.0F), 40.0);
        
        // setup the message font
        boinkFont = new Font("SansSerif", Font.BOLD, 24);
        metrics = this.getFontMetrics(boinkFont);

    } // end of Boink(MainWindow, long)


      /**
     * This is the initialization method that should be overridden 
     * by the derived class. This method will only be called once for setting up
     * game objects.
     */
    @Override
    public void customizeInit() {}


    /**
     * This is the Render() method that should be overridden during inheritance and
     * customized for your game to handle frame rendering.
     */
    @Override
    public void customizeGameRender() {
        
        if (!super.gameOver) {
            theCanvas.setColor(Color.cyan); // splash on a "cloudless sky" color
            theCanvas.fillRect(0, 0, super.getWidth(), super.getHeight());

            theCanvas.setColor(Color.white);      // text font color is white
            theCanvas.setFont(boinkFont);           // text font style
            
            // draw your game components here

            // place bill on stage in the current position
            bill.draw(theCanvas);
        }
    }


    /**
     * This is the GameUpdate() method that should be overridden during inheritance
     * and customized for your game to handle frame updates.
     */
    @Override
    public void customizeGameUpdate() {
      // Update your game state here: move objects, change screen text, etc.
    }


    @Override
    public void customizeMousePress(int i, int i1) {}


    @Override
    protected void preGameLoop() {}


    @Override
    protected void insideGameLoop() {}


    @Override
    protected void postGameLoop() {}
}
