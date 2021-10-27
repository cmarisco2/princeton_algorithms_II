/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 27, 2021
 *
 * Create Directed Edge Class for Edge Weighted Digraphs.
 * Have int v, and int w for vertices.
 * Have double weight for the edge's weight
 *****************************************************************************/
public class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double weight(){
        return weight;
    }

    public String toString(){
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
