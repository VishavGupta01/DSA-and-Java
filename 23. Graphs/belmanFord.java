import java.util.ArrayList;

public class belmanFord {
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
        ArrayList<Edge>[] graph = new ArrayList[5];

        for(int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1)); // Change wt to -11 for Negative Weight Cycle testcase

        return graph;
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) { // Time Complexity: O(V*E)
        // can work for weighted graphs with negative weights
        // but cant work if negative weight cycles exist i.e. sum of weights in a cycle is negative
        int V = graph.length;
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < V - 1; i++) {
            // Extracting all edges -> O(E)
            for(int j = 0; j < V; j++) {
                for(int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    // Edge Relaxation
                    if(dist[e.src] != Integer.MAX_VALUE && dist[e.dest] > dist[e.src] + e.wt) {
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);

                if(dist[e.dest] != Integer.MAX_VALUE && dist[e.dest] > dist[e.src] + e.wt) {
                    System.out.println("Negative Weight Cycle detected! Shortest Path not available!");
                    return;
                }
            }
        }

        for(int i = 0; i < V; i++) {
            System.out.println("Shortest distance from " + src + " to " + i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        bellmanFord(graph, 0);
    }
}
