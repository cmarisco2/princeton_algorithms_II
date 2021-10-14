import edu.princeton.cs.algs4.In;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 11, 2021
 *
 * Directed Graph Class
 * Directed Graph - Basic API and Internal Structure
 * Directed Graph - Similar (and Simpler) implementation. Useful Properties
 *****************************************************************************/
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[this.V];
        for(int v = 0; v < this.V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {  // Add an edge.
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    //Key Difference -> Non-Symetric adding of edges == Direct Edge Creation
    //Creates Edge
    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    //Returns the adjacency list for v.
    //All the vertices v points to (v -> x) == Outdegree vertices of v.
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    //Creates Reverse of the current Digraph
    //Shows the Indegree Vertices.
    public Digraph reverse(){
        Digraph reVerb = new Digraph(this.V);
        for(int v = 0; v < this.V; v++)
            for(int w : adj(v))
                reVerb.addEdge(w, v);
        return reVerb;
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public String toString(){
        String s = this.V + " vertices, " + this.E + " edges\n";
        for (int v = 0; v < this.V; v++)
        {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }

}
