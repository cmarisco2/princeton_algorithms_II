import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 11, 2021
 *
 * Graph Class
 * Undirected Graph - Basic API and Internal Structure
 * Undirected Graph - Basis for Processing Abstractions Built on top of it.
 *****************************************************************************/
public class Graph {
    private int V;
    private int E;
//    Adjacency List (An array of Linked Lists (Generic/Iterable))
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V] ;
        for(int v = 0; v < this.V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {  // Add an edge.
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }


    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return this.adj[v];
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

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        StdOut.println(G);
    }



}
