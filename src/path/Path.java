/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package path;

import java.util.ArrayList;

/**
 *
 * @author kevinlawrence
 */
public class Path {
//    TODO: Consider refactor - does this add anything to a raw arraylist?

    private ArrayList<PathSegment> path = new ArrayList<PathSegment>();

//   <editor-fold defaultstate="collapsed" desc="Constructors">  
    public Path(ArrayList<PathSegment> path){
        this.path = path;
    }
//   </editor-fold>  

//   <editor-fold defaultstate="collapsed" desc="Getters and Setters">  
    /**
     * @return the path
     */
    public ArrayList<PathSegment> getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(ArrayList<PathSegment> path) {
        this.path = path;
    }
//   </editor-fold>  

}
