/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package path;

import java.awt.Point;

/**
 *
 * @author kevinlawrence
 */
public class PathSegment {

    private Point start, end;
    private BasisVector basis;

//   <editor-fold defaultstate="collapsed" desc="Constructors">  
    public PathSegment(Point start, Point end) {
        this.start = start;
        this.end = end;

        this.basis = new BasisVector(start, end, true);
    }
//   </editor-fold>  

//   <editor-fold defaultstate="collapsed" desc="Getters and Setters">  
    public BasisVector getBasis() {
        return this.basis;
    }

    /**
     * @return the start
     */
    public Point getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Point getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Point end) {
        this.end = end;
    }
//   </editor-fold>  

    /**
     * Compute if the Point provided is "beyond" the endpoint of the segment. -
     * For x (horizontal) dimension, if segment bears: - WEST: any point to the
     * WEST is beyond, i.e. Point.x < end.x - EAST: any point to the EAST is
     * beyond; i.e. Point.x > end.x - NONE: (vertical line) ignore and rely on y
     * check;
     *
     * - For y (vertical) dimension, if segment bears: - NORTH: any point to the
     * NORTH is beyond, i.e. Point.y < end.y - SOUTH: any point to the SOUTH is
     * beyond; i.e. Point.y > end.y - NONE: (horizontal line) ignore...
     *
     * @return boolean: true if point is beyond endpoint, false otherwise
     */
    public boolean isPointPastEnd(Point point) {
        // Check x dimension (WEST <------> EAST)
        if ((end.x - start.x) > 0) {   // EAST
            return (point.x > end.x);
        } else {                       // WEST
            if (point.x < end.x) {
                return true;
            }
        }

        // Check y dimension (NORTH <------> SOUTH)
        if ((end.y - start.y) > 0) {   //SOUTH
            if (point.y > end.y) {
                return true;
            }
        } else {                       // NORTH
            if (point.y < end.y) {
                return true;
            }
        }

        return false;
    }
}
