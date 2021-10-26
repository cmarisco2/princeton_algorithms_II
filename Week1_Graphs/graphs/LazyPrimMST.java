/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 26, 2021
 *
 * Prim's Minimum Spanning Tree Class
 *
 * Processing Paradigm for the Undirected Edge-Weighted Graph Class:
 *
 * Utilizes Greedy MST Algorithm to find a Tree, T, that is minimum spanning.
 * -T is a tree (connected and acyclic).
 * -Tree T is a minimum weight tree
 * -T spans every vertex in given Graph, G.
 *
 *****************************************************************************/
public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;
    private double minWeight;

    public LazyPrimMST(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        mst = new Queue<>();
        pq = new MinPQ<>(G.E());
        minWeight = 0.0;

        visit(G, 0);
        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either(); int w = e.other(v);
            double weight = e.weight();

            if(marked[v] && marked[w]) continue;
            mst.enqueue(e);
            minWeight += weight;
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }

    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e: G.adj(v)){
            if(!marked[e.other(v)])
                pq.insert(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
    public double weight(){
        return this.minWeight;
    }

    public String toString(){
        String s = "Minimum Spanning Tree Weight: " + this.minWeight + "\n" + ("Minimum Spanning Tree Edges are: " + "\n");
        for(Edge e : mst)
            s+= e + "  " + "\n";
        return s;
    }
}
