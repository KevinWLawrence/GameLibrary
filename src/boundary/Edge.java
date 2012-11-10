/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

/**
 *
 * @author kevinlawrence
 */
public class Edge {
    private EdgeType type = EdgeType.SOLID;
    private EdgeFace face = EdgeFace.NORTH;
    
    public Edge(EdgeType type){
        this.type = type;
    }

    public Edge(EdgeFace face){
        this.face = face;
    }

    public Edge(EdgeType type, EdgeFace face){
        this.type = type;
        this.face = face;
    }

    /**
     * @return the type
     */
    public EdgeType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EdgeType type) {
        this.type = type;
    }

    /**
     * @return the face
     */
    public EdgeFace getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(EdgeFace face) {
        this.face = face;
    }
    
}
