/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package path;

import environment.Movable;
import java.awt.Point;

/**
 *
 * @author kevinlawrence
 */
public class SimpleSegment implements Segment {

    public enum Direction {WEST, NORTH, EAST, SOUTH};
    
    private final Direction direction;
    private Point start, end;
    private double remainder;

    public SimpleSegment(Point start, Point end){
        this.start = start;
        this.end = end;

        if (end.x > start.x)
            this.direction = Direction.EAST;
        else if (end.x < start.x)
            this.direction = Direction.WEST;
        else if (end.y > start.y)
            this.direction = Direction.SOUTH;
        else
            this.direction = Direction.NORTH;
    }

    public SimpleSegment(Point start, Point end, Direction direction){
        this.start = start;
        this.end = end;
        
        this.direction = direction;
    }

    @Override
    public boolean moveAlongSegment(Point point, double speed) {
        return applyMovement(point, computeMovement(speed));
    }

    @Override
    public boolean moveAlongSegment(Movable mover, double speed) {
        return applyMovement(mover.getPosition(), computeMovement(speed));
    }

    private int computeMovement(double speed) {
        return (int) speed;

/*      The following code creates a problems when there are multiple movers
 *      on the same Segment concurrently, as the remainders are moved from
 *      mover to mover... yuk!
 *
 *      Temporary solution: just truncate velocity (double) into an int for now;
 *      not really a problem until we get angled lines: NOT SimpleSegment
 *
 *      Proper Solution(s):
 *      1) Have Actor carry remainder? Don't really want to change
 *         or sepcialize Actor class
 *
 *      2) Inversion of control - plug in "mover" class (more flexible, neater)
 */
//        double delta = speed + remainder;
//        int movement = (int) delta;
//        remainder = delta - movement;
//
//        return movement;
    }

    private boolean applyMovement(Point point, int movement) {
        switch (direction){
            case EAST:
                point.x += movement;
                break;

            case WEST:
                point.x -= movement;
                break;

            case NORTH:
                point.y -= movement;
                break;

            case SOUTH:
                point.y += movement;
        }
        return !atEnd(point);
    }

    @Override
    public boolean atEnd(Point point){
        switch (direction){
            case EAST:
                return point.x >= end.x;
            case WEST:
                return point.x <= end.x;
            case NORTH:
                return point.y <= end.y;
            case SOUTH:
                return point.y >= end.y;
            default:
                return false;
        }
    }

    @Override
    public Point getStart() {
        return this.start;
    }

    @Override
    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public Point getEnd() {
        return this.end;
    }

    @Override
    public void setEnd(Point end) {
        this.end = end;
    }

    public Direction getDirection(){
        return this.direction;
    }

}
