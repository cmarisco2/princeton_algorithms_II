/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 12, 2021
 *
 * DepthFirstSearch Class
 *
 * Processing Paradigm for the Graph Class:
 *
 * Utilizes the Recursive Depth First Search to explore
 * and query a given Graph, G, and an associated vertex source, s.
 * -Queries pertain to s post processing via DFS.
 *
 * Computes if there is a path from a vertex v in G to s.
 *
 * Gives an Iterable Object back for displaying a path from a vertex, v, to s, if it exists.
 *****************************************************************************/

public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPath(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

}
