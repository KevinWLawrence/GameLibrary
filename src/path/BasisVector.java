/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package path;

import java.awt.Point;

/**
 *
 * @author kevin.lawrence
 */
public class BasisVector {

    private double x, y;
    boolean isNormalized = false;

//   <editor-fold defaultstate="collapsed" desc="Constructors">  
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
//   </editor-fold>

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

//   <editor-fold defaultstate="collapsed" desc="Getters and Setters">  
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
//   </editor-fold>
}
