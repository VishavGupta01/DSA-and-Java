import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraphs_Coloring {
    // A Bipartite Graph is a graph in which nodes can be divided into two disjoint sets with each edge connecting nodes from one set to other.
    // And crucially, no edges exists between nodes of same set.
    // If a graph is Acyclic, then it is automatically bipartite.

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

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1) {
                q.add(i);
                color[i] = 0;

                while(!q.isEmpty()) {
                    int curr = q.remove();

                    for(int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if(color[e.dest] == -1) {
                            color[e.dest] = color[curr] == 0 ? 1 : 0;
                            q.add(e.dest);
                        } else if(color[e.dest] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();

        System.out.println(isBipartite(graph));
    }
}
