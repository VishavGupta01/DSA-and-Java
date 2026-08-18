import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class disconnectedGraphTraversals {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static ArrayList<Edge>[] createGraph() {
        ArrayList<Edge>[] graph = new ArrayList[7];

        for(int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }

        // Component 1: Vertices 0, 1, and 2 (Forming a triangle)
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // Component 2: Vertices 3 and 4 (Connected only to each other)
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));

        // Component 3: Vertices 5 and 6 (Connected only to each other)
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

        return graph;
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                bfsUtil(graph, i, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;

        for(int i = 0; i < graph[src].size(); i++) {
            int neighbour = graph[src].get(i).dest;
            if(!visited[neighbour]) {
                dfsUtil(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();
        System.out.print("BFS: ");
        bfs(graph);

        System.out.println();

        System.out.print("DFS: ");
        dfs(graph);
    }
}