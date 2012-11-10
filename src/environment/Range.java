/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package environment;

/**
 *
 * @author kevinlawrence
 */
public class Range {
    private int start, end;
    private String name;

    public Range(String name, int start, int end){
        this.name = name;
        this.start = start;
        this.end = end;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
