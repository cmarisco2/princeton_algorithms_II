/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 22, 2021
 *
 * Kruskal's Minimum Spanning Tree Class
 *
 * Processing Paradigm for the Undirected Edge-Weighted Graph Class:
 *
 * Utilizes Greedy MST Algorithm to find a Tree, T that is minimum spanning.
 * -It is the minimum weight
 * -It is a tree, T (connected and acyclic).
 * -It spans every vertex in given Graph, G.
 *
 *****************************************************************************/
public class KruskalMST {
    Queue<Edge> mst;
    double minWeight;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue<Edge>();
        minWeight = 0.0;

        MinPQ<Edge> pq = new MinPQ<>(G.E());
        for(Edge e: G.edges())
            pq.insert(e);

        UF uf = new UF(G.V());

        while(!pq.isEmpty() && mst.size() < G.V() - 1){
            Edge e = pq.delMin();
            int v = e.either(); int w = e.other(v);
            double weight = e.weight();

            if(!uf.connected(v, w)){
                uf.union(v, w);
                mst.enqueue(e);
                minWeight+= weight;
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight(){
        return this.minWeight;
    }
}
