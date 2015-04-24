/**************************************************************
 * CIST 2744 Advanced Game Physics, Section 41259             *
 *                                                            *
 * Assignment:  Final Project: Boink                          *
 *                                                            *
 * Name:        Aidan Hegarty, SID 3036 (last four)           *
 *                                                            *
 * Description: A platform game with an appetite for          *
 *              destruction! Help the green Boink-ball        *
 *              catch the blue Bink-ball by clicking          *
 *              wooden platform planks.                       *
 *                                                            *
 **************************************************************/
package com.aidan3d.boink;

import java.awt.Color;
import java.awt.Graphics;
import math.geom2d.Vector2D;

/**
 * The Circle class represents a single circle shape
 * to operate as a "sprite" on screen (i.e., it will
 * move around and hit things). A circle might be a
 * ball, the pocket on a pool table or, conceivably,
 * a balloon, floating through the sky.
 * 
 */
public class Circle {
    protected Vector2D center;          // The circle's center (also, its
                                        // displacement)
    
    protected double radius;            // The circles radius
    
    protected double mass;

    protected Vector2D velocity;        // The circle's speed and heading

    protected Vector2D acceleration;    // The circles change in direction and
                                        // speed

    protected Vector2D gravitationalForce;

    protected Color fillColor;          // The circle's "fill" color
    
    /**
     * The no-argument constructor.
     */
    public Circle() {

        center = new Vector2D(0.0F, 0.0F);
        radius = 0.0F;
        mass = 0.0F;
        velocity = new Vector2D(0.0F, 0.0F); // otherwise initialized to (0, 1)
        gravitationalForce = new Vector2D(0.0F, 0.0F);
        fillColor = null;        

    } // end Circle no-argument constructor

    
    /**
     * The two-argument constructor
     * @param c a 2d Euclidian vector referencing the
     * circle's center
     * @param r the circle's radius
     * @param m the circle's mass, in kg
     * @param g the strength and direction of the gravitational force
     * operating on this circle
     * @param ink the circle's fill color
     * @
     */
    public Circle(Vector2D c, double r,  double m, Vector2D g, Color ink) {
        
        center = c;
        radius = r;
        mass = m;
        velocity = new Vector2D(0.0F, 0.0F);
        gravitationalForce = g;
        fillColor = ink;

    } // end Circle two-argument constructor

    
    /**
     * Refers the Vector2D object velocity to a new heading and speed.
     * @param v a Euclidian 2d vector representing the circle's velocity
     */
    public void setVelocity(Vector2D v) {
    
        velocity = v;
        
    } // end method setVelocity


    private Vector2D calcAcceleration() {

        // Hold the 
        acceleration = new Vector2D();

        // First push on the gravity.
        acceleration = acceleration.plus(gravitationalForce.times(Math.pow(mass, -1.0)));
        
        // Return zero acceleration for a system
        // in pleasant equilibrium.
        return acceleration;

    } // end method calcAcceleration
    

    /**
     * This method paints a circle to screen.
     * @param sheet the backbuffer
     */
    public void draw(Graphics sheet) {

        // Draw the circle first.
        sheet.setColor(fillColor);
        sheet.fillOval((int)center.x(), (int)center.y(), (int)(2* radius),(int)(2 * radius));

        // Draw the circle's "gyroscope.
        sheet.setColor(Color.white);
        sheet.drawLine((int)(center.x() + radius), (int)(center.y() + radius),
            (int)(center.x() + radius), (int)(center.y() + (2 * radius)));
    } // end method draw


    /**
     * This method sets the circle to the right
     * position in the game window before the
     * <i>draw()</i> method is called to paint the
     * circle to screen.
     */
    public void move() {
        
        // Add the Euclidian 2d vector "acceleration" to "velocity";
        // then
        // add the Euclidian 2d vector "velocity" to the 2d Euclidian
        center = (center.plus(velocity)).plus(calcAcceleration());

    } // end method move

} // end class Circle
