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
import java.util.ArrayList;
import math.geom2d.Vector2D;


/**
 *
 * The Rectangle class simulates a 2d shape. It uses
 * its major and minor axes to "build" itself after
 * receiving it's construction parameters from the
 * calling object.
 */
public class Rectangle {

    // <editor-fold defaultstate="collapsed" desc="Fields">

    protected Vector2D origin;        // the center of the rectangle (i.e. our placement point in the game window)
    protected Vector2D majorAxis;     // joins the origin to the right-hand vertical side of the rectangle
    protected Vector2D minorAxis;     // joins the origin to the top or "north" horizontal rail of the rectangle

    protected Vector2D topLeft;       // the uppermost left-hand vertex
    protected Vector2D topRight;      // the uppermost right-hand vertex
    protected Vector2D bottomRight;   // the lowermost left-hand vertext
    protected Vector2D bottomLeft;    // the lowermost right-hand vertext
    
    ArrayList<Vector2D> vertices;

    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Constructors">

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
        
        vertices = new ArrayList<>();

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
        
        vertices = new ArrayList<>();
        
        // stack 'em. Lets build the four peripheral points.
        build();
        
        loadVertexList();
        
    } // end three-argument constructor

    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Accessors">

    /**
     * This method retrieves the 2d Euclidian vector
     * referred to by the instance variable "topLeft."
     * @return the rectangle's left-hand uppermost vertex
     */
    public Vector2D getTopLeft() {

        return topLeft;

    } // end method getTopLeft


    /**
     * This method retrieves the 2d Euclidian vector
     * referred to by the instance variable "topRight."
     * @return  the rectangle's right-hand uppermost
     * vertex
     */
    public Vector2D getTopRight() {

        return topRight;

    } // end method getTopRight


    /**
     * This method retrieves the 2d Euclidian vector
     * referred to by the instance variable "bottomRight."
     * @return  the rectangle's right-hand lowermost
     * vertex
     */
    public Vector2D getBottomRight() {

        return bottomRight;

    } // end method getBottomRight


    /**
     * This method retrieves the 2d Euclidian vector
     * referred to by the instance variable "bottomLeft."
     * @return the rectangles left-hand lowermost
     * vertex
     */
    public Vector2D getBottomLeft() {

        return bottomLeft;

    } // end method getBottomLeft


    /**
     * This method retrieves the set of 2d Euclidian
     * vectors (i.e. <i>vertices</i>) defining this rectangle.
     * @return a list containing the rectangle's vertices
     */
    public ArrayList<Vector2D> getVertexList() {
        return vertices;
    }
    
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Operations">

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

        // origin - (a + b) = upper left-hand point: A
        topLeft = origin.minus(majorAxis.plus(minorAxis));
        
        // origin + (a - b) = upper right-hand point: B
        topRight = origin.plus(majorAxis.minus(minorAxis));

        // origin + (a + b) = lower right-hand point: C
        bottomRight = origin.plus(majorAxis.plus(minorAxis));

        // origin - (a - b) = lower left-hand point: D
        bottomLeft = origin.minus(majorAxis.minus(minorAxis));
        
    } // end method build
    
    
    /**
     * Intended to be overridden by the subclass.
     */
    public void draw(Graphics sheet) {

        //****************************************************
        // 1. Draw the rectangle's vertices.                 *
        //                                                   *
        //****************************************************

        // 1.1 use a yellow crayon
        sheet.setColor(Color.yellow);

        // 1.2 draw the rectangle's origin
        sheet.drawOval((int)(origin.x()-3), (int)(origin.y()-3), 6, 6);

        // draw the major axis
        sheet.drawOval((int)(origin.plus(majorAxis).x()-3), (int)(origin.plus(majorAxis).y()-3), 6, 6);

        // draw the minor axis
        sheet.drawOval((int)(origin.plus(minorAxis).x()-3), (int)(origin.plus(minorAxis).y()-3), 6, 6);

        // try some red ink!
        sheet.setColor(Color.red);

        // draw A
        sheet.drawOval((int)(topLeft.x()-6), (int)(topLeft.y()-6), 12, 12);

        // draw B
        sheet.drawOval((int)(topRight.x()-6), (int)(topRight.y()-6), 12, 12);

        // draw C
        sheet.drawOval((int)(bottomRight.x()-6), (int)(bottomRight.y()-6), 12, 12);

        // draw D
        sheet.drawOval((int)(bottomLeft.x()-6), (int)(bottomRight.y()-6), 12, 12);


        //****************************************************
        // 2. Draw the rectangle's edges.                    *
        //                                                   *
        //****************************************************

        // draw AB
        sheet.drawLine((int)topLeft.x(), (int)topLeft.y(), (int)topRight.x(), (int)topRight.y());
        
        // draw BC
        sheet.drawLine((int)(topRight.x()), (int)(topRight.y()), (int)(bottomRight.x()), (int)(bottomRight.y()));

        // draw CD
        sheet.drawLine((int)(bottomRight.x()), (int)(bottomRight.y()), (int)(bottomLeft.x()), (int)(bottomLeft.y()));

        // draw DA
        sheet.drawLine((int)(bottomLeft.x()), (int)(bottomLeft.y()), (int)(topLeft.x()), (int)(topLeft.y()));

    } // end method draw


    /**
     * Populate the list of vertices. This will be useful for
     * calling objects to detect collisions.
     */
    protected void loadVertexList() {

        vertices.add(topLeft);
        vertices.add(topRight);
        vertices.add(bottomRight);
        vertices.add(bottomLeft);

    } // end mthod loadVertexList

    // </editor-fold>

} // end class Rectangle