/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package path;

import environment.Movable;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import path.PathEventHandler.PathEventType;

/**
 *
 * @author kevinlawrence
 */
public final class PathMoveManager {
    /**
     * TODO: Will this be more efficient if a "base vector" is calculated for
     * movement for each path?  Only relevant (maybe) if allow paths that
     * are neither vertical nor horizontal. First iteration - keep it simple...
     */

    /**
     * TODO: Should there be a "path" velocity (perhaps default) or a PathSegment
     * velocity (again, perhaps default) that would apply to all movers, or
     * should we allow each mover to have their own velocity on the path?
     * Should probably keep it simple for now, and have only "path" velocity
     */

    /**
     * TODO: The assumption built into the addMover methods is that Movers can
     * only be added at the start of the Path (the start of the first 
     * PathSegment); should this object be enhanced to allow the placement of a
     * Mover at the start of any segment, or perhaps at any point in along the
     * path?
     */

    private ArrayList<Segment> path;
    private ArrayList<ArrayList<Movable>> segmentMovers;
    private double speed = 3;
    private PathEventHandler pathEventHandler;
    private int FIRST_SEGMENT = 0;
    
//   <editor-fold defaultstate="collapsed" desc="Constructors">  
    public PathMoveManager(ArrayList<Segment> path){
        this.path = path;
        createSegmentMovers();
    }

    public PathMoveManager(ArrayList<Segment> path, ArrayList<Movable> movers){
        this.path = path;
        createSegmentMovers();

        for (Movable mover : movers) {
            addMover(mover);
        }
    }
//   </editor-fold>  

    private void createSegmentMovers(){
        //create an ArrayList of ArrayList<Segment> elements: one for each segment
        //this structure will track the Movable objects that are on each segment
        segmentMovers = new ArrayList<ArrayList<Movable>>();

        for (Segment segment : path) {
            segmentMovers.add(new ArrayList<Movable>());
        }
    }

    public void addMover(Movable mover){
        addMover(mover, 0);
    }

    private void addMover(Movable mover, int pathSegmentIndex){

        mover.setPosition(new Point(path.get(pathSegmentIndex).getStart().x,
                                    path.get(pathSegmentIndex).getStart().y));

        segmentMovers.get(pathSegmentIndex).add(mover);

        if (pathSegmentIndex == FIRST_SEGMENT) {
            raisePathEvent(PathEventHandler.PathEventType.PATH_START, mover);
        }
        raisePathEvent(PathEventHandler.PathEventType.SEGMENT_START, mover);
    }

    /**
     * This method will iterate across all Mover objects that have been added to
     * the PathMoveManager object, and will attempt to move that object along 
     * the the its current PathSegment. If the mover reaches the end of a
     * segment, it is moved to the next segment. If the mover reaches the end 
     * of the path, it is removed from the PathMoveManager. Note that PathEvents
     * are raised in both instances.
     */
    public void moveAll(){
        Movable currentMover;
        Iterator movers;

        for (int pathSegmentIndex = 0; pathSegmentIndex < segmentMovers.size(); pathSegmentIndex++){
            //for each set of movers, move all objects
            //if the object cannot move (move call returns false) then are at
            //end of segment:
            //  - if possible, move to next segment
            //  - if at end of path, discard mover
            movers = segmentMovers.get(pathSegmentIndex).iterator();

            while (movers.hasNext()){
                currentMover = (Movable) movers.next();
                if (!path.get(pathSegmentIndex).moveAlongSegment(currentMover, speed)){
                    //failed movement: must be at end of segment
                    raisePathEvent(PathEventHandler.PathEventType.SEGMENT_END, currentMover);
                    movers.remove();

                    if (pathSegmentIndex == path.size() - 1){
                        //at end of path: remove from structure, then notify
                        raisePathEvent(PathEventHandler.PathEventType.PATH_END, currentMover);
                    } else {
                        //move to next segment
                        addMover(currentMover, pathSegmentIndex+1);
                        raisePathEvent(PathEventHandler.PathEventType.SEGMENT_START, currentMover);
                    }
                }
            }
        }
    }

    /**
     * @param pathEventType the type of path event to be raised through the 
     * PathEventHandler callback method
     * @param mover the object of type Mover that is associated with the path 
     * event; this will also be passed through the PathEventHandler callback
     */
    private void raisePathEvent(PathEventType pathEventType, Movable mover) {
        if (getPathEventHandler() != null) {
            getPathEventHandler().pathEvent(pathEventType, mover);
        }
    }

    //   <editor-fold defaultstate="collapsed" desc="Getters and Setters">  
    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the path
     */
    public ArrayList<Segment> getPathClone() {
        ArrayList<Segment> pathClone = new ArrayList<Segment>();
        
        for (Segment segment : path) {
            pathClone.add(segment);
        }
            
        return pathClone;
    }

    /**
     * @return the pathEventHandler
     */
    public PathEventHandler getPathEventHandler() {
        return pathEventHandler;
    }

    /**
     * @param pathEventHandler the pathEventHandler to set.  This interface is 
     * used as a callback for events (segment start/end, path start/end; see the 
     * PathEventHandler interface for more information) 
     */
    public void setPathEventHandler(PathEventHandler pathEventHandler) {
        this.pathEventHandler = pathEventHandler;
    }
//   </editor-fold>  

}
