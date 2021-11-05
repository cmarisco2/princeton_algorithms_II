/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     November 5, 2021
 *
 * Dijkstra's Algorithm For Finding the Shortest Path in an Edge Weighted Directed Graph with non-negative weights.
 *
 * Processing Paradigm for the Directed Edge-Weighted Graph Class:
 *
 * Dijkstra's Algorithm:
 * -G is a Directed Graph with non-negative Weights.
 * -Consider Vertices in increasing order of Distance from S (non-tree vertex with the lowest distTo[] value).
 * -Add Vertex to the Tree & Relax All Edges Pointing from That Vertex.
 *****************************************************************************/
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private Double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int S){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new Double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        pq.insert(S, 0.0);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            for(DirectedEdge e: G.adj(v))
                relax(e);
        }
    }

    private void relax(DirectedEdge e){
        int v = e.from(); int w = e.to();
        if(distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;

            if(pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }
}
