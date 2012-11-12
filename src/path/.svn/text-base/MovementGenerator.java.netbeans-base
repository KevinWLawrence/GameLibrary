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
public class MovementGenerator {

    public static Point getRandomMovement(int minX, int maxX, int minY, int maxY){
        return new Point(getRandomRangeValue(minX, maxX), getRandomRangeValue(minY, maxY));
    }

    public static int getRandomRangeValue(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

}
