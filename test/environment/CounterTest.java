/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package environment;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author kevinlawrence
 */
public class CounterTest {
    private String defaultName = "Counter";
        int defaultMinimum = -10;
        int defaultMaximum = 1000;
        int defaultValue = 200;
        Range[] defaultRanges = null;

    public Counter initializeCounter(){
        return new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
    }

    public CounterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("\nenvironment.Counter Test\n========================");
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
     * Test of constructor method, of class Counter; ensure inbound parameters
     * are properly assigned
     */
    @Test
    public void testConstructor() {
        System.out.println(" Counter constructor");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultName, counter.getName());
        assertEquals(defaultMinimum, counter.getMinimum());
        assertEquals(defaultMaximum, counter.getMaximum());
        assertEquals(defaultValue, counter.getValue());
    }

    /**
     * Test of getName method, of class Counter.
     */
    @Test
    public void testGetName() {
        System.out.println(" getName");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultName, counter.getName());
    }

    /**
     * Test of setName method, of class Counter.
     */
    @Test
    public void testSetName() {
        System.out.println(" setName");
        String expName = "Expected Name";

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultName, counter.getName());

        counter.setName(expName);
        assertEquals(expName, counter.getName());
    }

    /**
     * Test of getMinimum method, of class Counter.
     */
    @Test
    public void testGetMinimum() {
        System.out.println(" getMinimum");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultMinimum, counter.getMinimum());
    }

    /**
     * Test of setMinimum method, of class Counter.
     */
    @Test
    public void testSetMinimum() {
        System.out.println(" setMinimum");
        int expMinimum = -1000;

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultMinimum, counter.getMinimum());

        counter.setMinimum(expMinimum);
        assertEquals(expMinimum, counter.getMinimum());
    }

    /**
     * Test of setMinimum method, of class Counter.
     */
    @Test
    public void testSetMinimumBoudaryConditions() {
        System.out.println(" setMinimumboundaryConditions");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);

        // minimum may not exceed maximum
        counter.setMinimum(0);
        counter.setMaximum(100);
        counter.setValue(50);

        counter.setMinimum(200);
        assertEquals(100, counter.getMinimum());
        assertEquals(100, counter.getValue());

        // changing minimum greater than current value should raise value to minimum
        counter.setMinimum(0);
        counter.setMaximum(10);
        counter.setValue(5);
        counter.setMinimum(6);
        assertEquals(6, counter.getMinimum());
        assertEquals(6, counter.getValue());

        // raising minimum to less than current value should not affect value
        counter.setMinimum(0);
        counter.setMaximum(10);
        counter.setValue(5);
        counter.setMinimum(4);
        assertEquals(4, counter.getMinimum());
        assertEquals(5, counter.getValue());
    }

    /**
     * Test of getMaximum method, of class Counter.
     */
    @Test
    public void testGetMaximum() {
        System.out.println(" getMaximum");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultMaximum, counter.getMaximum());
    }

    /**
     * Test of setMaximum method, of class Counter.
     */
    @Test
    public void testSetMaximum() {
        System.out.println(" setMaximum");
        int expMaximum = 1000;

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultMaximum, counter.getMaximum());

        counter.setMaximum(expMaximum);
        assertEquals(expMaximum, counter.getMaximum());
    }

        /**
     * Test of setMinimum method, of class Counter.
     */
    @Test
    public void testSetMaximumBoudaryConditions() {
        System.out.println(" setMaximumboundaryConditions");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);

        // maximum may not be less than minimum
        counter.setMinimum(0);
        counter.setMaximum(100);
        counter.setValue(50);

        counter.setMaximum(-100);
        assertEquals(0, counter.getMinimum());
        assertEquals(0, counter.getValue());

        // lowering maximum to less than current value should lower value to maximum
        counter.setMinimum(0);
        counter.setMaximum(10);
        counter.setValue(5);
        counter.setMaximum(4);
        assertEquals(4, counter.getMaximum());
        assertEquals(4, counter.getValue());

        // lowering maximum to greater than current value should not affect value
        counter.setMinimum(0);
        counter.setMaximum(10);
        counter.setValue(5);
        counter.setMaximum(6);
        assertEquals(6, counter.getMaximum());
        assertEquals(5, counter.getValue());
    }

    /**
     * Test of getValue method, of class Counter.
     */
    @Test
    public void testGetValue() {
        System.out.println(" getValue");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertEquals(defaultValue, counter.getValue());
    }

    /**
     * Test of setValue method, of class Counter.
     */
    @Test
    public void testSetValue() {
        System.out.println(" setValue");
        int minimum = 0;
        int maximum = 1000;
        int value_0 = 50;
        int value_1 = 100;
        int value_low = -50;
        int value_high = 1500;

        Counter counter = new Counter(defaultName, minimum, maximum, value_0, defaultRanges);
        assertEquals(value_0, counter.getValue());

        counter.setValue(value_1);
        assertEquals(value_1, counter.getValue());

        counter.setValue(value_high);
        assertEquals(maximum, counter.getValue());

        counter.setValue(value_low);
        assertEquals(minimum, counter.getValue());
    }

    /**
     * Test of incrementValue method, of class Counter.
     */
    @Test
    public void testIncrementValue() {
        System.out.println(" incrementValue");
        int increment = 10;
        int maximum = 25;

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);

        counter.setValue(10);
        assertEquals(10, counter.getValue());
        
        counter.setMaximum(maximum);
        assertEquals(maximum, counter.getMaximum());

        counter.incrementValue(increment);
        assertEquals(20, counter.getValue());

        counter.incrementValue(increment);
        assertEquals(maximum, counter.getValue());
    }

    /**
     * Test of decrementValue method, of class Counter.
     */
    @Test
    public void testDecrementValue() {
        System.out.println(" decrementValue");
        int decrement = 10;
        int minimum = -10;

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);

        counter.setValue(15);
        assertEquals(15, counter.getValue());

        counter.setMinimum(minimum);
        assertEquals(minimum, counter.getMinimum());

        counter.decrementValue(10);
        assertEquals(5, counter.getValue());

        counter.decrementValue(10);
        assertEquals(-5, counter.getValue());

        counter.decrementValue(10);
        assertEquals(minimum, counter.getValue());
    }

    /**
     * Test of getCurrentRange method, of class Counter.
     */
    @Test
    public void testGetCurrentRange() {
        outputTest("getCurrentRange");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, getTestRanges());

        counter.setValue(lowRangeStart);
        assertEquals(counter.getCurrentRange().getName(), lowRangeName);

        counter.setValue(middleRangeStart);
        assertEquals(counter.getCurrentRange().getName(), middleRangeName);

        counter.setValue(highRangeEnd);
        assertEquals(counter.getCurrentRange().getName(), highRangeName);

        counter.setValue(highRangeEnd + 1);
        assertNull(counter.getCurrentRange());
    }


    private final int lowRange = 0;
    private final int middleRange = 1;
    private final int highRange = 2;

    private final String lowRangeName = "Low";
    private final int lowRangeStart = 0;
    private final int lowRangeEnd = 10;

    private final String middleRangeName = "Middle";
    private final int middleRangeStart = 11;
    private final int middleRangeEnd = 20;

    private final String highRangeName = "High";
    private final int highRangeStart = 21;
    private final int highRangeEnd = 100;


    public Range[] getTestRanges(){
        Range[] ranges = new Range[3];

        ranges[lowRange] = new Range(lowRangeName, lowRangeStart, lowRangeEnd);
        ranges[middleRange] = new Range(middleRangeName, middleRangeStart, middleRangeEnd);
        ranges[highRange] = new Range(highRangeName, highRangeStart, highRangeEnd);

        return ranges;
    }

    /**
     * Test of getRanges method, of class Counter.
     */
    @Test
    public void testGetRanges() {
        outputTest("getRanges");

        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertNull(counter.getRanges());

        Counter counter2 = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, getTestRanges());

        assertEquals(counter2.getRanges()[lowRange].getName(), lowRangeName);
        assertEquals(counter2.getRanges()[lowRange].getStart(), lowRangeStart);
        assertEquals(counter2.getRanges()[lowRange].getEnd(), lowRangeEnd);

        assertEquals(counter2.getRanges()[middleRange].getName(), middleRangeName);
        assertEquals(counter2.getRanges()[middleRange].getStart(), middleRangeStart);
        assertEquals(counter2.getRanges()[middleRange].getEnd(), middleRangeEnd);

        assertEquals(counter2.getRanges()[highRange].getName(), highRangeName);
        assertEquals(counter2.getRanges()[highRange].getStart(), highRangeStart);
        assertEquals(counter2.getRanges()[highRange].getEnd(), highRangeEnd);
    }

    /**
     * Test of setRanges method, of class Counter.
     */
    @Test
    public void testSetRanges() {
        outputTest("setRanges");
        Counter counter = new Counter(defaultName, defaultMinimum, defaultMaximum, defaultValue, defaultRanges);
        assertNull(counter.getRanges());

        counter.setRanges(getTestRanges());

        assertEquals(counter.getRanges()[lowRange].getName(), lowRangeName);
        assertEquals(counter.getRanges()[lowRange].getStart(), lowRangeStart);
        assertEquals(counter.getRanges()[lowRange].getEnd(), lowRangeEnd);

        assertEquals(counter.getRanges()[middleRange].getName(), middleRangeName);
        assertEquals(counter.getRanges()[middleRange].getStart(), middleRangeStart);
        assertEquals(counter.getRanges()[middleRange].getEnd(), middleRangeEnd);

        assertEquals(counter.getRanges()[highRange].getName(), highRangeName);
        assertEquals(counter.getRanges()[highRange].getStart(), highRangeStart);
        assertEquals(counter.getRanges()[highRange].getEnd(), highRangeEnd);
    }

    private void outputTest(String string) {
        System.out.println(" " + string);
    }

}