/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package environment;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author kevinlawrence
 */
public class RangeTest {

    public RangeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("\nenvironment.Range Test\n======================");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getStart method, of class Range.
     */
    @Test
    public void testConstructor() {
        System.out.println(" Range constructor");

        int expStart = -100;
        int expEnd = 1000;
        String expName = "Range Name";
        Range instance = new Range(expName, expStart, expEnd);

        String resultName = instance.getName();
        int resultStart = instance.getStart();
        int resultEnd = instance.getEnd();

        assertEquals(expName, resultName);
        assertEquals(expStart, resultStart);
        assertEquals(expEnd, resultEnd);
    }

    /**
     * Test of getStart method, of class Range.
     */
    @Test
    public void testGetStart() {
        System.out.println(" getStart");

        int expResult = 0;
        Range instance = new Range("Range", expResult, 100);
        int result = instance.getStart();

        assertEquals(expResult, result);
    }

    /**
     * Test of setStart method, of class Range.
     */
    @Test
    public void testSetStart() {
        System.out.println(" setStart");
        int expResult = 10;

        Range instance = new Range("Range", 0, 100);
        instance.setStart(expResult);
        int result = instance.getStart();

        assertEquals(expResult, result);
    }

    /**
     * Test of getEnd method, of class Range.
     */
    @Test
    public void testGetEnd() {
        System.out.println(" getEnd");
        final int expResult = 10;

        Range instance = new Range("Range", 0, expResult);
        int result = instance.getEnd();

        assertEquals(expResult, result);
    }

    /**
     * Test of setEnd method, of class Range.
     */
    @Test
    public void testSetEnd() {
        System.out.println(" setEnd");

        final int expResult = 200;
        Range instance = new Range("Range", 0, 100);

        instance.setEnd(expResult);
        int result = instance.getEnd();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Range.
     */
    @Test
    public void testGetName() {
        System.out.println(" getName");

        final String expResult = "Range Name";
        Range instance = new Range(expResult, 0, 100);
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Range.
     */
    @Test
    public void testSetName() {
        System.out.println(" setName");

        final String expResult = "Range Name";
        Range instance = new Range("Initial Name", 0, 100);

        instance.setName(expResult);
        String result = instance.getName();

        assertEquals(expResult, result);
    }

}