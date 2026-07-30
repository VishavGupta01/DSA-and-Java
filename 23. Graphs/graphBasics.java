import java.util.ArrayList;

public class graphBasics {
    // Graph Representations:
    // 1. Adjacency List - ArrayList<ArrayList<Integer>>, ArrayList<Integer>[], HashMap<Integer, ArrayList<Integer>>
    // 2. Adjacency Matrix - Integer[][]
    // 3. Edge List - {{}, {}, ..., {}}

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "(" + src + "->" + dest + ", wt:" + wt + ")";
        }
    }

    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        return graph;
    }

    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edge>[] graph = createGraph(v);

        // Adding edges:
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));

        for(int i = 0; i < v; i++) {
            System.out.println("Vertex " + i + ": " + graph[i]);
        }

        // Printing neighbours
        for(int i = 0; i < v; i++) {
            System.out.print("Neighbour of " + i + " : ");
            for(int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).dest + " ");
            }
            System.out.println();
        }
    }
}
