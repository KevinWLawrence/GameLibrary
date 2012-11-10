/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.awt.Point;

/**
 *
 * @author kevinlawrence
 */
public class Platform {
    private Point start, end;
    private String type = "Platform";
    
//  <editor-fold defaultstate="collapsed" desc="Constructors">
    public Platform(Point start, Point end){
        this.start = start;
        this.end = end;
    }
//  </editor-fold>    
    
//  <editor-fold defaultstate="collapsed" desc="Getters and setters">    
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
//  </editor-fold>
    
}
