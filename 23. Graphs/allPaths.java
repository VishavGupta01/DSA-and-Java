import java.util.ArrayList;

public class allPaths {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static ArrayList<Edge>[] createGraph() {
        ArrayList<Edge>[] graph = new ArrayList[6];

        for(int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        return graph;
    }

    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String path, boolean[] visited) {
        if(src == dest) {
            System.out.println(path + " " + dest);
            return;
        }

        visited[src] = true;

        for(int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!visited[e.dest]) {
                allPath(graph, e.dest, dest, path + " " + src, visited);
            }
        }

        visited[src] = false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = createGraph();
        allPath(graph, 5, 1, "", new boolean[graph.length]);
    }
}
