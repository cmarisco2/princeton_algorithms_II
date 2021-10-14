import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

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
        StdOut.println("Given Graph: ");
        StdOut.println(g);
        int vertex = 0;
        BreadthFirstPath path = new BreadthFirstPath(g, vertex);

        StdOut.println("A Shortest Path to Each Vertex Starting from Vertex " + vertex + " are:");

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
