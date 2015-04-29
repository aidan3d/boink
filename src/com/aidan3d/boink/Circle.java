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
    protected Vector2D center;      // the circle's center (also, its displacement)
    protected double radius;        // the circles radius
    protected double mass;          // the circle's mass is needed for kinetic energy-based calculations
    protected Vector2D velocity;    // the circle's speed and heading

    
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


    /**
     * Draw the Circle. Will be overridden by the
     * subclass. Uses the calling object's
     * backbuffer.
     * @param sheet a <i>backbuffer</i> belonging to
     * the calling object.
     */
    public void draw(Graphics sheet) {
    }


    /**
     * Move the circle. Will be overridden by
     * the subclass.
     */
    public void move() {
    }

} // end class Circle
