/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 12, 2021
 *
 * DepthFirstSearch Class
 *
 * Processing Paradigm for the Directed Graph Class:
 *
 * Utilizes the Recursive Depth First Search to explore
 * and query a given Graph, G, and an associated vertex source, s.
 * -Queries pertain to s post processing via DFS.
 *
 * Computes if there is a path from a vertex v in G to s.
 *
 * Gives an Iterable Object back for displaying a path from a vertex, v, to s, if it exists.
 *****************************************************************************/

//Bare Minimum For functionality.
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public boolean marked(int v){
        return marked[v];
    }
}
