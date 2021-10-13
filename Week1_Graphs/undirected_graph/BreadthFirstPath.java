/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 12, 2021
 *
 * BreadthFirstSearch Class
 *
 * Processing Paradigm for the Graph Class:
 *
 * Utilizes the Explicit Queue Breadth First Search to explore
 * and query a given Graph, G, and an associated vertex source, s.
 * -Queries pertain to s post processing via BFS.
 *
 * Computes if there is a path from a vertex v in G to s.
 *
 * Gives an Iterable Object back for displaying a path from a vertex, v, to s, if it exists.
 *
 * FINDS THE SHORTEST PATH FROM A SOURCE VERTEX!
 *****************************************************************************/
public class BreadthFirstPath {
    private boolean [] marked;
    private int [] edgeTo;
    private final int s;

    public BreadthFirstPath(Graph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int v){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        marked[v] = true;
        while(!queue.isEmpty()){
            int x = queue.deQueue();
            for(int w : g.adj(x)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = x;
                    queue.enqueue(w);
                }
            }
        }
    }
}
