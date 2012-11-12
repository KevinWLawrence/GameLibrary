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

    public PathSegment(Point start, Point end) {
        this.start = start;
        this.end = end;

        this.basis = new BasisVector(start, end, true);
    }

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

    /**
     * Compute if the Point provided is "beyond" the endpoint of the segment.
     *   - For x (horizontal) dimension, if segment bears:
     *       - WEST: any point to the WEST is beyond, i.e. Point.x < end.x
     *       - EAST: any point to the EAST is beyond; i.e. Point.x > end.x
     *       - NONE: (vertical line) ignore and rely on y check;
     *
     *   - For y (vertical) dimension, if segment bears:
     *       - NORTH: any point to the NORTH is beyond, i.e. Point.y < end.y
     *       - SOUTH: any point to the SOUTH is beyond; i.e. Point.y > end.y
     *       - NONE: (horizontal line) ignore...
     *
     * @return boolean: true if point is beyond endpoint, false otherwise
     */
    public boolean isPointPastEnd(Point point) {

        // Check x dimension (WEST <------> EAST)
        if ((end.x - start.x) > 0)  //EAST
            return (point.x > end.x);
            
         else { // WEST
            if (point.x < end.x) {
                return true;
            }
        }

        // Check y dimension (NORTH <------> SOUTH)
        if ((end.y - start.y) > 0) { //SOUTH
            if (point.y > end.y) {
                return true;
            }
        } else { // NORTH
            if (point.y < end.y) {
                return true;
            }
        }

        return false;
    }

    public class BasisVector {

        private double x, y;
        boolean isNormalized = false;

        public BasisVector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public BasisVector(double x, double y, boolean isNormalized) {
            this.x = x;
            this.y = y;

            this.isNormalized = isNormalized;
            if (isNormalized) {
                normalize();
            }
        }

        public BasisVector(Point start, Point end, boolean isNormalized) {
            x = end.x - start.x;
            y = end.y - start.y;

            this.isNormalized = isNormalized;
            if (isNormalized) {
                normalize();
            }
        }

        private void normalize() {
            //compute normalized basis vector
            if ((x != 0.0) && (y != 0.0)) {
                // can't normalize (0, 0) basis, will get div by zero error
                double xBasisAbs = Math.abs(x);
                double yBasisAbs = Math.abs(y);

                x /= Math.max(xBasisAbs, yBasisAbs);
                y /= Math.max(xBasisAbs, yBasisAbs);
            }

        }

        /**
         * @return the x
         */
        public double getX() {
            return this.x;
        }

        /**
         * @return the y
         */
        public double getY() {
            return y;
        }
    }
}
