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
 *
 * The Rectangle class simulates a 2d shape. It uses
 * its major and minor axes to "build" itself after
 * receiving it's construction parameters from the
 * calling object.
 */
public class Rectangle
{
    // Fields
    Vector2D origin;        // the center of the rectangle (i.e. our placement point in the game window)
    Vector2D majorAxis;     // joins the origin to the right-hand vertical side of the rectangle
    Vector2D minorAxis;     // joins the origin to the top or "north" horizontal rail of the rectangle
    Vector2D topLeft;
    Vector2D topRight;
    Vector2D bottomRight;
    Vector2D bottomLeft;
    
    
    // Constructors
    /**
     * The no-argument (default) constructor.
     */
    public Rectangle() {
        origin = new Vector2D(0.0F, 0.0F);
        majorAxis = new Vector2D(0.0F, 0.0F);
        minorAxis = new Vector2D(0.0F, 0.0F);
        topLeft = new Vector2D(0.0F, 0.0F);
        topRight = new Vector2D(0.0F, 0.0F);
        bottomRight = new Vector2D(0.0F, 0.0F);
        bottomLeft = new Vector2D(0.0F, 0.0F);

    } // end no-argument constructor
    
    
    /**
     * The three-argument constructor.
     * @param startPoint the centroid of the rectangle, and "placement" point in the game window
     * @param major joins the rectangle's origin to the right-hand vertical "rail"
     * @param minor  joins the rectangle's origin to the topmost horizontal "rail"
     */
    public Rectangle(Vector2D startPoint, Vector2D major, Vector2D minor) {

        origin = startPoint;
        majorAxis = major;
        minorAxis = minor;
        topLeft = new Vector2D(0.0F, 0.0F);
        topRight = new Vector2D(0.0F, 0.0F);
        bottomRight = new Vector2D(0.0F, 0.0F);
        bottomLeft = new Vector2D(0.0F, 0.0F);

    } // end three-argument constructor


    /**
     * Build out the rectangle's four perimeter points using:
     * <p>
     *     &nbsp &nbsp a) The <i>"center"</i>;
     *     <p>
     *     &nbsp &nbsp b) The length-from-center-to-right-hand- <br>
     *        &nbsp &nbsp &nbsp &nbsp vertical-rail (we're referring to this value <br>
     *        &nbsp &nbsp &nbsp &nbsp value with the 2d euclidian vector <i>"majorAxis"</i>);
     *     <p>
     *     &nbsp &nbsp c) The length-from-center-to-topmost-rail <br>
     *        &nbsp &nbsp &nbsp &nbsp (<i>"minorAxis"</i> will refer to this 2d euclidian <br>
     *        &nbsp &nbsp &nbsp &nbsp vector).
     */
    private void build() {
        // in the build() method's space,
        // let major axis = a,
        //     minor axis = b.

        // origin - (a - b) = upper left-hand point: A
        topLeft = origin.minus(majorAxis.minus(minorAxis));

        // origin + (a + b) = upper right-hand point: B
        topRight = origin.plus(majorAxis.plus(minorAxis));

        // origin + (a - b) = lower right-hand point: C
        bottomRight = origin.plus(majorAxis.minus(minorAxis));

        // origin - (a + b) = lower left-hand point: D
        bottomLeft = origin.minus(majorAxis.plus(minorAxis));

    } // end method build
    
    
    /**
     * Intended to be overridden by the subclass.
     */
    public void draw(Graphics sheet) {
        
        // use a yellow crayon
        sheet.setColor(Color.yellow);
        
        // draw the rectangle's origin
        sheet.drawOval((int)(origin.x()-3), (int)(origin.y()-3), 6, 6);
        
        
        // draw the major axis.
        sheet.drawOval((int)(origin.plus(majorAxis).x()-3), (int)(origin.plus(majorAxis).y()-3), 6, 6);
        
        // draw the minor axis.
        sheet.drawOval((int)(origin.plus(minorAxis).x()-3), (int)(origin.plus(minorAxis).y()-3), 6, 6);
        //sheet.drawOval((int)(topLeft.x()-3), (int)(topLeft.y()-3), 6, 6);
    }

}