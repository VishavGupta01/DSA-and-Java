import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra {
    static class Edge {
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
        ArrayList<Edge>[] graph = new ArrayList[6];

        for(int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        return graph;
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int n, int p) {
            this.node = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) { // Time Complexity : O(V + ElogV)
        // Shortest Paths from the sources to all the vertices (weighted graph)
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!visited[curr.node]) {
                visited[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    if(dist[e.dest] > dist[e.src] + e.wt) {
                        dist[e.dest] = dist[e.src] + e.wt;
                        pq.add(new Pair(e.dest, dist[e.dest]));
                    }
                }
            }
        }

        for(int i = 0; i < V; i++) {
            System.out.println("Distance from " + src + " to " + i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        dijkstra(graph, 0);
    }
}
