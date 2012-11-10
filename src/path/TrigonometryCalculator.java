/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package path;

import environment.Velocity;
import java.awt.Point;

/**
 *
 * @author kevinlawrence
 */
public class TrigonometryCalculator {

    public static Velocity calculateVelocity(Point start, Point end, double speed){
//      Given a start point and the end point, use trigonometry to calculate
//      a velocity vector that is scaled to the speed provided

//      SOH CAH TOA
//      sin(angle) = Opposite / Hypotenuse
//      cos(angle) = Adjacent / Hypotenuse
//      tan(angle) = Opposite / Adjacent
//
//      Adjacent = delta X = end.x - start.x
//      Opposite = delta Y = end.y - start.y
//
//      arcTan(Opposite / Adjacent) = angle
//      arcTan(delta Y / delta X) = angle
//
//      since
//        cos(angle) = Adjacent / Hypotenuse
//      and the Hypotenuse of the desired triangle is the "speed"
//        Hypotenuse = speed

//        cos(angle) = X component / speed
//      solve for X Component
//        X Component = scaled X = speed * cos(angle);
//
//      in the same manner:
//        sin(angle) = Opposite / Hypotenuse
//        sin(angle) = Y component / speed
//      solve for Y Component
//        Y Component = scaled Y = speed * sin(angle);

        double angle = calculateAngle(start, end);
        return new Velocity((int) (speed * Math.cos(angle)), (int) (speed * Math.sin(angle)));
    }

    public static double calculateAngle(Point start, Point end){
//      Given a start point and the end point, use trigonometry to calculate
//      an angle for the connecting vestor

//      SOH CAH TOA
//      sin(angle) = Opposite / Hypotenuse
//      cos(angle) = Adjacent / Hypotenuse
//      tan(angle) = Opposite / Adjacent
//
//      Adjacent = delta X = end.x - start.x
//      Opposite = delta Y = end.y - start.y
//
//      arcTan(Opposite / Adjacent) = angle
//      arcTan(delta Y / delta X) = angle
//

        return Math.atan2((1.0 * (end.y - start.y)) , (1.0 * (end.x - start.x)));

//        double angle = Math.atan((1.0 * (end.y - start.y)) / (1.0 * (end.x - start.x)));
//        return (start.x >= end.x) ? angle : angle + (Math.PI / 2.0);
    }

//        public static double calculateAngle2(Point start, Point end){
//        double angle = Math.atan((1.0 * (end.y - start.y)) / (1.0 * (end.x - start.x)));
//        return (end.x < start.x) ? angle + (Math.PI / 2.0) : angle;
//    }
//
//    public static double calculateAngle3(Point start, Point end){
//        return Math.atan2((1.0 * (end.y - start.y)) , (1.0 * (end.x - start.x)));
////        return (end.x < start.x) ? angle + (Math.PI / 2.0) : angle;
//    }
}
