import edu.princeton.cs.algs4.In;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 20, 2021
 *
 * Edge Weighted Graph Class
 * Edge Weighted Graph - Basic API and Internal Structure
 * Edge Weighted Graph - Similar API as Graph Class But with Generics (Edge) vice Primitive (int) rep edges
 * Edge Weighted Graph - Edges contain int vertices -> still recursive Vertex indexed array with Vertex values
 *
 * Edge Weighted Graph - Makes Use of the Edge Abstraction to Encapsulate Weight and Comparable interface of Edge Class.
 * Edge Weighted Graph - Also, Has Edges() method to analyze the edges in the graph.
 *****************************************************************************/
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge> [] adj;

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v = 0; v < this.V; v++)
            adj[v] = new Bag<Edge>();
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {  // Add an edge.
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public void addEdge(Edge e){
        int v = e.either(); int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b = new Bag<Edge>();
        for(int v = 0; v < this.V; v++)
            for(Edge e : adj[v])
                if(e.other(v) > v) b.add(e);
        return b;
    }
}
