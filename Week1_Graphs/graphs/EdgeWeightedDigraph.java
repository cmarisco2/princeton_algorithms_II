/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 27, 2021
 *
 * Edge Weighted Digraph Class
 * Edge Weighted Digraph - Basic API and Internal Structure
 * Edge Weighted Digraph - Similar API as EWG Class But with Generic DirectedEdges vice Edges
 *
 * Edge Weighted Digraph - Adds only to int v, via Edge e.to(), instead of both v & w.
 *****************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[])new Bag[V];
        for(int v = 0; v < this.V; v++){
            adj[v] = new Bag<>();
        }
    }
    public EdgeWeightedDigraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].add(e);
        this.E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> b = new Bag<>();
        for(int v = 0; v < this.V; v++)
            for(DirectedEdge e : adj[v])
                b.add(e);
        return b;
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public String toString(){
        String s = this.V() + " vertices, " + this.E() + " edges\n";
        for(int v = 0; v < this.V; v++){
            s+= v + ": ";
            for(DirectedEdge e: this.adj(v))
                s+= e + " ";
            s+= "\n";
        }
        return s;
    }

    public static void main(String[] args){
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
        StdOut.println(G);
    }
}
