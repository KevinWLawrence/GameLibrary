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
public interface Segment {
    Point getStart();
    void setStart(Point start);

    Point getEnd();
    void setEnd(Point end);

    boolean moveAlongSegment(Point point, double velocity);
    boolean moveAlongSegment(Movable mover, double velocity);
    boolean atEnd(Point point);

}
