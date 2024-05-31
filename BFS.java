import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int V;   // number of vertices
    private LinkedList<Integer>[] adj; // adjacency list

    public BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // add edge to graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // breadth-first search from source s
    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // sample test case
    public static void main(String[] args) {
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS traversal starting from vertex 2:");
        g.BFS(2);
    }
}
