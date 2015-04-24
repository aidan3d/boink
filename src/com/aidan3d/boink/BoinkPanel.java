/**************************************************************
 * CIST 2744 Advanced Game Physics, Section 41259             *
 *                                                            *
 * Assignment:  Final Project: Boink                          *
 *                                                            *
 * Name:        Aidan Hegarty, SID 3036 (last four)           *
 *                                                            *
 * Description: A platform game with an appetite for          *
 *              destruction! Help the green Boink-ball        *
 *              catch the blue Bink-ball by removing          *
 *              wooden platform planks.                       *
 *                                                            *
 **************************************************************/
package com.aidan3d.boink;

import Eureka.EurekaPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import math.geom2d.Angle2D;         // using the PI constants
import math.geom2d.Vector2D;


/**
 * The <b>BoinkPanel</b> is a <b>JPanel</b> (or more precisely
 * <b>a EurekaPanel</b>) object on which we paint.
 * @author hardnett
 */
public class BoinkPanel extends EurekaPanel {
    
    // Fields
    private final double BOINK_RADIUS = 32.0F;          // The BoinkPanel's (or ball's)
                                                        // radius

    private final double BOINK_MASS = 10.0F;            // All Boinks contain 10kg
                                                        // of matter (accelerate 
                                                        // at a rate of 1px per
                                                        // second vertically)
    
    private final Color GREEN_SKIN = Color.GREEN;
    private final Vector2D GRAVITY = new Vector2D(0.0F, 10.0F); // A force
                                                                // y is downards
                                                                // so the force is
                                                                // positive
    
    private final Circle bill;
    private final BoinkWindow boinkTop;
    private final Font boinkFont;
    private final FontMetrics metrics;

    public BoinkPanel() {

        // Initialize the EurekaPanel superclass (which
        // itself inherits from the JPanel class and sits
        // inside the BoinkWindow (JFrame-derived) object.
        this(null, 0L);

    } // end of BoinkPanel()


    public BoinkPanel(BoinkWindow bunk, long p) {

        // Initialize the Component superclass
        // downwards. We can access ALL of the
        // superclass's variables and methods in
        // the parental inheritance list (Grandad
        // is a JPanel, Great Grandad is an awt
        // component, etc).
        super(p);

        // In case we need to refer to the parent
        // object (super. = bunk.)
        boinkTop = bunk;
        super.
        setBackground(Color.cyan);
        setPreferredSize(new java.awt.Dimension(PWIDTH, PHEIGHT));

        // Create the green boink who will be doing the "hitting."
        bill = new Circle(new Vector2D(0.0F, 0.0F), BOINK_RADIUS, BOINK_MASS, GRAVITY, GREEN_SKIN);
        
        
        // setup the message font
        boinkFont = new Font("SansSerif", Font.BOLD, 24);
        metrics = this.getFontMetrics(boinkFont);

    } // end of BoinkPanel(MainWindow, long)


      /**
     * This is the initialization method that should be overridden 
     * by the derived class. This method will only be called once for setting up
     * game objects.
     */
    @Override
    public void customizeInit() {
        
    } // end method customizeInit


    /**
     * This is the Render() method that should be overridden during inheritance and
     * customized for your game to handle frame rendering.
     */
    @Override
    public void customizeGameRender() {
        
        if (!super.gameOver) {
            theCanvas.setColor(Color.black); // splash on a "cloudless sky" color
            theCanvas.fillRect(0, 0, super.getWidth(), super.getHeight());

            theCanvas.setColor(Color.white); // text font color is white
            theCanvas.setFont(boinkFont);    // text font style

            // place bill on stage in the current position
            bill.draw(theCanvas);

        } // end if

    } // end method customizeGameRender


    /**
     * This is the GameUpdate() method that should be overridden during inheritance
     * and customized for your game to handle frame updates.
     */
    @Override
    public void customizeGameUpdate() {

        // Move bill-the-BoinkPanel first.
        bill.move();
        
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
