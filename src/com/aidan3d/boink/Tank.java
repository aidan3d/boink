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

/**
 * The Tank class simulates a glass fish tank or
 * aquarium. In it are bunk beds on which Boinks
 * rest (until they hit each other and roll around
 * on the bunks).
 * 
 */
public class Tank
{
    /**
     * No-argument (default) constructor. Creates
     * an empty fish tank with no physical size.
     */
    public Tank() {
    
    } // end no-argument (default) Tank constructor


    /**
     * Let's load the upperBunk list with
     * appropriate rectangles.
     */
    public void buildUpperBunk() {
    /*
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
    */
    } // end method buildUpperBunk

} // end class Tank
