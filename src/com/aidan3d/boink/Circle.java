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

    // <editor-fold defaultstate="collapsed" desc="Fields">

    protected Vector2D center;      // the circle's center (also, its displacement)
    protected double radius;        // the circles radius
    protected double mass;          // the circle's mass is needed for kinetic energy-based calculations
    protected Vector2D velocity;    // the circle's speed and heading
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    /**
     * The no-argument constructor.
     */
    public Circle() {
        center = new Vector2D(0.0F, 0.0F);
        radius = 0.0F;
        velocity = new Vector2D(0.0F, 0.0F); // otherwise initialized to (0, 1)
        mass = 0.0F;
    }

    
    /**
     * The four-argument constructor
     * @param c a 2d Euclidian vector referencing the
     * circle's center
     * @param r the circle's radius
     * @param v the circle's initial velocity, a 2d euclidian vector
     * @param m the circle's mass, in kg
     */
    public Circle(Vector2D c, double r,  Vector2D v, double m) {
        center = c;
        radius = r;
        velocity = v;
        mass = m;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Operations">
    
    /**
     * This method handles a series of connected questions
     * relating to time:
     * <p>
     * &nbsp &nbsp &nbsp a) Is this circle going to hit the received Rectangle<br>
     * &nbsp &nbsp &nbsp &nbsp &nbsp object (or, looking at things in a "Newtonian" way:<br>
     * &nbsp &nbsp &nbsp &nbsp &nbsp is any part of the Rectangle object going to enter<br>
     * &nbsp &nbsp &nbsp &nbsp &nbsp this circle's airspace).
     * <p>
     * &nbsp &nbsp &nbsp b) how long is the wall's journey towards us;
     * <p>
     * &nbsp &nbsp &nbsp c) at what proportion of that journey-time are we<br>
     * &nbsp &nbsp &nbsp &nbsp &nbsp located temporally (valid range:  0 - 1 inclusive)?
     * <p>
     * We'll do this by expanding the Rectangle object by the radius of<br>
     * the circle, and seeing if our circle's center is being held for<br>
     * ransom by the infringing Rectangle object.
     * @param rect a Rectangle object holding its centroid and vertices
     * @return truth if any of the vertices are inside this circle
     */
    public boolean circleRectangleCollision(Rectangle rect) {

        boolean status = false;  // a signal flag, raised if any of the rectangle's vertices are
                                 // in this circle's "airpsace"
        
        //****************************************************
        // 1. Let's see if any of the "incoming"             *
        //    rectangle's vertices are inside                *
        //    this circle's "airsplace."                     *
        //****************************************************
        
        for(Vector2D vertex : rect.getVertexList()) {
            
            if (pointCircleCollision(vertex)) {
                
                status = true;
            
            } // end if
            
        } // end for
        
        return status;
    
    } // end method i


    /**
     * Draw the Circle. Will be overridden by the
     * subclass. Uses the calling object's
     * backbuffer.
     * @param sheet a <i>backbuffer</i> belonging to
     * the calling object.
     */
    public void draw(Graphics sheet) {
    } // end method draw


    /**
     * Move the circle. Will be overridden by
     * the subclass.
     */
    public void move() {
    } // end method move


    /**
     * This method is a "radar detector," lighting up if
     * the vertex received in the parameter is inside this
     * circle
     * @param vertex a 2d Euclidian vector referring to the
     * incurring node
     * @return true if the incurring vertex is "inside" this circle
     */
    public boolean pointCircleCollision(Vector2D vertex) {
        
        boolean status = false;  // a signal flag, raised if we have a "hit."

        // create a vector connecting the impinging vertex to this circle's center
        Vector2D displacement = vertex.minus(center);
        
        // check the length of the rope from-the-vertex-to-this-circle's-center
        if (displacement.norm() < radius) {
            
            // the tethered point IS in our "airspace"
            status = true;

        } // end if
                
        return status;
        
    } // end method pointCircleCollision

    // </editor-fold>

} // end class Circle
