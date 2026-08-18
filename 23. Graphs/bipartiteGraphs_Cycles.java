import java.util.ArrayList;
import java.util.Arrays;

public class bipartiteGraphs_Cycles {
    // If No cyles = Bipartite
    // If Even length cycles = Bipartite
    // If Odd Length cycles = Non-Bipartite

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

        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        return graph;
    }

    public static boolean isBipartiteByCyles(ArrayList<Edge>[] graph) {
        int[] depth = new int[graph.length];
        Arrays.fill(depth, -1);

        for (int i = 0; i < graph.length; i++) {
            if (depth[i] == -1) {
                if (!dfsCycleCheck(graph, i, 0, -1, depth)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfsCycleCheck(
            ArrayList<Edge>[] graph,
            int curr,
            int currDepth,
            int parent,
            int[] depth
        ) {
            depth[curr] = currDepth; // Recording depth of curr node

            for(int i = 0; i < graph[curr].size(); i++) {
                int neighbour = graph[curr].get(i).dest;

                if(depth[neighbour] == -1) { // If neighbour is unvisited, move down
                    if(!dfsCycleCheck(graph, neighbour, currDepth + 1, curr, depth)) {
                        return false;
                    }
                } else if(neighbour != parent) { // Visited Node but not immediate parent node (Cycle Detected)
                    int cycleLength = (currDepth - depth[neighbour] ) + 1; // Cycle Length Calculation

                    if(cycleLength % 2 != 0) {
                        return false;
                    }
                }
            }

            return true;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        System.out.println(isBipartiteByCyles(graph));
    }
}
