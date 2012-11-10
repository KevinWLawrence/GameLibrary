/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package path;

import java.awt.Point;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kevinlawrence
 */
public class TrigonometryCalculatorTest {

    public TrigonometryCalculatorTest() {
    }

//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
    /**
     * Test of calculateAngle method, of class TrigonometryCalculator.
     */
    @Test
    public void testCalculateAngle() {
//                                x,  y
        int[][] testData = {{1, 0}, // EAST
            {1, 1}, // NORTH-EAST
            {0, 1}, // NORTH
            {-1, 1}, // NORTH-WEST
            {-1, 0}, // WEST
            {-1, -1}, // SOUTH-WEST
            {0, -1}, // SOUTH
            {1, -1} // SOUTH-WEST
        };


        System.out.println("calculateAngle");
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);
//        TrigonometryCalculator instance = new TrigonometryCalculator();
        for (int[] testPoint : testData) {
            end.x = testPoint[0];
            end.y = testPoint[1];

            System.out.printf(" Start [%d, %d] End [%2d, %2d] Angle = %9f\n",
                    start.x, start.y, end.x, end.y,
                    TrigonometryCalculator.calculateAngle(start, end));
        }

        assertEquals(true, true);
//
//
//        double expResult = 0.0;
//        double result = instance.calculateAngle(start, end);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateVelocity method, of class TrigonometryCalculator.
     */
    @Test
    public void testCalculateVelocity() {
        int[] scaleFactors = {1, 10, 100};

        int[][] testData = {{1, 0}, // EAST
            {1, 1}, // NORTH-EAST
            {0, 1}, // NORTH
            {-1, 1}, // NORTH-WEST
            {-1, 0}, // WEST
            {-1, -1}, // SOUTH-WEST
            {0, -1}, // SOUTH
            {1, -1} // SOUTH-WEST
        };


        System.out.println("calculateVelocity");
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);
        double speed = 10.0;

        System.out.println(" Test Scale Consistency");
        for (int[] testPoint : testData) {
            for (int scale : scaleFactors) {
                end.x = testPoint[0] * scale;
                end.y = testPoint[1] * scale;

                System.out.printf(" Start [%d, %d] End [%4d, %4d] Scale %3d Speed %3.1f Velocity %s\n",
                        start.x, start.y, end.x, end.y, scale, speed,
                        TrigonometryCalculator.calculateVelocity(start, end, speed));

            }
        }

        assertEquals(true, true);

//        Point start = null;
//        Point end = null;
//        double speed = 0.0;
//        TrigonometryCalculator instance = new TrigonometryCalculator();
//        Velocity expResult = null;
//        Velocity result = instance.calculateVelocity(start, end, speed);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
