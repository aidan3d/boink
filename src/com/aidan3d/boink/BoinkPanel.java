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
import java.util.ArrayList;
import math.geom2d.Vector2D;


/**
 * The <b>BoinkPanel</b> is a <b>JPanel</b> (or more precisely
 * <b>a EurekaPanel</b>) object on which we paint.
 * @author hardnett
 */
public class BoinkPanel extends EurekaPanel {

    // <editor-fold defaultstate="collapsed" desc="Fields">

    private final double BOINK_RADIUS = 16.0F;          // the ball's radius
    
    private final double BOINK_MASS = 1.0F;             // all the young Boinks contain 1kg of matter (accelerating 
                                                        // at a rate of 10px per second vertically) with a
                                                        // gravitational force equal to ten newtons directed
                                                        // towards screen-"south"
    private final int TANK_WIDTH = 384;
    private final int TANK_HEIGHT = 384;
    
    private final Color BLUE_SLEEVE = Color.blue;       // the Blue Boink's cover is blue (challenger)
    private final Color YELLOW_SLEEVE = Color.yellow;   // a Yella Boink's cover is yellow (challenged-boink)

    // a Boink to be dropped down from on-high
    private final Vector2D INITIAL_POSITION_BLUE = new Vector2D(PWIDTH/2-BOINK_RADIUS, PHEIGHT/2-TANK_HEIGHT/2);
    
    // a Boink to be dropped-upon
    private final Vector2D INITIAL_POSITION_YELLOW = new Vector2D(PWIDTH/2+4, PHEIGHT/2+TANK_HEIGHT/2-2*BOINK_RADIUS); 
    
    private final Vector2D INITIAL_VELOCITY = new Vector2D(0.0F, 0.0F);    // get the ball rolling

    
    private final Vector2D GRAVITY = new Vector2D(0.0F, 0.0F); // y is downwards so this
                                                                // force is always positive

    private final Rectangle tank;                       // the fish tank in which the bonks "float"

    private final ArrayList<Rectangle> topBunkList;     // the upper platform offering safe haven for Boinks

    private final Ball bill;                            // the blue Boink (or "mushy" ball)
    private final Ball ben;                             // the yellow Boink

    private final BoinkWindow boinkTop;                 // the calling object
    private final Font boinkFont;                       // used to display on-screen message
    private final FontMetrics metrics;                  // needed by the Font object

    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public BoinkPanel() {

        // call the two-argument constructor if we have an empty panel
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

        // create the fish tank
        tank = new Rectangle(new Vector2D(PWIDTH/2,PHEIGHT/2), new Vector2D(TANK_WIDTH/2, 0.0F),
            new Vector2D(0.0F, TANK_HEIGHT/2));
        
        // the upper platform is an array of Rectangle objects
        topBunkList = new ArrayList();
        
        // create the blue boink who will be doing the "hitting."
        bill = new Ball(INITIAL_POSITION_BLUE, BOINK_RADIUS, INITIAL_VELOCITY, BOINK_MASS, GRAVITY, BLUE_SLEEVE);
        
        // create a yellow "hitee" boink
        ben = new Ball(INITIAL_POSITION_YELLOW, BOINK_RADIUS, INITIAL_VELOCITY, BOINK_MASS, GRAVITY, YELLOW_SLEEVE);
        
        // set up the message font
        boinkFont = new Font("SansSerif", Font.BOLD, 24);
        metrics = this.getFontMetrics(boinkFont);

        // build the upper bunk (i.e. platform)
        buildUpperBunk();
    }
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="BoinkPanel Render/Update Loop Operations">
    
      /**
     * This is the initialization method that should be overridden 
     * by the derived class. This method will only be called once,
     * to set up game objects.
     */
    @Override
    public void customizeInit() {
        
    }


    /**
     * This is the Render() method that should be overridden during inheritance and
     * customized for your game to handle frame rendering.
     */
    @Override
    public void customizeGameRender() {
        
        if (!super.gameOver) {
            theCanvas.setColor(Color.black); // splash on a "cloudless sky" color
            theCanvas.fillRect(0, 0, PWIDTH, PHEIGHT);

            theCanvas.setColor(Color.white); // text font color is white
            theCanvas.setFont(boinkFont);    // text font style

            // construct a glass tank for the Boinks to float around in
            tank.draw(theCanvas);

            // draw the top bunk (platform)
            for (Rectangle rec : topBunkList)
                rec.draw(theCanvas);

            // place bill the "pursuer" on stage in the current position
            bill.draw(theCanvas);
            
            // place ben the "pursued" on stage
            ben.draw(theCanvas);

        } // end if

    } // end method draw


    /**
     * This is the GameUpdate() method that should be overridden during inheritance
     * and customized for your game to handle frame updates.
     */
    @Override
    public void customizeGameUpdate() {

        // Move bill-the-BoinkPanel first.
        bill.move();
        
    } // end method customizeGameUpdate


    @Override
    public void customizeMousePress(int i, int i1) {
    
    } // end method customizeMousePress


    @Override
    protected void preGameLoop() {
        
    } // end method preGameLoop


    @Override
    protected void insideGameLoop() {
    
    } // end method insideGameLoop


    @Override
    protected void postGameLoop() {
    
    } // end method postGameLoop
    
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Logical Game Operations">
    
    /**
     * Let's load the upperBunk list with
     * appropriate rectangles.
     */
    public void buildUpperBunk() {
        
        // add segement 1 of 4
        topBunkList.add(new Rectangle(new Vector2D(PWIDTH/2-TANK_WIDTH/2+BOINK_RADIUS*6, PHEIGHT/2+BOINK_RADIUS),
            new Vector2D(BOINK_RADIUS*2, 0.0), new Vector2D(0.0, BOINK_RADIUS)));
        
        // add segment 2 of 4
        topBunkList.add(new Rectangle(new Vector2D(PWIDTH/2-TANK_WIDTH/2+BOINK_RADIUS*10, PHEIGHT/2+BOINK_RADIUS),
            new Vector2D(BOINK_RADIUS*2, 0.0), new Vector2D(0.0, BOINK_RADIUS)));
        
        // add segment 3 of 4
        topBunkList.add(new Rectangle(new Vector2D(PWIDTH/2-TANK_WIDTH/2+BOINK_RADIUS*14, PHEIGHT/2+BOINK_RADIUS),
            new Vector2D(BOINK_RADIUS*2, 0.0), new Vector2D(0.0, BOINK_RADIUS)));
        
        // add segment 4 of 4
        topBunkList.add(new Rectangle(new Vector2D(PWIDTH/2-TANK_WIDTH/2+BOINK_RADIUS*18, PHEIGHT/2+BOINK_RADIUS),
            new Vector2D(BOINK_RADIUS*2, 0.0), new Vector2D(0.0, BOINK_RADIUS)));
    }
    // </editor-fold>


} // end class BoinkPanel
