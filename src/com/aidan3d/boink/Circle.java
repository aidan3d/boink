/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    protected Vector2D center;  // the circle's center
    protected double radius;    // the circles radius
    
    /**
     * The no-argument constructor.
     */
    public Circle() {
        center = new Vector2D(0.0F, 0.0F);
        radius = 0.0F;
    }

    
    /**
     * The two-argument constructor
     * @param c a 2d Euclidian vector referencing the
     * circle's center
     * @param r the circle's radius
     */
    public Circle(Vector2D c, double r) {
        center = c;
        radius = r;
    }


    /**
     * This method paints a circle to screen.
     * @param buf the backbuffer
     */
    public void draw(Graphics buf) {
        buf.drawOval(0, 0, 100, 100);
    }


    /**
     * This method sets the circle in the right
     * position in the game window before we
     * call the draw() method.
     */
    public void update() {
    
    }

}
