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
//    TODO: Will this be more efficient if a "base vector" is calculated for
//          movement for each path?  Only relevant (maybe) if allow paths that
//          are neither vertical nor horizontal.
//          First iteration - keep it simple (Graham's game), then expand for
//          Alex's game.

//    TODO: Should there be a "path" velocity (perhaps default) or a pathsegment
//          velocity (again, perhaps default) that would apply to all movers, or
//          should we allow each mover to have their own velocity on the path?
//          Should probably keep it simple for now, and have "path" velocity


    private ArrayList<Segment> path;
    private ArrayList<ArrayList<Movable>> segmentMovers;
    private double speed = 3;
    private PathEventHandler pathEventHandler;
    private int FIRST_SEGMENT = 0;
    
    public PathMoveManager(ArrayList<Segment> path){
        this.path = path;
        createSegmentMovers();
    }

    public PathMoveManager(ArrayList<Segment> path, ArrayList<Movable> movers){
        this.path = path;
        createSegmentMovers();

        for (Movable mover : movers)
            addMover(mover);
    }

    private void createSegmentMovers(){
        //create an ArrayList of ArrayList<Segment> elements: one for each segment
        //this structure will track the Movable objects that are on each segment
        segmentMovers = new ArrayList<ArrayList<Movable>>();

        for (Segment segment : path)
            segmentMovers.add(new ArrayList<Movable>());
    }


    public void addMover(Movable mover){
        addMover(mover, 0);
    }

    private void addMover(Movable mover, int pathSegmentIndex){

        mover.setPosition(new Point(path.get(pathSegmentIndex).getStart().x,
                                    path.get(pathSegmentIndex).getStart().y));

        segmentMovers.get(pathSegmentIndex).add(mover);

        if (pathSegmentIndex == FIRST_SEGMENT)
            raisePathEvent(PathEventHandler.PathEventType.PATH_START, mover);
        raisePathEvent(PathEventHandler.PathEventType.SEGMENT_START, mover);
    }

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

    private void raisePathEvent(PathEventType pathEventType, Movable mover) {
        if (getPathEventHandler() != null)
            getPathEventHandler().pathEvent(pathEventType, mover);
    }

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
        for (Segment segment : path)
            pathClone.add(segment);
            
        return pathClone;
    }

    /**
     * @return the pathEventHandler
     */
    public PathEventHandler getPathEventHandler() {
        return pathEventHandler;
    }

    /**
     * @param pathEventHandler the pathEventHandler to set
     */
    public void setPathEventHandler(PathEventHandler pathEventHandler) {
        this.pathEventHandler = pathEventHandler;
    }

}
