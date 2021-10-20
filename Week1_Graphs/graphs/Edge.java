/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 20, 2021
 *
 * Create Edge Class for Edge Weighted Graphs.
 * Have int v, and int w for vertices.
 * Have double weight for the edge's weight
 *
 * Comparable Class based on weight.
 *****************************************************************************/
public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return this.weight;
    }

    public int either(){
        return this.v;
    }

    public int other(int vertex){
        if(vertex == this.v) return this.w;
        else if (vertex == this.w) return this.v;
        else {
            throw new RuntimeException("Inconsistent Vertex");
        }
    }

    public int compareTo(Edge that){
        if (this.weight < that.weight()) return -1;
        else if(this.weight > that.weight()) return 1;
        else return 0;
    }

    public String toString(){
        return String.format("%d-%d %.2f", this.v, this.w, this.weight);
    }
}
