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

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

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

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args){

        Graph g = new Graph(new In(args[0]));
        int vertex = 0;
        DepthFirstPath path = new DepthFirstPath(g, vertex);

        StdOut.println("Connections of Graph Along Vertex are: ");

        for(int v = 0; v < g.V(); v++){
            for(int w: path.pathTo(v)){
                if(w == v)
                    StdOut.print(w);
                else
                    StdOut.print(w + "-");
            }
        StdOut.println();
        }
    }

}
