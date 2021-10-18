/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 12, 2021
 *
 * ConnectedComponents Class
 *
 * Utilizes Serial DFS to find connected components in a Graph.
 *
 *****************************************************************************/
public class CC {
    boolean[] marked;
    int[] id;
    int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        for(int s = 0; s < G.V(); s++){
            if(!marked[s]){
                dfs(G,s);
                count++; //On The Way Up.
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
