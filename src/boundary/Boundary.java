/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import environment.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author kevinlawrence
 */
public class Boundary implements BoundaryPhysics, Intersectable {

    private Edge north = new Edge(EdgeFace.NORTH);
    private Edge east = new Edge(EdgeFace.EAST);
    private Edge south = new Edge(EdgeFace.SOUTH);
    private Edge west = new Edge(EdgeFace.WEST);
    private Rectangle objectBoundary = new Rectangle(0, 0, 1, 1); // int x, int y, int width, int height) 
    private BoundaryPhysics boundaryPhysics;
    private IntersectionHandler intersectionHandler;

    public Boundary() {
    }

    public Boundary(BoundaryPhysics boundaryPhysics) {
        this.boundaryPhysics = boundaryPhysics;
    }

    /**
     * @param physicsObject the object to be affected by the interaction with
     * the boundary
     */
    @Override
    public void react(PhysicsObject physicsObject) {
        if (boundaryPhysics != null) {
            boundaryPhysics.react(physicsObject);
        } else {
            new DefaultBoundaryPhysics().react(physicsObject);
        }
    }

    /**
     * @return the intersectionHandler
     */
    public IntersectionHandler getIntersectionHandler() {
        return intersectionHandler;
    }

    /**
     * @param intersectionHandler the intersectionHandler to set
     */
    public void setIntersectionHandler(IntersectionHandler intersectionHandler) {
        this.intersectionHandler = intersectionHandler;
    }

    private class DefaultBoundaryPhysics implements BoundaryPhysics {

        @Override
        public void react(PhysicsObject physicsObject) {
            //if the objects are intersecting
            if (intersects(physicsObject)) {
                // test the center of mass location to assess which edge is being 
                // penetrated, then apply appropriate physics reaction
                Direction[] directions = Physics.getRelativeDirection(getCenterOfMass(), physicsObject.getCenterOfMass());

                switch (directions[0]) {
                    case NORTH:
                        physicsObject.getPosition().y = objectBoundary.y - physicsObject.getObjectBoundary().height;

                        if (north.getType() == EdgeType.SOLID) {
                            physicsObject.getVelocity().y = 0;
                        } else if (north.getType() == EdgeType.REFLECTIVE) {
                            physicsObject.getVelocity().y *= -1;
                        }

                        break;

                    case SOUTH:
                        physicsObject.getPosition().y = objectBoundary.y + getObjectBoundary().height;

                        if (north.getType() == EdgeType.SOLID) {
                            physicsObject.getVelocity().y = 0;
                        } else if (north.getType() == EdgeType.REFLECTIVE) {
                            physicsObject.getVelocity().y *= -1;
                        }

                        break;

                    case EAST:
                        physicsObject.getPosition().x = objectBoundary.x + getObjectBoundary().width;

                        if (north.getType() == EdgeType.SOLID) {
                            physicsObject.getVelocity().x = 0;
                        } else if (north.getType() == EdgeType.REFLECTIVE) {
                            physicsObject.getVelocity().x *= -1;
                        }

                        break;

                    case WEST:
                        physicsObject.getPosition().x = objectBoundary.x - physicsObject.getObjectBoundary().width;

                        if (north.getType() == EdgeType.SOLID) {
                            physicsObject.getVelocity().x = 0;
                        } else if (north.getType() == EdgeType.REFLECTIVE) {
                            physicsObject.getVelocity().x *= -1;
                        }

                        break;
                }
            }
        }
    }

    
//  <editor-fold defaultstate="collapsed" desc="Getters and Setters"> 
    /**
     * @return the center of mass as a Point
     */
    public Point getCenterOfMass() {
        return Physics.getCenterOfMass(this.getObjectBoundary());
    }

    /**
     * @return the north
     */
    public Edge getNorth() {
        return north;
    }

    /**
     * @param north the north to set
     */
    public void setNorth(Edge north) {
        this.north = north;
    }

    /**
     * @return the east
     */
    public Edge getEast() {
        return east;
    }

    /**
     * @param east the east to set
     */
    public void setEast(Edge east) {
        this.east = east;
    }

    /**
     * @return the south
     */
    public Edge getSouth() {
        return south;
    }

    /**
     * @param south the south to set
     */
    public void setSouth(Edge south) {
        this.south = south;
    }

    /**
     * @return the west
     */
    public Edge getWest() {
        return west;
    }

    /**
     * @param west the west to set
     */
    public void setWest(Edge west) {
        this.west = west;
    }

    /**
     * @param boundary the boundary to set
     */
    public void setBoundary(Rectangle boundary) {
        this.objectBoundary = boundary;
    }

    /**
     * @param boundaryPhysics the boundaryPhysics to set
     */
    public void setBoundaryPhysics(BoundaryPhysics boundaryPhysics) {
        this.boundaryPhysics = boundaryPhysics;
    }
//  </editor-fold>    

//   <editor-fold defaultstate="collapsed" desc="Intersectable">    
    /**
     * @return the object boundary
     */
    @Override
    public Rectangle getObjectBoundary() {
        return objectBoundary;
    }

    @Override
    public boolean intersects(Intersectable intersectable) {
        return this.getObjectBoundary().intersects(intersectable.getObjectBoundary());
    }
    
        /**
     * @param intersections the list of Intersectable objects that the current 
     * object intersects with (presumably, this will be created by an external
     * method that will call the "intersects" method on the relevant objects.
     * The intent of this method is to allow child classes to optionally 
     * implement their own class that implements IntersectionHandler, and use 
     * the "intersect" method on this class to define their own "collision 
     * physics", i.e. their own reaction to intersecting to other objects in
     * the environment.
     */
    @Override
    public void intersects(ArrayList<Intersectable> intersections) {
        if (this.getIntersectionHandler() != null)
            for (Intersectable intersectable : intersections)
                this.getIntersectionHandler().intersect(intersectable);
    }
//  </editor-fold>
    
}
