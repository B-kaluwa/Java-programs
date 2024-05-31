import java.util.*;

public class GraphDFS {
    private int V; // number of vertices
    private LinkedList<Integer>[] adj; // adjacency list

    // Constructor
    public GraphDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS traversal from a given source vertex
    public void DFS(int s) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Call the recursive helper function
        DFSUtil(s, visited);
    }

    // A recursive function to do DFS traversal
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2):");
        g.DFS(2);
    }
}