/**************************************************************
 *                B O I N K !                                 *
 *                                                            *
 * Author:        Aidan Hegarty                               *
 *                                                            *
 * Last modified: May 6, 2015                                 *
 *                                                            *
 * Description:   A platform game with an appetite for        *
 *                destruction! Help the green Boink-ball      *
 *                catch the blue Bink-ball by removing        *
 *                wooden platform planks.                     *
 *                                                            *
 **************************************************************/
package com.aidan3d.boink;

import java.awt.Color;
import java.awt.Graphics;
import math.geom2d.Vector2D;

/**
 * The <b>Ball</b> class represents a bouncing
 * ball. Depending on its "bounciness" it could
 * be a bowling ball or a "basket" ball!
 */
public class Ball extends Circle {

    // <editor-fold defaultstate="collapsed" desc="Fields">

    protected Vector2D gravity;             // a force operating on the ball
    protected Color fillColor;              // the balls's "fill" color

    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">
     
    /**
     * The no-argument (default) constructor.
     */
    public Ball() {
        // call the superclass's default constructor
        super();
        
        gravity = new Vector2D(0.0F, 0.0F);
        fillColor = Color.GRAY;
    }


    /**
     * The six-argument constructor.
     * @param c The ball's center
     * @param r The ball's displacement, or current position in space at it's center
     * @param v The ball's speed and heading
     * @param m The ball's mass, in kg
     * @param g The value of the gravitational force in our system, in Newtons
     * @param ink  The ball's color
     */
    public Ball( Vector2D c, double r, Vector2D v, double m, Vector2D g, Color ink ) {
        // initialize the superclass's constuctor first
        super(c, r, v, m);
        
        gravity = g;
        fillColor = ink;
    }

    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Operations">

    /**
     * 
     * @return a Vector2D object holding the ball's
     * resultant acceleration, based on Newtonian forces
     * in the system.
     */
    private Vector2D calcAcceleration() {

        // a variable to hold the computed acceleration
        Vector2D acceleration = new Vector2D(0.0F, 0.0F);

        // first push on the gravity.
        acceleration = acceleration.plus(gravity.times(Math.pow(mass, -1.0)));

        return acceleration;
    }
    

    /**
     * This method paints a circle to screen.
     * @param sheet the backbuffer
     */
    @Override
    public void draw(Graphics sheet) {
        // fill the ball with the right pigment
        sheet.setColor(fillColor);
        
        // create the ball at the right point in space
        sheet.fillOval((int)center.x(), (int)center.y(), (int)(2* radius),(int)(2 * radius));
    }


    /**
     * This method sets the circle to the right position in
     * the game window before the <i>draw()</i> method is
     * called to paint the ball to screen.
     */
    @Override
    public void move() {
        
        // add the Euclidian 2d vector "acceleration" to "velocity"; then add the Euclidian 2d vector 
        // "velocity" to the 2d Euclidian
        center = (center.plus(velocity)).plus(calcAcceleration());

    } // end method move
    
    // </editor-fold>

} // end class Ball
